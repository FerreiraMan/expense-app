package in.pferreira.expenseappproject.repository;

import in.pferreira.expenseappproject.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
