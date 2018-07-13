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
		pracownik.setFirstName("Jan");
		pracownik.setLastName("Kowalski");
		pracownik.setSalary(2650);
		pracownik.setLocality("Warszawa");
		pracownik.setZipCode("05-125");
		pracownik.setStreet("Prosta");
		pracownik.setStreetNumber(14);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pracownik);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
