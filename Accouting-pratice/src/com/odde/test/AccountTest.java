package com.odde.test;


import com.odde.java.Account.Accounting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class AccountTest {

    private Accounting accounting;
    private double result;

    @Before
    public void init() {
        accounting = new Accounting();
    }

    @Test
    public void invalidDate() {
        givenDateInterval(LocalDate.of(2019, 2, 1), LocalDate.of(2019, 1, 1));
        resultShouldBe(0);
    }



    @Test
    public void emptyBudget() {
        givenDateInterval(LocalDate.of(2019, 3, 1), LocalDate.of(2019, 3, 1));
        resultShouldBe(0);
    }

    @Test
    public void singleDayBudget() {
        givenDateInterval(LocalDate.of(2019, 2, 16), LocalDate.of(2019, 2, 16));
        resultShouldBe(2);
    }

    @Test
    public void intervalDayBudgetInSingleMonth() {
        givenDateInterval(LocalDate.of(2019, 1, 11), LocalDate.of(2019, 1, 15));
        resultShouldBe(5);
    }

    @Test
    public void intervalDayBudgetMultiMonth() {
        givenDateInterval(LocalDate.of(2019, 1, 30), LocalDate.of(2019, 2, 5));
        resultShouldBe(12);

    }

    private void givenDateInterval(LocalDate start, LocalDate end) {
        result = accounting.totalAmount(start, end);
    }

    private void resultShouldBe(double expceted) {
        Assert.assertEquals(expceted, result, 0.0);
    }

}
