package com.java.dangdo1198.project.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Date covertToDate(String dateStr){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return getStartOfDay();
    }

    public static Date getNextDay(Date date) {
        // Tạo một đối tượng Calendar để thao tác với ngày
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(java.util.Calendar.DATE, 1); // Thêm 1 ngày
        return calendar.getTime();
    }

    public static Date getPreviousDay(Date date) {
        // Tạo một đối tượng Calendar để thao tác với ngày
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(java.util.Calendar.DATE, -1); // Trừ 1 ngày
        return calendar.getTime();
    }

    private static Date getStartOfDay() {
//        Calendar calendar = Calendar.getInstance(); // Lấy thời gian hiện tại
//        calendar.set(Calendar.HOUR_OF_DAY, 0); // Đặt giờ là 0
//        calendar.set(Calendar.MINUTE, 0); // Đặt phút là 0
//        calendar.set(Calendar.SECOND, 0); // Đặt giây là 0
//        calendar.set(Calendar.MILLISECOND, 0); // Đặt mili giây là 0
//        return calendar.getTime(); // Trả về đối tượng Date

        return Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

}
