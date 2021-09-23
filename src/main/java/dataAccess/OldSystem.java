package edu.bu.met.cs665.dataAccess;

import java.util.List;

/** Concrete old system */
public class OldSystem implements CustomerDataOldSystem {
  /** the database of all customers as a list */
  private List<Customer> customersData;

  /**
   * Constructor of OldSystem
   *
   * @param customersData the list of all customers
   */
  public OldSystem(List<Customer> customersData) {
    this.customersData = customersData;
  }

  /**
   * To retrieve customer with email address in old system
   *
   * @param email a String as customer's email address
   * @return the Customer object who is with that email address
   */
  @Override
  public Customer getCustomer(String email) {
    return this.getCustomersData().stream()
        .filter(curCustomer -> curCustomer.getEmail().equals(email))
        .findFirst()
        .orElse(null);
  }

  /** Getter */
  public List<Customer> getCustomersData() {
    return customersData;
  }
  /** Setter */
  public void setCustomersData(List<Customer> customersData) {
    this.customersData = customersData;
  }
}
