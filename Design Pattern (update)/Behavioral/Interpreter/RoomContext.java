// สร้าง class RoomContext ขึ้นมา ประกอบไปด้วยตัวแปร หน่วยค่าไฟเดือนเก่า หน่วยค่าไฟเดือนใหม่ หน่วยค่าน้ำเดือนเก่า หน่วยค่าน้ำเดือนใหม่ และประเภทห้อง
class RoomContext {
    private int oldElectricityUnits;
    private int newElectricityUnits;
    private int oldWaterUnits;
    private int newWaterUnits;
    private String roomType;

    public RoomContext(int oldElectricityUnits, int newElectricityUnits, int oldWaterUnits, int newWaterUnits,
            String roomType) {
        this.oldElectricityUnits = oldElectricityUnits;
        this.newElectricityUnits = newElectricityUnits;
        this.oldWaterUnits = oldWaterUnits;
        this.newWaterUnits = newWaterUnits;
        this.roomType = roomType;
    }

    public int getOldElectricityUnits() {
        return oldElectricityUnits;
    }

    public int getNewElectricityUnits() {
        return newElectricityUnits;
    }

    public int getOldWaterUnits() {
        return oldWaterUnits;
    }

    public int getNewWaterUnits() {
        return newWaterUnits;
    }

    public String getRoomType() {
        return roomType;
    }
}

// Expression
interface Interpreter { // Interpreter ใช้ระบุ Method interpret เพื่อใช้ในการ override
    int interpret(RoomContext context);
}

// Terminal Expression ของค่าไฟ
// การ Override มาจากการ inherited from superclass โดยการ copy superclass
// มาแล้วเปลี่ยนพฤติกรรมแต่ไม่เปลี่ยนโครงสร้างเดิม
// implements interface Interpreter มา แล้วทำการ Override โดยใช้ Method
// interpret
class OldElectricityExpression implements Interpreter {
    @Override
    public int interpret(RoomContext context) {
        int cost = context.getOldElectricityUnits(); // รับค่าหน่วยค่าไฟเดือนเก่า (เดือนที่แล้ว)
        return cost;
    }
}

class NewElectricityExpression implements Interpreter {
    @Override
    public int interpret(RoomContext context) {
        int cost = context.getNewElectricityUnits(); // รับค่าหน่วยค่าไฟเดือนใหม่ (เดือนนี้)
        return cost;
    }
}

// Terminal Expression ของค่าน้ำ
class OldWaterExpression implements Interpreter {
    @Override
    public int interpret(RoomContext context) {
        int cost = context.getOldWaterUnits(); // รับค่าหน่วยค่าน้ำเดือนเก่า (เดือนที่แล้ว)
        return cost;
    }
}

class NewWaterExpression implements Interpreter {
    @Override
    public int interpret(RoomContext context) {
        int cost = context.getNewWaterUnits(); // รับค่าหน่วยค่าน้ำเดือนใหม่ (เดือนนี้)
        return cost;
    }
}

// Non-terminal Expression ของประเภทห้อง
class RoomTypeExpression implements Interpreter {
    @Override
    // สร้างตัวแปร totalCost เพื่อเก็บค่าผลการคำนวณ
    public int interpret(RoomContext context) {
        int totalCost = (((new OldElectricityExpression().interpret(context)
                - new NewElectricityExpression().interpret(context)) * 7)
                + ((new OldWaterExpression().interpret(context)
                        - new NewWaterExpression().interpret(context)) * 16));

        // สูตรในการคำนวณ คือ ค่าไฟเดือนเก่า ลบกับ ค่าไฟเดือนใหม่
        // แล้วนำผลลบของหน่วยค่าไฟ คูณด้วย 7 (ค่าไฟหน่วยละ 7 บาท) บวกกับ
        // ค่าน้ำเดือนเก่า ลบกับ ค่าน้ำเดือนใหม่ แล้วนำผลลบของหน่วยค่าน้ำ คูณด้วย 16
        // (ค่าน้ำหน่วยละ 16 บาท)
        // และนำมาหารกับเงื่อนไขของประเภทห้อง
        // กำหนดให้ ประเภทห้อง 4 คน มีค่าเป็น 4 และประเภทห้อง 2 คน มีค่าเป็น 2
        if (context.getRoomType().equals("4 people")) {
            return totalCost / 4;
        } else if (context.getRoomType().equals("2 people")) {
            return totalCost / 2;
        } else {
            // นอกเหนือจากเงื่อนไขประเภทห้องด้านบน
            return totalCost;
        }
    }
}
