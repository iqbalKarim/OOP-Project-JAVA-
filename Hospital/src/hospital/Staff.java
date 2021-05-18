package hospital;

import java.util.Scanner;

public abstract class Staff{
    protected String firstname, lastname;
    protected String email, phoneNumber, address;
    protected int id;
    protected double salary;
    public static int numStaff = 0;

    public Staff() {
        numStaff++;
    }

    public Staff(String firstname, String lastname, String email, String phoneNumber, String address, int id) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = id;
        numStaff++;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static int getNumStaff() {
        return numStaff;
    }

    public static void setNumStaff(int numStaff) {
        Staff.numStaff = numStaff;
    }

    @Override
    public String toString() {
        return "First Name: " + firstname + "\nLast Name: " + lastname + "\nEmail: " + email + "\nPhone Number: " + phoneNumber + "\nAddress: " + address + "\nID: " + id;
    }
    
    public void getInput(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter First Name: ");
        firstname = input.nextLine();
        System.out.print("Enter Last Name: ");
        lastname = input.nextLine();
        System.out.print("Enter Email: ");
        email = input.next();
        System.out.print("Enter Phone Number: ");
        phoneNumber = input.next();
        input.skip("\n");
        System.out.print("Enter Address: ");
        address = input.nextLine();
        
    }
    
    public boolean checkID(int id){
        return this.id == id;
    }
    
    public abstract String displayInfo();
    public abstract void calcSalary();
    public void addAppoitment(Patient p){};
}
