// ตัวอย่างการใช้งาน Adapter pattern
public class Main {
    public static void main(String[] args) {
        // สร้าง Object ของ NewPaymentSystem
        NewPaymentSystem newPaymentSystem = new NewPaymentSystem();

        // สร้าง Adapter object และส่ง newPaymentSystem เข้าไปใน Adapter constructor
        PaymentSystem adapter = new Adapter(newPaymentSystem);

        // เรียกใช้งานโค้ดของ PaymentSystem ผ่าน Adapter
        String bank = "GSB";
        String accountNumber = "123-456-789";
        double amount = 500.0;
        adapter.transferMoney(bank, accountNumber, amount);

        System.out.println("You have paid the water and electricity bill of this month. Thank You!");
    }
}