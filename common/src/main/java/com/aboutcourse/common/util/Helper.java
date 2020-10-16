package com.aboutcourse.common.util;

import java.util.Date;

public class Helper {

    // time should be 5 min step
    public static boolean validTime(Date date) {

        return date != null && date.getTime() % (5 * 60 * 1000) == 0;
    }

}
