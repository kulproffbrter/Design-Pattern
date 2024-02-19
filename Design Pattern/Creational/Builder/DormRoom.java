// สร้าง class DormRoom หรือห้องพักขึ้นมา โดยประกอบไปด้วย เลขห้อง ประเภทห้อง และประเภทเตียง
public class DormRoom {
    private int roomNumber;
    private String roomType;
    private String bedType;

    public DormRoom(int roomNumber, String roomType, String bedType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public String getBedType() {
        return bedType;
    }
}
