
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

## Định nghĩa Operation
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

