// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Constants.driveConstants;

public class DriveSub extends SubsystemBase {

  private final WPI_VictorSPX sag1 = new WPI_VictorSPX(driveConstants.sag1ID);
  private final WPI_VictorSPX sag2 = new WPI_VictorSPX(driveConstants.sag2ID);
  private final WPI_VictorSPX sol1 = new WPI_VictorSPX(driveConstants.sol1ID);
  private final WPI_VictorSPX sol2 = new WPI_VictorSPX(driveConstants.sol2ID);
  private final DifferentialDrive diffrentialDrive = new DifferentialDrive(sol1, sag1);
  
  public DriveSub() {
    sag1.configFactoryDefault();
    sag2.configFactoryDefault();
    sol1.configFactoryDefault();
    sol2.configFactoryDefault();

    sag1.setInverted(true);
    sag2.setInverted(false);

    sol2.follow(sag1);  
    sag2.follow(sol1);
  }


  public void arcadeDrive(double spd,  double i){
    diffrentialDrive.arcadeDrive(-spd,-i);
  }

  @Override
  public void periodic() {
  }
  
}