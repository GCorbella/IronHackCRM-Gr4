import Classes.Contact;
import Classes.Lead;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {
    Contact contact;
    @BeforeEach
    void setUp(){
        contact=new Contact("Juan","684895932", "juan1234@test.com","Desatranques Jaen");
    }
    @AfterEach
    void tearDown(){

    }
    @Test
    @DisplayName("Create Contact")
    void TestCreateContact(){
        List<Contact> listOfContacts=new ArrayList<>();
        listOfContacts.add(contact);
        assertEquals(1,listOfContacts.size());
    }
}
