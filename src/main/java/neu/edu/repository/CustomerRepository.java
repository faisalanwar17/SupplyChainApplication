package neu.edu.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import neu.edu.controller.model.Customer;
import neu.edu.entity.Customers;

@Repository
public class CustomerRepository {

	public CustomerRepository() {
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
	public boolean save(Customers customers) {
		try {
			em.persist(customers);
			System.out.println("inserted");
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}
	@Transactional
	public Customers findByUserName(String username) {
		
		if(false) {
			String sql = "SELECT u from Customers u where u.username = '" + username + "'";
			Query query = em.createQuery(sql);
			Customers customer = null;
			try {
			 customer = (Customers) query.getSingleResult();
			}catch(Exception ex) {
				System.out.println(ex.getMessage());
			}
			return customer;
		}else {
			return (Customers)em.find(Customers.class, username);
		}
		
		//return (Customers)em.find(Customers.class, username);
	}

}
