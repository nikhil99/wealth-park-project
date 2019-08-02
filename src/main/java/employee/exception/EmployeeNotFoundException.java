package employee.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
    public EmployeeNotFoundException(Long id,String message) {
        super(message + id);
    }
}