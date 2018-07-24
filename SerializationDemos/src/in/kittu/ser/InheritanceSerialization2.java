package in.kittu.ser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Human implements Serializable{
	private int age;
	private String name;
	
	public Human() {}
	public Human(int age, String name) {
		System.out.println("Inside Human");
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

class Doctor extends Human{
	private double salary;
	private String job;
	
	public Doctor() {}
	public Doctor(String name, int age, double salary, String job) {		
		super(age, name);
		System.out.println("Inside Doctor");
		this.job = job;
		this.salary = salary;
	}
	public String toString() {
		return "Name= "+getName()+"\nAge= "+getAge()+"\nJob= "+job+"\nSalary= "+salary;
	}
}
public class InheritanceSerialization2 {
	public static void main(String[] args) {
		Doctor emp = new Doctor("Janu", 29, 25600.00, "JA");
		try {
			System.out.println("********Serialization*******");
			OutputStream os = new FileOutputStream("emp.txt");
			ObjectOutputStream oos = new ObjectOutputStream(os);
			oos.writeObject(emp);
			oos.close();
			
			System.out.println("********De-Serialization*******");
			InputStream is = new FileInputStream("emp.txt");
			ObjectInputStream ois = new ObjectInputStream(is);
			Doctor d = (Doctor)ois.readObject();
			ois.close();
			System.out.println(d );
		}catch(Exception exp) {
			exp.printStackTrace();
		}
	}
}
