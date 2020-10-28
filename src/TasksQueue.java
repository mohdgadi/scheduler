import java.util.Comparator;
import java.util.PriorityQueue;

public class TasksQueue {
  PriorityQueue<Task> tasksQueue;
  public TasksQueue(){
    tasksQueue = new PriorityQueue<>(Comparator.comparingInt(Task::getExecutionTs));
  }

  public void inserInQueue(Task t) {
    tasksQueue.add(t);
  }

  public Task getTask() {
    int currentTs = (int) (System.currentTimeMillis()/1000L);
    if(!tasksQueue.isEmpty() && tasksQueue.peek().getExecutionTs() < currentTs){
      return tasksQueue.poll();
    }

    return null;
  }
}
