package tragheit.jpa.tutorial.domain;

import javax.persistence.Entity;

@Entity
public class Profesor extends Person{
	private double salary;

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
