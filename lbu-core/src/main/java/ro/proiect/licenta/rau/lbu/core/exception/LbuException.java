package ro.proiect.licenta.rau.lbu.core.exception;

public class LbuException extends Exception
{

  private static final long serialVersionUID = 1L;

  public LbuException()
  {
    super();
  }

  public LbuException(String message)
  {
    super(message);
  }

  public LbuException(Throwable cause)
  {
    super(cause);
  }

  public LbuException(String message, Throwable cause)
  {
    super(message, cause);
  }
}
