package Splitwise.service;

import Splitwise.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseServiceImpl implements ExpenseService {
    @Override
    public Map<User, Float> splitEqual(List<User> payeeList, float total) {
        float share = total / payeeList.size();
        float residue = total - (share * payeeList.size());

        Map<User, Float> amountSplit = new HashMap<>();
        amountSplit.put(payeeList.get(0), share + residue);

        for (int i = 1; i < payeeList.size(); ++i) {
            amountSplit.put(payeeList.get(i), share);
        }
        return amountSplit;
    }

    @Override
    public Map<User, Float> splitExact(List<User> payeeList, List<Float> amountList) {
        Map<User, Float> amountSplit = new HashMap<>();
        for (int i = 0; i < payeeList.size(); ++i) {
            amountSplit.put(payeeList.get(i), amountList.get(i));
        }
        return amountSplit;
    }

    @Override
    public Map<User, Float> splitByPercentage(List<User> payeeList, List<Float> percent, float totalAmount) {

        Map<User, Float> amountSplit = new HashMap<>();
        float residue = totalAmount;

        for (int i = 1; i < payeeList.size(); ++i) {
            float share = (percent.get(i) / 100.0f) * (totalAmount);
            amountSplit.put(payeeList.get(i), share);
            totalAmount -= share;
        }

        amountSplit.put(payeeList.get(0), amountSplit.get(payeeList.get(0)) + residue);
        return amountSplit;
    }
}
