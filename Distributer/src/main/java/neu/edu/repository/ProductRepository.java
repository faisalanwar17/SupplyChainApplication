package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Distributer;
import neu.edu.entity.Product;


public interface ProductRepository extends JpaRepository<Product, String>{
	List<Product> findBydistributerid(String distributerid);
	List<Product> findByproductname(String productname);
	Product findByproductupc(String productupc);
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Product s set s.availability = ?2,s.cost = ?3 where s.productupc = ?1")
	 void updateByproductupc(String productupc, int availability,int cost );
	 @Transactional
	 @Query("select i from Product i where i.distributerid=?1 and i.productname=?2")
	 Product findBydistributeridandname(String id, String name);
}
