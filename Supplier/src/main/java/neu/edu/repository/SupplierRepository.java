package neu.edu.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.request.SupplierModel;
import neu.edu.entity.Supplier;



public interface SupplierRepository extends JpaRepository<Supplier, String>{

	Supplier findBysupplierid(String supplierid);
	/*
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query("UPDATE Supplier s SET s.weather = :address WHERE c.id = :companyId")
    int updateSuppplier(@Param("companyId") int companyId);
    */
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Supplier s set s.weather = ?2,s.politicalissues =?3,s.labourissues =?4,s.driverissues =?5 where s.supplierid = ?1")
	 void updateBysupplierid(String id, String weather,String pi,String li, String di );
}
