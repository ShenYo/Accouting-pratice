package com.odde.java.Account;

import com.odde.java.Account.boudget.BudgetRepo;
import com.odde.java.Account.model.Budget;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class Accounting {


    BudgetRepo repo = new com.odde.Account.boudget.BudgetRepoImpl();
    int totalAmount = 0;

    public double totalAmount(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            return 0;
        }

        repo.getAll().forEach(budget -> {
            if (isAfterStartDate(start, budget) && isBeforeEndDate(end, budget)) {
                if(budgetNoData(budget)) {
                    return;
                }
                totalAmount += budget.amount / getLengthOfMonth(budget);
            }
        });


        return totalAmount * getPeriodBetweenStartAndEnd(start, end);
    }

    private int getPeriodBetweenStartAndEnd(LocalDate start, LocalDate end) {
        return Period.between(start, end).getDays()  + 1;
    }

    private int getLengthOfMonth(Budget budget) {
        return YearMonth.parse(budget.yaerMonth, DateTimeFormatter.ofPattern("yyyyMM")).lengthOfMonth();
    }

    private boolean budgetNoData(Budget budget) {
        return budget.amount == null;
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
