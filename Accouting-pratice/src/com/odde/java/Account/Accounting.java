package com.odde.java.Account;

import java.time.LocalDate;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class Accounting {


    com.odde.Account.boudget.BudgetRepo repo = new com.odde.Account.boudget.BudgetRepoImpl();

    public double totalAmount(LocalDate start, LocalDate end) {
        if (start.isAfter(end)) {
            return 0;
        }

        repo.getAll().forEach(budget -> {
              budget.
        });

        return 0;
    }
}
