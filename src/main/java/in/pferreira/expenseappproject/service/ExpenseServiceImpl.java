package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.Expense;
import in.pferreira.expenseappproject.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() { return expenseRepository.findAll(); }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        }
        throw new RuntimeException("Expense is not found for the id "+id);
    }

    @Override
    public void deleteExpenseById(Long id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public Expense saveExpenseDetails(Expense expense) { return expenseRepository.save(expense); }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        // Get existing expense object
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        return expenseRepository.save(existingExpense);
    }
}
