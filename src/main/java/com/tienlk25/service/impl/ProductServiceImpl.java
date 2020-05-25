package com.tienlk25.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.entity.Options;
import com.tienlk25.entity.Value;
import com.tienlk25.entity.Variants;
import com.tienlk25.exceptiones.NotFoundId;
import com.tienlk25.exceptiones.OptionCheckingException;
import com.tienlk25.model.request.ProductModelRequest;
import com.tienlk25.model.request.OptionModelRequest;
import com.tienlk25.model.request.VariantModelRequest;
import com.tienlk25.model.response.ProductModelResponse;
import com.tienlk25.model.response.OptionModelResponse;
import com.tienlk25.model.response.VariantModelResponse;
import com.tienlk25.repositories.ProductRepoitory;
import com.tienlk25.repositories.ValueRepository;
import com.tienlk25.repositories.OptionRepository;
import com.tienlk25.repositories.VariantRepository;
import com.tienlk25.service.ProductService;

@Service
@Transactional(rollbackOn = Exception.class)
public class ProductServiceImpl implements ProductService {

	final String TITLE_DEFAULFT = "Sự lựa chọn hoàn hảo";
	final String NAME_VALUE_DEFAULFT = "Title";
	final String VALUE_DEFAULFT = "Default title";
	final int OPTION_SIZE = 3;

	private ProductRepoitory productRepoitory;
	private VariantRepository variantRepository;
	private OptionRepository optionRepository;
	private ValueRepository valueRepository;

//	@PersistenceContext(type = PersistenceContextType.EXTENDED)
//	EntityManager entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
//	@PersistenceContext(type = PersistenceContextType.EXTENDED)
//	EntityManager entityManager;

	@Autowired
	public ProductServiceImpl(ProductRepoitory productRepoitory, VariantRepository variantRepository,
			OptionRepository optionRepository, ValueRepository valueRepository) {
		this.productRepoitory = productRepoitory;
		this.variantRepository = variantRepository;
		this.optionRepository = optionRepository;
		this.valueRepository = valueRepository;
	}

	@Override
	public List<ProductModelResponse> getAllProducts() {
		List<Motorbikes> motorbikes = productRepoitory.findAllProduct();
		List<ProductModelResponse> motorbikeModels = new ArrayList<ProductModelResponse>();
		try {
			for (Motorbikes motorbike : motorbikes) {
				ProductModelResponse productModel = getProductModelByProduct(motorbike);
				if (productModel != null) {
					motorbikeModels.add(productModel);
				}

			}
			return motorbikeModels;
		} catch (NullPointerException e) {
			System.out.println(e);
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public ProductModelResponse getProductModelByProduct(Motorbikes motorbikes) {
		List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(motorbikes.getId(), true);
		List<VariantModelResponse> variantModels = new ArrayList<>();
		List<Options> options = optionRepository.findAllOptionsByIdOfProduct(motorbikes.getId(), true);
		System.out.println(options.size() + "                   option size");
		List<OptionModelResponse> optionModelResponses = new ArrayList<OptionModelResponse>();
		OptionModelResponse optionModel1 = new OptionModelResponse(options.get(0));
		OptionModelResponse optionModel2 = new OptionModelResponse(options.get(1));
		OptionModelResponse optionModel3 = new OptionModelResponse(options.get(2));
		try {
			for (Variants variant : variants) {
				VariantModelResponse variantModel = getVariantModelByVariant(variant, options, optionModel1,
						optionModel2, optionModel3);
				variantModels.add(variantModel);
			}

			if (optionModel1.getName() != null) {
				optionModelResponses.add(optionModel1);
			}
			if (optionModel2.getName() != null) {
				optionModelResponses.add(optionModel2);
			}
			if (optionModel3.getName() != null) {
				optionModelResponses.add(optionModel3);
			}
			ProductModelResponse motorbikeModel = new ProductModelResponse(motorbikes, variantModels,
					optionModelResponses);
			return motorbikeModel;
		} catch (Exception e) {
			return null;
		}
	}

	private VariantModelResponse getVariantModelByVariant(Variants variant, List<Options> options,
			OptionModelResponse optionModel1, OptionModelResponse optionModel2, OptionModelResponse optionModel3) {
		String[] optionString = new String[3];

		int i = 0;
		for (Options option : options) {
			System.out.println(variant.getId() + "        variant Id             op tionid   " + option.getId());
			Value value = valueRepository.findValueByIdOfVariantAndOption(variant.getId(), option.getId());
			if (value == null) {
				value = new Value();
			}
			System.out.println(value.getValue() + "                            value --------------");
			if (option.getPosition() == 1) {
				System.out.println(value.getValue() + "                                                  optionmodel 1");
				optionModel1.addValue(value.getValue());
			}
			if (option.getPosition() == 2) {
				optionModel2.addValue(value.getValue());
			}
			if (option.getPosition() == 3) {
				optionModel3.addValue(value.getValue());
			}
			optionString[i++] = value.getValue();
		}
		VariantModelResponse variantModels = new VariantModelResponse(variant, optionString);

		return variantModels;
	}
	
//	private List<OptionModelResponse> getOptionsModelByOption(List<Options> options, Integer variantId, String[] optionString) {
//	
//		return optionModels;
//	}

	@Override
	public ProductModelResponse updateProduct(ProductModelRequest productModel) {
		Motorbikes currentProduct = productRepoitory.findByIdAndStatus(productModel.getId(), true);
		if (currentProduct == null) {
			throw new NotFoundId(productModel.getId());
		} else {
			Calendar calendar = Calendar.getInstance();
			Date modifiedOn = (Date) calendar.getTime();
			productModel.setMotorbike(currentProduct, modifiedOn);
			productRepoitory.save(currentProduct);
			updateVariant(productModel.getVariants(), modifiedOn, currentProduct.getId());
			ProductModelResponse motorbikeModelResponse = getProductModelByProduct(currentProduct);
			return motorbikeModelResponse;
		}
	}

	private void updateVariant(List<VariantModelRequest> variantModels, Date modifiedOn, Integer productId) {
		if (variantModels == null) {
			return;
		} else {
			List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(productId, true);
			List<Variants> variantsPush = new ArrayList<Variants>();
			boolean check;
			boolean flag = true;
			int sizeVariant = variants.size();
			for (VariantModelRequest variantModelRequest : variantModels) {
				check = false;
				for (Variants variant : variants) {
					if (variant.getId() == null) {
						flag = false;
					}
					if (variant.getTitle().compareTo(TITLE_DEFAULFT) == 0) {
						variantModelRequest.setVarriant(variant, modifiedOn, productId);
						variantsPush.add(variant);
						updateOption(variantModelRequest.getOptions(), productId, variant.getId());
						check = true;
						break;
					} else if (variant.getId() == variantModelRequest.getId()) {
						variantModelRequest.setVarriant(variant, modifiedOn, productId);
						variantsPush.add(variant);
						updateOption(variantModelRequest.getOptions(), productId, variant.getId());
						check = true;
						break;
					}

				}
				if (!check) {
					Variants variant = new Variants();
					variantModelRequest.setVarriant(variant, modifiedOn, productId);
					variant.setStatus(true);
					variant.setPosition(sizeVariant++);
					variantRepository.save(variant);
					updateOption(variantModelRequest.getOptions(), productId, variant.getId());
				}
			}
			if (flag) {
				int a = 0;
				for (Variants variant : variantsPush) {
					variant.setPosition(++a);
				}
			}
			variantRepository.saveAll(variantsPush);
		}
		return;
	}
	
	private void updateOption(List<OptionModelRequest> optionModels, Integer productId, Integer variantId) {
		if (optionModels == null) {
			return;
		} else {
			boolean check = false;
			List<Options> options = optionRepository.findAllOptionsByIdOfProduct(productId, true);
			for(OptionModelRequest optionModel : optionModels) {
				for (Options option : options) {
					if(optionModel.getId() == option.getId()) {
						check = true;
						if(option.getName() == null || option.getName().compareTo(NAME_VALUE_DEFAULFT) == 0) {
							optionModel.setOption(option);
							optionRepository.save(option);
						}
						updateValue(optionModel.getValue(), variantId, option.getId());
						break;
					}
				}
				if(!check) {
					throw new OptionCheckingException();
				}
			}
		}
	}



	private void updateValue(String value, Integer variantId, Integer optionId) {
		Value currentValue = valueRepository.findValueByIdOfVariantAndOption(variantId, optionId);
		System.out.println(currentValue + "                           current          =====  " + value);
		if (currentValue == null) {
			saveValue(value, variantId, optionId);
			return;
		}
		currentValue.setValue(value);
		valueRepository.save(currentValue);
	}

	@Override
	public ProductModelResponse getProductModelById(Integer id) {
			Motorbikes motorbikes = productRepoitory.findByIdAndStatus(id, true);
			if(motorbikes == null) {
				throw new NotFoundId(id);
			}
			return getProductModelByProduct(motorbikes);
	}

	@Override
	public boolean updateStatus(Integer id) {
		try {
			Calendar calendar = Calendar.getInstance();
			Date modifiedOn = (Date) calendar.getTime();
			Motorbikes motorbikes = productRepoitory.findByIdAndStatus(id, true);
			motorbikes.setStatus(false);
			motorbikes.setModifiedOn(modifiedOn);
			updateStatusVariantByIdProduct(id, modifiedOn);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	private void updateStatusVariantByIdProduct(Integer id, Date modifiedOn) {
		List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(id, true);

		for (Variants variant : variants) {
			variant.setStatus(false);
			variant.setModifiedOn(modifiedOn);
			updateStatusOptionByIdVariant(variant.getId(), id);
		}
		variantRepository.saveAll(variants);
	}

	private void updateStatusOptionByIdVariant(Integer variantId, Integer productId) {
		List<Options> options = optionRepository.findAllOptionsByIdOfProduct(productId, true);
		for (Options option : options) {
			option.setStatus(false);
			updateStatusValue(option.getId());
		}
		optionRepository.saveAll(options);
	}
	
	
	private void updateStatusValue(Integer optionId) {
		List<Value> values = valueRepository.findValueByIdOfOption(optionId);
		for(Value value : values) {
			value.setValue(null);
		}
		valueRepository.saveAll(values);
	}

	@Override
	public ProductModelResponse saveProduct(ProductModelRequest productModel) {
		if (productModel.getName() == null) {
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		Date date = (Date) calendar.getTime();
		Motorbikes motorbike = new Motorbikes();
		productModel.setMotorbike(motorbike, date);
		motorbike.setStatus(true);
		productRepoitory.save(motorbike);
		saveVariant(productModel.getVariants(), date, motorbike.getId());
		ProductModelResponse modelResponse = getProductModelByProduct(motorbike);
		return modelResponse;
	}

	private void saveVariant(List<VariantModelRequest> variantModels, Date date, Integer productId) {
		List<Options> options = new ArrayList<Options>();
		for(int j = 0;j < OPTION_SIZE;j++) {
			Options option = new Options();
			option.setProductId(productId);
			option.setStatus(true);
			options.add(option);
		}
		if (variantModels == null) {
			VariantModelRequest variantModelRequest = new VariantModelRequest();
			Variants variant = new Variants();
			variantModelRequest.setDefaultVariant(variant, date, productId);
			variantRepository.save(variant);
			saveOption(null, options, variant.getId());
		} else {
			int i = 1;
			
			for (VariantModelRequest variantModel : variantModels) {
				Variants variant = new Variants();
				variantModel.setVarriant(variant, date, productId);
				variant.setStatus(true);
				variant.setPosition(i++); // https:stackjava.com/wp-content/uploads/2018/05/hibernate-entitymanager-2.png
				variantRepository.save(variant);
				saveOption(variantModel.getOptions(), options, variant.getId());
			}
		}
	}

	private void saveOption(List<OptionModelRequest> optionModels, List<Options> options, Integer variantId) {
		if (optionModels == null) {
			for (int i = 0; i < OPTION_SIZE; i++) {
				Options option = options.get(i);
				if(i == 0) {
					OptionModelRequest optionModel = new OptionModelRequest();
					optionModel.setDefaultOption(option);
					optionRepository.save(option);
					saveValue(VALUE_DEFAULFT, variantId, option.getId());
					continue;
				}
				option.setPosition(i+1);
				option.setStatus(true);
				optionRepository.save(option);
			}
		} else {
			int i = 0;
			for (OptionModelRequest optionModelRequest : optionModels) {
				Options option = options.get(i++);
				optionModelRequest.setOption(option);
				option.setPosition(i);
				optionRepository.save(option);
				saveValue(optionModelRequest.getValue(), variantId, option.getId());
			}
			while (i + 1 <= OPTION_SIZE) {
				Options option = options.get(i++);
				OptionModelRequest optionModelRequest = new OptionModelRequest();
				optionModelRequest.setOption(option);
				option.setPosition(i);
				optionRepository.save(option);
			}
		}
	}

	private void saveValue(String value, Integer variantId, Integer optionId) {
		if (value == null) {
			return;
		}
		Value values = new Value();
		values.setOptionId(optionId);
		values.setVariantId(variantId);
		values.setValue(value);
		valueRepository.save(values);
	}

//	private void saveOption(List<OptionModelRequest> optionModels, Integer id) {
//		if (optionModels == null) {
//			Options option = new Options();
//			OptionModelRequest optionModel = new OptionModelRequest();
//			optionModel.setDefaultOption(option, id);
//			option.setStatus(true);
//			optionRepository.save(option);
////			entityManager.persist(option);
//		} else {
//			int i = 1;
//			for (OptionModelRequest optionModelRequest : optionModels) {
//				Options option = new Options();
//				optionModelRequest.setOption(option, id);
//				option.setPosition(i++);
//				optionRepository.save(option);
////				entityManager.persist(option);
//			}
//		}
//	}

}

//if (option.getName().compareTo(NAME_DEFAULFT) == 0 || option.getName() == null) {
//	optionModel.setOption(option, productId);
//	optionRepository.save(option);
//	saveValue(optionModel.getValue(), variantId, option.getId());
//	break;
//} else if (option.getName().compareTo(optionModel.getName()) == 0) {
//	optionRepository.save(option);
//	break;
//} else if (option.getName() != null) {
//	continue;
//}
