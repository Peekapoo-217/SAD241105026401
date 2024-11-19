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

## 2.Cơ chế phân tích:
