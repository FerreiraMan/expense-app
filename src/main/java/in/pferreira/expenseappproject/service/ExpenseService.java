package in.pferreira.expenseappproject.service;
import in.pferreira.expenseappproject.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);
    void deleteExpenseById(Long id);
    Expense saveExpenseDetails(Expense expense);
    Expense updateExpenseDetails(Long id, Expense expense);
}
