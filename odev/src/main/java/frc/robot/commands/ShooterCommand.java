

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooterSubsystem;

public class ShooterCommand extends Command {
  private shooterSubsystem shooter;
  private Double speed;
  public ShooterCommand(shooterSubsystem sub,Double spd) {
    shooter = sub;
    speed = spd;
    addRequirements(sub);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
   shooter.shooterspeed(speed);
  }

  @Override
  public void end(boolean interrupted) {
    shooter.shooterspeed(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
