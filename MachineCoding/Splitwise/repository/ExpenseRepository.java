package Splitwise.repository;

import Splitwise.model.Expense;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpenseRepository {
    private static Map<Integer, Expense> expenseDb;
    private static Integer sequenceId;

    public ExpenseRepository() {
        expenseDb = new HashMap<>();
        sequenceId = 0;
    }

    public Expense findExpenseById(Integer expenseId) {
        return expenseDb.get(expenseId);
    }

    public List<Expense> fetchAll(Set<Integer> expenseIdList) {
        return expenseDb.values().stream().filter(expense -> expenseIdList.contains(expense.getId())).toList();
    }

    public void createExpense(Expense expense) {
        expenseDb.put(expense.getId(), expense);
        ++sequenceId;
    }

    public Integer getNewId(){
        return sequenceId;
    }
}
