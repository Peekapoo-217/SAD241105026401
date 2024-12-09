# Subsystem Design: PrintService

## Overview
The **PrintService** subsystem is responsible for handling printing tasks, specifically printing paychecks (**Paycheck**). The subsystem is divided into distinct elements with clear responsibilities to ensure modularity, maintainability, and scalability.
---

## Subsystem Elements

### 1. `IPrintService`
- **Responsibility**: 
  - Defines a general interface for printing operations.
  - Provides the `printPaycheck(paycheck: Paycheck)` method.
#### Methods:
- `PrintPaycheck(paycheck: Paycheck)`

---

## 2. PrintServiceImplement
- **Responsibility**:
  - Implements the `IPrintService` interface.
  - Coordinates formatting and sending paychecks for printing.
#### Methods:
- `PrintPaycheck(paycheck: Paycheck)`

---

## 3. PrinterManager
- **Responsibility**:
  - Manages the connection to printers.
  - Handles sending formatted data to the printer.
#### Methods:
- `Print(data: string)`
- `IsPrinterReady(): bool`
---
 
## 4. IPrintFormatter
  - **Responsibility**:
  - Defines a general interface for formatting data before printing.
#### Methods:
- `String format(Object obj)`

---

## 5. PaycheckPrintFormatter

- **Responsibility**:
  - Implements the `IPrintFormatter` interface to format `Paycheck` objects.
#### Methods:
- `String format(Object obj)`

---
# Class Diagram
![markdown](https://www.planttext.com/api/plantuml/png/d59B3e8m5Dpt55t2fWTeZ65bmiA4w0aUvOae7zC-J8XwCXSUoIjOe2H0Y0kwQ3hJpcJUfD_t9p04ckeYPrb9g4-Wa8UHjk28-fvPz62yMnqPGQFEgAxUpHqa7oYVlHXJEHZ3n_gmkELOO4chZL3leOGKzTJ1Iu10SaCMfBwx2OsJ712InlCbZwigRmtdu-qgNG3HoBLdl2g-I6utLEGFzgD4BkGwZscpcwSGorsnvGQ5sCuhaRmsQFwydq_h17Ewpx8u70kmJDeVyWC00F__0m00)

---
# Interaction Diagram
![markdown](https://www.planttext.com/api/plantuml/png/Z55B2i8m4Dtd55dMHI_GXNGXGXT2gNY08HbhiKbBCXLwDXSUoIlOD46bfEWc3E-ROPxtHsu930sgPI2eC_naqJ3cNfvkUMaQJKSqjqPWeVgMPnugOHGN5DUa3yE6BQMeK9FBA6Pctna5H5DinltyvLrAN7CWVvjNb6cqka8QZERd04bkQPBKwx-V2JG7q53F2JEGl0DsG12M_wXYli86g4AGO_ANntV9Q4NyEdu_ndBKqXtr1G00__y30000)

---
# Subsystem Dependency
![markdown](https://www.planttext.com/api/plantuml/png/f59BJiCm4Dtx5ADkI3OvW8LG5mWf4aWLd63Y3AKqSIBF16G19-kYH-eLQlA1DCaAlF1dvlczyHkV3iSr2pffoaBLQFQu9LWzaNlR6O9xzEHMyA4WZ9qLSiyOmkd6XSC0whBTQ1CRzEQ5p3wg-us68HIts2_LBgP0PXXpfMLT_8alCFuKtzuXTrdyI8lS0zg0T7EbA4T13IpXi8r7sPJxgu-4kOzY3LbL5GlYTvKhKMRoK-z-OUCQkcXKPQyQmaH6ug6O1Tzw2_x55nYlu9PgiZbPuo4ZUIUom4t6deLALfVDllvCabdBrAo7IN8pDLj3myJBqAafFNOQxiGNtwtMuGdVV_WC003__mC0)



---

# Subsystem Design: BankSystem

## 1. `IBankSystem`
- **Responsibility**: 
  - Defines the general contract for banking operations within the system.
  - Provides methods for managing bank transactions, such as depositing funds.

#### Methods:
- `Deposit(PayCheck, BankInformation)`
- ` // Withdraw(amount: decimal)`
---

## 2. `BankSystem`
- **Responsibility**:
  - Implements the `IBankSystem` interface.
  - Coordinates deposit logic and interacts with bank APIs to carry out transactions.

#### Methods:
- `BankAPI : IBankAPI`
+ `Deposit(PayCheck, BankInformation)`
+ `GetBalance()`
---

## 3. `IBankAPI`
- **Responsibility**:
  - Defines interactions with external bank APIs to perform operations like deposits.

#### Methods:
- `RequestDeposit(amount: decimal, bankInformation: BankInformation)`
- `RequestWithDraw(amount: decimal, bankInformation: BankInformation)`
- ` // GetAccountBalance(): decimal`

---

### Dependencies between components:
- **`IBankSystem`** defines the contract for the system's banking operations, including deposits and withdrawals.
- **`BankSystem`** implements `IBankSystem` and coordinates the interactions with bank APIs to perform transactions.
- **`IBankAPI`** provides the necessary functions to interact with external bank APIs, enabling operations such as requesting a deposit or checking balance.

---
# Class Digram
![markdown](https://www.planttext.com/api/plantuml/png/V97FYi8m4CRlUOgvMM6jzoAB_s3fJVJWUKX76anIxKnPPDSdy-0ZxIkiJL4Z5EUIaFcO-NvV_YxNAGlMqZYhu5R62zKxr0Jv7Fr-Ss8X1p-XrzMI3XKRILPuMfIazn_G2dE_gsg7OYe_ZCJZCMoDb4MDtmcwgl6IGK7QEBITxAp2eIqoG-_6KNYUhNB8Ea-twyk6Bv8vMlIQak5Z-dru7rGxAoPQqx4XbZjOhyyNvNkaoDTCwrRmnju05W5zJJQ4nwKvi8gpd_ocQPICYbff-laaog1XOgMcv8lsD_y1003__mC0)

---
# Interaction Diagram
![markdown](https://www.planttext.com/api/plantuml/png/N90n3e9044NxESMMck05B0oA3HtHU80HXhY1dLrsXuApMNWah-120a7QF__z_pFVzoSDWbvwqmAMOhrw1FBWegHBxP15NP2R-n24p9-SZ_gvo056GXrEAwCwgYiv6xJi2Xoo5vLDCfrphgqtADho7bR-ICzvaRrHrrEGEGADxLaIzTm6BCYsFBDSQs_c4PkcQU-oC9gDQqce0aY9g_4JFm000F__0m00)

---
# Subsystem Dependency
![markdown](https://www.planttext.com/api/plantuml/png/f991JiCm44NtFiMe6ufKSe08eL90ABkABbXFd2crOaz2F569e2TZmP6u0h7JbdG34ip68_lxZz-NFzy_vbwmaTPPLQCkyObWia0kOTLv8GUhDlUncy2hWhuC2pLhr0HPqErbmzbGjrHNtiXqYTtDXdGvWo3CU5qr3iLKV1x5EnKNRT5x-9_LKFSa2xJ8cgRVsnV3Cw-N6QJ7TZn_DFdoBKbEg58mhhRaYCMhNdzCwEwb3u7HnjiGp7_BAMZ6P0_qt9AN0o2wgcL9eI1j7DePvAUSwK_WUwz78vkYmUrVpNO1yInaJbmGwmvoaYqHWp_0UJLA9qcknk4MyPw7YjMyRyAF-W800F__0m00)

---

# Subsytem Design: ProjectManagementDatabase
## 1. **IProjectManagementDatabase**
**IProjectManagementDatabase** is the interface for the subsystem that defines the method to get charge numbers based on provided criteria.

### Methods of `IProjectManagementDatabase`:
- `List<String> getChargeNumbers()`  
    - Description: This method retrieves charge numbers from the database based on the given criteria.

## 2. **ProjectManagementDatabase**
**ProjectManagementDatabase** implements the `IProjectManagementDatabase` interface. This class is responsible for querying charge numbers directly from the database.
### Methods of `ProjectManagementDatabase`:
- `List<String> getChargeNumbers()`  
    - Description: This method queries the database directly to fetch charge numbers based on the provided criteria. It might use an ORM (Object-Relational Mapping) tool or direct SQL queries.
  
- `Connection getConnection()`  
    - Description: Establishes a connection to the database directly. This method can be used inside `getChargeNumbers` to create a connection when needed.

## 3. **DatabaseConnection**
**DatabaseConnection** manages the direct connection to the database.
    - Description: In the case where DatabaseConnection requires a user and password, this is an essential part of the authentication process when connecting to the database.
### Attributes of `DatabaseConnection`:
- `url: String`  
    - Description: URL for the database connection.
- `username: String`  
    - Description: Username for database authentication.
- `password: String`  
    - Description: Password for database authentication.

### Methods of `DatabaseConnection`:
- `Connection connect()`  
    - Description: Establishes and returns a connection to the database using the provided credentials (URL, username, and password).

---
# Class Diagram
![markdown](https://www.planttext.com/api/plantuml/png/h95D2i9038NtEKMMkh074962RWGLmHF4DewLDfLCYWlrP2uyabUm_fH1gQwStRmatykykPuliJTIgueS81DZNLF2E5bekUN4PYJak62nCHcjo3CU01_7iOqsf8xdLR5YzPqkzd6QUHiiJJDnGpW193bvZ_-0XRvIf8PbfJoQmZNuDVXGUndriDAy7df26ycp2XNygUzgrBxKz5r7J9xK5lSVgGsEKVGz1_W-64N3jlVqxsjxW9WblV_T3G00__y30000)

---
# Interaction Diagram
![markdown](https://www.planttext.com/api/plantuml/png/b991QWCn34NtFeMM4qWlq4K8JBle8g4KSW3DMCousF8WoydXiiYHSeKuf8M6j6QwbFX-Nr_o-NXQ9qNH7Bp1NgF0Bf6OgRHSxoPaXRTtYP_KwmOP1mh4-eAA7IQwayrJVJVRo5pKBh8nLqTuMbMCu1a6qdP46MYRGqUIceMfw0ljdx0gwt7g0kblHPF5Bo6N38o1bZ1XIeSeTc5-UVKNQu_UMLHgXMpnTkXJCnzPY_f3-LektNcNHhBrkDL3V91cORZj3xuMQDR4zlg7BW000F__0m00)

---

# Subsystem Dependency
![markdown](https://www.planttext.com/api/plantuml/png/j59BJiD03Dtd55Ot10bwW0XLbTeD4Y2adi2Pc31qFf7jW13YP2mu4bTWcgHDn7-3DpEsdf-VtypRo-jI55bRxx86pHPhWjarnpio2fSOKkufA6pQKXv5oS_WAOCKDYZn3Hg2ym4-ejUeMABG0EsZ9btT8jTqrVgIM7B3Db5OB62ZR4DzNC255JthiqNN-fnrXt4e0lyuPsoD8QGPDeOyuSPiK9Fq75mwJ1zHdstgbU-X4-HKikdBUSjkB_84MY4Ew6ciD8dg8N8rMUI3m5sSmZqwMw7IYgbABbbqal-9hOpH4KvsFO8rDHGIYx4asVSFC9ylVle71LZVkAxs6yiNLXLGTIe4qfhBTDbzrdS0003__mC0)
