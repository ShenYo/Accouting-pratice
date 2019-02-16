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
        resultShouldBe(0);
    }

    private void resultShouldBe(double expected) {
        Assert.assertEquals(expected, accounting.totalAmount(
                LocalDate.of(2019, 1, 1),
                LocalDate.of(2019, 1, 1))
        , 0.0);
    }

}
