package frc.robot.subsystems;

import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;
import static frc.robot.Constants.DriveConstants.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CANFuelSubsystem extends SubsystemBase{
    //Initializes the motor controllers
    private final SparkMax intake;
    private final SparkMax shooter;
    
    public CANFuelSubsystem(){
        //Defines all the objects
        intake = new SparkMax(intakeID, MotorType.kBrushless);
        shooter = new SparkMax(shooterID, MotorType.kBrushless);

        //Sets the voltage and current
        SparkMaxConfig config = new SparkMaxConfig();
        config.voltageCompensation(Voltage);
        config.smartCurrentLimit(CurrentLimit);

        //Sets the timeout for the voltage going to the motors
        intake.setCANTimeout(250);
        shooter.setCANTimeout(250);

        //Sets the reset and persist parameters for the intake and shooter
        intake.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
        shooter.configure(config,ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    }

    //Able to change speed of intake by voltage output
    public void setVoltageIntake(double Output){
        intake.setVoltage(Output);
    }

    //Able to change speed of shooter b voltage output
    public void setVoltageShooter(double Output){
        shooter.setVoltage(Output);
    }

    //Use to stop shooter's motor
    public void stopMotorShooter(){
        shooter.stopMotor();
    }

    //Use to stop intake's motor
    public void stopMotorIntake(){
        intake.stopMotor();
    }

    @Override
    public void periodic(){
    }
}