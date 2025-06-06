package com.gepardec.training.microprofile.basic.config.converter;

import org.eclipse.microprofile.config.spi.Converter;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalConverter implements Converter<BigDecimal> {

    @Override
    public BigDecimal convert(String s) throws IllegalArgumentException, NullPointerException {
        return new BigDecimal(s).setScale(2, RoundingMode.HALF_UP);
    }
}
