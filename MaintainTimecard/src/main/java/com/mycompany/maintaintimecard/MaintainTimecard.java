/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.maintaintimecard;

import com.mycompany.maintaintimecard.service.TimecardService;
import com.mycompany.maintaintimecard.model.Timecard;
import java.time.LocalDate;


/**
 *
 * @author Huynh Cong Hung
 */
public class MaintainTimecard {

    public static void main(String[] args) {
         // Khởi tạo TimecardService
        TimecardService timecardService = new TimecardService();

        // ID của nhân viên
        String employeeId = "E001";

        // Tạo hoặc lấy Timecard cho nhân viên
        Timecard timecard = timecardService.getOrCreateTimecard(employeeId);

        // Hiển thị thông tin Timecard
        System.out.println("Timecard for Employee: " + employeeId);
        System.out.println("Start Date: " + timecard.getStartDate());
        System.out.println("End Date: " + timecard.getEndDate());

        // Thêm giờ làm việc
        System.out.println("\nAdding work hours...");
        timecardService.addHours(employeeId, "Charge001", 8);
        timecardService.addHours(employeeId, "Charge002", 5);

        // Hiển thị giờ làm việc
        System.out.println("Hours worked:");
        timecard.getChargeHours().forEach((charge, hours) -> {
            System.out.println("Charge Number: " + charge + ", Hours: " + hours);
        });

        // Nộp Timecard
        System.out.println("\nSubmitting Timecard...");
        timecardService.submitTimecard(employeeId);

        // Kiểm tra trạng thái Timecard
        System.out.println("Timecard submitted. Status: " + timecard.isSubmitted());
        System.out.println("Submitted Date: " + LocalDate.now());
    }
}
