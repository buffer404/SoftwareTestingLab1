package task3;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class RobotTest {

    @Test
    public void alreadyWithTrillian() {
        ArrayList<Creature> peopleIn = new ArrayList<>();
        peopleIn.add(new Human("Trillian"));
        Room room = new Room(false, peopleIn);
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, room);
        Assert.assertTrue(robot.findTrillian(null) == room);
    }

    @Test
    public void noTrillianAtAll() {
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, new Room(true, new ArrayList<>()));
        RobotException thrown = Assertions
                .assertThrows(RobotException.class, () -> {
                    robot.goToTrillianRoom(null);
                }, "RobotException was excepted");
        Assertions.assertEquals("Триллиан нигде нет(", thrown.getMessage());
    }

    @Test
    public void robotInLockedRoom() {
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, new Room(true, new ArrayList<>()));
        ArrayList<Creature> peopleIn = new ArrayList<>();
        peopleIn.add(new Human("Trillian"));
        Room room = new Room(false, peopleIn);
        RobotException thrown = Assertions
                .assertThrows(RobotException.class, () -> {
                    robot.goToTrillianRoom(room);
                }, "RobotException was excepted");
        Assertions.assertEquals("Не могу выйти из первой комнаты", thrown.getMessage());
    }

    @Test
    public void trillianRoomIsLocked() {
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, new Room(false, new ArrayList<>()));
        ArrayList<Creature> peopleIn = new ArrayList<>();
        peopleIn.add(new Human("Trillian"));
        Room room = new Room(true, peopleIn);
        RobotException thrown = Assertions
                .assertThrows(RobotException.class, () -> {
                    robot.goToTrillianRoom(room);
                }, "RobotException was excepted");
        Assertions.assertEquals("Комната Триллиан закрыта", thrown.getMessage());
    }

    @Test
    public void goToTrillianRoom() throws Exception {
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, new Room(false, new ArrayList<>()));
        ArrayList<Creature> peopleIn = new ArrayList<>();
        peopleIn.add(new Human("Trillian"));
        Room room = new Room(false, peopleIn);
        robot.goToTrillianRoom(room);
        Assert.assertTrue(robot.getCurrentRoom() == room);
        Assert.assertTrue(robot.getCurrentRoom().getPeopleIn().size() == 2);
    }

    @Test
    public void toEndTest() throws Exception {
        Room robotRoom = new Room(false, new ArrayList<>());
        Robot robot = new Robot(RobotState.SIT, LocationInRoom.IN_THE_CORNER, robotRoom);
        ArrayList<Creature> noTrillinaPeopleIn = new ArrayList<>();
        noTrillinaPeopleIn.add(new Human("NOTrillian"));
        Room noTrillianRoom = new Room(false, noTrillinaPeopleIn);
        ArrayList<Creature> trillinaPeopleIn = new ArrayList<>();
        trillinaPeopleIn.add(new Human("Trillian"));
        Room trillianRoom = new Room(false, trillinaPeopleIn);
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(noTrillianRoom);
        rooms.add(trillianRoom);
        robot.goToTrillianRoom(robot.findTrillian(new Area(rooms)));
        Assert.assertTrue(robot.getCurrentRoom() == trillianRoom);
        robot.go();
        Watcher watcher = new Watcher();
        Assert.assertTrue(watcher.watch(robot).getTryValue() == TryValue.HEROIC);
        robot.stop();
        Assert.assertTrue(robot.watch().equals("Вижу плечо"));
    }
}
