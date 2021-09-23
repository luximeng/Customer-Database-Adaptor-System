package edu.bu.met.cs665.dataAccess;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class NewSystemToOldSystemAdaptorTest {

  Customer customer1;
  Customer customer2;
  Customer customer3;
  String phoneNum1;
  String phoneNum2;
  String phoneNum3;
  List<Customer> customerData;
  OldSystem oldSystem;
  NewSystemToOldSystemAdaptor adaptor;

  @Before
  public void setUp() throws Exception {
    customer1 = new Customer("Abi Jones", "abi_jones@gmail.com");
    customer2 = new Customer("Bob Watt", "bwatt@gmail.com");
    customer3 = new Customer("Catherine Willard", "Catherine03@gmail.com");
    phoneNum1 = "202-489-5874";
    phoneNum2 = "206-845-3596";
    phoneNum3 = "312-369-7412";
    customerData = Arrays.asList(customer1, customer2, customer3);
    oldSystem = new OldSystem(customerData);
    adaptor = new NewSystemToOldSystemAdaptor(oldSystem);
  }

  @Test
  public void testOldGetCustomer() {
    assertEquals(customer1, adaptor.getCustomer("abi_jones@gmail.com"));
    assertEquals(customer2, adaptor.getCustomer("bwatt@gmail.com"));
    assertEquals(customer3, adaptor.getCustomer("Catherine03@gmail.com"));
    assertNotEquals(customer1, oldSystem.getCustomer(customer2.getEmail()));
  }

  @Test
  public void testNewGetCustomer() {
    assertEquals(customer1, adaptor.getCustomer("abi_jones@gmail.com", phoneNum1));
    assertEquals(customer2, adaptor.getCustomer("bwatt@gmail.com", phoneNum2));
    assertEquals(customer3, adaptor.getCustomer("Catherine03@gmail.com", phoneNum3));
  }

  @Test
  public void getOldSystem() {
    assertEquals(oldSystem, adaptor.getOldSystem());
  }
}
