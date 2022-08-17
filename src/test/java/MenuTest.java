import Classes.Lead;
import Menu.Menu;
import org.junit.jupiter.api.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class MenuTest {



    @BeforeEach
    void setup(){

    }

    @AfterEach
    void tearDown(){

    }

    @Test
    @DisplayName("Should accept valid phone")
    void setPhoneTest() {
        System.setIn(new ByteArrayInputStream("999999999".getBytes()));
        String validPhone = Menu.setPhone();
        assertEquals("999999999", validPhone);
    }


    @Test
    @DisplayName("Should accept valid company name")
    void setCompanyNameTest() {
        System.setIn(new ByteArrayInputStream("Burton Global".getBytes()));
        String validCompanyName = Menu.setCompanyName();
        assertEquals("Burton Global", validCompanyName);
    }





}
