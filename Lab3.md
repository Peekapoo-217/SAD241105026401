# Subsystem - PrintService
## Các thành phần chính

1. PayrollControl <<control>>
- Control class chịu trách nhiệm quản lý quy trình tính lương.
- Tương tác với PrintService subsystem thông qua IPrintService.
---
2. IPrintService <<interface>>
- Định nghĩa phương thức printPaycheck(paycheck: Paycheck), PayrollControl chỉ cần biết đến và sử dụng chứ không cần biết bên trong triển khai như thế nào.
---
3. PrintService <<subsystem proxy>>
- Triển khai của IPrintService.
- Là hệ thống con chịu trách nhiệm xử lý quy trình in thực sự.
--
4. IPrinter <<interface>>
- Là một subsystem, đại diện cho máy in vật lý. 
- Không cần biết người dùng sẽ sử dụng máy in hiệu gì, loại nào, chỉ cần 'plug and play'.
- PrintService sẽ tương tác với IPrinter để yêu cầu in.
---
5. Paycheck <<entity>>
- Chứa thông tin về paycheck của nhân viên.
---
## Mối quan hệ và tương tác:
- PayrollControl --> IPrintService: printPaycheck
- PrintService ..> IPrinter
- IPrintService --> Paycheck
- PrintService --> Paycheck

### Class Diagram
![markdown](https://www.planttext.com/api/plantuml/png/T56zJiCm4DxlAMwZ34rtP5cLoi9MYISmhcait7EmdOe8EZEmmCm28y_WWQ5zaJm1hu2TLbKJgLxik_j-xiv_yNVgWt2XNXc02zozj_6DIgHbkViHABVV4aqRFojSRxzmgON5XMxZAu4qmdkSYyPPOsQMGhgHCRb_SOxFW3YPeAi9gpqADW2QWdBtGYgycRiKt2gtrYdAw7Igd4kYibJoONIP6GUZKp1ZlhxpZGygQJlxr71-dZzqLAupwv2ZQojFJGx4PA0ewD3fRl9UPdaHgpP-Q7oi1M6PTW23uSTZFXZggjyFzAlifIXwSq6lN1JysF60cPsEekShC5Mqo1_x3m00__y30000)
---

# Subsytem Project Management Database

## Các thành phần chính

1. MaintainTimeCardControl <<control>>
- Lớp control chịu trách nhiệm quản lý timecard.
- Yêu cầu getAvailableChargeNumbers từ hệ thống con ProjectManagementDatabase.

2. CreateEmployeeReportControl <<control>>
- Lớp control chịu trách nhiệm tạo báo cáo nhân viên.
- Yêu cầu getAvailableChargeNumbers từ hệ thống con ProjectManagementDatabase.

3. IProjectManagementDatabase <<interface>>
- Giao diện của hệ thống con ProjectManagementDatabase
- Định nghĩa phương thức getAvailableChargeNumbers(): List<ChargeNumber>

4. ProjectManagementDatabase <<subsystem proxy>>
- Triển khai IProjectManagementDatabase.
- Là hệ thống con giao tiếp với cơ sở dữ liệu đã có.

5. ChargeNumber <<entity>>

