package neu.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.entity.Distributer;


public interface DistributerRepository extends JpaRepository<Distributer, String>{

	Distributer findBydistributerid(String distributerid);
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Distributer s set s.weather = ?2,s.politicalissues =?3,s.labourissues =?4,s.driverissues =?5 where s.distributerid = ?1")
	 void updateBydistributerid(String id, String weather,String pi,String li, String di );
}
