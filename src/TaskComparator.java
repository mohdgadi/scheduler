public class TaskComparator implements Comparable<Task> {

public TaskComparator() {
}

  @Override
  public int compareTo(Task o) {
    return o.getExecutionTs();
  }
}
