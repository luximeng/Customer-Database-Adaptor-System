package edu.bu.met.cs665.dataProcessingCommand;

import java.util.ArrayList;
import java.util.List;

public class DataProcessor {

  /** a list of command to store history of commands*/
  private List<Command> history = new ArrayList<>();

  public void storeAndExecute(final Command cmd){
      this.history.add(cmd);
      cmd.execute();
  }
}
