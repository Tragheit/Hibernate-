package tragheit.jpa.tutorial;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import tragheit.jpa.tutorial.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();

		Query query = entityManager.createQuery(
				"select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e.salary) from Employee e");

		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Œrednia: " + result[0]);
		System.out.println("Min: " + result[1]);
		System.out.println("Max: " + result[2]);
		System.out.println("Suma: " + result[3]);
		System.out.println("Iloœæ: " + result[4]);

		Query query2 = entityManager.createQuery(
				"select substring(e.firstName, 1, 3), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Karol' ");
		
		Object[] result2 = (Object[]) query2.getSingleResult();
		System.out.println("3 litery imienia: " + result2[0]);
		System.out.println("nazwisko bez spacji: " + result2[1]);
		System.out.println("imie ma³ymi: " + result2[2]);
		System.out.println("imiê wielkimi: " + result2[3]);
		System.out.println("d³ugoœc imienia: " + result2[4]);
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

	private static void addEmployees() {
		addEmployee("Karol", "Mateusiak", 2633);
		addEmployee("Marika", "Bednarek", 2345);
		addEmployee("Jan", "Mateusiak", 7346);
		addEmployee("Daria", "Kowalska", 2352);
		addEmployee("Monika", "Uciñska", 4263);
		addEmployee("Ernest", "Paj¹k", 2634);
		addEmployee("Kamil", "Stêpieñ", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "Wozniak", 3324);
		addEmployee("Agnieszka", "Nowak", 2000);
		addEmployee("Angelika", "Bednarska", 1000);
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}
