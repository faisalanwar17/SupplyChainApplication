package neu.edu.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.request.SupplierModel;
import neu.edu.entity.Item;
import neu.edu.entity.Supplier;



public interface ItemRepository extends JpaRepository<Item, String>{
	List<Item> findBysupplierid(String supplierid);
	List<Item> findByitemname(String itemname);
	Item findByitemid(int itemid);
	
	@Transactional
	
	@Query("select i from Item i where i.supplierid=?2 and i.itemname=?1")
	Item checkItem(String name, String id);
	@Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Item s set s.availability = ?2,s.cost =?3 where s.itemid = ?1")
	 void updateByItemid(int id, int avai,int cost);
}
