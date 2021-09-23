package edu.bu.met.cs665.dataAccess;

/** Old System interface */
public interface CustomerDataOldSystem {
  /**
   * To retrieve customer data using email address in old system
   *
   * @param email a String as customer's email address
   * @return the CustomerInNewSystem object who is with that email address
   */
  Customer getCustomer(String email);
}
