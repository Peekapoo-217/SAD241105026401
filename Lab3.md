# Subsystem - PrintService
## Các thành phần chính trong sơ đồ

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
## Relationships và Interactions
- PayrollControl --> IPrintService: printPaycheck
- PrintService ..> IPrinter
- IPrintService --> Paycheck
- PrintService --> Paycheck

### Class Diagram
![markdown]()



---

# Subsytem Project Management Database



