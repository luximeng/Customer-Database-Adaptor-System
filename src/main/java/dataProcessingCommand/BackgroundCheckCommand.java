package edu.bu.met.cs665.dataProcessingCommand;

import edu.bu.met.cs665.dataAccess.Customer;

public class BackgroundCheckCommand implements Command {
    private Customer customer;

    public BackgroundCheckCommand(Customer customer) {
        this.customer = customer;
    }

    /**
     * To execute command
     */
    @Override
    public void execute() {
        this.customer.isBackgroundChecked();
    }
}
