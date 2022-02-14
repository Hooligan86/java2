import javax.swing.plaf.TableHeaderUI;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(100, 20);
        Robot robot = new Robot(200, 300);
        Human human = new Human(30, 10);
        List<Action> participants = new ArrayList<>();
        participants.add(cat);
        participants.add(robot);
        participants.add(human);

        Wall wall = new Wall(21);
        Treadmill treadmill = new Treadmill(120);
        List<Obstacle> obstacles = new ArrayList<>();
        obstacles.add(wall);
        obstacles.add(treadmill);

        for (Action participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if(obstacle instanceof Wall){
                    Wall wall1 = (Wall)obstacle;
                    if(participant.jump() > wall1.getHeight()){
                        System.out.println("The " + participant.getClass().getName() + " pass the obstacle");
                    }else{
                        System.out.println("The " + participant.getClass().getName() + " didn't pass the obstacle and out from competition");
                        break;
                    }
                }else{
                    Treadmill treadmill1 = (Treadmill) obstacle;
                    if(participant.run() > treadmill1.getLength()){
                        System.out.println("The " + participant.getClass().getName() + " the pass obstacle");
                    }else{
                        System.out.println("The " + participant.getClass().getName() + " didn't pass the obstacle and out from competition");
                    }
                }
            }

        }
    }
}
