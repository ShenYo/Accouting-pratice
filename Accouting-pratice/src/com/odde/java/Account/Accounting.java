package com.odde.java.Account;

import com.odde.java.Account.boudget.BudgetRepo;
import com.odde.java.Account.boudget.BudgetRepoImpl;
import com.odde.java.Account.model.Budget;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class Accounting {


    private BudgetRepo repo = new BudgetRepoImpl();
    private Double totalAmount = 0d;

    public double totalAmount(LocalDate start, LocalDate end) {
        if (isInvalidPeriod(start, end)) {
            return 0;
        }

        List<Budget> filteredList = getFilteredList(start, end);

        calculateBugget(start, end, filteredList);

        return totalAmount;
    }


    private boolean isInvalidPeriod(LocalDate start, LocalDate end) {
        return start.isAfter(end);
    }

    @NotNull
    private List<Budget> getFilteredList(LocalDate start, LocalDate end) {
        return repo.getAll().stream()
                .filter(budget -> isAfterStartDate(start, budget) && isBeforeEndDate(end, budget))
                .collect(Collectors.toList());
    }

    private void calculateBugget(LocalDate start, LocalDate end, List<Budget> filteredList) {
        for (int index = 0; index < filteredList.size(); index++) {
            Budget budget = filteredList.get(index);

            if (isAmountEmpty(budget)) {
                continue;
            }

            if (isSingleMonth(start, end)) {
                totalAmount += (getSingleDayBudget(budget)) * getPeriodBetweenStartAndEnd(start, end);
            } else {
                if (index == 0) {
                    totalAmount += getSingleDayBudget(budget) * getDaysToEndOfMonth(start, budget);
                } else if (index == filteredList.size() - 1) {
                    totalAmount += (getSingleDayBudget(budget)) * getDaysFormBeginOfMonth(end);
                } else {
                    totalAmount += budget.amount;
                }
            }
        }
    }


    private boolean isAmountEmpty(Budget budget) {
        return budget.amount == null;
    }

    private boolean isSingleMonth(LocalDate start, LocalDate end) {
        return YearMonth.of(start.getYear(), start.getMonth()).equals(YearMonth.of(end.getYear(), end.getMonth()));
    }

    private double getSingleDayBudget(Budget budget) {
        return budget.amount / getLengthOfMonth(budget);
    }

    private int getPeriodBetweenStartAndEnd(LocalDate start, LocalDate end) {
        return Period.between(start, end).getDays() + 1;
    }

    private int getDaysToEndOfMonth(LocalDate start, Budget budget) {
        return getLengthOfMonth(budget) - start.getDayOfMonth() + 1;
    }

    private int getDaysFormBeginOfMonth(LocalDate end) {
        return end.getDayOfMonth();
    }

    private int getLengthOfMonth(Budget budget) {
        return YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).lengthOfMonth();
    }


    private boolean isBeforeEndDate(LocalDate end, Budget budget) {
        return YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).isBefore(YearMonth.of(end.getYear(), end.getMonth())) ||
                YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).equals(YearMonth.of(end.getYear(), end.getMonth()));
    }

    private boolean isAfterStartDate(LocalDate start, Budget budget) {
        return YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).isAfter(YearMonth.of(start.getYear(), start.getMonth())) ||
                YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).equals(YearMonth.of(start.getYear(), start.getMonth()));

    }
}
