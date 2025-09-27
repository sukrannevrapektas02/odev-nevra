// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.shooterConstants;

public class shooterSubsystem extends SubsystemBase {
private final SparkMax Motor3 = new SparkMax(shooterConstants.shooterNeo1,MotorType.kBrushless);
private final SparkMax Motor4 = new SparkMax(shooterConstants.shooterNeo2,MotorType.kBrushless);
  public shooterSubsystem() {}
public void shooterspeed(Double spd){
  Motor3.set(spd);
  Motor4.set(-spd);
}

  @Override
  public void periodic() {
    
  }
}
