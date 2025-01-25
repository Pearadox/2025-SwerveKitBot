// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.IOException;

import com.pathplanner.lib.auto.AutoBuilder;
import com.pathplanner.lib.auto.NamedCommands;
import com.pathplanner.lib.commands.PathPlannerAuto;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.ControlOuttake;
import frc.robot.commands.SwerveDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.OuttakeSubsystem;
import frc.robot.Constants.OuttakeConstants;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public static final Drivetrain drivetrain = Drivetrain.getInstance();
  public static final OuttakeSubsystem outtake = new OuttakeSubsystem();


  public static final XboxController controller = new XboxController(0);

  private final JoystickButton resetHeading_B = new JoystickButton(controller, XboxController.Button.kB.value);
  private final JoystickButton runOuttake_A = new JoystickButton(controller, XboxController.Button.kA.value);

  //Auton Thingy
  private final SendableChooser<Command> autoChooser;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    registerNamedCommands();
    drivetrain.setDefaultCommand(new SwerveDrive(drivetrain));

    autoChooser = AutoBuilder.buildAutoChooser("Blue Right");
    SmartDashboard.putData("Auto Chooser", autoChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    resetHeading_B.onTrue(new InstantCommand(drivetrain::zeroHeading, drivetrain));
    runOuttake_A.onTrue(new ControlOuttake(() -> OuttakeConstants.OUTTAKE_EJECT_VELOCITY, () -> 0, outtake));
    runOuttake_A.onFalse(new ControlOuttake(() -> 0, () -> 0, outtake));
  }



  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   * @throws IOException
   */

  public Command getAutonomousCommand(){
    return autoChooser.getSelected();
  }

  public void registerNamedCommands() {
    NamedCommands.registerCommand(
      "Start Outtake", new ControlOuttake(() -> OuttakeConstants.OUTTAKE_EJECT_VELOCITY, () -> 0, outtake).withTimeout(1.0));
    NamedCommands.registerCommand(
      "Stop Outtake", new ControlOuttake(() -> 0, () -> 0, outtake));
  }
}
