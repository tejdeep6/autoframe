package QaAutomation.frameworkqa.exceptions;

public class EmbitelReporterException extends Exception
{
	private String message;

	public EmbitelReporterException() {}

	public EmbitelReporterException(String message)  {
		this.message = message;
	}

	public String toString()  {
		return "[Custom Reporter Exception] " + this.message;
	}
}
