public class BillingSystem {
    // สร้างตัวแปร instance เพื่อเก็บ Singleton instance
    private static BillingSystem instance;

    // สร้างตัวแปรเก็บข้อมูลบิลค่าน้ำค่าไฟ
    // ใช้ double เพราะค่าน้ำค่าไฟเป็นทศนิยม
    private String monthName;
    private String studentName;
    private double waterBill;
    private double electricityBill;

    // private constructor เพื่อป้องกันการสร้าง instance จากภายนอก
    // หรือเพื่อไม่ให้คลาสอื่นใช้งานด้วย
    // set หมายถึง การกำหนดค่าให้กับตัวแปรนั้นๆ
    // get หมายถึง การดึงค่าจากตัวแปรนั้นๆ เพื่อ return มาแสดงผล
    private BillingSystem() {
        monthName = null;
        studentName = null;
        waterBill = 0.0;
        electricityBill = 0.0;
    }

    // Method getInstance สำหรับการดึง instance ของ Singleton
    public static BillingSystem getInstance() {
        if (instance == null) {
            instance = new BillingSystem();
        }
        return instance; // กำหนดให้ถ้า instance เป็นค่าว่าง ให้ instance สร้าบิลใหม่ (BillingSystem)
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    // Method setStudentName สำหรับกำหนดค่าชื่อนักศึกษา
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Method setWaterBill สำหรับกำหนดค่าบิลน้ำ
    public void setWaterBill(double waterBill) {
        this.waterBill = waterBill;
    }

    // Method setElectricityBill สำหรับกำหนดค่าบิลไฟ
    public void setElectricityBill(double electricityBill) {
        this.electricityBill = electricityBill;
    }

    // Method calculateTotalBill สำหรับคำนวณยอดรวม
    public double calculateTotalBill() {
        return waterBill + electricityBill;
    }

    // Method displayBill สำหรับการแสดงข้อมูลบิล โดยคลาส Main จะดึง Method
    // displayBill เพื่อไปแสดงค่า
    public void displayBill() {
        System.out.println("Month Name: " + monthName);
        System.out.println("Student Name: " + studentName);
        System.out.println("Water Bill: " + waterBill);
        System.out.println("Electricity Bill: " + electricityBill);
        System.out.println("Total Bill: " + calculateTotalBill());
    }
}