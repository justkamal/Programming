package Splitwise.service;

import Splitwise.model.Expense;
import Splitwise.model.User;

import java.util.HashSet;
import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<Expense> showBalance() {
        return null;
    }

    @Override
    public void addExpense(User user, Expense expense) {
        if (user.getExpenses() == null) {
            user.setExpenses(new HashSet<>());
        }
        user.getExpenses().add(expense.getId());
    }
}
