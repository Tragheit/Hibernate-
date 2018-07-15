package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Address;
import tragheit.jpa.tutorial.domain.Employee;

public class Main {

	public static void main(String[] args) {				 
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee pracownik = new Employee();
	    Address address = new Address();
		
		pracownik.setFirstName("Jan");
		pracownik.setLastName("Kowalski");
		pracownik.setSalary(2500);
		
		address.setLocality("Gdynia");
		address.setZipCode("128-64");
		address.setStreet("Poziomkowa");
		address.setStreetNumber(13);
		
		pracownik.setAddress(address);
		
		entityManager.getTransaction().begin();
		entityManager.persist(pracownik);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
