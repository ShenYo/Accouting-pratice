package com.odde.java.Account.boudget;


import com.odde.java.Account.model.Budget;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class BudgetRepoImpl implements BudgetRepo {

    @Override
    public List<Budget> getAll() {
        return new ArrayList<Budget>() {{
            add(new Budget("201901", 31));
            add(new Budget("201902", 56));
            add(new Budget("201903", null));
            add(new Budget("201904", 900));
            add(new Budget("201905", 620));
            add(new Budget("201906", 600));
            add(new Budget("201907", 310));
            add(new Budget("201908", 620));
            add(new Budget("201909", null));
            add(new Budget("201910", 930));
            add(new Budget("201911", 300));
            add(new Budget("201912", 155));
        }};
    }
}
