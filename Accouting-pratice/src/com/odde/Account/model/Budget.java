package com.odde.Account.model;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class Budget {
    final String yaerMonth;
    final Object amount;

    public Budget(String yaerMonth, Integer amount) {
        this.yaerMonth = yaerMonth;
        this.amount = amount;
    }
}
