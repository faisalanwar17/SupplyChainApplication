package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Product;
import neu.edu.entity.Supplierorder;



public interface SupplierorderRepository extends JpaRepository<Supplierorder, String>{

	Supplierorder findByorderid(int orderid);
	@Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Supplierorder s set s.status = ?2 where s.orderid = ?1")
	 void updateByorderid(int orderid, String status );
}
