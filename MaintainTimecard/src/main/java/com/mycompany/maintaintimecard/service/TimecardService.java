/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintaintimecard.service;

import com.mycompany.maintaintimecard.model.Timecard;
import com.mycompany.maintaintimecard.exception.TimecardNotFoundException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import com.mycompany.maintaintimecard.utils.DateUtils;
import java.time.DayOfWeek;
/**
 *
 * @author Huynh Cong Hung
 */
public class TimecardService {
    private final Map<String, Timecard> timecards = new HashMap<>();
    private static final int MAX_HOURS = 40;

    // Tạo mới hoặc lấy timecard hiện tại
public Timecard getOrCreateTimecard(String employeeId) {
    return timecards.computeIfAbsent(employeeId, id -> {
        // Lấy ngày bắt đầu và kết thúc tuần sử dụng hàm tiện ích
        LocalDate today = LocalDate.now();
        LocalDate startDate = DateUtils.withDayOfWeek(today, DayOfWeek.MONDAY); // Ngày Thứ Hai
        LocalDate endDate = DateUtils.withDayOfWeek(today, DayOfWeek.SUNDAY);   // Ngày Chủ Nhật

        return new Timecard(id, startDate, endDate);
    });
}

    // Thêm giờ làm việc vào timecard
    public void addHours(String employeeId, String chargeNumber, int hours) {
        Timecard timecard = timecards.get(employeeId);
        if (timecard == null) throw new TimecardNotFoundException("Timecard not found for employee: " + employeeId);
        if (hours < 0 || hours > 24) throw new IllegalArgumentException("Hours must be between 0 and 24.");
        timecard.addOrUpdateHours(chargeNumber, hours);
    }

    // Nộp timecard
    public void submitTimecard(String employeeId) {
        Timecard timecard = timecards.get(employeeId);
        if (timecard == null) throw new TimecardNotFoundException("Timecard not found for employee: " + employeeId);

        int totalHours = timecard.getChargeHours().values().stream().mapToInt(Integer::intValue).sum();
        if (totalHours > MAX_HOURS) throw new IllegalArgumentException("Total hours exceed maximum allowed.");

        timecard.submitTimecard();
    }
}
