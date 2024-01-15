package neu.edu.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Manufacture;
import neu.edu.entity.Product;



public interface ManufactureRepository extends JpaRepository<Manufacture, String>{
	Manufacture findBymanufactureid(String manufactureid);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Manufacture s set s.weather = ?2,s.politicalissues =?3,s.labourissues =?4,s.driverissues =?5 where s.manufactureid = ?1")
	 void updateBymanufactureid(String id, String weather,String pi,String li, String di );


}
