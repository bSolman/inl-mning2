package Sprint_Two.gym;

import Sprint_Two.gym.customer.Customer;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MainControllerTest {

    MainController controller = new MainController("test/Sprint_Two/gym/users_test.txt");

    MainControllerTest() throws IOException {
    }

    @Test
    void createCustomerListSize(){
        List<Customer> customerList = controller.getCustomers();
        assertEquals(14, customerList.size());
    }

    @Test
    void getCustomerListLastPos(){
        List<Customer> customerList = controller.getCustomers();
        assertEquals("Nahema Ninsson", customerList.getLast().getName());
    }

    @Test
    void addOneCustomer(){
        controller.addCustomer(new Customer(800502L,"Bosse", "1980-05-02"));
        List<Customer> customerList = controller.getCustomers();
        assertEquals(15, customerList.size());
    }

    @Test
    void doesPersonExistLong(){
        assertNotNull(controller.doesPersonExistLong(8906138493L).getName());
    }

    @Test
    void getPersonNameLong(){
        assertEquals("Fritjoff Flacon", controller.doesPersonExistLong(7911061234L).getName());
    }

    @Test
    void doesPersonExistString(){
        assertNotNull(controller.doesPersonExistString("Fritjoff Flacon").getName());
    }

    @Test
    void getPersonNameString(){
        assertEquals("Fritjoff Flacon", controller.doesPersonExistString("Fritjoff Flacon").getName());
    }

    @Test
    void testIfAccountIsValid(){
        assertTrue(controller.doesPersonHaveValidAccount(controller.getCustomers().getLast())); // Gör om testet så att det inte blir datumdrivet
    }

    @Test
    void testFormatData(){
        List<String> data = controller.getRawData();
        assertTrue(controller.formatData(data).length > 0);
        assertEquals(controller.formatData(data).length, (controller.getRawData().size() / 2));
    }
}