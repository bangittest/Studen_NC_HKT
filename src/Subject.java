import java.util.Scanner;

public class Subject {
    private String subjectId;
    private String subjectName;

    public Subject(){

    }
    // Constructor
    public Subject(String subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    // Getter và Setter cho subjectId
    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    // Getter và Setter cho subjectName
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    // Phương thức inputData() để nhập thông tin môn học từ bàn phím
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã môn học (MHxxx): ");
        String id = scanner.nextLine();
        // Kiểm tra định dạng mã môn học
        if (!isValidSubjectId(id)) {
            System.out.println("Mã môn học không hợp lệ. Mã môn học phải bắt đầu bằng 'MH' và sau đó là 3 kí tự số.");
            return;
        }

        System.out.print("Nhập tên môn học: ");
        String name = scanner.nextLine();
        // Kiểm tra tên môn học không được để trống
        if (name.trim().isEmpty()) {
            System.out.println("Tên môn học không được để trống.");
            return;
        }

        // Cập nhật thông tin môn học sau khi kiểm tra hợp lệ
        this.subjectId = id;
        this.subjectName = name;
    }

    // Phương thức displayData() để hiển thị thông tin môn học
    public void displayData() {
        System.out.println("Mã môn học: " + subjectId);
        System.out.println("Tên môn học: " + subjectName);
    }

    // Kiểm tra định dạng mã môn học
    private boolean isValidSubjectId(String subjectId) {
        return subjectId.matches("MH\\d{3}");
    }
}
