package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.OuttakeSubsystem;


public class ControlOuttake extends Command {
    private final DoubleSupplier forward;
    private final DoubleSupplier reverse;
    private final OuttakeSubsystem outtake;

    public ControlOuttake(DoubleSupplier forward, DoubleSupplier reverse, OuttakeSubsystem outtake) {
        this.forward = forward;
        this.reverse = reverse;
        this.outtake = outtake;
        addRequirements(this.outtake);
    }

    @Override
    public void initialize() {
        SmartDashboard.putBoolean("Coral Out", false);
    }

    @Override
    public void execute() {
        // Run the roller motor at the desired speed
        outtake.runMotor(forward.getAsDouble(), reverse.getAsDouble());
        SmartDashboard.putBoolean("Coral Out", true);
    }

    @Override
    public void end(boolean isInterrupted) {
        outtake.stopMotor();
        SmartDashboard.putBoolean("Coral Out", false);
    }

    @Override
    public boolean isFinished() {
        return false;
    }

}
