package com.odde.Account.boudget;

import com.odde.Account.model.Budget;

import java.util.List;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public interface BudgetRepo {

    List<Budget> getAll();
}
