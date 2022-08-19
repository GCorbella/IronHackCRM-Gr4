package Menu;

import Classes.Account;
import Classes.Contact;
import Classes.Lead;
import Classes.Opportunity;
import Enums.Status;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import static Enums.Industry.*;
import static Enums.Product.*;

public class Menu {

  //Scanner scanner = new Scanner(System.in); // Scanner for commands, login message and instructions

    //lists
    static List<Lead> allLeads = new ArrayList<>(); //List of all the existing Leads.
    static List<Account> allAccounts = new ArrayList<>(); //List of all the existing Accounts.
    static List<Opportunity> allOpportunities = new ArrayList<>(); //List of all the existing Opportunities.
    static List<Contact> allContacts = new ArrayList<>(); //List of all the existing Contacts.

    public static void start() {
        String command;
        String actionCommand;

        String[] commands = new String[]{"help","new lead", "show leads", "convert", "close-lost", "close-won","quit"};
        
        try {
            System.out.println("\r*** Welcome to CRM of Group 4***");
            Thread.sleep(1000);
            System.out.println("\r***Login successful***");
            Thread.sleep(1000);
            System.out.println("\nTo start you need to type HELP to print all commands.");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("CRM App was interrupted");
        }

        // Command loop: asks for valid input and assigns id to variable if necessary
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\nPlease, type a command:");
            command = scanner.nextLine().toLowerCase();

            switch (command) {
                case "new lead":
                    newLead();
                    break;
                case "show leads":
                    showLeads();
                    break;
                case "help":
                    System.out.println("Available commands:");
                    for (String c : commands) {
                        System.out.println(c);
                    }
                    break;

                case "convert":
                    System.out.println("What's the Id of the Lead you want to convert?");
                    int id = scanner.nextInt();
                    convertLead(id);
                    break;
                case "close-lost":
                    System.out.println("What's the Id of the Opportunity you want to close?");
                    int id1 = scanner.nextInt();
                    changeOpportunityStatus(id1, Status.CLOSED_LOST);
                    System.out.println("Opportunity status set to CLOSED_LOST");
                    break;
                case "close-won":
                    System.out.println("What's the Id of the Opportunity you want to close?");
                    int id2 = scanner.nextInt();
                    changeOpportunityStatus(id2, Status.CLOSED_WON);
                    System.out.println("Opportunity status set to CLOSED_LOST");
                    System.out.println("Congratulations!");
                    break;
                case "quit":
                    try {
                        System.out.println("Log out ...");
                        Thread.sleep(1000);
                        System.out.println("Goodbye!");
                        Thread.sleep(1000);
                        System.exit(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                default:
                    System.out.println("Please enter a valid command");
            }
        }
    }

    public static void showLeads(){
        System.out.println("Leads : ");
       // allLeads.forEach((n) -> System.out.println(allLeads));
        allLeads.forEach(System.out::println);
    }

    public static Lead findLeadById(int id) throws IllegalArgumentException {
        for (Lead lead : allLeads) {
            if(lead.getId() == id) {
                return lead;
            }
        }
        throw new IllegalArgumentException("No lead matching provided id");
    }

    // Creates a new lead, called by welcome()
    public static void newLead() {
        String tempName;
        String tempPhoneNumber;
        String tempEmail;
        String tempCompanyName;

        tempName = setName();
        tempPhoneNumber = setPhone();
        tempEmail = setEmail();
        tempCompanyName = setCompanyName();

        Lead lead = new Lead(tempName, tempPhoneNumber, tempEmail, tempCompanyName);

        allLeads.add(lead);
    }

    public static String setName() {
        Scanner scanner = new Scanner(System.in);
        String name;
        boolean isThereFirstAndLastname;
        System.out.println("Please, enter lead's name and lastname:");

        while (true) {
            name = scanner.nextLine();
            isThereFirstAndLastname = (name.split(" ").length == 2);

            if (name.length() < 3) {
                System.out.println("Name must have at least 3 characters");
            } else if (name.matches(".*\\d.*")) {
                System.out.println("Name cannot contain numbers");
            } else if (!isThereFirstAndLastname) {
                System.out.println("Please enter name and lastname separated by a space");
            } else {
                break;
            }
        }
        System.out.println("The registered name is: " + name + "\n");
        return name;
    }

    // newLead() helper method with phone input validation
    public static String setPhone() {
        Scanner scanner = new Scanner(System.in);
        String phone;
        System.out.println("Enter lead's phone number, should be 9 digits long:");

        while (true) {
            phone = scanner.nextLine();
            if (phone.length() != 9) {
                System.out.println("Phone must be 9 digits long");
            } else if (phone.charAt(0) == '0') {
                System.out.println("Phone cannot start with zero");
            } else if (phone.matches(".*[a-z|A-Z].*")) {
                System.out.println("Phone cannot have letters");
            } else {
                break;
            }
        }

        System.out.println("The registered phone is: " + phone + "\n");
        return phone;
    }

    // newLead() helper method with email input validation
    public static String setEmail() {
        Scanner scanner = new Scanner(System.in);
        String email;
        System.out.println("Enter lead's email address:");

        while (true) {
            email = scanner.nextLine();

            if (email.length() < 4) {
                System.out.println("Email must be more than 4 characters long");
            } else if (!email.matches("^(.+)@(.+)\\.(.+)$")) {
                System.out.println("Please enter a valid email address");
                ;
            } else {
                break;
            }
        }
        System.out.println("The registered email is: " + email + "\n");
        return email;
    }

    // newLead() helper method with companyName input validation
    public static String setCompanyName() {
        Scanner scanner = new Scanner(System.in);
        String companyName;
        System.out.println("Enter lead's company name:");

        while (true) {
            companyName = scanner.nextLine();

            if (companyName.length() < 3) {
                System.out.println("Company name must have at least 3 characters");
            } else {
                break;
            }
        }
        System.out.println("The registered company name is: " + companyName + "\n");
        return companyName;
    }

    //this method is for convert lead to opportunity saving and create an account .
    public static void convertLead(int id) {
        Lead lead = findLeadById(id);
        Scanner scanner = new Scanner(System.in);

        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        allContacts.add(contact);
        System.out.println("In what product is the customer interested:" +"\n1.HYBRID" +"\n2.FLATBED"+"\n3.BOX");
        int election = scanner.nextInt();
        switch (election) {
            case 1:
                Opportunity opportunity =new Opportunity(HYBRID,contact, Status.OPEN);
                break;
            case 2:
                Opportunity opportunity2 =new Opportunity(FLATBED,contact,Status.OPEN);

                break;
            case 3:
                Opportunity opportunity3 =new Opportunity(BOX,contact,Status.OPEN);
                break;
            default:
                System.out.println("INSERT CORRECT NUM");
                break;
        }

        boolean salir = false;
        System.out.println("Select the industry of the customer:"+"\n1.PRODUCE" +"\n2.ECOMMERCE"+"\n3.MANUFACTURING"+"\n4.MEDICAL" +"\n5.OTHER");
        int employeeCount;
        String city;
        String country;
        int election2 = scanner.nextInt();
        switch (election2) {
            case 1:
                System.out.println("How many employees does have the customer business?");
                employeeCount = scanner.nextInt();
                System.out.println("In which city is located it's HQ?");
                city = scanner.nextLine();
                city = scanner.nextLine();

                System.out.println("In which country operates?");
                country = scanner.nextLine();
                country = scanner.nextLine();

                System.out.println("New account created");

                Account account = new Account(PRODUCE, employeeCount, city, country);
                break;

            case 2:
                System.out.println("How many employees does have the customer business?");
                employeeCount = scanner.nextInt();
                System.out.println("In what city is located it's HQ?");
                city = scanner.nextLine();
                city = scanner.nextLine();

                System.out.println("In which country operates?");
                country = scanner.nextLine();
                country = scanner.nextLine();

                System.out.println("New account create");
                Account account2 = new Account(ECOMMERCE, employeeCount, city, country);
                break;
            case 3:
                System.out.println("How many employees does have the customer business?");
                employeeCount = scanner.nextInt();
                System.out.println("In which city is located it's HQ?");
                city = scanner.nextLine();
                city = scanner.nextLine();

                System.out.println("In which country operates?");
                country = scanner.nextLine();
                country = scanner.nextLine();

                System.out.println("New account create");
                Account account3 = new Account(MANUFACTURING, employeeCount, city, country);
                break;
            case 4:
                System.out.println("How many employees does have the customer business?");
                employeeCount = scanner.nextInt();
                System.out.println("In which city is located it's HQ?");
                city = scanner.nextLine();
                city = scanner.nextLine();

                System.out.println("In which country operates?");
                country = scanner.nextLine();
                country = scanner.nextLine();

                System.out.println("New account create");
                Account account4 = new Account(MEDICAL, employeeCount, city, country);
                break;
            case 5:
                System.out.println("How many employees does have the customer business?");
                employeeCount = scanner.nextInt();
                System.out.println("In which city is located it's HQ?");
                city = scanner.nextLine();
                city = scanner.nextLine();

                System.out.println("In which country operates?");
                country = scanner.nextLine();
                country = scanner.nextLine();

                System.out.println("New account create");
                Account account5 = new Account(OTHER, employeeCount, city, country);
                break;

            default:
                System.out.println("Please, enter a valid option.");
                break;
        }
        allLeads.remove(findLeadById(id));
        }
        // this method is for change opportunity status
        public static void changeOpportunityStatus(int id, Status status){

            for (int i = 0; i < allOpportunities.size(); i++) {
                if (allOpportunities.get(i).getId() == id ){
                    allOpportunities.get(i).setStatus(status);
                }
            }
        }
}
