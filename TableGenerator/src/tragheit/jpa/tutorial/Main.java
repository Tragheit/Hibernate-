package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import tragheit.jpa.tutorial.domain.Profesor;
import tragheit.jpa.tutorial.domain.Student;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		Profesor profesor = new Profesor();
		profesor.setFirstName("Jan");
		profesor.setLastName("Nowak");
		profesor.setSalary(7563.0);
		
		Student student = new Student();
		student.setFirstName("Marek");
		student.setLastName("Kowalski");
		student.setAverageGrade(4.75);
		
		entityManager.getTransaction().begin();
		entityManager.persist(profesor);
		entityManager.persist(student);
		entityManager.getTransaction().commit();
			
		entityManager.close();
		entityManagerFactory.close();
	}

}
