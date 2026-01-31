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
    private static final int leftLeaderID = 0;
        private final SparkMax leftLeader;
        private final SparkMax rightLeader;
        private final SparkMax leftFollower;
        private final SparkMax rightFollower;
        private final DifferentialDrive drive;
    
        public CANDriveSubsystem(){
            leftLeader = new SparkMax(leftLeaderID, MotorType.kBrushless);
            rightLeader = new SparkMax(rightLeaderID, MotorType.kBrushless);
            leftFollower = new SparkMax(leftFollowerID, MotorType.kBrushless);
            rightFollower = new SparkMax(rightFollowerID, MotorType.kBrushless);
            drive = new DifferentialDrive(leftLeader, rightLeader);
            SparkMaxConfig config = new SparkMaxConfig();
            config.voltageCompensation(Voltage);
            config.smartCurrentLimit(CurrentLimit);
    }

}