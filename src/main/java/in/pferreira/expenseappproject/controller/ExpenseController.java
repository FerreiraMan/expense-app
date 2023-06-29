package in.pferreira.expenseappproject.controller;

import in.pferreira.expenseappproject.entity.Expense;
import in.pferreira.expenseappproject.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Optional<Expense> getExpenseById(@PathVariable("id") Long id) {
        return expenseService.getExpenseById(id);
    }
}
