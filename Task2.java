/*Develop a sophisticated Java program to manage various aspects of a hospital or healthcare facility. This system should include modules for patient registration, appointment scheduling, electronic health records(EHR), billing and invoicing, inventory management for medical supplies,and staff management*/

import java.util.ArrayList;
import java.util.Scanner;

class Patient 
{
	String name, patientID, contact, disease;
	ArrayList<String> medicalHistory;
	
	Patient(String name, String patientID, String contact, String disease) 
	{
        	this.name = name;
        	this.patientID = patientID;
        	this.contact = contact;
        	this.disease = disease;
        	this.medicalHistory = new ArrayList<>();
        	addMedicalHistory("Initial diagnosis: " + disease);
    	}

   	void addMedicalHistory(String record) 
	{
        	medicalHistory.add(record);
    	}
    	void displayMedicalHistory() 
	{
        	System.out.println("Medical History for Patient ID: " + patientID);
        	for (String record : medicalHistory) 
		{
            		System.out.println(record);
        	}
    	}

    	String getPatientID() {
        	return patientID;
    	}

    	void displayPatientInfo() 
	{
        	System.out.println("Patient Name: " + name + "\nPatient ID: " + patientID + "\nContact: " + contact + "\nDisease: " + disease);
    	}
}

class Appointment 
{
	String appointmentID, patientID, doctorName, date;

	Appointment(String appointmentID, String patientID, String doctorName, String date) 
	{
        	this.appointmentID = appointmentID;
        	this.patientID = patientID;
        	this.doctorName = doctorName;
        	this.date = date;
    	}

    	void displayAppointmentDetails() 
	{
        	System.out.println("Appointment ID: " + appointmentID + "\nPatient ID: " + patientID + "\nDoctor: " + doctorName + "\nDate: " + date);
    	}
}

class Billing 
{
	String patientID;
    	double amount;
    	String billingDate;

    	Billing(String patientID, double amount, String billingDate) 
	{
        	this.patientID = patientID;
        	this.amount = amount;
        	this.billingDate = billingDate;
    	}

    	void displayInvoice() 
	{
        System.out.println("Patient ID: " + patientID + "\nAmount: " + amount + "\nBilling Date: " + billingDate);
    	}
}

class InventoryItem 
{
	String itemName, itemID;
    	int quantity;

    	InventoryItem(String itemName, String itemID, int quantity) 
	{
        	this.itemName = itemName;
        	this.itemID = itemID;
        	this.quantity = quantity;
    	}

    	void displayInventoryItem() 
	{
        	System.out.println("Item Name: " + itemName + "\nItem ID: " + itemID + "\nQuantity: " + quantity);
    	}
}

class Staff 
{
    	String staffName, staffID, role, contact;

    	Staff(String staffName, String staffID, String role, String contact) 
	{
        	this.staffName = staffName;
        	this.staffID = staffID;
        	this.role = role;
        	this.contact = contact;
    	}

    	void displayStaffInfo() 
	{
        	System.out.println("Staff Name: " + staffName + "\nStaff ID: " + staffID + "\nRole: " + role + "\nContact: " + contact);
    	}
}

public class Task2
{
    	static ArrayList<Patient> patients = new ArrayList<>();
    	static ArrayList<Appointment> appointments = new ArrayList<>();
    	static ArrayList<Billing> bills = new ArrayList<>();
    	static ArrayList<InventoryItem> inventory = new ArrayList<>();
    	static ArrayList<Staff> staffMembers = new ArrayList<>();

    public static void main(String[] args) 
	{
        	Scanner sc = new Scanner(System.in);
        	while (true) {
            		System.out.println("--------HOSPITAL MANAGEMENT SYSTEM--------" +
                               "\n1. Register Patient" +
                               "\n2. Schedule Appointment" +
                               "\n3. View Medical History" +
                               "\n4. Generate Bill" +
                               "\n5. Manage Inventory" +
                               "\n6. Manage Staff" +
                               "\n7. Exit\nChoose an option: ");
            	int choice = sc.nextInt();
            	sc.nextLine();
            	switch (choice) {
                	case 1:
                    		registerPatient(sc);
                    		break;
                	case 2:
                    		scheduleAppointment(sc);
                    		break;
                	case 3:
                    		viewMedicalHistory(sc);
                    		break;
                	case 4:
                    		generateBill(sc);
                    		break;
                	case 5:
                    		manageInventory(sc);
                    		break;
                	case 6:
                    		manageStaff(sc);
                    		break;
                	case 7:
                    		System.out.println("Thank you for using the Hospital Management System.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please choose a valid option.");
            }
      }
}

static void registerPatient(Scanner sc) {
        System.out.println("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Patient ID: ");
        String patientID = sc.nextLine();
        System.out.println("Enter Contact Number: ");
        String contact = sc.nextLine();
        System.out.println("Enter Disease: ");
        String disease = sc.nextLine();
        
        Patient patient = new Patient(name, patientID, contact, disease);
        patients.add(patient);
        System.out.println("Patient registered successfully!");
}

static void scheduleAppointment(Scanner sc) {
        System.out.println("Enter Appointment ID: ");
        String appointmentID = sc.nextLine();
        System.out.println("Enter Patient ID: ");
        String patientID = sc.nextLine();
        System.out.println("Enter Doctor Name: ");
        String doctorName = sc.nextLine();
        System.out.println("Enter Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        Appointment appointment = new Appointment(appointmentID, patientID, doctorName, date);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully!");
 }

static void viewMedicalHistory(Scanner sc) {
        System.out.println("Enter Patient ID: ");
        String patientID = sc.nextLine();
        Patient patient = findPatientByID(patientID);
        if (patient != null) {
            patient.displayMedicalHistory();
        } else {
            System.out.println("Patient not found!");
        }
}

static void generateBill(Scanner sc) {
        System.out.println("Enter Patient ID: ");
        String patientID = sc.nextLine();
        System.out.println("Enter Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();  // consume newline
        System.out.println("Enter Billing Date: ");
        String billingDate = sc.nextLine();

        Billing bill = new Billing(patientID, amount, billingDate);
        bills.add(bill);
        System.out.println("Bill generated successfully!");
}

static void manageInventory(Scanner sc) {
        System.out.println("Enter Item Name: ");
        String itemName = sc.nextLine();
        System.out.println("Enter Item ID: ");
        String itemID = sc.nextLine();
        System.out.println("Enter Quantity: ");
        int quantity = sc.nextInt();

        InventoryItem item = new InventoryItem(itemName, itemID, quantity);
        inventory.add(item);
        System.out.println("Inventory item added successfully!");
}

static void manageStaff(Scanner sc) {
        System.out.println("Enter Staff Name: ");
        String staffName = sc.nextLine();
        System.out.println("Enter Staff ID: ");
        String staffID = sc.nextLine();
        System.out.println("Enter Role: ");
        String role = sc.nextLine();
        System.out.println("Enter Contact: ");
        String contact = sc.nextLine();

        Staff staff = new Staff(staffName, staffID, role, contact);
        staffMembers.add(staff);
        System.out.println("Staff added successfully!");
}

static Patient findPatientByID(String patientID) {
        for (Patient patient : patients) {
            if (patient.getPatientID().equals(patientID)) {
                return patient;
            }
        }
        return null;
    }
}
