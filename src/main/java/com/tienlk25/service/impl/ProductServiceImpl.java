package com.tienlk25.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.entity.Options;
import com.tienlk25.entity.Variants;
import com.tienlk25.model.request.ProductModelRequest;
import com.tienlk25.model.request.OptionModelRequest;
import com.tienlk25.model.request.VariantModelRequest;
import com.tienlk25.model.response.ProductModelResponse;
import com.tienlk25.model.response.OptionModelResponse;
import com.tienlk25.model.response.VariantModelResponse;
import com.tienlk25.repositories.ProductRepoitory;
import com.tienlk25.repositories.OptionRepository;
import com.tienlk25.repositories.VariantRepository;
import com.tienlk25.service.ProductService;

@Service
@Transactional(rollbackOn = Exception.class)
public class ProductServiceImpl implements ProductService {

	private ProductRepoitory productRepoitory;
	private VariantRepository variantRepository;
	private OptionRepository optionRepository;

//	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager entityManager = Persistence.createEntityManagerFactory("persistence").createEntityManager();
//	@PersistenceContext(type = PersistenceContextType.EXTENDED)
//	EntityManager entityManager;

	@Autowired
	public ProductServiceImpl(ProductRepoitory productRepoitory, VariantRepository variantRepository,
			OptionRepository optionRepository) {
		this.productRepoitory = productRepoitory;
		this.variantRepository = variantRepository;
		this.optionRepository = optionRepository;
	}

	@Override
	public List<ProductModelResponse> getAllProducts() {
		List<Motorbikes> motorbikes = productRepoitory.findAllProduct();
		List<ProductModelResponse> motorbikeModels = new ArrayList<ProductModelResponse>();
		try {
			System.out.println(motorbikes.size() + "                                     length");
			for (Motorbikes motorbike : motorbikes) {
				
				//System.out.println(motorbike.getName() + "mototrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
				ProductModelResponse productModel = getProductModelByProduct(motorbike);
				//System.out.println(motorbikeModel.getName() + "-----------------------------------");
				motorbikeModels.add(productModel);
			}
			return motorbikeModels;
		} catch (NullPointerException e) {
			System.out.println(e+"=====================================");
			return null;
		}catch (Exception e) {
			System.out.println(e+"=====================================");
			return null;
		}
	}

	@Override
	public ProductModelResponse getProductModelByProduct(Motorbikes motorbikes) {
		System.out.println(motorbikes.getName() + "               75");
		List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(motorbikes.getId(), true);
		System.out.println(variants.size() + "                         list variant");
		List<VariantModelResponse> variantModels = new ArrayList<>();
		List<Options> options = new ArrayList<Options>();
		try {
			for (Variants variant : variants) {
				
				VariantModelResponse variantModel = getVariantModelByVariant(variant,options);
				variantModels.add(variantModel);
			}
			
			ProductModelResponse motorbikeModel = new ProductModelResponse(motorbikes, variantModels,getOptionsModelByOption(options,motorbikes.getId()));
			return motorbikeModel;
		} catch (Exception e) {
			return null;
		}
	}

	private VariantModelResponse getVariantModelByVariant(Variants variant , List<Options> optionsList) {
		List<Options> options = optionRepository.findAllOptionsByIdOfVarriant(variant.getId(), true);
		System.out.println(options.size() + "                tttttttttttttttttttttttttttttttttttttttttttttttt92");
		optionsList.addAll(options);
		try {
			String[] optionString = new String[3];
			int i  = 0;
			for (Options option : options) {
				optionString[i++] = option.getValue();
			}
			VariantModelResponse variantModels = new VariantModelResponse(variant, optionString);
			System.out.println(variantModels + "modelllllllllllllllllllllllllllllllllllllllllllllllllllllllllll");
			return variantModels;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ProductModelResponse updateProduct(ProductModelRequest productModel) throws Exception {
		Motorbikes currentProduct = productRepoitory.findByIdAndStatus(productModel.getId(), true);
//		System.out.println(motorbikeModel.getId());
//		System.out.println(motorbikeModel.getVariants().get(1).getWeight());
		if (currentProduct == null) {
			return null;
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
	
	

	@Override
	public ProductModelResponse getProductModelById(Integer id) {
		try {
			Motorbikes motorbikes = productRepoitory.findByIdAndStatus(id, true);
			
			return getProductModelByProduct(motorbikes);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean updateStatus(Integer id) {
		List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(id, true);
		List<Options> options = new ArrayList<Options>();
		try {
			for (Variants variant : variants) {
				options = optionRepository.findAllOptionsByIdOfVarriant(variant.getId(), true);
				for(Options option : options) {
					optionRepository.deleteStatus(option.getId());
				}
				variantRepository.deleteStatus(variant.getId());
			}
			productRepoitory.deleteStatus(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ProductModelResponse saveProduct(ProductModelRequest productModel) throws Exception {

		if (productModel.getName() == null) {
			return null;
		}
//			entityManager.getTransaction().begin();
		Calendar calendar = Calendar.getInstance();
		Date date = (Date) calendar.getTime();
		Motorbikes motorbike = new Motorbikes();
		productModel.setMotorbike(motorbike, date);
		motorbike.setStatus(true);
//			entityManager.persist(motorbike);
		productRepoitory.save(motorbike); 
		saveVariant(productModel.getVariants(), date, motorbike.getId());
//				entityManager.flush();
//			entityManager.getTransaction().commit();
//			entityManager.getTransaction().rollback();

		ProductModelResponse modelResponse = getProductModelByProduct(motorbike);
		return modelResponse;
	}

	
	private void saveVariant(List<VariantModelRequest> variantModels, Date date, Integer id) throws Exception {
		if (variantModels == null) {
			VariantModelRequest variantModelRequest = new VariantModelRequest();
			Variants variant = new Variants();
			variantModelRequest.setDefaultVariant(variant, date, id);
			if (variantRepository.save(variant) == null) {
				throw new Exception();
			}
//			entityManager.persist(variant);
			saveOption(null, variant.getId());
		} else {
			int i = 1;
			for (VariantModelRequest variantModel : variantModels) {
				Variants variant = new Variants();
				variantModel.setVarriant(variant, date, id);
				variant.setStatus(true);
				variant.setPosition(i++); // https:stackjava.com/wp-content/uploads/2018/05/hibernate-entitymanager-2.png
				variantRepository.save(variant);
//				entityManager.persist(variant);
				saveOption(variantModel.getOptions(), variant.getId());
			}

		}
	}
	
	private void saveOption(List<OptionModelRequest> optionModels, Integer id) throws Exception {
		if (optionModels == null) {
			Options option = new Options();
			OptionModelRequest optionModel = new OptionModelRequest();
			optionModel.setDefaultOption(option, id);
			option.setStatus(true);
			optionRepository.save(option);
//			entityManager.persist(option);
		} else {
			int i = 1;
			for (OptionModelRequest optionModelRequest : optionModels) {
				Options option = new Options();
				optionModelRequest.setOption(option, id);
				option.setPosition(i++);
				optionRepository.save(option);	
//				entityManager.persist(option);
			}
		}
	}
	
/*	private void saveOption(List<OptionModelRequest> optionModels, Integer id) throws Exception {
		if (optionModels == null) {
			Options option = new Options();
			OptionModelRequest optionModel = new OptionModelRequest();
			optionModel.setDefaultOption(option, id);
			option.setStatus(true);
			optionRepository.save(option);
//			entityManager.persist(option);
			int i = 2;
			while (i <= 3) {
				Options optionAdd = new Options();
				optionAdd.setPosition(i++);
				optionAdd.setVariantId(id);
				optionAdd.setStatus(true);
				optionRepository.save(optionAdd);
//				entityManager.persist(optionAdd);
			}
		} else {
			int i = 1;
			for (OptionModelRequest optionModelRequest : optionModels) {
				Options option = new Options();
				optionModelRequest.setOption(option, id);
				option.setPosition(i++);
				optionRepository.save(option);	
//				entityManager.persist(option);
			}
			while (i <= 3) {
				Options option = new Options();
				OptionModelRequest optionModelRequest = new OptionModelRequest();
				optionModelRequest.setOption(option, id);
				option.setPosition(i++);
				option.setStatus(true);
				optionRepository.save(option);
//				entityManager.persist(option);
			}
		}
	}*/
	
	private void updateVariant(List<VariantModelRequest> variantModels, Date modifiedOn, Integer id) throws Exception {
		if (variantModels == null) {
			return;
		} else {
			List<Variants> variants = variantRepository.findListVarriantByIdOfProdust(id, true);
			int i = 1;
			for(Variants variant : variants) {
				for (VariantModelRequest variantModelRequest : variantModels) {
					Variants currentVariant = variant;
					if (variantModelRequest.getId() == null) {
						variantModelRequest.setVarriant(currentVariant, modifiedOn, id);
						currentVariant.setStatus(true);
					} else {
						variantModelRequest.setVarriant(currentVariant, modifiedOn, id);
					}
					if(variantModels.size() == variants.size()) {
						currentVariant.setPosition(i++);
					}
					variantRepository.save(currentVariant);
					updateOption(variantModelRequest.getOptions(), currentVariant.getId());
				}
			}
		}
		return;
	}

	private void updateOption(List<OptionModelRequest> optionModels, Integer variantId) throws Exception {
		if (optionModels == null) {
			return;
		} else {
			List<Options> options = optionRepository.findAllOptionsByIdOfVarriant(variantId, true);
			if (options.size() == 0) {
				saveOption(optionModels, variantId);
				return;
			}
			for (OptionModelRequest optionModel : optionModels) {
				for (int i = 0; i < 3; i++) {
					Options option = options.get(i);
					if (option.getName().compareTo(optionModel.getName()) == 0) {
						option.setValue(optionModel.getValue());
						optionRepository.save(option);
						break;
				    } else if (option.getName().compareTo("Title") == 0 || option.getName() == null ) {
						optionModel.setOption(option, variantId);
						optionRepository.save(option);
						break;
					} else if (option.getName() != null) {
						continue;
					}
				}
			}
		}
	}

	private List<OptionModelResponse> getOptionsModelByOption(List<Options> options,Integer id) {
		List<OptionModelResponse> optionModels = new ArrayList<OptionModelResponse>();
		OptionModelResponse optionModel1 = new OptionModelResponse(options.get(0), id);
		OptionModelResponse optionModel2 = new OptionModelResponse(options.get(1), id);
		OptionModelResponse optionModel3 = new OptionModelResponse(options.get(2), id);
			for (Options option : options) {
				if(option.getPosition() == 1) {
					optionModel1.addValue(option.getValue());
				}if(option.getPosition() == 2) {
					optionModel2.addValue(option.getValue());
				}if(option.getPosition() == 3) {
					optionModel3.addValue(option.getValue());
				}
			}
			if(optionModel1.getName() != null) {
				optionModels.add(optionModel1);
			}if(optionModel2.getName() != null) {
				optionModels.add(optionModel2);
			}if(optionModel3.getName() != null) {
				optionModels.add(optionModel3);
			}
		return optionModels;
	}
}
