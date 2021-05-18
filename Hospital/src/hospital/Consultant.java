package hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Consultant extends Staff {
    public static int numConsultants = 0;
    private String speciality;
    private double perConsultance;
    private int countConsultance;
    private ArrayList<Patient> schedule = new ArrayList();

    public Consultant() {
        numConsultants++;
    }
    
    public Consultant(String firstName, String lastName, String email, String phoneNumber, String address, int id, String speciality, double perConsultance, int countConsultance, ArrayList<Patient> schedule) {
        super(firstName, lastName, email, phoneNumber, address, id);
        this.speciality = speciality;
        this.perConsultance = perConsultance;
        this.countConsultance = countConsultance;
        calcSalary();
        numConsultants++;
        this.schedule = schedule;
    }
    
    public Consultant(int id) {
        numConsultants++;
        this.id = id;
    }
    
    public Consultant(String firstName, String lastName, String email, String phoneNumber, String address, int id, String speciality, double perConsultance, int countConsultance) {
        super(firstName, lastName, email, phoneNumber, address, id);
        this.speciality = speciality;
        this.perConsultance = perConsultance;
        this.countConsultance = countConsultance;
        calcSalary();
        numConsultants++;
    }

    public String displaySchedule(){
        String str = "\n";
        if (schedule.isEmpty())
            str+= " There are no patients on the appoitment list";
        else{
            for (int i = 0; i < schedule.size(); i++){
                str += schedule.get(i);
            }
        }
        return str;
    }

    public static int getNumConsultants() {
        return numConsultants;
    }

    public static void setNumConsultants(int numConsultants) {
        Consultant.numConsultants = numConsultants;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getPerConsultance() {
        return perConsultance;
    }

    public void setPerConsultance(double perConsultance) {
        this.perConsultance = perConsultance;
    }

    public int getCountConsultance() {
        return countConsultance;
    }

    public void setCountConsultance(int countConsultance) {
        this.countConsultance = countConsultance;
    }
    
    public ArrayList<Patient> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Patient> schedule) {
        this.schedule = schedule;
    }
    
    public void addAppoitment(Patient p){
        schedule.add(p);
    }
    
    @Override
    public String toString() {
        return "\n\tCONSULTANT\n" + super.toString() + "\nSpeciality: " + speciality + "\nSalary: " + salary;
    }
    
    @Override
    public void getInput(){
        Scanner input = new Scanner(System.in);
        super.getInput();
        System.out.print("Enter Speciality: ");
        speciality = input.nextLine();
        System.out.print("Enter pay per Consultance: ");
        perConsultance = input.nextDouble();
        System.out.print("Enter number of Consultances: ");
        countConsultance = input.nextInt();
        calcSalary();
    }
    
    @Override
    public String displayInfo() {
        return (toString() + "\nSchedule:" + displaySchedule());
    }

    @Override
    public void calcSalary() {
        salary = perConsultance * countConsultance;
    }
}
