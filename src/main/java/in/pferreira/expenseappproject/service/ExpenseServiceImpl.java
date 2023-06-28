package in.pferreira.expenseappproject.service;

import in.pferreira.expenseappproject.entity.Expense;
import in.pferreira.expenseappproject.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{
    @Autowired
    private ExpenseRepository expenseRepository;
    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
