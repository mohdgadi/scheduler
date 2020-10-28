import java.util.Comparator;

public abstract class Task{
  private int executionTs;

  public void setExecutionTs(int executionTs) {
    this.executionTs = executionTs;
  }

  public int getExecutionTs() {
    return executionTs;
  }

  public abstract void run();
}
