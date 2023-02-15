package Splitwise.service;

import Splitwise.model.Expense;
import Splitwise.model.User;

import java.util.List;

public interface UserService {
    List<Expense> showBalance();
    void addExpense(User user, Expense expense);
}
