package com.tienlk25.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienlk25.entity.Motorbikes;
import com.tienlk25.entity.Options;
import com.tienlk25.entity.Variants;
import com.tienlk25.repositories.OptionRepository;
import com.tienlk25.service.OptionService;

@Service
public class OptionServiceImpl implements OptionService {
	private OptionRepository optionRepository;
	@PersistenceContext
	EntityManager entityManager;


}
