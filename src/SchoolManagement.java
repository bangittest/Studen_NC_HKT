import java.util.Scanner;

public class SchoolManagement {
    public static void main(String[] args) {
        Student[] students = new Student[100];
        int studentIndex = 0;
        Subject[] subjects = new Subject[100];
        int subjectIndex = 0;
        Mark[] marks = new Mark[100];
        int markIndex = 0;
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                    ************************SCHOOL-MANAGEMENT*************************
                    1.	Quản lý học sinh
                    2.	Quản lý môn học
                    3.	Quản lí điểm thi
                    4.	Thoát
                                        
                    """);
            System.out.println("Chon");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("""
                            **********************STUDENT-MANAGEMENT************************
                            1.Thêm mới học sinh
                            2.Hiển thị danh sách tất cả học sinh đã lưu trữ
                            3.Thay đổi thông tin học sinh theo mã id
                            4.Xóa học sinh theo mã id (kiểm tra xem nếu sinh viên có điểm thi thì không xóa được)
                            5.Thoát			
                                               
                            """);
                    int studenChoise = scanner.nextInt();
                    switch (studenChoise) {
                        case 1:
                            //them moi hoc sinh
                            students[studentIndex]=new Student();
                            students[studentIndex].setNewId(studentIndex);
                            students[studentIndex++].inputData();
                            System.out.println("them moi thanh cong");
                            break;
                        case 2:
                            //hien thi danh sach sinh vien
                            for (int i = 0; i < studentIndex; i++) {
                                students[i].displayData();
                            }
                            break;
                        case 3:
                            //thay doi thong tin hoc sinh vien
                            System.out.println("nhap id de thay doi thong tin hoc sinh vien");
                            int idEdit= scanner.nextInt();
//                            for (int i = 0; i < studentIndex; i++) {
//                                if (students[i].getStudentId()==idEdit){
//                                    students[i].inputData();
//                                    System.out.println("cap nhat thanh cong");
//                                }else {
//                                    System.out.println("k tim thay thong tin hoc sinh co id " +idEdit);
//                                }
//                            }
                            Student studentUpdate=findStudentById(students,idEdit);
                            if (studentUpdate!=null ){
                                studentUpdate.inputData();
                                System.out.println("cap nhat thanh cong");
                            }else {
                                System.out.println("k tim thay thong tin hoc sinh co id " +idEdit);
                            }
                            break;
                        case 4:
                            //xoa hoc sinh
                            System.out.println("nhap id de xoa hoc sinh");
                            int idDelete=scanner.nextInt();
                            Student studenToDelete=findStudentById(students,idDelete);
                            if (studenToDelete!=null){
                                if (!isStudentHasMark(marks,idDelete)){
                                    deleteStudent(students,studenToDelete);
                                    System.out.println("xoa thanh cong");
                                    studentIndex--;
                                }else {
                                    System.out.println("hoc sinh cos diem thi k the xoa");
                                }
                            }else {
                                System.out.println("k tim thay hoc sinh co id " +idDelete);
                            }

//                            for (int i = 0; i < studentIndex; i++) {
//                                for (int j = i; j <studentIndex ; j++) {
//                                    if (students[i].getStudentId()==idDelete){
//                                        students[j]=students[j+1];
//                                        System.out.println("xoa thanh cong");
//                                    }
//                                    studentIndex--;
//                                }
//
//                            }

                            break;
                    }
                case 2:
                    //quan ly mon hoc
                    System.out.println("""
                            **********************SUBJECT-MANAGEMENT*************************
                            1.Thêm mới môn học
                            2.Hiển thị danh sách tất cả môn học đã lưu trữ
                            3.Thay đổi thông tin học môn học theo mã id
                            4.Xóa môn học theo mã id (kiểm tra nếu môn học  có điểm thi thì không xóa được\s
                            5.Thoát
                                                        
                                                        
                            """);
                    int subjectChoce=scanner.nextInt();
                    switch (subjectChoce){
                        case 1:
                            //them moi mon hoc
                            subjects[subjectIndex]=new Subject();
                            subjects[subjectIndex++].inputData();
                            System.out.println("them moi thanh cong");
                            break;
                        case 2:
                            //danh sach diem
                            System.out.println("danh sach mon hoc");
                            for (int i = 0; i < subjectIndex; i++) {
                                subjects[i].displayData();
                            }
                            break;
                        case 3:
                            //thay doi thong tin mon hoc
                            System.out.println("nhap id mon hoc can thay doi : " );
                            String idSubEdit=scanner.nextLine();
                                Subject subjectUpdate=findSubjectById(subjects,idSubEdit);
                                if (subjectUpdate!=null){
                                  subjectUpdate.inputData();
                                    System.out.println("cap nhat thanh cong");
                                }else {
                                    System.out.println("k tim thay mon hoc co ma id :" +idSubEdit);
                                }
                            break;
                        case 4:
                            //xoa thong tin mon hoc
                            System.out.println("nhap id mon hoc can xoa : ");
                            String idSubDelete=scanner.nextLine();
                            Subject subjectDelete=findSubjectById(subjects,idSubDelete);
                            if (subjectDelete!=null){
                                if (!isSubjectHasMark(marks,idSubDelete)){
                                    //xoa mon hoc neu k co diem thi
                                    deleteSubject(subjects,subjectDelete);
                                    System.out.println("xoa thanh cong");
                                    subjectIndex--;
                                }else {
                                    System.out.println("mon hoc co diem thi ,k the xoa :");
                                }
                            }else{
                                System.out.println("k tim thay mon hoc co id :" +idSubDelete);
                            }
                            break;
                    }
                case 3:
                   //menu quan ly diem thi
                    System.out.println("""
                            *********************MARK-MANAGEMENT************************
                            1.Thêm mới điểm thi cho 1 sinh viên
                            2.Hiển thị danh sách tất cả điểm thi theo thứ tự điểm tăng dần
                            3.Thay đổi điểm theo mã id
                            4.Xóa điểm theo mã id
                            5.Hiển thị danh sách điểm thi theo mã môn học
                            6.Hiển thị đánh giá học lực của từng học sinh theo mã môn học (giả sử <5 là yếu , <=6.5 là trung bình, <= 8 là khá, <= 9 là giỏi, còn lại là xuất sắc).
                                                        
                            """);
                    int markChoice=scanner.nextInt();
                    switch (markChoice){
                        case 1:
                            if (subjectIndex==0||studentIndex==0){
                                System.out.println("can it nhat 1 hoc sinh va 1 mon hoc de them diem thi");
                                break;
                            }
                            marks[markIndex]=new Mark(null,null,0.0);
                            marks[markIndex].inputData(students,subjects);
                            markIndex++;
                            break;
                        case 2:
                            System.out.println("xem tat ca mon hoc va du lieu");
                            sortMarksByPoint(marks, markIndex);
                            for (int i = 0; i < markIndex; i++) {
                                marks[i].displayData();
                            }
                            break;
                        case 3:
                            // Thay đổi điểm theo mã id
                            System.out.print("Nhập mã điểm cần thay đổi: ");
                            int markId = scanner.nextInt();
                            Mark markToUpdate = findMarkById(marks, markId);
                            if (markToUpdate != null) {
                                markToUpdate.inputData(students, subjects);
                                System.out.println("thay doi thanh cong");
                            } else {
                                System.out.println("Không tìm thấy điểm có mã id: " + markId);
                            }
                            break;
                        case 4:
                            //xoa diem theo ma id

                            System.out.println("nhap ma diem can xoa: ");
                            int idMarkDelete=scanner.nextInt();
                            Mark markDelete=findMarkById(marks,idMarkDelete);
                            if (markDelete!=null){
                                deleteMark(marks,markDelete);
                                System.out.println("xoa thanh cong");
                                markIndex--;
                            }else {
                                System.out.println("k tim thay id can xoa" +idMarkDelete);
                            }
                            break;
                        case 5:
                            // Hiển thị danh sách điểm thi theo mã môn học
                            System.out.print("Nhập mã môn học: ");
                            String subjectId = scanner.next();
                            displayMarksBySubject(marks, markIndex, subjectId);
                            break;
                        case 6:
                            // Hiển thị đánh giá học lực của từng học sinh theo mã môn học
                            System.out.print("Nhập mã môn học: ");
                            String subjectIdForEvaluation = scanner.next();
                            displayStudentPerformanceBySubject(marks, markIndex, students, studentIndex, subjectIdForEvaluation);
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    }
                    break;
                case 4:
                    System.out.println("ket thuc chuong trinh");
                    break;
                default:
                    System.out.println("lua chon k dung");


            }
        }while (choice!=4);
    }

    //tim hoc sinh theo ma id
    private static Student findStudentById(Student[]students,int studentId){
        for (Student student : students) {
            if (student!=null && student.getStudentId()==studentId){
                return student;
            }
        }
        return null;//k tim thay
    }
    //tim mon hoc theo ma ID
    private static Subject findSubjectById(Subject[]subjects,String subjectId ){
        for (Subject subject:subjects) {
            if (subject!=null&&subject.getSubjectId().equals(subjectId)){
                return subject;
            }
        }
        return null;//k tim thay
    }

    //tim diem theo ma
    private static Mark findMarkById(Mark[]marks,int markId){
        for (Mark mark :marks) {
            if (mark!=null&&mark.getMarkId()==markId){
                return mark;
            }
        }
        return null;//k tim thay
    }

    //xoa hoc sinh
    private static void deleteStudent(Student[]students,Student studentToDelete){
        for (int i = 0; i < students.length; i++) {
            if (students[i]!=null&&students[i].equals(studentToDelete)){
                students[i]=null;
                break;
            }
        }
    }

    //xoa mon hoc
    private static void deleteSubject(Subject[]subjects,Subject subjectToDelete){
        for (int i = 0; i < subjects.length; i++) {
            if (subjects[i]!=null &&subjects[i].equals(subjectToDelete)){
                subjects[i]=null;
                break;
            }
        }
    }


    //xoa diem
    private static void deleteMark(Mark[]marks,Mark markToDelete){
        for (int i = 0; i < marks.length; i++) {
            if (marks[i]!=null&&marks[i].equals(markToDelete)){
                marks[i]=null;
                break;
            }
        }
    }

    //kiem tra hoc sinh co diem thi
    public static boolean isStudentHasMark(Mark[]marks,int studentId) {
        for (Mark mark : marks) {
            if (mark!=null &&mark.getStudent().getStudentId()==studentId){
                return true;
            }
        }
     return false;
    }

    //kiem tra mon hoc co diem thi

    public static boolean isSubjectHasMark(Mark[]marks,String subjectId) {
        for (Mark mark : marks) {
        if (mark!=null&&mark.getSubject().getSubjectId().equals(subjectId)){
            return true;
            }
        }
        return false;
    }


    // Sắp xếp điểm thi theo thứ tự tăng dần
    private static void sortMarksByPoint(Mark[] marks, int markCount) {
        for (int i = 0; i < markCount - 1; i++) {
            for (int j = 0; j < markCount - i - 1; j++) {
                if (marks[j] != null && marks[j + 1] != null && marks[j].getPoint() > marks[j + 1].getPoint()) {
                    Mark temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                }
            }
        }
    }

    // Hiển thị điểm thi theo mã môn học
    private static void displayMarksBySubject(Mark[] marks, int markCount, String subjectId) {
        for (int i = 0; i < markCount; i++) {
            if (marks[i] != null && marks[i].getSubject().getSubjectId().equals(subjectId)) {
                marks[i].displayData();
            }
        }
    }

    // Hiển thị đánh giá học lực của từng học sinh theo mã môn học
    private static void displayStudentPerformanceBySubject(Mark[] marks, int markCount, Student[] students, int studentCount, String subjectId) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i] != null) {
                double totalPoint = 0;
                int count = 0;
                for (int j = 0; j < markCount; j++) {
                    if (marks[j] != null && marks[j].getStudent().equals(students[i]) && marks[j].getSubject().getSubjectId().equals(subjectId)) {
                        totalPoint += marks[j].getPoint();
                        count++;
                    }
                }
                if (count > 0) {
                    double averagePoint = totalPoint / count;
                    String evaluation = "";
                    if (averagePoint < 5) {
                        evaluation = "Yếu";
                    } else if (averagePoint <= 6.5) {
                        evaluation = "Trung bình";
                    } else if (averagePoint <= 8) {
                        evaluation = "Khá";
                    } else if (averagePoint <= 9) {
                        evaluation = "Giỏi";
                    } else {
                        evaluation = "Xuất sắc";
                    }
                    System.out.println("Mã học sinh: " + students[i].getStudentId() + ", Tên: " + students[i].getStudentName() + ", Đánh giá học lực: " + evaluation);
                }
            }
        }
    }
}

