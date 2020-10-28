import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Scheduler implements Runnable{


  List<Worker> workers;

  TasksQueue queue;
  public Scheduler(int numberOfWorkers, TasksQueue queue) {
    workers = new ArrayList<>(numberOfWorkers);
    this.queue = queue;
    for(int i = 0 ; i < numberOfWorkers; i++) {
      workers.add(new Worker());
    }

  }

  public void start() throws InterruptedException {
    while(true) {
      Thread.sleep(1000);
      int currentTs = (int) (System.currentTimeMillis()/1000L);
      Task t = queue.getTask();
      while(t != null) {
        t = queue.getTask();
        if(t==null){
          break;
        }
        Worker worker;
        try {
          worker = getThreadForExection();
        } catch (NoThreadAvailableException e) {
          queue.inserInQueue(t);
          System.out.println("no available thread");
          break;
        }

        worker.assignTask(t);
      }
    }
  }

  public Worker getThreadForExection() throws NoThreadAvailableException{
    for(Worker w : workers) {
      if (!w.isExecuting()){
        return w;
      }
    }

    throw new NoThreadAvailableException();
  }

  @Override
  public void run() {
    try {
      start();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
