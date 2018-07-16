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
			
		Employee employee = new Employee();
		Address address = new Address();
		
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(111.2);
		employee.setAddress(address);

		address.setLocality("Warszawa");
		address.setZipCode("11-333");
		address.setStreet("Poziomkowa");
		address.setStreetNumber(123);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(address);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
