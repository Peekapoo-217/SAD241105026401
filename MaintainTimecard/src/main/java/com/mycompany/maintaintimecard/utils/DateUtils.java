/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintaintimecard.utils;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
/**
 *
 * @author Huynh Cong Hung
 */
public class DateUtils {
    public static LocalDate withDayOfWeek(LocalDate date, DayOfWeek dayOfWeek) {
        return date.with(TemporalAdjusters.previousOrSame(dayOfWeek));
    }
}
