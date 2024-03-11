
// ตัวอย่างการใช้งาน
import Builder.DormRoom;
import Builder.DormRoomBuilder;

public class MainBuilder {
    public static void main(String[] args) {
        // ใช้ DormRoomBuilder เพื่อสร้าง DormRoom
        DormRoom dormRoom = new DormRoomBuilder() // กำหนดให้ห้องหมายเลข 201 เป็นห้องประเภท 4 คน และประเภทเตียงเป็น
                                                  // เตียง 2 ชั้น ซึ่งจะถูกสร้างโดย DormRoomBuilder
                .setRoomNumber(201)
                .setRoomType("4 people")
                .setBedType("Bunk bed")
                .build();

        // แสดงข้อมูลของ DormRoom
        System.out.println("Room Number: " + dormRoom.getRoomNumber());
        System.out.println("Room Type: " + dormRoom.getRoomType());
        System.out.println("Bed Type: " + dormRoom.getBedType());
    }
}