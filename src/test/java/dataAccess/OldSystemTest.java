package edu.bu.met.cs665.dataAccess;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class OldSystemTest {
    Customer customer1;
    Customer customer2;
    Customer customer3;
    List<Customer> customerData;
    List<Customer> customerData2;
    OldSystem oldSystem;
    @Before
    public void setUp() throws Exception {
        customer1 = new Customer("Abi Jones", "abi_jones@gmail.com");
        customer2 = new Customer("Bob Watt", "bwatt@gmail.com");
        customer3 = new Customer("Catherine Willard", "Catherine03@gmail.com");
        customerData = Arrays.asList(customer1, customer2, customer3);
        oldSystem = new OldSystem(customerData);
    }

    @Test
    public void getCustomer() {
        assertEquals(customer1, oldSystem.getCustomer("abi_jones@gmail.com"));
        assertEquals(customer2, oldSystem.getCustomer("bwatt@gmail.com"));
        assertEquals(customer3, oldSystem.getCustomer("Catherine03@gmail.com"));
        assertNotEquals(customer1, oldSystem.getCustomer(customer2.getEmail()));
    }

    @Test
    public void getCustomersData() {
        assertEquals(customerData, oldSystem.getCustomersData());
        customerData2 = Arrays.asList(customer1, customer3);;
        assertNotEquals(customerData, customerData2);
    }
}