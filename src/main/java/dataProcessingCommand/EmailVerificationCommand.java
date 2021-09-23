package edu.bu.met.cs665.dataProcessingCommand;

import edu.bu.met.cs665.dataAccess.Customer;

public class EmailVerificationCommand implements Command {
    private Customer customer;
    private String emailToCheck;

    public EmailVerificationCommand(Customer customer, String emailToCheck) {
        this.customer = customer;
        this.emailToCheck = emailToCheck;
    }

    /**
     * To execute command
     */
    @Override
    public void execute() {
        customer.isEmailMatched(emailToCheck);
    }
}
