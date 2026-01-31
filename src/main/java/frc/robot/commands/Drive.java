package frc.robot.commands;
import frc.robot.subsystems.CANDriveSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import static frc.robot.Constants.DriveConstants.driverControllerPort;

public class Drive extends Command {
    CANDriveSubsystem JesseCAN;
    CommandXboxController driverController;
    public Drive(CommandXboxController controller, CANDriveSubsystem driver){
        addRequirements(driver);
        JesseCAN = driver;
        driverController = controller;
    }
}