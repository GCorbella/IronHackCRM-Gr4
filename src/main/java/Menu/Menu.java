package Menu;

import Classes.Account;
import Classes.Lead;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class Menu {

   static Scanner scanner = new Scanner(System.in);

   Lead lead;

    //lists
    List<Lead> allLeads = new ArrayList<>(); //List of all the existing Leads.
    List<Account> allAccounts = new ArrayList<>(); //List of all the existing Accounts.


    // Scanner for commands, login message and instructions
    public static void start() {
        String command;
        String actionCommand;


        //TODO List of all commands. Add all comands
        String[] commands = new String[]{
                "new lead",
                "show leads",
                "help",
                "quit"
        };
        
        try {
            System.out.println("\r*** Wellcome to CRM of Group 4***");
            Thread.sleep(1000);
            System.out.println("\r***Login successful***");
            Thread.sleep(1000);
            System.out.println("\nTo start you need ype HELP to print all commands.");
        } catch (InterruptedException e) {
            e.printStackTrace();
           System.out.println("CRM App was interrupted");
        }



        // Command loop: asks for valid input and assigns id to variable if necessary
        while (true) {
            System.out.println("\nPlease, type a command:");
            command = scanner.nextLine().toLowerCase();

            //TODO ".*\\d.*" may o minusculas
            if (command.matches(".*\\d.*")) {

               actionCommand = command;
            } else {
                actionCommand = command;
            }


            switch (actionCommand) {
                case "new lead":
                    newLead();
                    break;
                case "show leads":
                    //showLeads();
                    break;

                case "help":
                    System.out.println("Available commands:");
                    for (String c : commands) {
                        System.out.println(c);
                    }
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

    //TODO
    void createLead(String fullName, String phoneNumber, String email, String companyName){

    }

    //TODO
    void showLeads(){
        System.out.println("Leads : ");
       // allLeads.forEach((n) -> System.out.println(allLeads));
        allLeads.forEach(System.out::println);
    }

    public Lead findLeadById(int id) throws IllegalArgumentException {
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
        Lead tempLead;

        tempName = setName();
        tempPhoneNumber = setPhone();
        tempEmail = setEmail();
        tempCompanyName = setCompanyName();

        tempLead = new Lead(tempName, tempPhoneNumber, tempEmail, tempCompanyName);

        //Lead.addLead(tempLead);
        //Lead.save();
    }

    public static String setName() {
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
                ;
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
}
