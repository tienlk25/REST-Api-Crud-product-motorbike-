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
	
	@Query(value = "Update Options set status = 0 where id = :id")
	void deleteStatus(@Param("id") Integer id);
	
	@Query(value = "select p from Options p where p.variantId = :id and p.status = :status")
	List<Options> findAllOptionsByIdOfVarriant(@Param("id") Integer id, @Param("status") Boolean status);


}
