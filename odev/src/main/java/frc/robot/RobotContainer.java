

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.ShooterCommand;
import frc.robot.commands.intakeCommand;
import frc.robot.subsystems.DriveSub;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.intakesubsystem;
import frc.robot.subsystems.shooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  private final XboxController controller = new XboxController(OperatorConstants.kDriverControllerPort);
  private final intakesubsystem intake = new intakesubsystem();
  private final shooterSubsystem shooter = new shooterSubsystem();
  private final DriveSub drive = new DriveSub();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

public RobotContainer(){
        drive.setDefaultCommand(new RunCommand(()-> drive.arcadeDrive(controller.getRawAxis(OperatorConstants.kRightY),controller.getRawAxis(OperatorConstants.kLeftX)),drive));
        configureBindings();
      }

  private void configureBindings() {
  while (controller.getAButtonPressed()==true){
  new intakeCommand(intake,0.7);
  }
  while (controller.getAButtonPressed()==false){
    new intakeCommand(intake,0.0);
    }
    while (controller.getAButtonPressed()==true){
      new ShooterCommand(shooter,0.7);  
      }
      while (controller.getAButtonPressed()==false){
        new ShooterCommand(shooter,0.0);  
        }
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

   
 
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }


  public Command getAutonomousCommand() {
  
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
