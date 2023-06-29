package in.pferreira.expenseappproject.controller;

import in.pferreira.expenseappproject.entity.Expense;
import in.pferreira.expenseappproject.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public Expense getExpenseById(@PathVariable Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam Long id){ expenseService.deleteExpenseById(id); }

    @PostMapping("/expenses")
    public Expense saveExpenseDetails(@RequestBody Expense expense){ return expenseService.saveExpenseDetails(expense);}
}
