package Classes;

public class Lead {

    //counter used to attach a new unique ID for every object instantiated.
    private int counter = 0;
    //attributes
    private int id;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;

    //constructor
    public Lead(String name, String phoneNumber, String email, String companyName) {
        setId(counter++); //this setter give the object instantiated a unique ID, counting the past ones.
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setCompanyName(companyName);
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

}

