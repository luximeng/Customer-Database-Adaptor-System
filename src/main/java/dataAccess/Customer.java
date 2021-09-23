package edu.bu.met.cs665.dataAccess;

import java.util.Objects;

/** customer class */
public class Customer {
  private String name;
  private String email;
  private boolean isEmailVerified; // flag for email verification in data processing part
  private boolean isBackgroundChecked; // flag for background check in data processing part

  /**
   * Constructor for only customer data
   *
   * @param name a String as customer name
   * @param email a String as customer email address
   */
  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * Constructor with customer data and related flag for data processing
   *
   * @param name a String as customer name
   * @param email a String as customer email address
   * @param isBackgroundChecked to set if this customer's background check is passed or not
   */
  public Customer(String name, String email, boolean isBackgroundChecked) {
    this.name = name;
    this.email = email;
    this.isEmailVerified =
        false; // email verification set false by default, need to call isEmailMatched() to change
    this.isBackgroundChecked = isBackgroundChecked;
  }

  /** Getters and Setters */
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public boolean getIsEmailVerified() {
    return isEmailVerified;
  }

  public void setEmailVerified(boolean emailVerified) {
    isEmailVerified = emailVerified;
  }

  public boolean getIsBackgroundChecked() {
    return isBackgroundChecked;
  }

  public void setBackgroundChecked(boolean backgroundChecked) {
    isBackgroundChecked = backgroundChecked;
  }

  /**
   * method to execute in EmailVerificationCommand
   *
   * @param inputEmail
   */
  public void isEmailMatched(String inputEmail) {
    if (this.getEmail().equals(inputEmail)) {
      this.setEmailVerified(true);
      System.out.println(this.getName() + "'s Email is verified as " + inputEmail);
    } else {
      this.setEmailVerified(false);
      System.out.println(inputEmail + " cannot be verified.");
    }
  }

  /** method to execute in BackgroundCheckCommand */
  public void isBackgroundChecked() {
    if (this.isBackgroundChecked) {
      System.out.println(this.getName() + "'s background check passed.");
    } else {
      System.out.println(this.getName() + "'s background check didn't pass.");
    }
  }

  /** override equals(), hashCode() and toString() */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Customer customer = (Customer) o;
    return isEmailVerified == customer.isEmailVerified
        && isBackgroundChecked == customer.isBackgroundChecked
        && Objects.equals(name, customer.name)
        && Objects.equals(email, customer.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, email, isEmailVerified, isBackgroundChecked);
  }

  @Override
  public String toString() {
    return "\nCustomer " + "name='" + name + '\'';
  }
}
