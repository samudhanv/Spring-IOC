package in.kittu.ser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Person {//implements Serializable{
	private int age;
	private String name;
	
	public Person() {}
	public Person(int age, String name) {
		System.out.println("Inside Person");
		this.setAge(age);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Employee extends Person implements Serializable{
	private double salary;
	private String job;
	
	public Employee() {}
	public Employee(String name, int age, double salary, String job) {		
		super(age, name);
		System.out.println("Inside Employee");
		this.job = job;
		this.salary = salary;
	}
	public String toString() {
		return "Name= "+getName()+"\nAge= "+getAge()+"\nJob= "+job+"\nSalary= "+salary;
	}
}
public class InheritanceSerialization1 {
	public static void main(String[] args) {
		Employee emp = new Employee("Kittu", 33, 25600.00, "Consultant");
		try {
			System.out.println("********Serialization*******");
			OutputStream os = new FileOutputStream("emp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(emp);
			oos.close();
			
			System.out.println("********De-Serialization*******");
			InputStream is = new FileInputStream("emp.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			Employee e = (Employee)ois.readObject();
			ois.close();
			System.out.println(e);
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
}
