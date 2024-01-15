package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Product;
import neu.edu.entity.Rawmaterial;



public interface ProductRepository extends JpaRepository<Product, String>{

	Product findByproductid(int productid);
	List<Product> findBymanufactureid(String manufactureid);
	List<Product> findByproductname(String productname);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Product s set s.availability = ?2,s.cost =?3 where s.productid = ?1")
	void updateByproductid(int id, int avai,int cost);
	@Transactional
	
	 @Query("select i from Product i where i.manufactureid=?1 and i.productname=?2")
	Product findbynameandid(String id, String name);
}
