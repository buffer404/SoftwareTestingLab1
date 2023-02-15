package task3;

public class Robot {
    private RobotState robotState;
    private Location location;

    public Robot(RobotState robotState, Location location) {
        this.robotState = robotState;
        this.location = location;
    }

    public void sit() {
        robotState = RobotState.SIT;
        location = Location.IN_THE_CORNER;
    }

    public void stand() {
        robotState = RobotState.STAND;
    }

    public void go() {
        robotState = RobotState.GO;
        location = Location.CROSSING_THE_ROOM;
    }

    public void stop() {
        robotState = RobotState.STAND;
        location = Location.IN_FRONT_OF_TRILLIAN;
    }

    public String watch() {
        return "Вижу плечо хз";
    }

    public RobotState getRobotState() {
        return robotState;
    }

    public Location getLocation() {
        return location;
    }
}
