package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Product;
import neu.edu.entity.Rawmaterial;

public interface RawmaterialsRepository extends JpaRepository<Rawmaterial, String>{

	List <Rawmaterial> findBymanufactureid(String manufactureid);
	Rawmaterial findBymaterialid(String rawmaterialid);
	 @Transactional
	 @Modifying(clearAutomatically = true)
	 @Query("update Rawmaterial s set s.availability = ?2 where s.materialid = ?1")
	 void updateBymaterialid(String materialid, int availability );
	 @Transactional
		
	 @Query("select i from Rawmaterial i where i.manufactureid=?2 and i.itemname=?1")
	 Rawmaterial getrawmaterial(String name, String id);
}
