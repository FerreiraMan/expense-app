package in.pferreira.expenseappproject.service;
import in.pferreira.expenseappproject.entity.Expense;
import java.util.List;
import java.util.Optional;

public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
}
