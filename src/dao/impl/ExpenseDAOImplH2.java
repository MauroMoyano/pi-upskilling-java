package dao.impl;

import config.JdbcConfiguration;
import dao.ExpenseDAO;
import dao.dto.ExpenseDto;
import entities.Expense;

import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ExpenseDAOImplH2 implements ExpenseDAO {

    private final Connection connection;

    public ExpenseDAOImplH2() {
        this.connection = JdbcConfiguration.getDBConnection();
    }

    @Override
    public void insert(ExpenseDto expenseDto) {
        Expense newExpense = new Expense();
    }

    @Override
    public List<Expense> getAll() {
        return List.of();
    }

    @Override
    public void update(Expense expense) {

    }

    @Override
    public void delete(int id) {

    }
}
