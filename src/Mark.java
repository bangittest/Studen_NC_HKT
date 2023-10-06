import java.util.Scanner;

public class Mark {
    private static int nextId=1;
    private int markId;
    private Student student;

    private Subject subject;
    private double point;

    public Mark(Student student, Subject subject, double point) {
        this.markId =nextId++;
        this.student = student;
        this.subject = subject;
        this.point = point;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public void inputData(Student[]students,Subject[]subjects){
        Scanner scanner=new Scanner(System.in);

        //hien thi danh sach hoc sinh
        System.out.println("Danh sach hoc sinh:");
        for (Student student:
             students) {
            if (student!=null){
                System.out.println("ma hoc sinh:" +student.getStudentId() + ", Tên: " + student.getStudentName());
            }
        }
        System.out.println("nhap ma hoc sinh :");
        int studentID= Integer.parseInt(scanner.nextLine());
        this.student=findStudentById(students,studentID);


        //hien thi danh sach mon hoc
        System.out.println("Danh sach mon hoc:");
        for (Subject subject :subjects) {
            if (subject!=null){
                System.out.println("ma mon hoc: " + subject.getSubjectId() + ", Tên: " + subject.getSubjectName());
            }
        }
        System.out.println("nhap ma mon hoc: ");
        String subjectId=scanner.next();
        this.subject=findSubjectById(subjects,subjectId);

        System.out.println("nhap diem so tu 0-10 :");
        this.point=scanner.nextDouble();

        while (!isValidPoint(this.point)){
            System.out.println("diem so k hop le");
            System.out.print("nhap diem so tu 0-10 :");
            this.point=scanner.nextDouble();
        }
    }



    public void displayData(){
        System.out.println("ma diem : " +markId);
        System.out.println("ten hoc sinh: " +student.getStudentName());
        System.out.println("ten mon hoc: " +subject.getSubjectName());
        System.out.println("diem so: " +point);
    }


    // Tìm học sinh theo mã ID
    private Student findStudentById(Student[] students, int studentId) {
        for (Student student : students) {
            if (student != null && student.getStudentId() == studentId) {
                return student;
            }
        }
        return null; // Không tìm thấy
    }

    // Tìm môn học theo mã ID
    private Subject findSubjectById(Subject[] subjects, String subjectId) {
        for (Subject subject : subjects) {
            if (subject != null && subject.getSubjectId().equals(subjectId)) {
                return subject;
            }
        }
        return null; // Không tìm thấy
    }

    // Kiểm tra điểm số hợp lệ
    private boolean isValidPoint(double point) {
        return point >= 0 && point <= 10;
    }

}
