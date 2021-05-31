package employee_package;
import java.util.Scanner;
//import java.util.regex.*;
public class Employee
{
	private String e_name;
	private int e_id;
	private String e_role;
	private String e_contact_no;
	private String e_email;
	private String e_address;
	private double e_salary;
	private static int IDgenerator=0;
	Scanner sc=new Scanner(System.in);
	public Employee()  //default constructor
	{
		// IDgenerator++;
		// e_id = IDgenerator;
	}
	//Getter and Setter Method for instance variables
	public String getE_name() {
		return e_name;
	}

	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public int getE_id()
	{
		return e_id;
	}
	public void setE_id(int e_id)
	{
		this.e_id=e_id;
	}

	public String getE_role() {
		return e_role;
	}

	public void setE_role(String e_role) {
		this.e_role = e_role;
	}

	public String getE_contact_no() {
		return e_contact_no;
	}

	public void setE_contact_no(String e_contact_no) {
		this.e_contact_no = e_contact_no;
	}

	public String getE_email() {
		return e_email;
	}

	public void setE_email(String e_email) {
		this.e_email = e_email;
	}

	public String getE_address() {
		return e_address;
	}

	public void setE_address(String e_address) {
		this.e_address = e_address;
	}

	public double getE_salary() {
		return e_salary;
	}

	public void setE_salary(double e_salary) {
		this.e_salary = e_salary;
	}
	public static int getIDgenerator() {
		return IDgenerator;
	}

	public static void setIDgenerator(int iDgenerator) {
		IDgenerator = iDgenerator;
	}
}
