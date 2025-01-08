# **Định nghĩa các lớp cần thiết**
## Timecard
- **Trách nhiệm**: Quản lý thông tin thẻ chấm công của nhân viên, bao gồm các thao tác cơ bản như lưu, cập nhật, xóa, và truy vấn.

## Employee
- **Trách nhiệm**: Đại diện cho nhân viên trong hệ thống, quản lý thông tin cá nhân và danh sách thẻ chấm công.

## TimecardController
- **Trách nhiệm**: Điều phối logic nghiệp vụ liên quan đến thẻ chấm công, xử lý yêu cầu từ giao diện người dùng và tương tác với cơ sở dữ liệu.

## TimecardForm
- **Trách nhiệm**: Giao diện người dùng để nhập, sửa thông tin thẻ chấm công và gửi dữ liệu tới `TimecardController`.

## ProjectManagementDatabase
- **Trách nhiệm**: Tương tác với cơ sở dữ liệu để xử lý và xác minh mã charge, cung cấp dữ liệu cho các lớp khác.

---

## Class Diagram
![markdown](https://www.planttext.com/plantuml/png/V5DBQiCm4Dth5CAREWMRTkj524bQoA9GIYymiGP7HH-Z6QUOafDrqIFr2YKVMquQnxiPFRtFQFpx_JCZXi2DDQ8qG2JVjSKIWf9VGXu-WYscarFHr0eubWeD3ieAUTwkLAfL8RNZYTY94-kJhOrl4NjMKAfJIhaiUjcEAg3rMnn0LXtdyTneukwKqe5Irrnuny4RW-4ioKtHOxgRa6FYSLyLHblpjekTegqlW5imUg-ss42eSE4LNkZzI_JiW-spA4srWNRV6uv_vUg6-mOrQwjxFsFyhy5_OCaluA12YuwNmB06YezL8KURIsJGXjBIAomaST2kkX7g7BOJuaw-eG7Mtj56roJwrKWU4vbbCdd8y_iaxc4X_QSZSULTismwXDb3W57aUCoYznql7uOz51Ym5QV1NfNAysdSza92MI8HafYXK_k_x0y00F__0m00)

---

# **Định nghĩa Operation**
### **1. Timecard**
- **save()**: Lưu thông tin thẻ chấm công vào cơ sở dữ liệu.
- **update()**: Cập nhật thông tin đã thay đổi của thẻ chấm công.
- **delete()**: Xóa thẻ chấm công khỏi cơ sở dữ liệu.
- **getById(id: int)**: Lấy thông tin chi tiết của thẻ chấm công dựa trên ID.

**Mô tả**:  
Lớp này cung cấp các phương thức cơ bản để lưu, cập nhật, xóa, và truy vấn thông tin thẻ chấm công. Các thao tác này được sử dụng trong logic nghiệp vụ của hệ thống.

---

### **2. Employee**
- **addTimecard(tc: Timecard)**: Thêm một thẻ chấm công vào danh sách thẻ chấm công của nhân viên.
- **removeTimecard(tcId: int)**: Xóa một thẻ chấm công khỏi danh sách của nhân viên.
- **listTimecards()**: Trả về danh sách tất cả các thẻ chấm công của nhân viên.

**Mô tả**:  
Lớp này quản lý thông tin nhân viên và danh sách các thẻ chấm công liên quan đến từng nhân viên, hỗ trợ các thao tác thêm, xóa, và liệt kê thẻ chấm công.

---

### **3. TimecardController**
- **saveTimecard(tc: Timecard)**: Điều phối yêu cầu lưu một thẻ chấm công mới.
- **updateTimecard(tc: Timecard)**: Điều phối yêu cầu cập nhật thông tin của một thẻ chấm công.
- **deleteTimecard(tcId: int)**: Điều phối yêu cầu xóa một thẻ chấm công dựa trên ID.
- **getTimecardsByEmployee(empId: int)**: Lấy danh sách tất cả các thẻ chấm công của một nhân viên cụ thể.
- **validateChargeCode(tc: Timecard)**: Kiểm tra mã charge của thẻ chấm công có hợp lệ không (sử dụng `ProjectManagementDatabase`).

**Mô tả**:  
Lớp này là trung gian điều phối giữa giao diện người dùng và logic nghiệp vụ, đồng thời quản lý các yêu cầu liên quan đến thẻ chấm công
---

---

### **4. TimecardForm**
- **displayForm()**: Hiển thị biểu mẫu nhập liệu cho người dùng.
- **getInput()**: Thu thập dữ liệu từ người dùng qua biểu mẫu.
- **submitTimecard(tc: Timecard)**: Gửi thông tin thẻ chấm công từ người dùng tới `TimecardController`.

**Mô tả**:  
Lớp này đảm bảo giao tiếp giữa người dùng và hệ thống, cung cấp giao diện để nhập và gửi dữ liệu liên quan đến thẻ chấm công.

---

### **5. ProjectManagementDatabase**
- **getChargeCodeDetails(code: string)**: Lấy thông tin chi tiết về một mã charge cụ thể từ cơ sở dữ liệu.
- **validateChargeCode(code: string)**: Kiểm tra xem mã charge có hợp lệ hay không.
- **saveChargeCode(code: string)**: Lưu thông tin mã charge vào cơ sở dữ liệu.

**Mô tả**:  
Lớp này xử lý việc tương tác với cơ sở dữ liệu, cung cấp các chức năng để xác minh và quản lý mã charge, hỗ trợ các lớp khác trong hệ thống.

---
# **Các phương thức và ví dụ mã nguồn cho từng lớp trong hệ thống Payroll**

## **1. Timecard**

- **save()**: Lưu thông tin thẻ chấm công vào cơ sở dữ liệu.

```csharp
public void save()
{
    // Code để lưu thẻ chấm công vào cơ sở dữ liệu
    Console.WriteLine("Saving timecard to database.");
}

````

---
- **delete()**: Xóa thẻ chấm công khỏi cơ sở dữ liệu.

```csharp
public void delete()
{
    // Code để xóa thẻ chấm công khỏi cơ sở dữ liệu
    Console.WriteLine("Deleting timecard from database.");
}

````
---
- **getById()**: Lấy thông tin chi tiết của thẻ chấm công dựa trên ID.

```csharp
public Timecard getById(int id)
{
    // Code để lấy thông tin thẻ chấm công theo ID
    Console.WriteLine($"Getting timecard details for ID: {id}");
    return new Timecard(); // Trả về một đối tượng Timecard mẫu
}
````
---
## **2. Employee**

- **addTimecard(tc: Timecard)**: Thêm một thẻ chấm công vào danh sách thẻ chấm công của nhân viên.

```csharp
public void addTimecard(Timecard tc)
{
    timecards.Add(tc);
    Console.WriteLine("Timecard added to employee.");
}

````
---
- **removeTimecard(tcId: int)**: Xóa một thẻ chấm công khỏi danh sách của nhân viên.

```csharp
public void removeTimecard(int tcId)
{
    Timecard tc = timecards.FirstOrDefault(t => t.id == tcId);
    if (tc != null)
    {
        timecards.Remove(tc);
        Console.WriteLine("Timecard removed from employee.");
    }
}

````
---

- **listTimecards()**: Trả về danh sách tất cả các thẻ chấm công của nhân viên.

```csharp
public List<Timecard> listTimecards()
{
    return timecards;
}


````

---

## **3. TimecardController**
- **saveTimecard(tc: Timecard)**: Điều phối yêu cầu lưu một thẻ chấm công mới.

```csharp
public void saveTimecard(Timecard tc)
{
    tc.save();
    Console.WriteLine("Timecard saved.");
}
````
- **updateTimecard(tc: Timecard)**: Điều phối yêu cầu cập nhật thông tin của một thẻ chấm công.****
```csharp
public void updateTimecard(Timecard tc)
{
    tc.update();
    Console.WriteLine("Timecard updated.");
}

````

- **deleteTimecard(tcId: int)**: Điều phối yêu cầu xóa một thẻ chấm công dựa trên ID.****.****
```csharp
public void deleteTimecard(int tcId)
{
    Timecard tc = new Timecard();
    tc.id = tcId;
    tc.delete();
    Console.WriteLine("Timecard deleted.");
}
````

- **getTimecardsByEmployee(empId: )**: Lấy danh sách tất cả các thẻ chấm công của một nhân viên cụ thể..****.****
```csharp
public List<Timecard> getTimecardsByEmployee(int empId)
{
    // Code giả lập lấy thẻ chấm công của nhân viên từ cơ sở dữ liệu
    return new List<Timecard> { new Timecard() }; // Trả về một danh sách mẫu
}

````
- **validateChargeCode(tc: Timecard)**:  Kiểm tra mã charge của thẻ chấm công có hợp lệ không..****
```csharp
public bool validateChargeCode(Timecard tc)
{
    ProjectManagementDatabase db = new ProjectManagementDatabase();
    return db.validateChargeCode(tc.chargeCode);
}

````
---
### **4.TimecardForm**
- **displayForm()**:  Hiển thị biểu mẫu nhập liệu cho người dùng..****
```csharp
public void displayForm()
{
    Console.WriteLine("Displaying timecard form...");
}

````
- **getInput()**:  Thu thập dữ liệu từ người dùng qua biểu mẫu..****
```csharp
public Timecard getInput()
{
    Timecard tc = new Timecard();
    Console.WriteLine("Getting timecard input...");
    // Thu thập thông tin từ người dùng
    return tc;
}

````

- **submitTimecard(tc: Timecard)**: Gửi thông tin thẻ chấm công từ người dùng tới.****
```csharp
public void submitTimecard(Timecard tc)
{
    TimecardController controller = new TimecardController();
    controller.saveTimecard(tc);
}
````
---
### **5.ProjectManagementDatabase**
- **getChargeCodeDetails(code: string)**:Lấy thông tin chi tiết về một mã charge cụ thể từ cơ sở dữ liệu.****
```csharp
public string getChargeCodeDetails(string code)
{
    // Code để lấy thông tin mã charge từ cơ sở dữ liệu
    return "Charge Code Details";
}

````
---

- **validateChargeCode(code: string)**:Kiểm tra xem mã charge có hợp lệ hay không.****
```csharp
public bool validateChargeCode(string code)
{
    // Code để kiểm tra mã charge hợp lệ
    return code == "VALID_CODE"; // Ví dụ mã hợp lệ
}

````
---

- **saveChargeCode(code: string)**: Lưu thông tin mã charge vào cơ sở dữ liệu.****
```csharp
public void saveChargeCode(string code)
{
    // Code để lưu mã charge vào cơ sở dữ liệu
    Console.WriteLine($"Saving charge code: {code}");
}


````
---
## Xác định trạng thái
# Lớp Timecard

Lớp **Timecard** có trạng thái phản ánh quy trình xử lý thẻ chấm công.

## Trạng thái chính

- **Pending**: Thẻ chấm công vừa được tạo và chưa được duyệt.
- **Approved**: Thẻ chấm công đã được phê duyệt bởi quản lý hoặc hệ thống.
- **Rejected**: Thẻ chấm công bị từ chối do không hợp lệ hoặc sai sót.
- **Processed**: Thẻ chấm công đã được xử lý trong bảng lương (Payroll).

## Thuộc tính trạng thái

```csharp
public enum TimecardStatus
{
    Pending,
    Approved,
    Rejected,
    Processed
}
````
---
# Lớp Employee

Lớp **Employee** có trạng thái quản lý trạng thái của nhân viên. 

## Trạng thái chính

- **Active**: Nhân viên đang làm việc.
- **Inactive**: Nhân viên đã nghỉ việc hoặc tạm nghỉ.
- **OnLeave**: Nhân viên đang trong kỳ nghỉ phép.
- **Terminated**: Nhân viên đã nghỉ việc vĩnh viễn.

## Thuộc tính trạng thái

```csharp
public enum EmployeeStatus
{
    Active,
    Inactive,
    OnLeave,
    Terminated
}
````
---

# Lớp TimecardController

Lớp **TimecardController** chịu trách nhiệm điều phối và xử lý các thẻ chấm công dựa trên trạng thái từ lớp **Timecard**. 

## Chức năng chính

1. **Kiểm tra trạng thái của Timecard**: 
   - Trước khi thực hiện xử lý, kiểm tra trạng thái hiện tại của thẻ chấm công.

2. **Gửi yêu cầu phê duyệt hoặc từ chối**: 
   - Dựa trên logic nghiệp vụ, thay đổi trạng thái của thẻ chấm công (e.g., từ `Pending` sang `Approved` hoặc `Rejected`).

3. **Xử lý thẻ chấm công đã được phê duyệt**: 
   - Đảm bảo chỉ xử lý các thẻ ở trạng thái **Approved**.
---

# Lớp TimecardForm

Lớp **TimecardForm** phản ánh trạng thái giao tiếp của người dùng khi nhập liệu.

## Trạng thái chính

- **Editing**: Biểu mẫu đang được người dùng chỉnh sửa.
- **Submitted**: Biểu mẫu đã được gửi tới **TimecardController**.
- **Validated**: Dữ liệu đã được kiểm tra và hợp lệ.
- **Invalid**: Biểu mẫu chứa lỗi và cần sửa đổi.

## Mô tả trạng thái

- **Editing**: Người dùng đang nhập thông tin.
- **Submitted**: Hoàn tất việc nhập và gửi yêu cầu xử lý.
- **Validated**: Dữ liệu thỏa mãn điều kiện nhập liệu.
- **Invalid**: Có lỗi (e.g., thiếu thông tin, mã charge không hợp lệ).
---

## 5. Lớp ProjectManagementDatabase
Lớp **ProjectManagementDatabase** không giữ trạng thái phức tạp, nhưng có thể lưu cache hoặc trạng thái kết nối.

### Trạng thái chính
- **Connected**: Hệ thống cơ sở dữ liệu đang hoạt động.
- **Disconnected**: Hệ thống cơ sở dữ liệu không khả dụng.
- **CacheLoaded**: Dữ liệu mã charge đã được tải về bộ nhớ tạm.

### Mô tả trạng thái
- **Connected**: Có thể thực hiện các truy vấn tới cơ sở dữ liệu.
- **Disconnected**: Tạm dừng hoạt động, cần xử lý lỗi kết nối hoặc khôi phục.
- **CacheLoaded**: Dữ liệu đã được lưu vào bộ nhớ tạm để tăng tốc quá trình xử lý.

---
# **Định nghĩa các Attributes**
| Lớp                    | Thuộc tính                                       |
|------------------------|--------------------------------------------------|
| **Timecard**            | Id, EmployeeId, StartTime, EndTime, Status, ChargeCode, HoursWorked |
| **Employee**            | Id, Name, Position, Status, Timecards           |
| **TimecardController**  | TimecardService, Database                       |
| **TimecardForm**        | CurrentTimecard, IsValid                        |
| **ProjectManagementDatabase** | ConnectionString, ChargeCodes              |



---

# **Định Nghĩa Các Dependency Của Các Lớp**

## 1. Lớp **Timecard**
**Dependency**:
- **Employee**: Lớp Timecard phụ thuộc vào thông tin của **Employee** (EmployeeId) để xác định nhân viên nào đã tạo thẻ chấm công.
- **ProjectManagementDatabase**: Lớp Timecard có thể cần kết nối với cơ sở dữ liệu để lưu trữ và truy vấn thông tin về thẻ chấm công.

## 2. Lớp **Employee**
**Dependency**:
- **Timecard**: Lớp Employee có thể có nhiều **Timecard** liên kết với nhân viên đó. Do đó, **Timecard** là một dependency khi quản lý và hiển thị các thẻ chấm công của nhân viên.
- **ProjectManagementDatabase**: Cơ sở dữ liệu được sử dụng để lưu trữ và truy vấn các thông tin liên quan đến nhân viên.

## 3. Lớp **TimecardController**
**Dependency**:
- **TimecardService**: Lớp TimecardController sử dụng **TimecardService** để thực hiện các hành động như tạo mới, phê duyệt, hoặc từ chối thẻ chấm công.
- **ProjectManagementDatabase**: Lớp này phụ thuộc vào cơ sở dữ liệu để lấy và lưu các thông tin liên quan đến thẻ chấm công (Timecards).

## 4. Lớp **TimecardForm**
**Dependency**:
- **Timecard**: **TimecardForm** phụ thuộc vào đối tượng **Timecard** để điền thông tin và thực hiện các hành động liên quan đến việc tạo thẻ chấm công.
- **TimecardController**: Sau khi người dùng nhập thông tin, **TimecardForm** gửi dữ liệu tới **TimecardController** để xử lý và phê duyệt thẻ chấm công.

## 5. Lớp **ProjectManagementDatabase**
**Dependency**:
- **ConnectionString**: Lớp này phụ thuộc vào chuỗi kết nối cơ sở dữ liệu (ConnectionString) để thiết lập và duy trì kết nối với hệ thống cơ sở dữ liệu.
- **ChargeCodes**: Lớp **ProjectManagementDatabase** còn cần phải truy vấn các mã charge (ChargeCodes) để sử dụng trong quá trình tạo hoặc xử lý thẻ chấm công.
