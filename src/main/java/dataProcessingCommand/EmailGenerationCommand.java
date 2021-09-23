package edu.bu.met.cs665.dataProcessingCommand;

import edu.bu.met.cs665.dataAccess.Customer;

public class EmailGenerationCommand implements Command {
    private Customer customer;

    public EmailGenerationCommand(Customer customer) {
        this.customer = customer;
    }

    /**
     * To execute command
     */
    @Override
    public void execute() {
        if (this.customer.getIsEmailVerified() && this.customer.getIsBackgroundChecked()){
            System.out.println("Welcome Email: Welcome to the system, " + this.customer.getName());
        } else if (!this.customer.getIsEmailVerified()) {
            System.out.println("Rejection email: Sorry, your email address is not verified. Please check your email to verify.");
        } else if (!this.customer.getIsBackgroundChecked()) {
            System.out.println("Rejection email: Sorry, your background check is passed.");
        }
    }
}
