package hospital;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class HospSys {
    public static ArrayList<Staff> staff= new ArrayList(); 
    public static HashSet<Patient> patients = new HashSet();
    private static double income = 0;
    private static double expense = 0;
    private static double revenue = 10000;
    
    public static boolean addPatient(String firstname, String lastname, int ssn, String email, String phoneNumber, 
            String address, String dob, int age, String service, int preferredDoc){
        int docID;
        String str = "";
        Patient p = new Patient(firstname, lastname, ssn, email, phoneNumber, address, dob, age, service, preferredDoc);
    
        docID = preferredDoc;
        
        p.calcBill();
        searchStaff(docID).addAppoitment(p);
        return patients.add(p);
    }
    
    public static String displayPatients(){
        String str = "Number of Patients: " + Patient.numPatients + "\n";
        Iterator<Patient> i = patients.iterator();  
        while(i.hasNext())
            str += i.next();
        
        return str;
    }
    
    public static String searchPatient(int ssn){
        String str = "";
        Patient p;
        Iterator<Patient> i = patients.iterator();
        while(i.hasNext()){
            p = i.next();
            if (p.checkSSN(ssn))
                return p.toString();
        }
        return "\nPatient with SSN " + ssn + " does not exist.\n";
    }
    
    public static boolean deletePatient(int ssn){
        Patient p;
        Iterator<Patient> i = patients.iterator();
        while(i.hasNext()){
            p = i.next();
            if (p.checkSSN(ssn)){
                patients.remove(p);
                Patient.numPatients--;
                return true;
            }
        }
        return false;
    }
    
    public static String[] getSSNs(){
        String ssns[] = new String[Patient.numPatients];
        Patient p;
        int count = 0;
        Iterator<Patient> i = patients.iterator();
        while(i.hasNext()){
            p = i.next();
            ssns[count] = p.getSsn() + "";
            count++;
        }
        return ssns;
    }
    
    public static boolean checkStaffId(int id){
        for (int i = 0; i < staff.size(); i++)
            if (staff.get(i).checkID(id))
                return true;
        return false;
    }
    
    public static String addStaff(String type, int id, String fname, String lname, String email, String phone, String address, int count, String status, double multiplier){
        String str = "";
        if (checkStaffId(id))
                str += "Staff with ID " + id + " already exists.\n";
        else{
            //public Nurse(String firstName, String lastName, String email, String phoneNumber, String address, int id, boolean lisence, double wage, int hours) {

            if (type.equalsIgnoreCase("Nurse")){
                staff.add(new Nurse(fname, lname, email, phone, address, id, Boolean.parseBoolean(status), multiplier, count));
                str += ("Nurse " + staff.get(staff.size()-1).getFirstname() + " has been added to the Hospital System");
            }
            else if (type.equalsIgnoreCase("Surgeon")){
                staff.add(new Surgeon(fname, lname, email, phone, address, id, status, multiplier, count));
                str += ("Surgeon " + staff.get(staff.size()-1).getFirstname() + " has been added to the Hospital System");
                
            }
            else if (type.equalsIgnoreCase("Consultant")){
                staff.add(new Consultant(fname, lname, email, phone, address, id, status, multiplier, count));
                str += ("Consultant " + staff.get(staff.size()-1).getFirstname() + " has been added to the Hospital System");
            }
        }
        return str;
    }
    
    public static boolean deleteStaff(int id){
        for (int i = 0; i < staff.size(); i++)
            if (staff.get(i).checkID(id)){
                if (staff.get(i) instanceof Surgeon)
                    Surgeon.numSurgeons--;
                else if (staff.get(i) instanceof Consultant)
                    Consultant.numConsultants--;
                else if (staff.get(i) instanceof Nurse)
                    Nurse.numNurses--;
                staff.remove(i);
                Staff.numStaff--;
                return true;
            }
        return false;
    }
    
    public static Staff searchStaff(int id){
        for (int i = 0; i < staff.size(); i++)
            if (staff.get(i).checkID(id))
                return staff.get(i);
        return null;
    }
    
    public static String[] getIDs(){
        String ids[] = new String[Staff.numStaff];
        for (int i = 0; i < staff.size(); i++)
            ids[i] = staff.get(i).getId() + "";
        return ids;
    }
    
    public static String[] getSurgeonIDs(){
        String ids[] = new String[Surgeon.numSurgeons];
        int count = 0;
        for (Staff s : staff){
            if (s instanceof Surgeon){
                ids[count] = s.getId() + "  " + s.getFirstname() + " " + s.getLastname();
                count++;
            }
        }
        return ids;
    }
    
    public static String[] getConsultantIDs(){
        String ids[] = new String[Consultant.numConsultants];
        int count = 0;
        for (Staff s : staff){
            if (s instanceof Consultant){
                ids[count] = s.getId() + "  " + s.getFirstname() + " " + s.getLastname();
                count++;
            }
        }
        return ids;
    }
    
    
    public static String displayStaff(String type){
        String str = "";
        Scanner input = new Scanner(System.in);
        
        if (staff.isEmpty())
            return "There is no staff!!";
        
        if (type.equalsIgnoreCase("all")){
            str += "Number of Staff " + Staff.numStaff + "\n" ;
            for (Staff s : staff)
                str += s + "\n";
        }
        else if (type.equalsIgnoreCase("nurses")){
            str += "Number of Nurses " + Nurse.numNurses + "\n" ;
            for (Staff s : staff)
                if (s instanceof Nurse)
                    str += s + "\n";
        }
        else if (type.equalsIgnoreCase("surgeons")){
            str += "Number of Surgeon " + Surgeon.numSurgeons + "\n" ;
            for (Staff s : staff)
                if (s instanceof Surgeon)
                    str += s + "\n";
        }
        else if (type.equalsIgnoreCase("consultants")){
            str += "Number of Consultants " + Consultant.numConsultants + "\n" ;
            for (Staff s : staff)
                if (s instanceof Consultant)
                    str += s + "\n";
        }
        return str;
    }
    
    public static void calcIncome() {
        calcRevenue();
        calcExpense();
        income = revenue - expense;
    }
    
    public static void calcExpense(){
        int exp = 0;
        for (Staff s : staff)
            exp += s.getSalary();
        expense = exp;
    }
    
    public static void calcRevenue(){
        Iterator<Patient> i = patients.iterator();
        int rev = 0;
        Patient p;
        while(i.hasNext()){
            p = i.next();
            rev += p.getBill();
        }
        revenue = rev;
    }

    public static double getIncome() {
        calcIncome();
        return income;
    }

    public static void setIncome(double income) {
        HospSys.income = income;
    }

    public static double getExpense() {
        calcExpense();
        return expense;
    }

    public static void setExpense(double expense) {
        HospSys.expense = expense;
    }

    public static double getRevenue() {
        calcRevenue();
        return revenue;
    }

    public static void setRevenue(double revenue) {
        HospSys.revenue = revenue;
    }
    
}
