# LAB 1  
## PHÂN TÍCH KIẾN TRÚC, CƠ CHẾ, CA SỬ DỤNG  

---

## 1. Đề Xuất Kiến Trúc: 
Hệ thống Payroll được đề xuất sử dụng kiến trúc MVC:
 - Mô hình MVC phân chia ứng dụng thành ba thành phần chính:
   - Model: Quản lý dữ liệu và logic (như thông tin nhân viên, tính toán lương, phương thức thanh toán).
   - View: Hiển thị dữ liệu cho người dùng (như giao diện chọn phương thức thanh toán, bảng tổng hợp lương).
   - Controller: Xử lý các yêu cầu từ người dùng, tương tác với Model và trả về View.

- Lý do lựa chọn:
   - Model và Controller xử lý logic chung.
   - View được tùy chỉnh để phù hợp với từng loại giao diện (web, mobile).
   - Payroll System là hệ thống lớn, sử dụng mô hình MVC có thể dễ dàng bảo trì khi có thay đổi.
   - Dễ dàng tích hợp với các hệ thống bên ngoài như (APIs thanh toán tự động, ...)
   - 
### Biểu đồ Package biểu diễn 2 use case SelectPayment và MaintainTimecard
![markdown](https://www.planttext.com/api/plantuml/png/V5HBQiCm4Dtx52AREj1Sm9GGQ5C8rBGq_Qo5DOr5P4jev0PJSh8kUgHUeN9asKfir-2FHZDlvhqP-VVxPuM6QbCL8eeYHRCztG6PfPA1c96lY91CK4IoBfIGDS39P2_E4i9BunObBI0XMwDvkNCMHUi2IfE2oQNrV0gNpiFm0ZAg6IRaWQEvUMdNIxjzZBgyPv4-kQdLHJu6XdA1WJ70yD0-d55Zm-_iqwrpMMbybteF7QbZT0pKUEDm2CNOWe3CjANTIrrqo1oLeFMZCboM6C-TTGVc5K5lIbMPU3vK8oWrfJQ_lNt98JZcyk3jZMGUdZBcpITJ0BVMMkgc-X3ZP4m1qNAB2_Vsmiq7t6zbQRGK0dIeG4kXt_G9b9QPXNGAMH7Y_oQX9V191MzwucSiXlPZu_fX9VDRuuqTbX5gSe5stOrUqW6qXGYhgZVXI1KZWsghkIBF8EYfupbNI3waRYV4ioKL0iaeGZJKRR5OzeSh8JHhv0ESy3m_3WcfL2FSbFTmJXEYeMIWfoBwWKdyCECuGp-f_UdgI8wqPOhbX6k7sJESy1mzC3tBgL96QQviKFCV_0C00F__0m00)

## 2. Cơ chế phân tích

### a. **Các cơ chế cần giải quyết**
- **Xác thực**: Kiểm tra xem nhân viên đã đăng nhập hay chưa trước khi chọn phương thức thanh toán.  
- **Lưu trữ dữ liệu**: Cập nhật thông tin phương thức thanh toán mới vào cơ sở dữ liệu.  
- **Xử lý lỗi**: Đảm bảo xử lý các tình huống khi không tìm thấy nhân viên hoặc dữ liệu không hợp lệ.  
- **Hiển thị tùy chọn**: Tải và hiển thị danh sách các phương thức thanh toán hiện có.  

---

### b. **Giải thích lý do**
- **Xác thực**: Đảm bảo hệ thống an toàn, ngăn chặn truy cập trái phép.  
- **Lưu trữ chính xác**: Đảm bảo dữ liệu được cập nhật đúng và nhất quán.  
- **Xử lý lỗi**: Nâng cao trải nghiệm người dùng, giảm thiểu gián đoạn.  
- **Hiển thị đầy đủ**: Hỗ trợ người dùng dễ dàng chọn phương thức thanh toán phù hợp.  

---

### c. **Danh sách cơ chế phù hợp**
1. **Authentication & Authorization**:  
   Đảm bảo chỉ những nhân viên được phép mới có thể truy cập.  

2. **Data Validation**:  
   Kiểm tra tính hợp lệ của dữ liệu nhập vào để tránh lỗi.  

3. **Exception Handling**:  
   Quản lý các tình huống bất ngờ, như lỗi kết nối hoặc dữ liệu không hợp lệ.  

4. **Database Transaction**:  
   Đảm bảo dữ liệu được lưu trữ an toàn và duy trì tính toàn vẹn trong cơ sở dữ liệu.  


---

## 3. Phân tích ca sử dụng Select Payment

## Models:

### Lớp Employee
- **Thuộc tính**:
  - id
  - name
  - paymentMethod

- **Phương thức**:
  - selectPaymentMethod(): Chọn phương thức thanh toán
  - updatePaymentInfo(): Cập nhật thông tin thanh toán
  - getPaymentMethod(): Lấy thông tin phương thức thanh toán


### Lớp PaymentMethod
- **Thuộc tính**:
  - employeeId: ID của nhân viên
  - type: Loại thanh toán (pickup, mail, direct deposit)
  - address: Địa chỉ gửi thư (cho mail)
  - bankAccount: Số tài khoản (cho direct deposit)
  - bankName: Tên ngân hàng (cho direct deposit)

- **Phương thức**:
  - Các phương thức getter để lấy thông tin
  - updatePaymentMethod(): Cập nhật thông tin thanh toán
  - validatePaymentInfo(): Kiểm tra tính hợp lệ của thông tin

---

## View:

### Lớp PaymentMethodView
  - displayPaymentOptions(): Hiển thị các lựa chọn thanh toán
  - getPaymentSelection(): Nhận lựa chọn từ người dùng
  - displayAddressForm(): Hiển thị form nhập địa chỉ
  - displayBankForm(): Hiển thị form nhập thông tin ngân hàng
  - showConfirmation(): Hiển thị thông báo thành công
  - showError(): Hiển thị thông báo lỗi

---

## Controller:

### Lớp PaymentMethodController
- **Thuộc tính**:
  - paymentMethod: Tham chiếu đến model
  - view: Tham chiếu đến view

- **Phương thức**:
  - handlePaymentSelection(): Xử lý lựa chọn phương thức thanh toán
  - processAddressInput(): Xử lý nhập địa chỉ
  - processBankInput(): Xử lý nhập thông tin ngân hàng
  - validateInput(): Kiểm tra đầu vào
  - updatePaymentMethod(): Cập nhật thông tin thanh toán

### Quan hệ:
   - Employee có một PaymentMethod
   - PaymentSystem tương tác với Employee để yêu cầu và cập nhật thông tin phương thức thanh toán

---
# Sequence Diagram biểu diễn UseCase Select Payment

![markdown](https://www.planttext.com/api/plantuml/png/d9HBRi8m48RtFiKeAoB11P2eQ2igiG1LgbXNnfw2XL-rdLOvMnSzKgzGvmLr25GY6zkPR_wPtvhav-jxxWDreL2IK1QCWuMoqfI8nCRNWWbBTO0NbCZ2CoqLwh32i3VyoJW5rCDc-H_vQ7HmHbPmkvNeI0oBK0xn5RYeeuHqtS3aBbQQWZ_7HpdPBAluINmA3jyBz6VW2QaIcY9Js64A-aWsCPZqT6t29NfjXrnuAsdP4qppydDZR6-CnxHVLIz3zWhBQRX04oe3D0UOpI2pWXqAcn68px3_QseeFVvLKrJ836gnfgtEoF7ELv4GUdVFkKFlH-sQrobzrzQP3y6nbu9LaVOmZbVk_QTnFB_9mHXerq3V2XSkpj8hHsky2DarJmzK7vRwpOoksZXIsxXPKuMnE6Ecq65Tg2swMnrSb4FDoT0C9jEsgPMxpoHnTu6RHztuG_W5003__mC0)


# Class Diagram biểu diễn UseCase Select Payment
![markdown](https://www.planttext.com/api/plantuml/png/d5J1RXiX4Btp5IYNkb8TfTSzH76YLF8XILLNlUDbOgC0Wu1rv5RziXxwIVs50il6O9n6ghJIYdblXfd7Wp-_VbyvpwmVb2JkIMZ3B5EqbyovXVTMh0SFonxrIdm7Ua78Etg772H93FgPxHLeVmT-Yvp-89JEGHc9Uu0bx-Wg5D2R6FLx0-MQSMx1kJAqPlffqVSuQ7ySlcUgp0uVtO3_6chEtXVn65oCXPluzQ5wZGs6Cm_L896mHfJ0T6Jic1G5PwaViMJyZA9y4_1yIfCOJxfGBfoHR9_H1-C5wjJc3WNFJMPm1HBwYDUTvWfvmazeLPcUqJZdCUIs-7o3-b5OnQQo9NPhBTgP2aNPvaNdYPF62zdUefHWJmrvG4SBc1BiQcx4Tq6KhjKfd-oMQIwXaQ9qKD6_iTY7nhCeIsq6FpioLykE8etKOtTze6mqoJsUI9-SCERMBdd3Hqd6stmtieZJSbHDL1T6rvP_IzDqb4chfeEf-Qh1oSIj-Gw9zHvfW2yWauFSLXX7Nle_-tX6v_Fqgr-4BfocevVaDRly8r4n7TpuFydfpdMq7vbDXGIVdrysE-ORLCpLi8hTEpeuS8HSWURXyVmB003__mC0)

---
## 4. Phân tích ca sử dụng Maintain Timecard

## Mô hình (Model):

### Timecard:
- **Thuộc tính**:
 - employeeId
 - startDate
 - endDate
 - status (new, submitted)
 - hoursWorked
 - projectCharges (danh sách các charge numbers)
 - submittedDate

Phương thức:

 - createNewTimeCard()
 - updateHours()
 - submitTimeCard()
 - validateHours()
 - saveTimeCard()

### Project:
- **Thuộc tính**:
 - projectId
 - chargeNumber
 - maxHours
   
Phương thức:

 - getChargeNumbers()
 - validateChargeNumber()

## View:
### Time Card View:
- **Phương thức**:
 - retrieveTimeCard()
 - updateTimeCardHours()
 - submitTimeCard()
 - validateTimeCardEntry()
 - getProjectChargeNumbers()

# Sequence Diagram biểu diễn UseCase Maintain Timecard
![markdown](https://www.planttext.com/api/plantuml/png/j5RDZjCm4BxdAUR6hiI-G0zeLwKI2B6xqhBBsNMcZS6n8zlfqZC7peWp4eW30Wcnv-s1Gu7tw1Fm2eoJk4beqnyGELXHFDytCvy_J_jhzktOEcPSdig8SQSD3D9CwYbYbD5dmKN6b8Cd8iK-C_6LmEkr6tsjdD5IebcxtVfuRlGpv2wAGYeukjVAq0DK3atuT70ODNURqNNQ7XXqHk04bp2iw1_6Xr5q1nw9nUnb2iumY9bZGsOnMkNnx5M1FU09ykVtg-2J2HEI3OKKRaebCUcMFA2q0rRkIuo0dee3ZZggHMEqAIBNrR0YI2ni9jaqr3BmQ2gYYG_Q15Lxa1cTPixp2fNZcUapnL5Mi6BnJGIPg5kjBLhW5Q28y4_tEOLGwfOZnXLrLrSrkaO-5IxHkUidp8pnD4-7Q6n5WvAKNQskQ68bpoPdb92p30rpGgijLNPfNwedkoZA0bhwsqHVDr6FqLesnWQOV8DWn3WXirrIjzoR2LLiIm5K71KYB7ssdyTipZcbx7HPm-bZN7i4spBm9cPlD_-PqVTB5_KqMTn-oM1Cz_KjoFcx52Rq-eflcnSFT4uqYL_ljYhRRNvCc1GaD9we-3BpBnluskEat0DLRCBtr_CFu1QpDuhMs_UYOyZKLo4aRienU26iimVjhFwsjdFvkOD5w3-9VrLMG1ODWwMmNJlNbZpDZl9j-ZL9_jg-NPrTbBZQKETag8-A-8QfSE08mtrURx2leCRvTFvPWKf-tW3_yMc3oqg2FN-MCZyQhRtmM6lBsR6h8qe5oMx-v2VBGmhAZ7Avqt6irFsVvG-TKlH8c3HCpC9JZIv6DCimtftVZzF2d_KSBGxuc5Rw__8R003__mC0)

---
# Class Diagram biểu diễn UseCase Maintain Timecard
![markdown](https://www.planttext.com/api/plantuml/png/h5JBZXCn4BpxArgv492oWki8HRiAYpOIh5O4mRapqoHc_HZPdeI0-38EV1A_G8yzpZeFLdj0YZA9gwkwgzIUFxz-N_g0BdHQ2NylJOiEDTGAlRyAmSbb5sXUMxEGtmbU2X4H-2WrpT0ry4C0J4Ytokw8vaq52-QOLNyQPTzWe0hwxrXeciC3hWcTBrbhspd_sRfxOh6tocBeJrjdlr8TPcjqA-BwTzA7ruaqZJhTKiiGw52UFr0xuZ-tjCqZZvzNiB6owS6kRHYywLkEO-EX9PSihLM4fgzAuYM_03Uev8F84H4tT8xsCyTubsob50UFXo7MqV5jfvVaodEDtswAWGUpAneYIeGupr5K-u7Bmh4vQ71krEpZawHjd1SSSJ4L3a_NW8Ko-X1tFlaliMVusWItUqICaxahT-XV0PtudLbMjagHIwuRwLk5ktFRD40d3JBkrtPxxPnrxybxND5OfsUHrf7Kee_0UsaDZ_55Ees1VvUQx2lcE3Tj5teWhGFRU0OVICLwlvQj5_ihEterWia4HYz6-_shW6zuG6ayJCKPvvd2ZxrC1HeDJ_zqIboTr8gBIbv4BYwcfVeGWHTvo18l6bN05sSZ6nw45mA5kEIt3B_D_W800F__0m00)

## Giải thích:
 - TimeCard -- Project: Một TimeCard có thể chứa nhiều Project (thông qua charge numbers). Đây là mối quan hệ 1-nhiều.
 - TimeCardController -- TimeCard: Controller quản lý một TimeCard. Đây là mối quan hệ 1-1.
 - TimeCardController -- TimeCardView: Controller điều khiển View. Đây là mối quan hệ 1-1.
 - TimeCardView ..> TimeCard: View hiển thị thông tin từ TimeCard. Đây là mối quan hệ phụ thuộc (dependency).
 - Project ..> TimeCardController: Project cung cấp dữ liệu cho Controller. Đây là mối quan hệ phụ thuộc

---

# Hợp nhất kết quả phân tích

## Class diagram
![markdown](https://www.planttext.com/api/plantuml/png/h5NDRjim3BxxAOISqY4vz1eCHOCqm0QqnO1ilTCMasZLJq39QODXJxR37cclC2cH3CjsamseBuP5Kln-AFdFhz-trW6vMicYac0jMwgTD0T4zgDW_faomMTCQ1U_D2YSiPKZeJTn2HK8sLahGJy_zbEXgaojtMEjIgHEBEpYl-QS4rgR1HcpAB5oN-2WKBi7T5l3n-huIebNCxOtWiVyUiV1uRdyYIUrDiFLlWRfgr2u0EBZhQd9urbB0sx2gYtG1dC6URMjIoLSKvw2FukeS8QgaJb75xVQOCxPXjtkXNKVJsatP-XYDFBpoRy9-nV-3SW4ly7NLY4k3KaH0Ur1YW1fqKfPldhWTlo6WAKn4a5dX3w5ddqY_sj80dFQhjUhurUdNTy-Cj_zB4PXcE-FrVCTE2Z1udplfnXAFydkqE_axMmBqdUpEoCBenqPAP6QTaCduOBLbu_6-ypA05f2Nu9xFADk2dNCccl-xJs7O4UcylVAAfXjhJ1w04fogyViIU1BmuaBkvDmI9OlYGoDysOn9JUxZT7cnb-iVZgfuc6VQRUggq2n4xHRyt8iUl0nsE1RjKaNx-9Qa3esQrzUpOzXT3rYq-aD6tqOvNVPG8f_D_uEZ4d8kHIFvwte7ubZD0EG-HN22L5nYvg7dznV0000__y30000)

### Tích hợp
  - Các controller như PaymentController và TimeCardController sẽ kết nối các thực thể như Employee, PaymentMethod, và TimeCard.
  - Lớp Project được dùng chung để cung cấp dữ liệu liên quan (charge numbers).
  - Employee tương tác trực tiếp với cả PaymentMethod và TimeCard, thực hiện cả hai use case từ giao diện người dùng.

