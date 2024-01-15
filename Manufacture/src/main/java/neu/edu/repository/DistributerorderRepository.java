package neu.edu.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Distributerorder;
import neu.edu.entity.Manufacture;
import neu.edu.entity.Product;



public interface DistributerorderRepository extends JpaRepository<Distributerorder, String>{
	List<Distributerorder> findBymanufactureid(String manufactureid);
	Distributerorder findByorderid(int orderid);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Distributerorder s set s.status = ?2 where s.orderid = ?1")
	 void updateByorderid(int id, String status );
	
}
