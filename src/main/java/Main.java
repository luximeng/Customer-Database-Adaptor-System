package edu.bu.met.cs665;

import edu.bu.met.cs665.dataAccess.Customer;
import edu.bu.met.cs665.dataAccess.NewSystem;
import edu.bu.met.cs665.dataAccess.NewSystemToOldSystemAdaptor;
import edu.bu.met.cs665.dataAccess.OldSystem;
import edu.bu.met.cs665.dataProcessingCommand.*;

import java.util.Arrays;
import java.util.List;

public class Main {
  /**
   * A main method to run examples.
   *
   * @param args not used
   */
  public static void main(String[] args) throws InterruptedException {

    System.out.println("---- Part 1: Customer Data Access ----");
    // 1. Build Old System
    Customer customer1 = new Customer("Abi Jones", "abi_jones@gmail.com");
    Customer customer2 = new Customer("Bob Watt", "bwatt@gmail.com");
    Customer customer3 = new Customer("Catherine Willard", "Catherine03@gmail.com");
    List<Customer> customerData = Arrays.asList(customer1, customer2, customer3);
    OldSystem oldSystem = new OldSystem(customerData);
    // 2. Build a new system using adaptor and old system
    NewSystem newSystem = new NewSystem(new NewSystemToOldSystemAdaptor(oldSystem));
    // 3. find a customer with both email and phone number
    System.out.println("Customer email address: " + customer2.getEmail());
    System.out.println("Customer phone number: 206-345-9873");
    Thread.sleep(1000);
    System.out.println("\nSearching in new system...");
    Thread.sleep(1000);
    System.out.println(newSystem.getCustomer("bwatt@gmail.com", "206-345-9873"));
    Thread.sleep(1000);

    System.out.println("\n---- Part 2: Customer Data Processing ----");
    // Setup three customers
    Customer customer4 = new Customer("David Griffin", "david_4@gmail.com", true);
    Customer customer5 = new Customer("Eliana Mantle", "em5@gmail.com", true);
    Customer customer6 = new Customer("Elizabeth Leonard", "elileo6@gmail.com", false);

    System.out.println("Example 2.1 : email verification and background check pass -> welcome email will be generated");
    Thread.sleep(1000);
    Command emailVerifyCmd = new EmailVerificationCommand(customer4, "david_4@gmail.com");
    Command backgroundCheckCmd = new BackgroundCheckCommand(customer4);
    Command emailGenerationCmd = new EmailGenerationCommand(customer4);
    DataProcessor dataProcessor = new DataProcessor();

    dataProcessor.storeAndExecute(emailVerifyCmd);
    dataProcessor.storeAndExecute(backgroundCheckCmd);
    dataProcessor.storeAndExecute(emailGenerationCmd);
    Thread.sleep(1000);

    System.out.println("\nExample 2.2 : email verification fail -> rejection email will be generated");
    Thread.sleep(1000);
    emailVerifyCmd = new EmailVerificationCommand(customer5, "em@gmail.com");
    backgroundCheckCmd = new BackgroundCheckCommand(customer5);
    emailGenerationCmd = new EmailGenerationCommand(customer5);

    dataProcessor.storeAndExecute(emailVerifyCmd);
    dataProcessor.storeAndExecute(backgroundCheckCmd);
    dataProcessor.storeAndExecute(emailGenerationCmd);
    Thread.sleep(1000);

    System.out.println("\nExample 2.3 : Background check fail -> rejection email will be generated");
    Thread.sleep(1000);
    emailVerifyCmd = new EmailVerificationCommand(customer6, "elileo6@gmail.com");
    backgroundCheckCmd = new BackgroundCheckCommand(customer6);
    emailGenerationCmd = new EmailGenerationCommand(customer6);

    dataProcessor.storeAndExecute(emailVerifyCmd);
    dataProcessor.storeAndExecute(backgroundCheckCmd);
    dataProcessor.storeAndExecute(emailGenerationCmd);
    Thread.sleep(1000);
  }
}
