package com.odde.java.Account.model;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class Budget {

    public final String yaerMonth;
    public final Integer amount;

    public Budget(String yaerMonth, Integer amount) {
        this.yaerMonth = yaerMonth;
        this.amount = amount;
    }
}
