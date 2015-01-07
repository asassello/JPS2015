package pl.wcislo.sbql4j.examples.model.advanced;

import java.util.List;

public class Department {
	private List<Employee> employs;
	private Employee boss;
	private String name;
	private Double budget;
	private List<String> location;
	public Department(List<Employee> employs, Employee boss, String name, Double budget, List<String> location) {
		super();
		this.employs = employs;
		this.boss = boss;
		this.name = name;
		this.budget = budget;
		this.location = location;
	}
	public List<Employee> getEmploys() {
		return employs;
	}
	public void setEmploys(List<Employee> employs) {
		this.employs = employs;
	}
	public Employee getBoss() {
		return boss;
	}
	public void setBoss(Employee boss) {
		this.boss = boss;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getBudget() {
		return budget;
	}
	public void setBudget(Double budget) {
		this.budget = budget;
	}
	public List<String> getLocation() {
		return location;
	}
	public void setLocation(List<String> location) {
		this.location = location;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boss == null) ? 0 : boss.hashCode());
		result = prime * result + ((budget == null) ? 0 : budget.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (boss == null) {
			if (other.boss != null)
				return false;
		} else if (!boss.equals(other.boss))
			return false;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Department [boss=" + boss + ", name=" + name + ", budget="
				+ budget + ", location=" + location + "]";
	}
	
	
	
}
