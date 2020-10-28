public class NoThreadAvailableException extends Exception {
  public NoThreadAvailableException() {
    super("No threads free for task.");
  }
}
