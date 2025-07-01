package com.google.gson.internal;

import androidx.work.WorkRequest;
import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberLimits {
    private static final int MAX_NUMBER_STRING_LENGTH = 10000;

    private NumberLimits() {
    }

    private static void checkNumberStringLength(String str) {
        if (str.length() > MAX_NUMBER_STRING_LENGTH) {
            throw new NumberFormatException("Number string too large: " + str.substring(0, 30) + "...");
        }
    }

    public static BigDecimal parseBigDecimal(String str) throws NumberFormatException {
        checkNumberStringLength(str);
        BigDecimal bigDecimal = new BigDecimal(str);
        if (Math.abs((long) bigDecimal.scale()) < WorkRequest.MIN_BACKOFF_MILLIS) {
            return bigDecimal;
        }
        throw new NumberFormatException("Number has unsupported scale: " + str);
    }

    public static BigInteger parseBigInteger(String str) throws NumberFormatException {
        checkNumberStringLength(str);
        return new BigInteger(str);
    }
}
