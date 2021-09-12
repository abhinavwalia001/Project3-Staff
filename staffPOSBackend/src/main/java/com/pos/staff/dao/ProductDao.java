package com.pos.staff.dao;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.pos.staff.entity.*;


@Repository
public interface ProductDao extends JpaRepository<Product,Integer>{

	@Transactional
	@Modifying
	@Query("update Product P set P.stock=:updatedStock where P.id=:id")
	public Integer updateStock(@Param("updatedStock") Integer stock,@Param("id") Integer id);

	@Query("From Product P where P.name=:name")
	public Optional<Product> findByName(@Param("name") String name);
	
	
	
	
}
