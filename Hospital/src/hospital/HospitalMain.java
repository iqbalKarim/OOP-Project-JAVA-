
//Group members: Iqbal Karim, Shahid Abbas, Ahmed Salik Riaz
//Term project: Hospital System
/*
Dummy data for staff has been added
Schedule for Surgeons and Cosultants will be displayed when the appropriate staff is searched or
*/

package hospital;

import GUI.MainFrame;
import java.util.Scanner;

//Main class: Runs all the other classes 
public class HospitalMain {
    public static void main(String[] args) {
        
        //adding staff members into the staff arraylist
        HospSys.staff.add(new Nurse("Manahil", "Noor", "manahilNoor@gmail.com", "03008217432", "Eryaman", 11, true, 15, 20));
        HospSys.staff.add(new Surgeon("Abid", "Shaka", "abidShaka@gmail.com", "03352544782", "PNT", 21, "Cardiologist", 500, 5));
        HospSys.staff.add(new Consultant("Ahmed", "Salik", "ahmedSalik@gmail.com", "03002356458", "Karachi", 31, "ENT Specialist", 100, 10));
        HospSys.staff.add(new Nurse("Abida", "Parveen", "abidaParveen@gmail.com", "03331333232", "Lahore", 12, true, 20, 15));
        HospSys.staff.add(new Surgeon("Altaf", "Hussain", "altafHussain@gmail.com", "03345898887", "NINE-ZERO", 22, "Phsyio", 500, 4));
        HospSys.staff.add(new Consultant("Mamnoon", "Hussain", "mamnoonHussain@gmail.com", "03524587985", "NINE-ZERO", 32, "Gynaecologist", 100, 15));
        /*
        int ser, option, ssn, id;
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        
        //Asks the user for their choice of service
        System.out.print("MENU\n 1. Patient Services\n 2. Staff Services\n 3. Hospital Services\n 4. Stop\n");
        ser = input.nextInt();
        while(ser!=4){                      //loop ends if the user's choice is 4(Stop)
            switch (ser) {
                
                //displays all the choices for patient services and gets the user's preferred choice
                case 1:
                    System.out.print("\nPATIENT SERVICES\n 1. Add Patient\n 2. Search Patient\n 3. Display Patients\n 4. Delete Patient\n");
                    option = input.nextInt();
                    switch (option){
                        case 1: if (HospSys.addPatient())
                                System.out.println("Patient has been added!");
                            else
                                System.out.println("Patient already exist!");
                            break;
                        case 2: System.out.print("\nEnter Patient SSN: ");
                            ssn = input.nextInt();
                            System.out.print(HospSys.searchPatient(ssn));
                            break;
                        case 3: System.out.print(HospSys.displayPatients());break;
                        case 4:System.out.print("\nEnter Patient SSN: ");
                            ssn = input.nextInt();
                            flag = HospSys.deletePatient(ssn);
                            if (flag)
                                System.out.print("\nPatient with SSN "+ssn+" deleted\n");
                            else
                                System.out.print("\nThere is no patient with SSN "+ssn+"\n");
                            break;
                        default:System.out.print("Invalid Entry!");
                    }
                    break;
                    
                //displays all the choices for staff services and gets the user's preferred choice
                case 2:
                    System.out.print("\nSTAFF SERVICES\n 1. Add Staff\n 2. Search Staff\n 3. Display Staff\n 4. Delete Staff\n");
                    option = input.nextInt();
                    switch (option){
                        case 1:             //adds staff to the staff arraylist
                            HospSys.addStaff();
                            break;
                        case 2:             //searches for the staff using the entered id
                            System.out.print("\nEnter Staff ID: ");  
                            id = input.nextInt();
                            Staff s = HospSys.searchStaff(id);
                            if(s == null)
                                System.out.print("\nThere is no staff with ID "+id+"\n");
                            else
                                System.out.print(s.displayInfo());
                            break;
                        case 3:             //displays the staff members according to the user's choice(all, surgeons, nurses, or consultants)
                            System.out.print(HospSys.displayStaff());
                            break;
                        case 4:             //deletes the staff member whose ID the user enters
                            System.out.print("\nEnter Staff ID: ");
                            id = input.nextInt();
                            flag = HospSys.deleteStaff(id);
                            
                            if (flag)
                                System.out.print("\nStaff with ID "+id+" deleted\n");
                            else
                                System.out.print("\nThere is no staff with ID "+id+"\n");
                            break;
                            
                        default:System.out.print("\nInvalid Entry!\n");
                    }
                    break;
                
                //displays all the choices for hospital services and gets the user's preferred choice
                case 3:                     
                    System.out.print("\nHOSPITAL SERVICES\n 1. Get Income\n 2. Get Revenue\n 3. Get Expenses\n");
                    option = input.nextInt();
                    switch(option){
                        case 1: System.out.print("Income is: $" + HospSys.getIncome());break;
                        case 2: System.out.print("Revenue is: $" + HospSys.getRevenue());break;
                        case 3: System.out.print("Expense is: $" + HospSys.getExpense()); break;
                        default: System.out.print("Invalid Entry!");break;
                    }
                    break;
                
                //validates the input choice of the user
                default:
                    System.out.print("Invalid.");
                    break;
            }
            
            //the system keeps running and asking for the users choice again and again until the user exits by choosing 4
            System.out.print("\nMENU\n 1. Patient Services\n 2. Staff Services\n 3. Hospital Services\n 4. Stop\n");
            ser = input.nextInt();
        }
        
        //Displays an ending message to the user when they exit from the system
        System.out.print("\nThank you!!");*/
        
        MainFrame f =new MainFrame();
        f.setVisible(true);
    }
}