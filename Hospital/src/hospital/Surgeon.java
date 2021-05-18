package hospital;

import java.util.ArrayList;
import java.util.Scanner;

public class Surgeon extends Staff{
    public static int numSurgeons = 0;
    private String speciality;
    private double perSurgery;
    private int countSurgeries;
    private ArrayList<Patient> schedule = new ArrayList();

    public Surgeon() {
        numSurgeons++;
    }
    public Surgeon(String firstName, String lastName, String email, String phoneNumber, String address, int id, String speciality, double perSurgery, int countSurgeries, ArrayList<Patient> schedule) {
        super(firstName, lastName, email, phoneNumber, address, id);
        numSurgeons++;
        this.perSurgery = perSurgery;
        this.countSurgeries = countSurgeries;
        this.speciality = speciality;
        calcSalary();
        this.schedule = schedule; 
    }
    
    public Surgeon(int id) {
        numSurgeons++;
        this.id = id;
    }
    
    public Surgeon(String firstName, String lastName, String email, String phoneNumber, String address, int id, String speciality, double perSurgery, int countSurgeries) {
        super(firstName, lastName, email, phoneNumber, address, id);
        numSurgeons++;
        this.perSurgery = perSurgery;
        this.countSurgeries = countSurgeries;
        this.speciality = speciality;
        calcSalary();
    }

    public static int getNumSurgeons() {
        return numSurgeons;
    }

    public ArrayList<Patient> getSchedule() {
        return schedule;
    }

    public void setSchedule(ArrayList<Patient> schedule) {
        this.schedule = schedule;
    }

    public static void setNumSurgeons(int numSurgeons) {
        Surgeon.numSurgeons = numSurgeons;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getPerSurgery() {
        return perSurgery;
    }

    public void setPerSurgery(double perSurgery) {
        this.perSurgery = perSurgery;
    }

    public int getCountSurgeries() {
        return countSurgeries;
    }

    public void setCountSurgeries(int countSurgeries) {
        this.countSurgeries = countSurgeries;
    }
    
    public void addAppoitment(Patient p){
        schedule.add(p);
    }
    
    @Override
    public String toString() {
        return "\n\tSURGEON\n" + super.toString() + "\nSpeciality: " + speciality + "\nSalary: " + salary;
    }
    
    @Override
    public String displayInfo() {
        return (toString() + "\nSchedule:" + displaySchedule());
    }

    @Override
    public void calcSalary() {
        salary = countSurgeries * perSurgery;
    }
    
    @Override
    public void getInput(){
        super.getInput();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter speciality: ");
        speciality = input.next();
        System.out.print("Enter pay per Surgery: ");
        perSurgery = input.nextDouble();
        System.out.print("Enter number of Surgeries: ");
        countSurgeries = input.nextInt();
        calcSalary();
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
}
