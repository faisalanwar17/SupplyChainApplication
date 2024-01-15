package neu.edu.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.model.EmployeeModel;
import neu.edu.entity.Customers;
import neu.edu.entity.Employee;
@Repository
public class EmployeeRepository {

	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
	}
	@PersistenceContext
	private EntityManager em;
/*
	@Transactional
	public List<Users> getAllUsers() {
		return (List<Users>)em.createQuery("from Users").getResultList();
	}
	*/
	
	@Transactional
	public boolean save(Employee employee) {
		try {
			em.persist(employee);
			System.out.println("inserted");
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	@Transactional
	public Employee findByUserName(String username) {
		
		if(false) {
			String sql = "SELECT u from Employee u where u.username = '" + username + "'";
			Query query = em.createQuery(sql);
			Employee employee = null;
			try {
				employee = (Employee) query.getSingleResult();
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			return employee;
		}else {
			return (Employee)em.find(Employee.class, username);
		}
		
		//return (Customers)em.find(Customers.class, username);
	}

}
