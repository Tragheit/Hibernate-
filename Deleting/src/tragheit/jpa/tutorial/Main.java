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
		pracownik.setLastName("Nowak");
		pracownik.setSalary(1000.0);

		entityManager.getTransaction().begin();
		entityManager.persist(pracownik);
		entityManager.getTransaction().commit();
		
		entityManager.getTransaction().begin();
		entityManager.remove(pracownik);
		entityManager.getTransaction().commit();
		
		
		entityManager.refresh(pracownik);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
