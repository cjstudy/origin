package com.mini.base.utils;

import java.math.BigDecimal;

public class MathUtils {
    public static BigDecimal minusOfBigDecimal(BigDecimal bd, BigDecimal... bds) {
        BigDecimal result = bd;

        if (result == null)
            result = BigDecimal.ZERO;

        if (bds != null && bds.length > 0) {
            for (BigDecimal b : bds) {
                if (b == null)
                    b = BigDecimal.ZERO;

                result = result.subtract(b);
            }
        }

        return result;
    }
}
