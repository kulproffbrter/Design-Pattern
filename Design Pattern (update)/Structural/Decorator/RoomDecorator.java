// คลาสหลัก: ห้องพัก
interface RoomNumber {
    void showRoomNumber();
}

// คลาสที่มีการสร้างห้องพัก
class StandardRoom implements RoomNumber {
    @Override
    public void showRoomNumber() {
        System.out.println("101");
    }
}

// Decorator abstract class
abstract class RoomNumberDecorator implements RoomNumber {
    protected RoomNumber decoratedRoomNumber;

    public RoomNumberDecorator(RoomNumber decoratedRoomNumber) {
        this.decoratedRoomNumber = decoratedRoomNumber;
    }

    @Override
    public void showRoomNumber() {
        decoratedRoomNumber.showRoomNumber();
    }
}

// Decorator: การเพิ่มบริการ WiFi
class WiFiDecorator extends RoomNumberDecorator {
    public WiFiDecorator(RoomNumber decoratedRoomNumber) {
        super(decoratedRoomNumber);
    }

    @Override
    public void showRoomNumber() {
        super.showRoomNumber();
        addWiFi();
    }

    private void addWiFi() {
        System.out.println(" + WiFi");
    }
}

// Decorator: การเพิ่มบริการเครื่องทำน้ำอุ่น
class HotWaterDecorator extends RoomNumberDecorator {
    public HotWaterDecorator(RoomNumber decoratedRoomNumber) {
        super(decoratedRoomNumber);
    }

    @Override
    public void showRoomNumber() {
        super.showRoomNumber();
        addHotWater();
    }

    private void addHotWater() {
        System.out.println(" + Hot Water");
    }
}