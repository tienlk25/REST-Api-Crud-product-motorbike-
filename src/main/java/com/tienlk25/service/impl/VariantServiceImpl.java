package com.tienlk25.service.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.entity.Variants;
import com.tienlk25.repositories.ProductRepoitory;
import com.tienlk25.repositories.OptionRepository;
import com.tienlk25.repositories.VariantRepository;
import com.tienlk25.service.VariantService;

@Service
public class VariantServiceImpl implements VariantService{
	private VariantRepository variantRepository;
	@PersistenceContext EntityManager entityManager;
	
	@Autowired
	public VariantServiceImpl(VariantRepository variantRepository,
			OptionRepository optionRepository) {
		this.variantRepository = variantRepository;
	}
	
}
