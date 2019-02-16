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

    @Before
    public void init() {
        accounting = new Accounting();
    }

    @Test
    public void InvalidDate(){
        Assert.assertEquals(0, accounting.totalAmount(
                LocalDate.of(2019, 2, 1),
                LocalDate.of(2019, 1, 1))
                , 0.0);
    }

    @Test
    public void EmptyBudget() {
        Assert.assertEquals(0, accounting.totalAmount(
                LocalDate.of(2019, 3, 1),
                LocalDate.of(2019, 3, 1))
                , 0.0);
    }

    @Test
    public void getSingleDayBudget(){
        Assert.assertEquals(2, accounting.totalAmount(
                LocalDate.of(2019, 2, 16),
                LocalDate.of(2019, 2, 16))
                , 0.0);
    }

    @Test
    public void getIntervalDayBudgetInSingleMonth(){
        Assert.assertEquals(5, accounting.totalAmount(
                LocalDate.of(2019, 1, 11),
                LocalDate.of(2019, 1, 15))
                , 0.0);
    }

    @Test
    public void getIntervalDayBudgetMultiMonth(){
        Assert.assertEquals(12, accounting.totalAmount(
                LocalDate.of(2019, 1, 30),
                LocalDate.of(2019, 2, 5))
                , 0.0);
    }


    //fixme
    private void resultShouldBe(double expected) {

    }

}
