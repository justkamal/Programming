package Splitwise.main;

import Splitwise.model.Expense;
import Splitwise.model.ExpenseType;
import Splitwise.model.User;
import Splitwise.repository.ExpenseRepository;
import Splitwise.repository.UserRepository;
import Splitwise.service.ExpenseService;
import Splitwise.service.ExpenseServiceImpl;
import Splitwise.service.UserService;
import Splitwise.service.UserServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class MainApp {

    private static BufferedReader br;
    private static StringTokenizer strz;
    private static UserRepository userRepository;
    private static ExpenseRepository expenseRepository;
    private static UserService userService;
    private static ExpenseService expenseService;

    public static void main(String[] args) throws IOException {
        userRepository = new UserRepository();
        expenseRepository = new ExpenseRepository();
        userService = new UserServiceImpl();
        expenseService = new ExpenseServiceImpl();
        addUsers();
        br = new BufferedReader(new InputStreamReader(System.in));

        String operationType = "START";
        while (!"EXIT".equals(operationType)) {
            strz = new StringTokenizer(br.readLine());
            operationType = strz.nextToken();
            if ("SHOW".equals(operationType)) {
                if (strz.hasMoreTokens()) {
                    User user = userRepository.findUserById(strz.nextToken());
                    if (Objects.nonNull(user.getExpenses())) {
                        user.getExpenses().forEach(expenseId -> {
                            printExpense(expenseRepository.findExpenseById(expenseId));
                        });
                    } else {
                        System.out.println("No balances");
                    }
                } else {
                    List<User> userList = userRepository.fetchAllUsers();
                    AtomicBoolean noBalances = new AtomicBoolean(false);
                    userList.forEach(user -> {
                        if (Objects.nonNull(user.getExpenses())) {
                            user.getExpenses().forEach(expenseId -> {
                                printExpense(expenseRepository.findExpenseById(expenseId));
                            });
                            noBalances.set(false);
                        } else {
                            noBalances.set(true);
                        }
                    });
                    if (noBalances.get()) {
                        System.out.println("No balances");
                    }
                }
            } else if ("EXPENSE".equals(operationType)) {
                User user = userRepository.findUserById(strz.nextToken());
                Float amount = Float.parseFloat(strz.nextToken());
                int splitCount = Integer.parseInt(strz.nextToken());
                List<User> payeeList = new ArrayList<>();
                for (int i = 0; i < splitCount; ++i) {
                    payeeList.add(userRepository.findUserById(strz.nextToken()));
                }
                ExpenseType expenseType = ExpenseType.valueOf(strz.nextToken());
                Map<User, Float> amountSplit = new HashMap<>();
                switch (expenseType) {
                    case EQUAL:
                        amountSplit = expenseService.splitEqual(payeeList, amount);
                        break;
                    case EXACT:
                        List<Float> amountList = new ArrayList<>();
                        for (int i = 0; i < payeeList.size(); ++i) {
                            amountList.add(Float.parseFloat(strz.nextToken()));
                        }
                        amountSplit = expenseService.splitExact(payeeList, amountList);
                        break;
                    case PERCENTAGE:
                        List<Float> percentList = new ArrayList<>();
                        for (int i = 0; i < payeeList.size(); ++i) {
                            percentList.add(Float.parseFloat(strz.nextToken()));
                        }
                        amountSplit = expenseService.splitByPercentage(payeeList, percentList, amount);
                        break;
                }
                Expense expense = Expense.builder().id(expenseRepository.getNewId()).payer(user.getUserId()).amount(amount).type(expenseType).amountSplit(amountSplit).build();
                userService.addExpense(user, expense);
                expenseRepository.createExpense(expense);
            }
        }
    }

    private static void addUsers() {
        User user1 = User.builder().userId("u1").email("u1@email.com").name("Kamal").phoneNumber("1234567890").build();
        User user2 = User.builder().userId("u2").email("u2@email.com").name("Vinay").phoneNumber("1234567890").build();
        User user3 = User.builder().userId("u3").email("u3@email.com").name("Yogesh").phoneNumber("1234567890").build();
        User user4 = User.builder().userId("u4").email("u4@email.com").name("Sagar").phoneNumber("1234567890").build();
        userRepository.createUser(user1);
        userRepository.createUser(user2);
        userRepository.createUser(user3);
        userRepository.createUser(user4);
    }

    private static void printExpense(Expense expense) {
        expense.getAmountSplit().forEach( (user, amount) -> {
            System.out.println("User " + user.getUserId() + " owes " + expense.getPayer() + " : " + amount);
        });
    }
}
