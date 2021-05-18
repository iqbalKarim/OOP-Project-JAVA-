package hospital;

import java.util.Scanner;

public class Nurse extends Staff{
    public static int numNurses = 0;
    private boolean lisence;
    private double wage;
    private int hours;
    
    public Nurse(){
        numNurses++;
    }
    
    public Nurse(int id){
        this.id = id;
        numNurses++;
    }
    
    public Nurse(String firstName, String lastName, String email, String phoneNumber, String address, int id, boolean lisence, double wage, int hours) {
        super(firstName, lastName, email, phoneNumber, address, id);
        this.lisence = lisence;
        this.wage = wage;
        this.hours = hours;
        numNurses++;
        calcSalary();
    }

    public static int getNumNurses() {
        return numNurses;
    }

    public static void setNumNurses(int numNurses) {
        Nurse.numNurses = numNurses;
    }

    public boolean isLisence() {
        return lisence;
    }

    public void setLisence(boolean lisence) {
        this.lisence = lisence;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "\n\tNURSE\n" + super.toString() + "\nLisence: " + lisence /*+ "\nWage: " + wage + " TL" + "\nHours: " + hours */ + "\nSalary: " + salary + " TL";
    }
    
    public void getInput(){
        char temp;
        Scanner input = new Scanner(System.in);
        super.getInput();
        System.out.print("Is the Nurse Liscensed (Y/N)? ");
        temp = input.next().charAt(0);
        switch (temp) {
            case 'y':
            case 'Y':
                lisence = true;
                break;
            case 'n':
            case 'N':
                lisence = false;
                break;
            default:
                System.out.print("Invalid entry. Lisence is set to none");
                lisence = false;
                break;
        }
        System.out.print("Enter wage: ");
        wage = input.nextDouble();
        System.out.print("Enter hours worked: ");
        hours = input.nextInt();
        calcSalary();
    }
    
    @Override
    public String displayInfo() {
        return (toString());
    }

    @Override
    public void calcSalary() {
        salary = wage * hours;
    }
}
