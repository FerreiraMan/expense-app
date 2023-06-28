package in.pferreira.expenseappproject.service;
import in.pferreira.expenseappproject.entity.Expense;
import java.util.List;

public interface ExpenseService {
    List<Expense> getAllExpenses();
}
