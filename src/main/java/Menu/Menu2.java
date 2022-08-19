






package Menu;

import Classes.Account;
import Classes.Contact;
import Classes.Lead;
import Classes.Opportunity;
import Enums.Product;
import Enums.Status;

import java.util.Scanner;

import static Enums.Industry.*;
import static Enums.Product.*;

public class menu2 {


    static Scanner scanner = new Scanner(System.in);
    //this method is for convert lead to opportunity saving and create an account .
    public void convertLead(int id) throws InterruptedException {
        Lead lead = findLeadById(id);

        Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
        allContacts.add(contact);
        System.out.println("in What prduct is interestet:" +"\n1.HYBRID" +"\n2.FLATBED"+"\n3.BOX");
        int election = scanner.nextInt();
        switch (election) {
            case 1:
                Opportunity opportunity =new Opportunity(HYBRID,contact,Status.OPEN);


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
        System.out.println("Select the Industry :"+"\n1.PRODUCE" +"\n2.ECOMMERCE"+"\n3.MANUFACTURING"+"\n4.MEDICAL" +"\n5.OTHER");
        int employeeCount;
        String city;
        String country;
        int election2 = scanner.nextInt();
        switch (election2) {
            case 1:
                System.out.println("how many employees do you have?");
                employeeCount=scanner.nextInt();
                System.out.println("city?:");
                city=scanner.nextLine();
                city=scanner.nextLine();

                System.out.println("country:");
                country=scanner.nextLine();
                country=scanner.nextLine();

                System.out.println("New account create");

                Account account =new Account(PRODUCE,employeeCount,city,country);
                break;

            case 2 :
                System.out.println("how many employees do you have?");
                employeeCount=scanner.nextInt();
                System.out.println("city?:");
                city=scanner.nextLine();
                city=scanner.nextLine();

                System.out.println("country:");
                country=scanner.nextLine();
                country=scanner.nextLine();

                System.out.println("New account create");
                Account account2 =new Account(ECOMMERCE,employeeCount,city,country);
                break;
            case 3:
                System.out.println("how many employees do you have?");
                employeeCount=scanner.nextInt();
                System.out.println("city?:");
                city=scanner.nextLine();
                city=scanner.nextLine();

                System.out.println("country:");
                country=scanner.nextLine();
                country=scanner.nextLine();

                System.out.println("New account create");
                Account account3 =new Account(MANUFACTURING,employeeCount,city,country);
                break;
            case 4:
                System.out.println("how many employees do you have?");
                employeeCount=scanner.nextInt();
                System.out.println("city?:");
                city=scanner.nextLine();
                city=scanner.nextLine();

                System.out.println("country:");
                country=scanner.nextLine();
                country=scanner.nextLine();

                System.out.println("New account create");
                Account account4 =new Account(MEDICAL,employeeCount,city,country);
                break;
            case 5:
                System.out.println("how many employees do you have?");
                employeeCount=scanner.nextInt();
                System.out.println("city?:");
                city=scanner.nextLine();
                city=scanner.nextLine();

                System.out.println("country:");
                country=scanner.nextLine();
                country=scanner.nextLine();

                System.out.println("New account create");
                Account account5 =new Account(OTHER,employeeCount,city,country);
                break;

            default:

                break;
        }
        // this method is for change opportunity status
        public static void changeOpportunityStatus(int id, Status status){

            for (int i = 0; i < allOpportunities.size(); i++) {
                if (allOpportunities[i].getId()==id ){
                    allOpportunities[i].setStatus(status);

                }
            }

        }
        }


    }