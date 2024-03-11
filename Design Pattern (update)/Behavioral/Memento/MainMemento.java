public class MainMemento {
    public static void main(String[] args) {
        // Create DormRoom and Caretaker
        Dorm_Room Dorm_Room = new Dorm_Room(101, "4 People", 2);
        DormRoomCaretaker caretaker = new DormRoomCaretaker();

        // Save initial state
        caretaker.addMemento(Dorm_Room.saveState());

        // Update state
        Dorm_Room = new Dorm_Room(101, "4 People", 1);

        // Save new state
        caretaker.addMemento(Dorm_Room.saveState());

        // Restore to initial state
        Dorm_Room.restoreState(caretaker.getMemento(0));

        System.out.println(Dorm_Room); // Output: Room 101 RoomType 4 People : 2 available beds
    }
}