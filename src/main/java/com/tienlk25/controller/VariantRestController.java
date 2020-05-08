package com.tienlk25.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienlk25.entity.Variants;
import com.tienlk25.model.response.OptionModelResponse;
import com.tienlk25.model.response.VariantModelResponse;
import com.tienlk25.entity.Options;
import com.tienlk25.service.OptionService;
import com.tienlk25.service.ProductService;
import com.tienlk25.service.VariantService;

@RestController
public class VariantRestController {

//	private VariantService variantService;
//	private OptionService optionService;
//	private ValueService valueService;
//	
//	@Autowired
//	public VariantRestController(VariantService variantService, ValueService valueService, OptionService optionService) {
//		this.variantService = variantService;
//		this.valueService = valueService;
//		this.optionService = optionService;
//	}
//
//	@GetMapping("/admin/products/{id}/variants")
//	public ResponseEntity<List<VariantModel>> getCategories(@PathVariable("id") Integer id) {
//		List<Variants> listVariants = variantService.findListVarriantByIdOfProdust(id);
//		System.out.println(listVariants+ "================================================================================");
//		if(listVariants.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//		}
//		List<VariantModel> variantModelList = new ArrayList<VariantModel>();
//		List<OptionModel> optionModelList = new ArrayList<OptionModel>();
//		for (Variants variant : listVariants) {
//		    List<Options> listOption = optionService.findListOptionsByIdOfVarriant(variant.getId());
//		    for (Options option : listOption) {
//				List<Value> listValue = valueService.findValueByIdOfOption(option.getId()); 
//				String[] values = new String[listValue.size()];
//				for (int i = 0; i < listValue.size(); i++) {
//					values[i] = listValue.get(i).getName();
//				}
//				OptionModel optionModel = new OptionModel(option, values);
//				optionModelList.add(optionModel);
//			}
//		    VariantModel variantModel = new VariantModel(variant, optionModelList);
//		    variantModelList.add(variantModel);  
//		}
//		
//		return new ResponseEntity<>(variantModelList, HttpStatus.OK);
//	}
//
//	@GetMapping("/admin/variants/{id}")
//	public ResponseEntity<VariantModel> getVariantById(@PathVariable("id") Integer id) {
//
//		Variants variant = variantService.findById(id);
//		
//		    List<Options> listOption = optionService.findListOptionsByIdOfVarriant(variant.getId());
//			List<OptionModel> optionModelList = new ArrayList<OptionModel>();
//		    for (Options option : listOption) {
//				List<Value> listValue = valueService.findValueByIdOfOption(option.getId()); 
//				String[] values = new String[listValue.size()];
//				for (int i = 0; i < listValue.size(); i++) {
//					values[i] = listValue.get(i).getName();
//				}
//				OptionModel optionModel = new OptionModel(option, values);
//				optionModelList.add(optionModel);
//			}
//		    VariantModel variantModel = new VariantModel(variant, optionModelList);
//		
//		return new ResponseEntity<>(variantModel, HttpStatus.OK);
//	}
//
//	@SuppressWarnings("null")
//	@PostMapping("/products/{id}/variants")
//	public ResponseEntity<ObjectResponse> createProduct(@PathVariable("productId") Integer id,@ModelAttribute Variants variants) {
//		List<Variants>  countVariants = variantService.findListVarriantByIdOfProdust(id);
//		Calendar calendar = Calendar.getInstance();
//		Date date = calendar.getTime();
//		variants.setCreateOn(date);
//		variants.setModifiedOn(date);
//		variants.setStatus(true);
//		variants.setPosition(countVariants.size() + 1);
//	    variants.setMotorbikeId(id);
//		variantService.save(variants);
//		List<Options> options = new ArrayList<Options>();
//		for (int i = 0; i < 3; i++) {
//			Options option = new Options();
//			option.setPosition(i+1); 
//			option.setStatus(true);
//			option.setVariantId(variants.getId());
//			optionService.save(option);
//			options.add(option);
//		}
//		return ResponseEntity.ok(ObjectResponse.success(variants));
//	}
//
//	@PutMapping("/variants/{id}")
//	public ResponseEntity<Variants> updatProduct(@PathVariable("id") Integer id, @ModelAttribute Variants variants) {
//		Variants currentProduct = variantService.findById(id);
//		if(variants.getTitle() != null) {
//			currentProduct.setTitle(variants.getTitle());
//		}
//
//		Calendar calendar = Calendar.getInstance();
//		Date update = calendar.getTime();
//		variants.setModifiedOn(update);
//		variantService.save(currentProduct);
//		return new ResponseEntity<>(currentProduct, HttpStatus.OK);
//	}
//
//	@DeleteMapping("/product/{productId}/variants/{id}")
//	public ResponseEntity<Variants> deleteProduct(@PathVariable("id") Integer id) {	
//		Variants variants = variantService.findById(id);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}	
}
