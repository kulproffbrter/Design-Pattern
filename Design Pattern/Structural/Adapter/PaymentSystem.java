// อินเทอร์เฟซสำหรับระบบการโอนเงิน
interface PaymentSystem {
    void transferMoney(String bank, String accountNumber, double amount);
}

// คลาสที่มีการออกแบบใหม่สำหรับระบบการโอนเงิน
class NewPaymentSystem {
    void makePayment(String bank, String accountNumber, double amount) {
        System.out.println("Payment of " + amount + " Baht successfully transferred to account " +
                accountNumber + " via " + bank + ".");
    }
}

// Adapter class ที่ใช้เพื่อให้ PaymentSystem สามารถใช้งานร่วมกับ NewPaymentSystem ได้
class Adapter implements PaymentSystem {
    private NewPaymentSystem newPaymentSystem;

    public Adapter(NewPaymentSystem newPaymentSystem) {
        this.newPaymentSystem = newPaymentSystem;
    }

    @Override
    public void transferMoney(String bank, String accountNumber, double amount) {
        // ใช้ newPaymentSystem.makePayment() เพื่อโอนเงิน
        newPaymentSystem.makePayment(bank, accountNumber, amount);
    }
}