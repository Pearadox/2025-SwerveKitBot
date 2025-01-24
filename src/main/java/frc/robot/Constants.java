// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final double FIELD_WIDTH_METERS = 8.02;
    public static final double FIELD_LENGTH_METERS = 16.4846;

    public static final class OuttakeConstants {
        //Outtake motor ID
        public static final int OUTTAKE_MOTOR_ID = 34;

        //Outtake characteristics
        public static final double OUTTAKE_EJECT_VELOCITY = 0.5;
    }

    public static final class SwerveConstants{
        //Drivetrain motor/encoder IDs
        public static final int LEFT_FRONT_DRIVE_ID = 1;
        public static final int RIGHT_FRONT_DRIVE_ID = 2;
        public static final int LEFT_BACK_DRIVE_ID = 3;
        public static final int RIGHT_BACK_DRIVE_ID = 4;
        
        public static final int LEFT_FRONT_TURN_ID = 5;
        public static final int RIGHT_FRONT_TURN_ID = 6;
        public static final int LEFT_BACK_TURN_ID = 7;
        public static final int RIGHT_BACK_TURN_ID = 8;
        
        public static final int LEFT_FRONT_CANCODER_ID = 11;
        public static final int RIGHT_FRONT_CANCODER_ID = 12;
        public static final int LEFT_BACK_CANCODER_ID = 13;
        public static final int RIGHT_BACK_CANCODER_ID = 14;

        //Drivetrain characteristics
        public static final double LEFT_FRONT_OFFSET = -0.080; // from -0.080
        public static final double RIGHT_FRONT_OFFSET = -0.221; // from -0.221
        public static final double LEFT_BACK_OFFSET = 0.280; // from 0.280
        public static final double RIGHT_BACK_OFFSET = 0.237; // from 0.237

        public static final double WHEEL_DIAMETER = Units.inchesToMeters(3);
        public static final double DRIVE_MOTOR_GEAR_RATIO = 5.25;
        public static final double TURN_MOTOR_GEAR_RATIO = 55.965;
        public static final double DRIVE_MOTOR_PCONVERSION = Math.PI * WHEEL_DIAMETER / DRIVE_MOTOR_GEAR_RATIO;
        public static final double TURN_MOTOR_PCONVERSION = 2 * Math.PI / TURN_MOTOR_GEAR_RATIO;
        public static final double DRIVE_MOTOR_VCONVERSION = DRIVE_MOTOR_PCONVERSION;
        public static final double TURN_MOTOR_VCONVERSION = TURN_MOTOR_PCONVERSION / 60.0;
        public static final double KP_TURNING = 0.7;

        public static final double DRIVETRAIN_MAX_SPEED = 5.266;
        public static final double DRIVETRAIN_MAX_ANGULAR_SPEED = 3.6 * Math.PI;

        //Teleop constraints
        public static final double TELE_DRIVE_MAX_SPEED = DRIVETRAIN_MAX_SPEED / 1;
        public static final double TELE_DRIVE_MAX_ANGULAR_SPEED = DRIVETRAIN_MAX_ANGULAR_SPEED / 1.5;
        public static final double TELE_DRIVE_MAX_ACCELERATION = 3;
        public static final double TELE_DRIVE_MAX_ANGULAR_ACCELERATION = 3;

        //Auton constraints
        public static final double AUTO_DRIVE_MAX_SPEED = DRIVETRAIN_MAX_SPEED / 1.5;
        public static final double AUTO_DRIVE_MAX_ANGULAR_SPEED = DRIVETRAIN_MAX_ANGULAR_SPEED / 5;
        public static final double AUTO_DRIVE_MAX_ACCELERATION = 3;
        public static final double AUTO_DRIVE_MAX_ANGULAR_ACCELERATION = Math.PI / 2;

        public static final double AUTO_kP_FRONT = 0.5;
        public static final double AUTO_kP_SIDE = 0.5;
        public static final double AUTO_kP_TURN = 0.2;

        public static final TrapezoidProfile.Constraints AUTO_TURN_CONTROLLER_CONSTRAINTS = new TrapezoidProfile.Constraints(
                AUTO_DRIVE_MAX_ANGULAR_SPEED,
                AUTO_DRIVE_MAX_ANGULAR_ACCELERATION);

        //Swerve Kinematics
        public static final double TRACK_WIDTH = Units.inchesToMeters(18.0);
        public static final double WHEEL_BASE = Units.inchesToMeters(17.0);
        public static final SwerveDriveKinematics DRIVE_KINEMATICS = new SwerveDriveKinematics(
            new Translation2d(WHEEL_BASE / 2, TRACK_WIDTH / 2),
            new Translation2d(WHEEL_BASE / 2, -TRACK_WIDTH / 2),
            new Translation2d(-WHEEL_BASE / 2, TRACK_WIDTH / 2),
            new Translation2d(-WHEEL_BASE / 2, -TRACK_WIDTH / 2)
        );
    }
}
