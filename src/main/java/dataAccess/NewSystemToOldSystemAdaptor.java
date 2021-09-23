package edu.bu.met.cs665.dataAccess;

/** Adaptor to generate a new system and adapt new getCustomer() method to old system */
public class NewSystemToOldSystemAdaptor
    implements CustomerDataOldSystem, CustomerDataManagementSystem {

  private OldSystem oldSystem;

  public NewSystemToOldSystemAdaptor(OldSystem oldSystem) {
    this.setOldSystem(oldSystem);
  }

  /**
   * To retrieve customer data using email address in old system
   *
   * @param email a String as customer's email address
   * @return the CustomerInNewSystem object who is with that email address
   */
  @Override
  public Customer getCustomer(String email) {
    return this.getOldSystem().getCustomer(email);
  }

  /**
   * To retrieve customer data using email address and phone number in new system
   *
   * @param email a String as customer's email address
   * @param phoneNumber a String as customer's phone number
   * @return the CustomerInNewSystem object who is with that email address and phone number
   */
  @Override
  public Customer getCustomer(String email, String phoneNumber) {
    return this.getCustomer(email);
  }

  /** getter */
  public OldSystem getOldSystem() {
    return oldSystem;
  }

  /** setter */
  public void setOldSystem(OldSystem oldSystem) {
    this.oldSystem = oldSystem;
  }
}
