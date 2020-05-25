package com.tienlk25.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tienlk25.entity.Variants;

@Repository
public interface VariantRepository extends JpaRepository<Variants, Integer>{

	@Query(value = "select v from Variants v where v.motorbikeId = :id and v.status = :status")
	List<Variants> findListVarriantByIdOfProdust(@Param("id") Integer id, @Param("status") Boolean status);
	
	@Query(value = "select p from Variants p where p.id = :id and p.status = :status")
	Variants findByIdAndStatus(@Param("id") Integer id, @Param("status") Boolean status);
	
	@Query(value = "Update Variants set statu = :status where motorbikeId = :id")
    public void updateStatusByIdProduct(@Param("id") Integer id, @Param("status") Boolean status);
	
}
