package Splitwise.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@Builder
public class Expense {
    private int id;
    private float amount;
    private ExpenseType type;
    private String payer;
    private Map<User, Float> amountSplit;

    @Override
    public String toString() {
        return "Amount: " + amount + " split: " + amountSplit;
    }
}
