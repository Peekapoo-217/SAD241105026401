# Biểu đồ USE CASE là gì?

Biểu đồ trường hợp sử dụng UML lý tưởng cho:
  * Biểu diễn các mục tiêu của tương tác giữa hệ thống và người dùng 
  * Xác định và tổ chức các yêu cầu chức năng trong một hệ thống
  * Chỉ định bối cảnh và yêu cầu của một hệ thống
  * Mô hình hóa luồng sự kiện cơ bản trong một trường hợp sử dụng  
Tham khảo thêm tại đường dẫn bên dưới:  
        [What's_use_case_UML](https://www.lucidchart.com/pages/uml-use-case-diagram)



# Demo USECASE Mua sắm trực tuyến

## Mô tả USECASE DIAGRAM:
 * Actors như Customer, Authentication, Identity Provider, Credit Payment Service, và PayPal tương tác với các trường hợp sử dụng (use cases) của hệ thống mua sắm trực tuyến.
 * Các use cases như "View items", "Make purchase", "Complete checkout", và "Log in" đại diện cho các chức năng chính của hệ thống.
 * Các đường liên kết như <<include>> cho thấy một số use case được bao gồm trong các use case khác.

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



## CLASS DIAGRAM 
![markdown](https://www.planttext.com/api/plantuml/svg/R91D2i8m48NtESNGbGgzG1TIg9jkLEW9OXpQqFoKJAA8U38N7iahc6YjBZgxztZlOsQUzqT9dZiVj69CA4u4LI1lDJguCdZFIUAvzgXfiHmTpNlS1oSwJZYPohQrYUhs1UsCaWQRpWw3D6rpeSYOeCBgGQ77gaFHs-3_Y_Klc8ECOiirGW6DTn4q-eEJ8faR6muAKvbDcqEUho5RPHzI0LawWRAPmEoEiH08Ovwn4iqn_UO5003__mC0)

## Mô tả CLASS DIAGRAM:
  * Customer có các phương thức để xem mặt hàng (viewItems), thực hiện mua hàng (makePurchase), và đăng nhập (logIn).
  * OnlineShoppingSystem chịu trách nhiệm xác thực (authenticate) và hoàn tất thanh toán (completeCheckout).
  * PaymentService là một lớp cơ sở cho các dịch vụ thanh toán như CreditPayment và PayPal.

```` Code demo
@startuml

class Customer {
    + viewItems()
    + makePurchase()
    + logIn()
}

class OnlineShoppingSystem {
    + completeCheckout()
}

class Item {
    - itemName : String
    - price : Double
}

Customer  --> "*" Item : "views"
Customer  --> "*" OnlineShoppingSystem : "uses"

@enduml
````

## SEQUENCE DIAGRAM

## Mô tả SEQUENCE DIAGRAM
 * Trong Sequence Diagram này, người dùng (Customer) đăng nhập vào hệ thống và xác thực thông qua Authentication và Identity Provider.
 * Hệ thống trả về thông tin mua hàng

   
![markdown](https://www.planttext.com/api/plantuml/svg/R98nRiCm34LtdOB8r0v1zmn5YdJ9L0D63o38J4n0bWoA2k2pTUYHUeLIifl4HJH9_pzIdu9-lhxtIInB7hmnrabaEEGaSK0se-haQBH1OFCHF0Li-pYE5Cxjb0I73TW4ytODlsNfCUZP2iLGiIAjeGDZHmADdGPbeKM-aCCApzRYhAjKRAolrBnTsyUkt2iJD1mlr25NylZU6FCt5snVbz2m0n_Fn_3qR1P1hH9K3NiR0TMlghhQwP_vcP0LACRsLiuecSCzg0y1-jIIqzBiFiPZd35bBzTiMd2TeIOdxPYTmvHUJfPyPZHbFUOxIgEt4uoPNMyJWelXH3pKgupPO-ZA9_W5003__mC0)

````Code demo
@startuml

actor Customer
participant "OnlineShoppingSystem" as System
participant "Authentication" as Auth
participant "Credit Payment Service" as CreditPayment
participant "PayPal" as PayPal
participant "Identity Provider" as IDP

Customer -> System : logIn()
System -> Auth : authenticate()
Auth -> IDP : authenticateUser()
IDP --> Auth : return authentication status
Auth --> System : return authentication result
System --> Customer : login success/failure




System --> Customer : display purchase confirmation

@enduml

````


