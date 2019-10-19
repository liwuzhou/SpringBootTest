package com.lee.demo.dao;

import javafx.util.converter.BigDecimalStringConverter;

import java.math.BigDecimal;

public interface SalaryDao {

    public void updateSalaryByUserId(String userId, String salary);
}
