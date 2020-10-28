
public class Main {

  public static void main(String[] args){
    TasksQueue queue = new TasksQueue();
    Scheduler scheduler = new Scheduler(2, queue);
    Thread th = new Thread(scheduler);
    th.start();

    int currentTS = (int) (System.currentTimeMillis()/1000L);
    Task t = new OneTimeTask(currentTS);
    Task t2 = new RecurringTask(5, queue);
    try {
      queue.inserInQueue(t);
      queue.inserInQueue(t2);
      Thread.sleep(1000000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
