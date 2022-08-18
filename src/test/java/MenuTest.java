import Classes.Lead;
import Menu.Menu;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class MenuTest {



    @BeforeEach
    void setup(){
        Lead lead1 = new Lead("Juan","684895932", "juan1234@test.com","Desatranques Jaen");
        Lead lead2= new Lead("Jose","68340253","jose123@test.com","Ironhack");
        Lead lead3 = new Lead("Maria","69492022", "mariantonia@test.com","Telefonica");
        Menu.allLeads.add(lead1);
        Menu.allLeads.add(lead2);
        Menu.allLeads.add(lead3);
    }

    @AfterEach
    void tearDown(){
    Menu.allLeads.clear();
    }

    @Test
    @DisplayName("Set a name to a lead")
    void testSetNameLead(){
        System.setIn(new ByteArrayInputStream("Pepito Perez".getBytes()));
        String validName = Menu.setName();
        assertEquals("Pepito Perez",validName);
    }
    @Test
    @DisplayName("Set a phone to a lead")
    void testSetPhoneLead(){
        System.setIn(new ByteArrayInputStream("693848205".getBytes()));
        String validPhone = Menu.setPhone();
        assertEquals("693848205",validPhone);
    }
    @Test
    @DisplayName("Set a email to a lead")
    void testSetEmailLead() {
        System.setIn(new ByteArrayInputStream("pepitoperez@test.com".getBytes()));
        String validEmail = Menu.setEmail();
        assertEquals("pepitoperez@test.com", validEmail);
    }
    @Test
    @DisplayName("Set a company to a lead")
    void testSetCompanyLead() {
        System.setIn(new ByteArrayInputStream("Ironhack".getBytes()));
        String validCompany = Menu.setCompanyName();
        assertEquals("Ironhack", validCompany);
    }


    @Test
    @DisplayName("Find a lead by his Id")
    void testFindLeadById(){

    assertEquals(Menu.allLeads.get(0),Menu.findLeadById(1));

    }

    @Test
    @DisplayName("Throw exception ID not match with any lead")
    void testIdNotFound(){
            assertThrows(IllegalArgumentException.class,()->Menu.findLeadById(-6));
    }
}
