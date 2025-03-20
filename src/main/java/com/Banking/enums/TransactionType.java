package com.Banking.enums;

public enum TransactionType {
    WITHDRAW, DEPOSIT;

    public static boolean isValid(String value) {
        try {
            TransactionType.valueOf(value);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
