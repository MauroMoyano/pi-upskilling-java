package exception;

public class InvalidDataTypeExceptionImp extends RuntimeException{
    public InvalidDataTypeExceptionImp() {
    }

    public InvalidDataTypeExceptionImp(String message) {
        super(message);
    }

    public InvalidDataTypeExceptionImp(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataTypeExceptionImp(Throwable cause) {
        super(cause);
    }
}
