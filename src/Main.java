interface Workable {
    void work();
}

class HumanWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is assembling...");
    }
}


class Manager {
    Workable human = new HumanWorker();
    Workable robot = new RobotWorker();

    void printHuman() {
        human.work();
    }

    void printRobot() {
        robot.work();
    }

}
public class Main {
    public static void main(String[] args) {
        Manager manager1 = new Manager();

        manager1.printHuman();
        manager1.printRobot();
    }
}
