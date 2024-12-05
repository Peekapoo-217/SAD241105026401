# USE CASE MAINTAIN TIMECARD

## Object
  - Employee: Represents an employee using the system and interact with TimeCardForm
  - TimeCard: Central object for managing details such as start/end dates, status, and work entries.
  - TimeCardController: Connects to ProjectManagementDatabase to fetch required information.
  - TimeCardForm: : The user interface for employees to interact with the system.
  - ProjectManagementDatabaseSubSystem: A database for managing project details.

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
