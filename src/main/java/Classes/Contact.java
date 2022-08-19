package Classes;

public class Contact extends Lead{

    //counter used to attach a new unique ID for every object instantiated.
    private int counter = 0;

    //constructor
    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        setId(counter++); //this setter give the object instantiated a unique ID, counting the past ones.
    }
}
