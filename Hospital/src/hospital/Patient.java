package hospital;

import java.util.Scanner;

public class Patient implements PatientInterface {
    private String firstname, lastname;
    private int ssn;
    private String email, phoneNumber, address, dob;
    private int age;
    private String service;
    private double bill;
    public static int numPatients = 0;
    private int preferredDoc;
    
    public Patient() {
        numPatients++;
    }
    
    public Patient(String firstname, String lastname, int ssn, String email, String phoneNumber, String address, String dob, int age, String service, int preferredDoc) {
        numPatients++;
        this.firstname = firstname;
        this.lastname = lastname;
        this.ssn = ssn;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dob = dob;
        this.age = age;
        this.service = service;
        this.preferredDoc = preferredDoc;
        calcBill();
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

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getPreferredDoc() {
        return preferredDoc;
    }

    public void setPreferredDoc(int preferredDoc) {
        this.preferredDoc = preferredDoc;
    }

    public double getBill() {
        return bill;
    }

    public void setBill(double bill) {
        this.bill = bill;
    }
    
    public int getNumPatients(){
        return numPatients;
    }

    @Override
    public String toString() {
        String s="";
        
        s+= "\nFirst name: " + firstname;
        s+= "\nLast name: " + lastname;
        s+= "\nSSN: " + ssn;
        s+= "\nPhone number: " + phoneNumber;
        s+= "\nAddress: " + address;
        s+= "\nDate of birth: " + dob;
        s+= "\nAge: " + age;
        s+= "\nService: " + service;
        s+= "\nPreferred doctor: " + preferredDoc;
        s+= "\nBill: $" + bill;
        s+= instructions() + "\n";
        
        return s;
    }    
    
    public void getInput(){
        Scanner s = new Scanner (System.in);
        
        System.out.print("Enter patient first name: ");
        firstname = s.next();
        
        System.out.print("Enter patient last name: ");
        lastname = s.next();
        
        System.out.print("Enter patient SSN: ");
        ssn = s.nextInt();
        
        s.skip("\n");
        
        System.out.print("Enter patient email: ");
        email = s.nextLine();
        
        System.out.print("Enter patient phone number: ");
        phoneNumber = s.next();
        
        s.skip("\n");
        
        System.out.print("Enter patient address: ");
        address = s.nextLine();
        
        System.out.print("Enter patient date of birth(DD/MM/YYYY): ");
        dob = s.nextLine();
        
        System.out.print("Enter patient age: ");
        age = s.nextInt();
        
        s.skip("\n");
        
        System.out.print("Enter patient service (Surgery/Consultancy): ");
        service = s.nextLine();
        while (!service.equalsIgnoreCase("Surgery") && !service.equalsIgnoreCase("Consultancy")){
            System.out.print("Incorrect input. Please enter correct Service.\nEnter patient service (Surgery/Consultancy): ");
            service = s.nextLine();
        }
        calcBill();
    }
    
    public boolean checkSSN(int ssn){
        return this.ssn == ssn;
    }
    
    @Override
    public String instructions(){
        if(service.equalsIgnoreCase("Consultancy"))
            return "\nPlease be on time !!!";
        
        else if(service.equalsIgnoreCase("Surgery"))
            return "\nPlease do not eat 12 hours prior to the Surgery!";
        
        return "";
    }
    
    @Override
    public void calcBill(){
        if(service.equalsIgnoreCase("Consultancy"))
            bill = 400;
        
        else if(service.equalsIgnoreCase("Surgery"))
            bill = 1500;
    }
}
