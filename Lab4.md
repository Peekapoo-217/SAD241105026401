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
![markdown](https://www.planttext.com/api/plantuml/png/X5J1QiCm3BtdAqHFARI7NSieBLst5TOosDZEIYnQ3pikjjCjb7tP3lka_SBYr7OJI6akKPwbf_TaaR-Vtvcng6qfHP8BD0QMSYzKHGJ71Efd3Bom4Lmn3nghUR653KhoIAQKW9LvLAKMbSUOAZD1iCOl1vkv4EgJJXG01yKPh0fB6dFxpktkbKlAKRDxfMKwJBuJhoZW7KK1Z8gYxX1u_0ujmOlpwA8sk2nO2_AEwanRcavjcKbkBPsJlVOvOyl2wYfr1oDlTjZEE9Mc0Mj6z8Q2ixgWp-52rNnA2DBHwxDM7vJRDHQu9Kc5Su4P6e8GUF8ufOMccZvyfc4Smrxf8Mq4Lqn4lX3qo7SN5uLVke-eCmJjNdVSx0LMFSqwExClRRDGroOVULfYBm_qw0cUkB6tYntgBMrAcP6UmWFP-G6vmBfF-yIScAFNmSq0nkDfy-vCPUAMjjbqatGE-YfQQp21qj2vf7NILrYdoyRNrOhBKvW0vZaPrpMPKS7Sd-4V003__mC0)


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
### Sequence Diagram with subsystem ProjectManagementDatabaseSubSystemDatabase
![markdown](https://www.planttext.com/api/plantuml/png/X99DJiCm44RtEONLLP3A1LYW5hS55gLL6z7r91wr1lz44oTIpiQ28t45d8GK9mfYw--DvytONn-VYy81kLAh239dYQrrhcoD6EN-M6Oo1-FOB94QCo2niQHd30gMRAO1ReqZgnHIX_5fh0k7sPxi6sPk2mREgD6u5JX8eS0MtczN3r7Ksx7RUw_0xjYpSKZU_2JT9PICRoAVDnJtr04TIQoGbqJ-uXwC--iyp5lOivmG7Eweh_aJRemy_uXkMO5Ka2ha5w0plfGwHIgyGei44YMPCVBJk9bb9OjSGJqcfeREI_TaIn_x7U6SXILprYOdI-ye1bjO2h7shrF7oPpzNtTToBMignbIFNI42ZjgIlXOfbh-hdrWDSgIi7MNnK6VLr1IU8zk-f50s62yrGE2s1bL1qoqG2EQd_yD003__mC0)

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
![markdown](https://www.planttext.com/api/plantuml/png/b5HBRi8m4Dtx55wMHI_0eaA5LcA1YWGzmE0CnOf_6Zj8ELiNFLAlK3iXWJHEHIEXe9dttioR6VZ-_5hu01GghHY8O8c_QATiZSXS34iX7PZ0TxKFg9VAYd9j0j8Hn12mXPgiKajhGdeZ3R9xgL405KDAHU847j-e-0MFOkA4eXm6IPgmGpfBWRlgu9kE1eXdC6NRw3NFEZlyyIdhWi-vD39827Zny31ZMM0K6BdCiiUe2IfX88bdx7hqK-HkVZUSBZJ96OptXZY8JxBxiSsv02KgrJhymrspiGZ_G8FKefjGf81gTgenBabZEDc2Iyyt81MF1xULegmSu_79Q-SM7mkv5E-hkCkN6KFbCLDk9Gb5u2jqriimNIvpHMa8XD5Jokq9Z8y_5MbDj9PaSen98KTMeFTZbJIaAuM_6pZ70S51OPF-Pxzfs_Mu29g2fS_T9wg1oluyjstlMDnnDGKg3Frbhu-RA8J5gwLLIhGTiKNi9Vtp_0000F__0m00)

---
## Class diagram
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
