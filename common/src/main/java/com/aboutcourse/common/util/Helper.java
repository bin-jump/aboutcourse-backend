package com.aboutcourse.common.util;

import java.util.Calendar;
import java.util.Date;

public class Helper {

    // time should be 5 min step
    public static boolean validTime(Date date) {

        return date != null && date.getTime() % (5 * 60 * 1000) == 0;
    }

    public static Date dateOnly(Date date) {
        return new Date((date.getTime() / (24 * 3600 * 1000)) * 24 * 3600 * 1000);
    }

    public static Date timeOnly(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        cal.set(Calendar.YEAR, 1970);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, min);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
