package dao.dto;

import java.util.Objects;

public class ExpenseDto {
    private Integer id;
    private Double amount;
    private String category;
    private String date;
    private String frequency;

    public ExpenseDto() {
    }

    public ExpenseDto(Integer id, Double amount, String category, String date, String frequency) {
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.date = date;
        this.frequency = frequency;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "ExpenseDto{" +
                "id=" + id +
                ", amount=" + amount +
                ", category='" + category + '\'' +
                ", date='" + date + '\'' +
                ", frequency='" + frequency + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExpenseDto that = (ExpenseDto) o;
        return Objects.equals(id, that.id) && Objects.equals(amount, that.amount) && Objects.equals(category, that.category) && Objects.equals(date, that.date) && Objects.equals(frequency, that.frequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, category, date, frequency);
    }
}
