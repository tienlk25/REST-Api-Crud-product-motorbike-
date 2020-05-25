package com.tienlk25.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.model.request.ProductModelRequest;
import com.tienlk25.model.response.ProductModelResponse;


@Transactional
public interface ProductService {

	List<ProductModelResponse> getAllProducts();
	
	ProductModelResponse getProductModelById(Integer id);
	
	ProductModelResponse getProductModelByProduct(Motorbikes motorbikes);
	ProductModelResponse updateProduct(ProductModelRequest motorbikeModel);
    ProductModelResponse saveProduct(ProductModelRequest motorbikeModel);
	
	boolean updateStatus(Integer id);
//	VariantModelResponse getVariantModelByVariant(Variants variant, List<Options> option);
	
	//OptionModelResponse getOptionModelByOption(Options option);

	
	
//	void saveVariant(List<VariantModelRequest> variantModels, Date date,Integer id) throws Exception;
//	
//	void saveOption(List<OptionModelRequest> optionModels,Integer id) throws Exception;
	
	
	
//	void updateVariant(List<VariantModelRequest> variantModels,Date date,Integer id) throws Exception;
//	
//	void updateOption(List<OptionModelRequest> optionModels,Integer variantId) throws Exception;
	
}
