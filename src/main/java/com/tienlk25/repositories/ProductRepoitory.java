package com.tienlk25.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienlk25.entity.Motorbikes;

@Repository
public interface ProductRepoitory extends JpaRepository<Motorbikes, Integer>{
	
     
	@Query(value = "select p from Motorbikes p where p.status = 1")
    List<Motorbikes> findAllProduct();
	
	@Query(value = "select p from Motorbikes p where p.id = :id and p.status = :status")
	Motorbikes findByIdAndStatus(@Param("id") Integer id, @Param("status") Boolean status);
    
//	@Query(value = "select p from Variants p where p.motorbikeId= :id and p.status = :status")
//	List<Variants> findListVariantByProductId(@Param("id") Integer id, @Param("status") Boolean status);
	
	@Query(value = "Update Motorbikes set status = :status where id = :id")
    public void updateStatusById(@Param("id") Integer id, @Param("status") Boolean status);
	
	@Query(value = "select p.name from Motorbikes p where p.name= :name and p.status = :status")
	String findNameByName(@Param("name") String name, @Param("status") Boolean status);
	
}

