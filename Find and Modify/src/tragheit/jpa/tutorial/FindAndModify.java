package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Employee;

public class FindAndModify {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
			
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("First name: " + employee.getFirstName());
		System.out.println("\nLast name: " + employee.getLastName());
		System.out.println("\nSalary: " + employee.getSalary());
		
		employee.setSalary(2000.);
		System.out.println("\nSalary: " + employee.getSalary());
		
		entityManager.getTransaction().commit();
	
		entityManager.close();
		entityManagerFactory.close();

	}

}
