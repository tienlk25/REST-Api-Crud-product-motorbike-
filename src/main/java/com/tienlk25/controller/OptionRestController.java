package com.tienlk25.controller;

import java.sql.SQLSyntaxErrorException;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienlk25.entity.Variants;
import com.tienlk25.service.OptionService;
import com.tienlk25.service.VariantService;
import com.tienlk25.entity.Options;

@RestController
@RequestMapping(value = "/options")
public class OptionRestController {

//	private OptionService optionService;
//	private VariantService variantService;
//
//	public OptionRestController(OptionService optionService,VariantService variantService) {
//		this.optionService = optionService;
//		this.variantService = variantService;
//	}
//
//	@GetMapping(value = "/")
//	public ResponseEntity<List<Options>> getCategories() {
//		List<Options> products = optionService.getAllColor();
//		if (products.isEmpty()) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		Iterator itr = products.iterator(); 
//		while (itr.hasNext()) {
//            Options element = (Options) itr.next();
//            if(!element.getStatus()) {
//            	itr.remove();
//            }
//        }
//		return new ResponseEntity<>(products, HttpStatus.OK);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<Options> getCategoryById(@PathVariable("id") Integer id) {
//
//		Options options = optionService.findById(id);// motorbikeRepoitory.findById(id);
//
//		return new ResponseEntity<>(options, HttpStatus.OK);
//	}
//
//	@PostMapping(value = "/{id}")
//	public ResponseEntity<Options> createProduct(@PathVariable("id") Integer id,
//			@ModelAttribute Options option) {
//		int i = 0;
//		Calendar cal = Calendar.getInstance();
//		Date dateNow = cal.getTime();
//		
//		List<Options> options = optionService.findListOptionsByIdOfVarriant(id);
////		System.out.println(options);
//		if(options.size() >= 0) {
////			System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
//			for (i = 0; i < 3; i++) {
//				if(options.get(i).getName() != null) {
////		System.out.println(i + "==========================================================================================");
//					continue;
//				}if(options.get(i).getName() == option.getName()) {
//					return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
//				}
//				break;
//			}
//			if(i >= 3) {
//				return new ResponseEntity<>( HttpStatus.METHOD_NOT_ALLOWED);
//			}
//			Options curentOptions = options.get(i);
//			curentOptions.setName(option.getName());		
//			curentOptions.setCreateOn(dateNow);
//			curentOptions.setModifiedOn(dateNow);
//			curentOptions.setStatus(true);
//			optionService.save(curentOptions);
//			return new ResponseEntity<>(curentOptions, HttpStatus.CREATED);
//		}else {
//			option.setCreateOn(dateNow);
//			option.setModifiedOn(dateNow);
//			option.setStatus(true);
//			optionService.save(option);
//			return new ResponseEntity<>(option, HttpStatus.CREATED);
//		}
//	}
//
//	@PutMapping(value = "/{id}")
//	public ResponseEntity<Options> updatProduct(@PathVariable("id") Integer id,
//			@ModelAttribute Options options) {
//		Options currentOption= optionService.findById(id);
//		currentOption.setName(options.getName());
//		
//		Calendar calendar = Calendar.getInstance();
//		Date update = calendar.getTime();
//		currentOption.setModifiedOn(update);
//		optionService.save(currentOption);
//		return new ResponseEntity<>(currentOption, HttpStatus.OK);
//	}
// 
//	@DeleteMapping(value = "/{id}")
//	public ResponseEntity<Options> deleteProduct(@PathVariable Integer id) {
//		Options options = optionService.findById(id);
//		options.setStatus(false);
//		optionService.save(options);
//		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	}

}
