package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		Employee employee1 = new Employee();
		employee1.setFirstName("Jan");
		employee1.setLastName("Nowak");
		employee1.setSalary(3333.3);
		
		Employee employee2 = new Employee();
		employee2.setFirstName("Robert");
		employee2.setLastName("Bednarek");
		employee2.setSalary(4444.4);
		
		Employee employee3 = new Employee();
		employee3.setFirstName("Damian");
		employee3.setLastName("Stach");
		employee3.setSalary(5555.5);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee1);
		entityManager.persist(employee2);
		entityManager.persist(employee3);
		entityManager.getTransaction().commit();
			
		entityManager.close();
		entityManagerFactory.close();
	}

}
