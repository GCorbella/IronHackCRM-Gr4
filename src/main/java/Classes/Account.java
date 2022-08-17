package Classes;

import Enums.Industry;

import java.util.ArrayList;
import java.util.List;

public class Account {

    //counter used to attach a new unique ID for every object instantiated.
    private int counter = 0;

    //attributes
    private int id;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private List<Contact> contactList = new ArrayList<>(); //list for every Contact related with this account.
    private List<Opportunity> opportunityList = new ArrayList<>(); //list for every Opportunity related with this account.

    //constructor
    public Account(Industry industry, int employeeCount, String city, String country) {
        setId(counter++); //this setter give the object instantiated a unique ID, counting the past ones.
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    public void setEmployeeCount(int employeeCount) {
        this.employeeCount = employeeCount;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public void setOpportunityList(List<Opportunity> opportunityList) {
        this.opportunityList = opportunityList;
    }

    //getters
    public int getId() {
        return id;
    }

    public Industry getIndustry() {
        return industry;
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public List<Opportunity> getOpportunityList() {
        return opportunityList;
    }
}
