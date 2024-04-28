package entities;

public class Expense {

    private Integer id;
    private Double amount;
    private ExpenseCategory category;
    private String date;

    public Expense() {
    }

    public Expense(Integer id, Double amount, ExpenseCategory category, String date) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }
    

}
