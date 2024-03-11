package Builder;

// Builder class สำหรับสร้าง DormRoom
public class DormRoomBuilder {
    private int roomNumber;
    private String roomType;
    private String bedType;

    public DormRoomBuilder setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
        return this;
    }

    public DormRoomBuilder setRoomType(String roomType) {
        this.roomType = roomType;
        return this;
    }

    public DormRoomBuilder setBedType(String bedType) {
        this.bedType = bedType;
        return this;
    }

    public DormRoom build() {
        return new DormRoom(roomNumber, roomType, bedType);
    }
}
