/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maintaintimecard.model;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Huynh Cong Hung
 */
public class Timecard {
    private String employeeId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Map<String, Integer> chargeHours = new HashMap<>();
    private LocalDate submittedDate;
    private boolean isSubmitted = false;

    public Timecard(String employeeId, LocalDate startDate, LocalDate endDate) {
        this.employeeId = employeeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    
    
    public boolean isSubmitted() { return isSubmitted; }
    
    public void setSubmittedDate(LocalDate submittedDate) { this.submittedDate = submittedDate; }
    
    public Map<String, Integer> getChargeHours() { return chargeHours; }
    
    public void addOrUpdateHours(String chargeNumber, int hours) {
        if (isSubmitted) throw new IllegalStateException("Timecard is submitted and cannot be changed.");
        if (hours < 0 || hours > 24) throw new IllegalArgumentException("Hours must be between 0 and 24.");
        chargeHours.put(chargeNumber, hours);
    }
    
    public void submitTimecard() { this.isSubmitted = true;}
}
