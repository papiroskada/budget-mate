package com.budget.budgetmate.utils;

import com.budget.budgetmate.dto.request.StateName;
import com.budget.budgetmate.state.AccountState;
import com.budget.budgetmate.state.ActiveState;
import com.budget.budgetmate.state.ClosedState;
import com.budget.budgetmate.state.FrozenState;

public class StateUtils {
     public static AccountState getStateByName(StateName name) {
         return switch (name) {
             case ACTIVE -> new ActiveState();
             case FROZEN -> new FrozenState();
             case CLOSED -> new ClosedState();
             default -> throw new IllegalArgumentException("Unknown state: " + name);
         };
     }
}
