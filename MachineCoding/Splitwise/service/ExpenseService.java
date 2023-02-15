package Splitwise.service;

import Splitwise.model.Expense;
import Splitwise.model.User;

import java.util.List;
import java.util.Map;

public interface ExpenseService {
    Map<User, Float> splitEqual(List<User> payeeList, float total);
    Map<User, Float> splitExact(List<User> payeeList, List<Float> amount);
    Map<User, Float> splitByPercentage(List<User> payeeList, List<Float> amount, float totalAmount);
}
