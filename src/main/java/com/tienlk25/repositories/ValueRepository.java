package com.tienlk25.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienlk25.entity.Value;

@Repository
public interface ValueRepository extends JpaRepository<Value, Integer>{

	@Query(value = "select p from Value p where p.variantId = :variantId and p.optionId = :optionId")
	Value findValueByIdOfVariantAndOption(@Param("variantId") Integer variantId, @Param("optionId") Integer optionId);
	
	@Query(value = "select p from Value p where p.optionId = :optionId")
	List<Value> findValueByIdOfOption(@Param("optionId") Integer optionId);
}
