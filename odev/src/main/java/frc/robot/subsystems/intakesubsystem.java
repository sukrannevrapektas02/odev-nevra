// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.intakeConstants;

public class intakesubsystem extends SubsystemBase {
private final SparkMax Motor1 = new SparkMax(intakeConstants.intakeNeo1,MotorType.kBrushless);
private final SparkMax Motor2 = new SparkMax(intakeConstants.intakeNeo2,MotorType.kBrushless);
  public intakesubsystem() {}
public void intakeSpeed(Double spd){
  Motor1.set(spd);
  Motor2.set(-spd);
}
  @Override
  public void periodic() {
    
  }
}
