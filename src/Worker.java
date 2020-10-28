public class Worker implements Runnable{

  private Task task;
  private boolean isExecuting;
  public Worker() {
    this.isExecuting = false;
  }

  public void assignTask(Task task) {
    this.task = task;
    run();
  }

  public boolean isExecuting() {
    return isExecuting;
  }

  @Override
  public void run() {
    task.run();
    this.isExecuting = false;
  }
}
