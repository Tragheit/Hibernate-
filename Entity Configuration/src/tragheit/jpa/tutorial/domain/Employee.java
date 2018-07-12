package tragheit.jpa.tutorial.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	//warto�ci dla zmiennej Id b�d� generowane automatycznie (nie trzeba ich r�cznie uzupe�nia�)
	@Column(name = "imie", nullable = false, length = 10)
	private String firstName;
	@Column(name = "nazwisko", columnDefinition = "VARCHAR(10) NOT NULL" )
	private String lastName;
	@Column(name = "pensja")
	private double salary;
	@Column(precision = 10, scale = 2)
	private BigDecimal salary2;

	public BigDecimal getSalary2() {
		return salary2;
	}

	public void setSalary2(BigDecimal salary2) {
		this.salary2 = salary2;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}


}
