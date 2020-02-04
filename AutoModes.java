package frc.robot.auto;
import frc.robot.auto.setup.RobotFunction;
import frc.robot.auto.setup.RocketScript;
import frc.robot.auto.functions.collectBall;
import frc.robot.auto.functions.distanceDrive;
import frc.robot.auto.functions.shootBall;
import frc.robot.auto.functions.timeDrive;
import frc.robot.auto.functions.turnAngle;



public class AutoModes {
    private RocketScript rs;

    public void crossLineTime() {
        rs.addFunction(new timeDrive(2.0, 0.5));
    }

    public void crossLineDistance() {
        rs.addFunction(new distanceDrive(0.5,2.0));
    }

    public void startLeft() {
        rs.addFunction(new distanceDrive(-0.5,89)); //go backwards for 89 inches, distance of initiation line to wall-length of robot (33 inches)
        rs.addFunction(new shootBall(4.0)); //deposit balls (4 seconds)
        rs.addFunction(new distanceDrive(0.5,122));
        rs.addFunction(new turnAngle(0.5,90,true));
        rs.addFunction(new distanceDrive(0.5,39));
        rs.addFunction(new turnAngle(0.5,90,false));        
        rs.addFunction(new distanceDrive(0.5,89));
    }

    public void startRight() {
        rs.addFunction(new distanceDrive(0.5,125));
    }







}
