package com.project.semicolon.eduactive.database;

import androidx.room.TypeConverter;

import java.util.Date;

public class DateConverter {
    @TypeConverter
    public static Date toDate(long time) {
        return new Date(time);
    }

    @TypeConverter
    public static long fromDate(Date date) {
        return date.getTime();
    }


}
