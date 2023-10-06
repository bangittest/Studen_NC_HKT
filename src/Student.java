import java.util.Scanner;

public class Student {
    private static int nextId=1;
    private int studentId ;

    private String studentName;

    private String birthDay;
    private String address;
    private boolean gender;
    private String phone;
    public Student(){}

    public Student( String studentName, String birthDay, String address, boolean gender, String phone) {
        this.studentId = nextId++;
        this.studentName = studentName;
        this.birthDay = birthDay;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


//    public void displayData() {
//        System.out.println("Student{" +
//                "studentId=" + studentId +
//                ", studentName='" + studentName + '\'' +
//                ", birthDay='" + birthDay + '\'' +
//                ", address='" + address + '\'' +
//                ", gender=" + (gender?"nam":"nu") +
//                ", phone='" + phone + '\'' +
//                '}');
//    }

    public  void setNewId(int index){
        this.studentId = index+1;
    }

    public void inputData(){
        Scanner scanner=new Scanner(System.in);

        System.out.println("nhap ten hoc sinh: ");
        while (true){
            this.studentName=scanner.nextLine();
            if (studentName.length()>=5){
                break;
            }else {
                System.out.println("ten it nhat phai 5 ki tu !");
            }
        }

        System.out.println("ngày sinh : ");
        this.birthDay=scanner.nextLine();


        System.out.println("nhap dia chi: ");
        while (true){
            this.address=scanner.nextLine();
            if (address.length()>0){
                break;
            }else {
                System.out.println("dia chi khong duoc de trong");
            }
        }

        System.out.println("nhap gioi tinh");
        String genderInput = scanner.nextLine().toLowerCase();
        this.gender = genderInput.equals("nam");


        System.out.println("nhap so dien thoai: ");
        String regex = "^0\\d{9}$";
        while (true){
            this.phone=scanner.nextLine();
            if (phone.matches(regex)){
                return;
            }else {
                System.out.println("so dien thoai it nhat 10 ki tu bat dau tu so 0");
            }
        }

    }

    public void displayData(){
        System.out.println("mã học sinh " + studentId);
        System.out.println("tên học sinh " + studentName);
        System.out.println("ngày sinh " + birthDay);
        System.out.println("địa chỉ " + address);
        System.out.println("giới tính " + (gender?"nam":"nu"));
        System.out.println("số điện thoại " + phone);
    }
}
