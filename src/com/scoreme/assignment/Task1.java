package com.scoreme.assignment;

import java.util.*;

public class Task1 {

    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: handle null input list
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {

            // FIX: skip null account
            if (account == null) continue;

            // FIX: check dueDate not null before calling before()
            if (account.getDueDate() != null && account.getDueDate().before(new Date())) {

                // FIX: ensure outstanding balance is positive
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}