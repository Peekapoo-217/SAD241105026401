/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintaintimecard.controller;

import com.mycompany.maintaintimecard.service.TimecardService;

/**
 *
 * @author Huynh Cong Hung
 */
public class TimecardController {
    private TimecardService timecardService = new TimecardService();

    public void processTimecard(String employeeId) {
        try {
            System.out.println("Fetching or creating timecard...");
            timecardService.getOrCreateTimecard(employeeId);

            System.out.println("Adding hours...");
            timecardService.addHours(employeeId, "PROJ001", 8);

            System.out.println("Submitting timecard...");
            timecardService.submitTimecard(employeeId);

            System.out.println("Timecard submitted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
