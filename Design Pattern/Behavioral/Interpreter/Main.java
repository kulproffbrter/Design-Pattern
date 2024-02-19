// class Main ดึงค่าของ RoomContext มาแสดง
public class Main {
    public static void main(String[] args) {
        // Sample usage
        RoomContext roomContext = new RoomContext(259, 237, 28, 22, "4 people");

        RoomTypeExpression roomTypeExpression = new RoomTypeExpression();
        int totalCost = roomTypeExpression.interpret(roomContext);

        System.out.println("Total cost for the room: " + totalCost + " Baht");
    }
}