package frc.robot.auto.functions;
 
import frc.robot.auto.setup.RobotFunction;
import frc.robot.subsystems.Drivetrain;

// Drives straight for period of time 
public class turnAngle extends RobotFunction {
    

    private double startAngle, speed, targetAngle, turnAngle;
    private boolean direction;
    // for our purposes, true is left and false is right
    AHRS navx;
 
    public turnAngle(double speed, double turnAngle, boolean direction) {
        this.speed = speed;
        this.turnAngle=turnAngle;
        navx = new AHRS(); //port number needed
    }
    @Override
    public void init() {
        startAngle = navx.getRoll();
        if(direction==true){
            if(startAngle-turnAngle>=-180){
                targetAngle=startAngle-turnAngle;
                }
            if(startAngle-turnAngle<-180){
                double overFlow = turnAngle-startAngle+180;
                targetAngle=180+overFlow;
                }

        }
        if(direction==false){
            if(startAngle+turnAngle<=180){
                targetAngle=startAngle+turnAngle;
                }
            if(startAngle+turnAngle>180){
                double overFlow = turnAngle+startAngle-180;
                targetAngle=-180+overFlow;
                }
        }

    }
    @Override
    public void run() {
        if(direction==true)
            Drivetrain.tankDrive(-speed,speed);
        if(direction==false)
            Drivetrain.tankDrive(speed,-speed);
    }
    @Override
    public boolean isFinished() {
        return navx.getRoll() == targetAngle;
    }
    @Override
    public void stop(){
        Drivetrain.tankDrive(0.0,0.0);
    }
 
 
}