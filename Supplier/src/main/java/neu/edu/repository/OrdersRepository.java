package neu.edu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.request.SupplierModel;
import neu.edu.entity.Item;
import neu.edu.entity.Orders;
import neu.edu.entity.Supplier;



public interface OrdersRepository extends JpaRepository<Orders, String>{
		// TODO Auto-generated constructor stub
	List<Orders> findBysupplierid(String supplierid);
	Orders findByorderid(int orderid);
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Orders s set s.status = ?2 where s.orderid = ?1")
	 void updateByorderid(int orderid, String status );
	}


