package frc.robot.subsystems;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.DriveConstants.*;

public class CANDriveSubsystem extends SubsystemBase{
    //Initializes the motor controllers
    private final SparkMax leftLeader;
    private final SparkMax rightLeader;
    private final SparkMax leftFollower;
    private final SparkMax rightFollower;
    private final DifferentialDrive drive;
    
    public CANDriveSubsystem(){
        //Defines all the objects
        leftLeader = new SparkMax(leftLeaderID, MotorType.kBrushless);
        rightLeader = new SparkMax(rightLeaderID, MotorType.kBrushless);
        leftFollower = new SparkMax(leftFollowerID, MotorType.kBrushless);
        rightFollower = new SparkMax(rightFollowerID, MotorType.kBrushless);
        drive = new DifferentialDrive(leftLeader, rightLeader);

        //Sets the voltage and current
        SparkMaxConfig config = new SparkMaxConfig();
        config.voltageCompensation(Voltage);
        config.smartCurrentLimit(CurrentLimit);

        //Sets the timeout for the voltage going to the motors
        leftLeader.setCANTimeout(250);
        rightLeader.setCANTimeout(250);
        leftFollower.setCANTimeout(250);
        rightFollower.setCANTimeout(250);

        //Sets the followers  to follow the leader and also sets the reset and persist parameters for the followers and leaders
        config.follow(leftLeaderID);
        leftFollower.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        config.follow(rightLeaderID);
        rightFollower.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        config.disableFollowerMode();
        leftLeader.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        config.inverted(true);
        rightLeader.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    }
    @Override
    public void periodic(){

    }

    public void driveArcade(double xSpeed, double zRotation){
        drive.arcadeDrive(xSpeed, zRotation);
    }
}