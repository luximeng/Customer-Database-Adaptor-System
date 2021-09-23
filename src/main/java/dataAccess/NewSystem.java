package edu.bu.met.cs665.dataAccess;

public class NewSystem implements CustomerDataManagementSystem {
    NewSystemToOldSystemAdaptor adaptor;

    public NewSystem(NewSystemToOldSystemAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    /**
     * To retrieve customer data using email address and phone number in new system
     *
     * @param email       a String as customer's email address
     * @param phoneNumber a String as customer's phone number
     * @return the CustomerInNewSystem object who is with that email address and phone number
     */
    @Override
    public Customer getCustomer(String email, String phoneNumber) {
        return this.adaptor.getCustomer(email,phoneNumber);
    }
}
