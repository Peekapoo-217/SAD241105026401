# Subsystem - PrintService
## Các thành phần chính

1. PayrollControl <<control>>
- Control này quản lý quy trình tính lương.
- Tương tác với chương trình con thông qua interface IPrintService
---
2. IPrintService <<interface>>
- Định nghĩa method printPaycheck()
---
3. PrintService <<subsystem proxy>>
- Kế thừa IPrintService.
- Là hệ thống con(subsystem) đảm nhiệm chức năng PrintService
--
4. Paycheck <<entity>>
- Chứa thông tin về paycheck của nhân viên.
---
5. IPrinter <<interface>>
- Là một subsystem đại diện cho máy in vật lý. 
- PrintService tương tác với IPrinter để yêu cầu in.
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

---

## Các mối quan hệ trong biểu đồ:
    - MaintainTimeCardControl --> IProjectManagementDatabase: MaintainTimeCardControl yêu cầu lấy số thẻ tính phí từ IProjectManagementDatabase.
    - CreateEmployeeReportControl --> IProjectManagementDatabase: CreateEmployeeReportControl cũng yêu cầu lấy số thẻ tính phí từ IProjectManagementDatabase.
    - IProjectManagementDatabase <|.. ProjectManagementDatabase: Lớp ProjectManagementDatabase kế thừa giao diện IProjectManagementDatabase.
    - IProjectManagementDatabase --> ChargeNumber: IProjectManagementDatabase làm việc với ChargeNumber để lấy thông tin thẻ tính phí.
    - ProjectManagementDatabase --> ChargeNumber: Tương tự, ProjectManagementDatabase cũng làm việc với ChargeNumber.
---

# Analysis class to design element map (Use case Maintain Timecard)
| Analysis Class            | Design Element     	 |
|---------------------------|----------------------------|
| TimecardForm              | TimecardForm       	 |
| TimecardController        | TimecardController 	 |
| Employee                  | Employee           	 |
| Timecard                  | Timecard           	 |
| ProjectManagementDatabase | IProjectManagementDatabase |

# Design element to owning package map (Use case Maintain Timecard)
| Design Element     	     | "Owning" package                   |
|----------------------------|------------------------------------|
| TimecardForm       	     | Middleware::Security:GUI Framework |
| TimecardController 	     | Applications::Employee Activities  |
| Employee           	     | Applications::Entities             |
| Timecard           	     | Applications::Entities             |
| IProjectManagementDatabase | Data Access             		  |


## Class Diagram
![markdown](https://www.planttext.com/api/plantuml/png/f98zJiGm48LxdsAwXMBt02YA5WKAYaK8SO69CoH6_Wcsio9Qg2beeAQ1aZEaeDYzI4x05R05Y9KW4HAMB5cQcU-zUV9Rzpft7grlb6Hi0flxlhlJ5UYoshmWyFKp1zbtZpKirqzG2ZHGYBwxrOnBT0uMABGFzqmeoj0McT7U6Wb9mZzUQRfYx8PzjcUMqDEXggLfYKwfDjR_CWAhE1B8PC-H4noTM7D1t2zGOqcAj3z0Zpaw2fqGJqb-Vub2OYufgz2MTDoedApRsVrM7wOaYMjortfIK5jprKRNVwLk5m8eO8LlltQOG1OZL7tt8E2oGGrLI8yDnJQTfcFBxWqxOcFH_WCxF3MRNOzHsOXWzBCjCwBoevNDIHVnjxu3003__mC0)


# Architecture layers diagram
![markdown](https://www.planttext.com/api/plantuml/png/T99DJiCm48NtFiMeArWa1uYYg0WsbRg811SmPjfOSPnex20YsXKBJiC9ik0iEG5Nm0t5gQFK6__Cw7j-p_xflzV6Sh9jfLZ3HSdt2AkSqA2stCfQmvPtI2juP-26KDmOo7b7jLBtjRPkXZGLVwiiSsrZtv4TsSIxQnebnG9EQekqum9XavFRF2AzIhTBKryPcU17Ssfp-g90KTuqvqK2_qUtP_cBouPWqpwRpbYi7Af-wpm-lF53NN5vpViev50k8cal2KkMa1RTX78RlIDkBBN2jeIBifxb3OIisPj4KJRBD0cpOxF43t4SHCM2SXndavy4zaF_9K4D_QSkdECPwwJjPQvNfdmEKGGJ_8daq7zeA0iksHhro-bl_W800F__0m00)


### Mô tả:
- **Presentation Layer**: Chứa `PayrollControl`, đảm nhiệm việc quản lý quy trình và giao tiếp với tầng ứng dụng thông qua interface `IPrintService`.  
- **Application Layer**: Bao gồm interface `IPrintService` và lớp `PrintService`, đóng vai trò cầu nối giữa các tầng, xử lý logic ứng dụng.  
- **Domain Layer**: Đại diện cho các đối tượng nghiệp vụ, bao gồm thực thể `Paycheck` và các interface trừu tượng như `IPrinter`.  
- **Infrastructure Layer**: Tầng thấp nhất, xử lý các chi tiết kỹ thuật và phần cứng, như triển khai máy in vật lý (`Printer`).  


