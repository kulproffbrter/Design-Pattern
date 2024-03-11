// ตัวอย่างการใช้งาน
public class MainDecorator {
    public static void main(String[] args) {
        // สร้างห้องพักมาต้นทาง
        RoomNumber standardRoom = new StandardRoom();

        // เพิ่ม WiFi ในห้องพัก
        RoomNumber roomWithWiFi = new WiFiDecorator(standardRoom);

        // เพิ่มเครื่องทำน้ำอุ่นในห้องพักที่มี WiFi
        RoomNumber roomWithHotWater = new HotWaterDecorator(standardRoom);

        // แสดงข้อมูลของห้องพัก
        System.out.println("Standard Room:");
        standardRoom.showRoomNumber();

        System.out.println("\nRoom with WiFi:");
        roomWithWiFi.showRoomNumber();

        System.out.println("\nRoom with Hot Water:");
        roomWithHotWater.showRoomNumber();
    }
}