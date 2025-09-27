// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.intakesubsystem;

public class intakeCommand extends Command{
  private intakesubsystem intake;
  private Double speed;
  public intakeCommand(intakesubsystem sub,Double spd){
    intake = sub;
    speed = spd;
addRequirements(sub); }
public intakeCommand() {
  // Use addRequirements() here to declare subsystem dependencies.
}

// Called when the command is initially scheduled.
@Override
public void initialize() {}

// Called every time the scheduler runs while the command is scheduled.
@Override
public void execute() {
  intake.intakeSpeed(speed);
}

// Called once the command ends or is interrupted.
@Override
public void end(boolean interrupted) {
intake.intakeSpeed(0.0);
}

// Returns true when the command should end.
@Override
public boolean isFinished() {
  return false;
}
}
