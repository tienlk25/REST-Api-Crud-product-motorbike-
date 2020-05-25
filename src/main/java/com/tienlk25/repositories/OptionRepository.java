package com.tienlk25.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienlk25.entity.Options;

@Repository
public interface OptionRepository extends JpaRepository<Options, Integer>{
	@Query(value = "Select o from Options o where o.id = :id and o.status = :status")
    Options findByIdAndStatus(@Param("id") Integer id, @Param("status") Boolean status);
	
	
	@Query(value = "Update Options o set status = :status where o.productId = :id")
	public void updateStatusByIdProduct(@Param("id") Integer id, @Param("status") Boolean status);
	
	@Query(value = "select p from Options p where p.productId = :id and p.status = :status")
	List<Options> findAllOptionsByIdOfProduct(@Param("id") Integer id, @Param("status") Boolean status);


}
