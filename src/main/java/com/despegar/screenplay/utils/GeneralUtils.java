package com.despegar.screenplay.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneralUtils {

    public static String[] getNDaysAferTodayDateAsStr(int n){

        DateTimeFormatter dateFormat_yyyyMM = DateTimeFormatter.ofPattern("yyyy-MM");
        DateTimeFormatter dateFormat_dd = DateTimeFormatter.ofPattern("d");

        LocalDateTime today = LocalDateTime.now();

        String date_yyyyMM = today.plusDays(n).format(dateFormat_yyyyMM);
        String date_d =      today.plusDays(n).format(dateFormat_dd);

        return new String[]{ date_yyyyMM, date_d };
    }

}
