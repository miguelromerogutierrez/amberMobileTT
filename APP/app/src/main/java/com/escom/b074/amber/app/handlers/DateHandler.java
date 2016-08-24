package com.escom.b074.amber.app.handlers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by miguelangelromerogutierrez on 09/08/16.
 */
public class DateHandler {

    public static String getStringDateRepresentation (Date date) {
        if (date == null) {
            return null;
        }

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        return sdf.format(date);
    }

    public static String getStringYearRepresentation (Date date) {
        String myFormat = "yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        return sdf.format(date);
    }

    public static String getStringDayAndMonthRepresentation (Date date) {
        String myFormat = "dd / MM";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        return sdf.format(date);
    }

    public static Date getDateFromString (String dateString) {
        Date date;

        String myFormat = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            date = null;
        }

        return date;
    }

    public static long getTimeSince(int years) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - years);

        return calendar.getTimeInMillis();
    }

}
