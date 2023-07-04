package in.pferreira.expenseappproject.exceptions;

import java.io.Serial;

public class ExpenseNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public ExpenseNotFoundException(String message) {
        super(message);
    }
}
