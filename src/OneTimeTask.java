public class OneTimeTask extends Task {

  public OneTimeTask(int executionTs) {
    this.setExecutionTs(executionTs);
  }

  @Override
  public void run() {
    System.out.println(10*10);
  }


}
