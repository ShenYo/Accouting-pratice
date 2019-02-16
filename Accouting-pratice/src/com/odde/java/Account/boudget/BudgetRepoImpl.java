package com.odde.Account.boudget;


import com.odde.java.Account.model.Budget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 *
 * @author Shenyo
 * @version 1.0, 2019/2/16
 */


public class BudgetRepoImpl implements com.odde.Account.boudget.BudgetRepo {
    Map<String, Budget> list = new HashMap<>()


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
            add(new Budget("2019010", 930));
            add(new Budget("2019011", 300));
            add(new Budget("2019012", 155));
        }};
    }
}
