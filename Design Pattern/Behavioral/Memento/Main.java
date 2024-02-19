public class Main {
    public static void main(String[] args) {
        // Create DormRoom and Caretaker
        DormRoom DormRoom = new DormRoom(101, "4 People", 2);
        DormRoomCaretaker caretaker = new DormRoomCaretaker();

        // Save initial state
        caretaker.addMemento(DormRoom.saveState());

        // Update state
        DormRoom = new DormRoom(101, "4 People", 1);

        // Save new state
        caretaker.addMemento(DormRoom.saveState());

        // Restore to initial state
        DormRoom.restoreState(caretaker.getMemento(0));

        System.out.println(DormRoom); // Output: Room 101 RoomType 4 People : 2 available beds
    }
}