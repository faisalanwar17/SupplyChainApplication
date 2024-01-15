package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Distributer;
import neu.edu.entity.Manufactureorder;


public interface ManufactureorderRepository extends JpaRepository<Manufactureorder, String>{
	Manufactureorder findByorderid(int orderid);
	@Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Manufactureorder s set s.status = ?2 where s.orderid = ?1")
	 void updateByorderid(int orderid, String status );

}
