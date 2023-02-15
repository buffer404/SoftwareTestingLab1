package task3;

public class Watcher {
    public Try watch(Robot robot) {
        if (robot.getRobotState() == RobotState.GO && robot.getLocation() == Location.CROSSING_THE_ROOM) {
            return new Try(TryValue.HEROIC);
        }
        else return new Try(TryValue.ORDINARY);
    }
}
