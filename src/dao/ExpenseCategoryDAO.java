package dao;

import dao.dto.ExpenseCategoryDto;
import entities.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryDAO {

    void insert(ExpenseCategoryDto expenseCategory);

    List<ExpenseCategory> getAll();

    void update(ExpenseCategory expenseCategory);

    void delete(int id);
}
