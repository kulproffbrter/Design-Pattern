import java.util.ArrayList;
import java.util.List;

// สร้างตัวแปร roomState ใน class DormRoomMemento
class DormRoomMemento {
    private final String roomState;

    public DormRoomMemento(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomState() {
        return roomState;
    }
}

// สร้างตัวแปร roomNumber และ availableBeds (การใช้งานของเตียง) ใน Class
// DormRoom (Originator)
class Dorm_Room {
    private final int roomNumber;
    private String roomType;
    private int availableBeds;

    public Dorm_Room(int roomNumber, String roomType, int availableBeds) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.availableBeds = availableBeds;
    }

    // สร้าง Method getState getState เพื่อบอกสถานะปัจจุบันของห้องพัก
    // โดยจะนำหมายเลขห้อง และจำนวนเตียงที่ว่าง มาประกอบเข้าด้วยกัน
    public String getState() {
        return "Room " + roomNumber + " RoomType " + roomType + " : " + availableBeds + " available beds";
    }

    // สร้าง Method saveState เพื่อบันทึกสถานะจาก class getState มาเก็บไว้ที่ class
    // DormRoomMemento
    public DormRoomMemento saveState() {
        return new DormRoomMemento(getState());
    }

    // สร้าง Method restoreState เพื่อ return สถานะของห้องพัก จาก Memento
    public void restoreState(DormRoomMemento memento) {
        String[] parts = memento.getRoomState().split(": "); // ดึงข้อมูลสถานะจาก Memento
        String availableBedsStr = parts[1].split(" ")[0]; // แยกตัวเลขจากข้อความ
        this.availableBeds = Integer.parseInt(availableBedsStr); // แปลงข้อมูลที่แยกมาให้เป็นจำนวนเตียงที่ว่าง
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " RoomType " + roomType + " : " + availableBeds + " available beds";
    }
}

// สร้าง ArrayList ของ Memento ใน class DormRoomCaretaker
class DormRoomCaretaker {
    private final List<DormRoomMemento> mementos = new ArrayList<>();

    // สร้าง Method addMemento เพื่อเพิ่ม Memento ลงใน list ซึ่งถูกเก็บไว้ใน
    // mementos
    // เมื่อ DormRoom บันทึกสถานะ Memento จะถูกสร้างขึ้น และ Method addMemento
    // จะถูกเรียกเพื่อเก็บ Memento
    public void addMemento(DormRoomMemento memento) {
        mementos.add(memento);
    }

    // สร้าง Method getMemento เพื่อดึง Memento ที่ตำแหน่งระบุใน list mementos
    // ใช้ index ระบุตำแหน่งใน ArrayList
    // หากต้องการ return สถานะ หรือดึงข้อมูลสถานะกลับมา จะใช้ Method getMemento
    public DormRoomMemento getMemento(int index) {
        return mementos.get(index);
    }
}