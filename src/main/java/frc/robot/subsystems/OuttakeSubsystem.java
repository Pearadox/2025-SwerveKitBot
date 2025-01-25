package frc.robot.subsystems;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.lib.drivers.PearadoxSparkMax;
import frc.robot.Constants.OuttakeConstants;

public class OuttakeSubsystem extends SubsystemBase {
    private final PearadoxSparkMax outtakeMotor;

    public OuttakeSubsystem() {
        outtakeMotor = new PearadoxSparkMax(
            OuttakeConstants.OUTTAKE_MOTOR_ID, 
            PearadoxSparkMax.MotorType.kBrushed, 
            IdleMode.kBrake, 
            25, 
            false
        );

        outtakeMotor.setCANTimeout(250);
    }

    public void runMotor(double forward, double reverse) {
        outtakeMotor.set(forward - reverse);
    }

    public void stopMotor() {
        outtakeMotor.stopMotor();
    }

    @Override
    public void periodic() {
    }

}
