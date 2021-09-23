package edu.bu.met.cs665.dataAccess;

/** New system interface */
public interface CustomerDataManagementSystem {
  /**
   * To retrieve customer data using email address and phone number in new system
   *
   * @param email a String as customer's email address
   * @param phoneNumber a String as customer's phone number
   * @return the CustomerInNewSystem object who is with that email address and phone number
   */
  Customer getCustomer(String email, String phoneNumber);
}
