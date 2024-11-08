# Biểu đồ USE CASE là gì?

Biểu đồ trường hợp sử dụng UML lý tưởng cho:
  * Biểu diễn các mục tiêu của tương tác giữa hệ thống và người dùng 
  * Xác định và tổ chức các yêu cầu chức năng trong một hệ thống
  * Chỉ định bối cảnh và yêu cầu của một hệ thống
  * Mô hình hóa luồng sự kiện cơ bản trong một trường hợp sử dụng  
Tham khảo thêm tại đường dẫn bên dưới:  
        [What's_use_case_UML](https://www.lucidchart.com/pages/uml-use-case-diagram)


# Demo USECASE Mua sắm trực tuyến

![markdown](https://www.planttext.com/api/plantuml/svg/N99DQiCm48NtEiNWlNs04aoAkmcqn63QRH7I48l8af56AQRqP5tqIBr2vHy5kIlflVSn8sRq-_rpzCGTXK4pnWLP1qtmP0TqcomU0_LeI0bEofe2k8VPWiF1exifWNMTq9ESGPgWTVQc9Bg5FZsr2MWSIaNGycc897HhWOLQeor9V9GZrmLZ3WLnSz48nTbePH2wtewZCXVe9ayu59yC87WKt4VcJU47g6ZxfVPhypuxEV72hmXjSAAFCa59vs1ZXr4Z8JGzYgiDbE2aS_ZPNa2PH4Ib3Fi2O2mD5SgohE_lsKweGbNd_U4XJbSP7OISfvidbLpHr7r3XGuBcZVQbTm5zxUnT5lmUQrxPrvTtYodTkP-U__JTOsCiICQ6R_Q7m000F__0m00)


#### Code demo
```Demo
@startuml

actor Customer
actor "Authentication" as Auth <<service>>
actor "Identity Provider" as IDP
actor "Credit Payment Service" as CreditPayment
actor "Paypal"

rectangle "Online Shopping System"{
  usecase "View items" as UC_View
  usecase "Make Purchase" as UC_Purchase
  usecase "Complete Checkout" as UC_Checkout
  usecase "Log in" as UC_Login
}  

Customer ---> UC_View
UC_View .u.> UC_Purchase : <<inlucde>>
UC_Purchase .d.> UC_Checkout : <<include>>

Customer --> UC_Purchase
Customer -->UC_Login

UC_Login --> Auth
UC_Login --> IDP
UC_Checkout --> Auth
UC_Checkout --> CreditPayment
UC_Checkout --> Paypal


@enduml

** Lưu ý: Phải dùng công cụ hỗ trợ thích hợp để chạy được code(PlantTextUML,...) **
```
