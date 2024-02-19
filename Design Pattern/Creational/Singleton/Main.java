public class Main {
    public static void main(String[] args) {
        // ใช้ getInstance() เพื่อดึง instance ของ BillingSystem
        BillingSystem billingSystem = BillingSystem.getInstance();

        // กำหนดค่าบิลน้ำบิลไฟของนักศึกษาคนหนึ่ง
        billingSystem.setStudentName("Kulpriya");
        billingSystem.setWaterBill(50.0);
        billingSystem.setElectricityBill(100.0);

        // แสดงข้อมูลบิลค่าน้ำค่าไฟ
        billingSystem.displayBill();
    }
}