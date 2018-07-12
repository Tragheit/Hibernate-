package tragheit.jpa.tutorial;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Employee;

public class Main {


	public static void main(String[] args) {
		
		 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee testEmployee = new Employee();
//		testEmployee.setId(1L);   Rêczne ustawianie identyfikatora - niezalecane
		testEmployee.setFirstName("Jan");
		testEmployee.setLastName("Kowalski");
		testEmployee.setSalary(3500.0);
		testEmployee.setSalary2(new BigDecimal("1234.5"));
		
		entityManager.getTransaction().begin();
		entityManager.persist(testEmployee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
