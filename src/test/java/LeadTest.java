import Classes.Lead;
import Menu.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeadTest {

    Lead lead;
@BeforeEach
void setUp(){
    lead=new Lead("Juan","684895932", "juan1234@test.com","Desatranques Jaen");
}
@Test
@DisplayName("Create Lead")
 void TestCreateLead(){
    List<Lead> listOfLeads=new ArrayList<>();
    listOfLeads.add(lead);
    assertEquals(1,listOfLeads.size());
}

}
