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
