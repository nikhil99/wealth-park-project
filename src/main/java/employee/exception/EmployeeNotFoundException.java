package employee.exception;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(Long id) {
        super("Could not find employee " + id);
    }

    public EmployeeNotFoundException(String firstName) {
        super("Could not find employee with name :" + firstName);
    }
    public EmployeeNotFoundException(Long id,String message) {
        super(message + id);
    }
}