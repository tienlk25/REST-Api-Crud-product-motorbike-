package com.tienlk25.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.exceptiones.NotFoundId;
import com.tienlk25.exceptiones.OptionCheckingException;
import com.tienlk25.model.request.ProductModelRequest;
import com.tienlk25.model.response.ProductModelResponse;
import com.tienlk25.service.ProductService;

@RestController
@RequestMapping(value = "/admin/products")
@Validated
public class ProductRestController {

	private ProductService productService;
//	private VariantService variantService;
//	private OptionService optionService;

	@Autowired
	public ProductRestController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<ProductModelResponse>> findAllProduct() {
		List<ProductModelResponse> motorbikes = productService.getAllProducts();
		if (motorbikes == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(motorbikes, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
		ProductModelResponse motorbikes = productService.getProductModelById(id);
		return new ResponseEntity<ProductModelResponse>(motorbikes, HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductModelRequest motorbikeModel) {
		if (motorbikeModel == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

		ProductModelResponse motorbike = productService.saveProduct(motorbikeModel);
		if (motorbike == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(motorbike, HttpStatus.OK);
	}

	@PutMapping(value = { "/{id}" }, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,
			@Valid @RequestBody ProductModelRequest motorbikeModel) {
		if (motorbikeModel == null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		ProductModelResponse motorbike = productService.updateProduct(motorbikeModel);
		return new ResponseEntity<>(motorbike, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Motorbikes> deleteProduct(@PathVariable Integer id) {
		if (productService.updateStatus(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
