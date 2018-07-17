package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Employee;


public class Main {

	public static void main(String[] args) {				 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee pracownik = new Employee();
		pracownik.setFirstName("Adam");
		pracownik.setLastName("Nowak");
		pracownik.setSalary(1500.0);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pracownik);
		entityManager.getTransaction().commit();
		
		entityManager.refresh(pracownik);
		
		System.out.println(pracownik.getFirstName() + "   " + pracownik.getLastName() + "   " + 
		pracownik.getSalary() + "   " + pracownik.getTax());
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
