package frc.robot.auto.functions;
 
import edu.wpi.first.wpilibj.Timer;
import frc.robot.auto.setup.RobotFunction;
import frc.robot.subsystems.Drivetrain;
 
// Drives straight for period of time
 
public class shootBall extends RobotFunction {
 
    private double startTime, speed, time;
 
    public shootBall(double time) {
        this.time = time;
    }
    @Override
    public void init() {
        startTime = Timer.getFPGATimestamp();
    }
    @Override
    public void run() {
        //PrettyPrint.put("Ball Outtake Elapsed");
        Wheels.spinShooter();
    }
    @Override
    public boolean isFinished() {
        return Timer.getFPGATimestamp() - startTime > time;
    }
    @Override
    public void stop(){
        Wheels.stopShooter();
    }
 
 
}
