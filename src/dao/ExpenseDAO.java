package dao;

import dao.dto.ExpenseDto;
import entities.Expense;

import java.util.List;

public interface ExpenseDAO {

    void insert(ExpenseDto expenseDto);

    List<Expense> getAll();

    void update(Expense expense);

    void delete(int id);
}
