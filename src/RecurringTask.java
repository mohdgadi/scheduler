public class RecurringTask extends Task {

  TasksQueue queue;
  private int interval;
  public RecurringTask(int interval, TasksQueue qu) {
    this.interval = interval;
    this.queue = qu;
    this.setExecutionTs((int) (System.currentTimeMillis()/1000L));
  }

  @Override
  public void run() {
    System.out.println(10*10);
    this.setExecutionTs((int) (System.currentTimeMillis()/1000L) + interval);
    queue.inserInQueue(this);
  }
}
