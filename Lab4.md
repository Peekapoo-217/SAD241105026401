# USE CASE MAINTAIN TIMECARD

## Object
## 1. **Employee**
   - **Description**: Represents an employee using the system and interacts with the `TimeCardForm`.

## 2. **TimeCard**
   - **Description**: Central object for managing details such as start/end dates, status, and work entries.

## 3. **TimeCardController**
   - **Description**: Connects to the `ProjectManagementDatabase` to fetch required information.

## 4. **TimeCardForm**
   - **Description**: The user interface for employees to interact with the system.

## 5. **ProjectManagementDatabaseSubSystem**
   - **Description**: A database for managing project details.


---    
### MaintainTimecard VOPC
![markdown](https://www.planttext.com/api/plantuml/png/Z9DBJiCm48RtEONLLOhK2hPTLMf1wW9KgN20gJrj3OaTZHsg2d4o5Xo9Ap1n7FT9HJP9vl7FvyoVdw_liVD0lYwBJ1RWd7ZM9KeWzM2f51-Pu4jfLnMm4pwcydu8smfDlhBquf16OhP0MHCsBsqQZKSI6rkJ4rmbv0PeZSBKvHB9HOrEEYQbLTYb7BpZuSZFx8HmOeqdMnGyfULSenVCG3pvb3MapcVKbGAFfyKE_GATqzR4W2JailzoHPhsv5jBRwX2eE9pLaZQgeJKoGXjLlOgay5jtXUZD2IX71BSbrLXTuYHm429xIgwk5OieOqFKL0gznjCs7ln_JTBYhDf6D_rSguhRYmmXzqyd8nBfan_HCfukl722YJhpCc-elIFO62D9Q-Aws493lTBd8H5FIMZiC2HAtjtFJ4OXDkv5x8BzkZT3eStRGy_STiLYb7q2OzVy0Ob_YLu3j7qjlPBPq-f0mJkw3vhDaQZcd_l5m00__y30000)


---
### Architectural Mechanisms

| **Analysis Class**                | **Architectural Mechanism(s)**                             |
|-----------------------------------|-----------------------------------------------------------|
| **Employee**                       | Security, Persistency, Distribution                       |
| **TimeCard**                       | Persistency, Security, Data Management                    |
| **TimeCardController**             | Distribution, Data Access, Transaction Management         |
| **TimeCardForm**                   | User Interface (UI), Interaction                          |
| **ProjectManagementDatabaseSubSystem** | Persistency, Data Access, Database Management           |

---
### Sequence Diagram with subsystem IProjectManagementDatabase
![markdown](https://www.planttext.com/api/plantuml/png/d9H1JiCm44NtFeMNoO8BT84g5P1OW93W0jDaI8DYEngFaNes5Xo9A-0a3QcBdJPTP6F_F_FdZPMVh--rPI1sgX5Gi25vhzh6x155wu_hecv1itoh5HP0vOCX5RtO6CracWOfUXqSFhwG-S22dq13XGertm735cpOyvzAY36RlBaD8gsaWbgp_oGVZhDS72kE7LFMbQoGPU68VFcOTP9s1SRslMsKP3uyvj5enuq8sP6UWCGxX4ELjMqRs5yrqmweGbcO4crodlGY-YARliQpKriacxqorRhAHTfqPlH393tKMmGWCSq8OTgBJ-Fhx8mZAz_zOmvxPl4r3RrSM_f5BcMTTiNdcdESuJSOop_d8eAdvbcA5Zw3W6befyfBaAKyAM2T_d9AdVfAHg5rbj0e6ZnYZRhi_g2_0000__y30000)

---

# USE CASE: RUN PAYROLL

## 1. **SystemClockInterface**
   - **Description**: Manages and triggers the payroll system automatically every Friday or on the last working day of the month.

## 2. **PayrollController**
   - **Description**: Responsible for coordinating and executing payroll operations

## 3. **Paycheck**
   - **Description**: Represents a "Paycheck" object within the system, containing information about the employee's payment for each payroll period.

## 4. **Employee**
   - **Description**: Represents an "Employee" object in the system, containing information about each employee, such as salary, benefits, and other relevant details.

## 5. **PurchaseOrder**
   - **Description**: Represents a "Purchase Order" object within the system, containing information about purchase orders related to employee compensation (e.g., other payments or employee orders).

## 6. **Timecard**
   - **Description**: Represents a "Timecard" object, used to record the working hours of an employee during a payroll period.

## 7. **IPrintService**
   - **Description**: Defines the interface for the printing subsystem, including the necessary methods for processing and printing paychecks.

## 8. **PrintService Subsystem**
   - **Description**: A subsystem responsible for performing print-related functions in the system, such as printing employee paychecks.

## 9. **IBankSystem**
   - **Description**: Defines the interface for the banking subsystem, responsible for handling bank transactions related to payroll deposits or payments.

## 10. **BankSystem Subsystem**
   - **Description**: A subsystem responsible for processing bank transactions, including generating and handling bank transfers for payroll payments.

---
## Sequence Diagram with SubSystem
![markdown](https://www.planttext.com/api/plantuml/png/b5HBReCm4DrpYbacKdC15ctKg0jMYPHUO6g6OCNObZsqucnTz4YzGkq01ITHare2QpxlCMyy-FlpQ-qP7RUDob2mSR3lF5EpKKOS1yypwcFlpMn8bK9Qr3nFB3IJgr1Gah33pXcbDaPptCabqPV6AjDH2dcL3GbqPShJEb6ZfwqhppZ25qHDeT2vizWvgNbFxbsU5nG3PnJ5J5qsamIhnwiASpZrQx7ChaKZwa9s3gxLO7jt05uaHDJOZXoaZxabTayPAfxC3C9InbYemg4GYXfex24CwmRrWJYI0JQcrL73dxZnC7eS3nP8NPbRqEJ8UlnkUn_oidi2bMWLCeNO7V3JH0IKem213ydrgBTI1lbkWlyrAstoMnYgk-Gcmvg3ZTPYhE41zXmSXuaZ3aI3Ka6O02l5STNQtrXS2Tr9JZ_o8_F4HCeJbDAHu5L9rdZ92TFrQgUV9OS1DQisHeiWsZN8qkXbMjg4ZLHp9a-w17QeVRXm0d1UfYwpSO_FEhpYNVK3003__mC0)

---
## VOPC RUNPAYROLL
![markdown](https://www.planttext.com/api/plantuml/png/V5LBRjim4Dth55gcG7o1G32Ik0NYHHeZ3f3rc9fOXFanXcG08Ut9kkYHUeLI4YbIYXnlB0tVl7byCwJ-_VbxQooGTL8K1LSMwGqObllMM9GReTbf6uDLTT1ErK3jUbr-56N_wvEllXM_y-mT-USzqZjdEAQNLJKYrkkOV-wWy_nxKAT1GLOyIqxLKTKT-8L06M2MQtK5EsXPW-nqKyQdwz8ssE6swattjPW0OyeVyYnqYvqqL9RRDkfQbGeaXaSCg6qT0eV055wDPXp47faZJ_7JoGDIM8Aw9ZGcl9qRhN2oZXAuYAlGIg_Y4MsZwx0_RlmMQcYzGKFWYDP7xgHlX9q5KtA-47UTnpQEo8DVk4G6bE0C17C2BExwYgDD3zgHQADPoQiocjNqW6UVcOeyZB6SQWy2Y6Fz1HaevRoT7R1DT7TPD2VSQ2cvCRxnYNIXdMo4JLNk7B4633vHZMGc9aqoyfAJd4-r1jgduFcO5CrUqDQvPrurdR1Eex13ukCO67Z7N5iaswRUkNFjPMOjJNB38LYokf-Zs7r2p_3ARHF6QrYTCf4MOgELxVwHgeeDpzcH9AS2RYRYsOU-tp-2WYDIZqxRolOq1c8t1vhKsr-hrMmYPulp6IlcWG6sD3c9INj4b3IDHZ-BJtQKgzLwyUQy05sy9YzW5wx42yXnBnUAVYr_tgXYyO3rFaoEmKq9noFXqO-GAUOa7VCegrZOoapPukTZ0Ybk_StVVRF-0m00__y30000)

---
## Architectural Mechanisms
| **Analysis Class**            | **Analysis Mechanism(s)**            |
|-------------------------------|--------------------------------------|
| **SystemClockInterface**       | **Legacy Interface**                 |
| **PayrollController**          | **Distribution**                     |
| **Paycheck**                   | **Persistency**                      |
| **Employee**                   | **Persistency, Security**            |
| **PurchaseOrder**              | **Persistency**                      |
| **Timecard**                   | **Persistency**                      |
| **IPrintService**              | **None**                             |
| **PrintService Subsystem**     | **None**                             |
| **IBankSystem**                | **None**                             |
| **BankSystem Subsystem**       | **Legacy Interface**                 |
