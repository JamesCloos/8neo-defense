package raidzero.frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Base {
    private static CANSparkMax LDrive[] = new CANSparkMax[4];
    private static CANSparkMax RDrive[] = new CANSparkMax[4];
    private static final boolean REVERSED_GEARBOX = false;

    public static void init() {
            LDrive[0] = new CANSparkMax(8, MotorType.kBrushless);
            LDrive[1] = new CANSparkMax(1 , MotorType.kBrushless);
            RDrive[0] = new CANSparkMax(2, MotorType.kBrushless);
            RDrive[1] = new CANSparkMax(3, MotorType.kBrushless);
            LDrive[2] = new CANSparkMax(4 , MotorType.kBrushless);
            LDrive[3] = new CANSparkMax(5 , MotorType.kBrushless);
            RDrive[2] = new CANSparkMax(6, MotorType.kBrushless);
            RDrive[3] = new CANSparkMax(7, MotorType.kBrushless);
        for(int i = 1; i < 4; i++) {
            LDrive[i].setIdleMode(IdleMode.kBrake);
            RDrive[i].setIdleMode(IdleMode.kBrake);
            LDrive[i].follow(LDrive[0],false);
            RDrive[i].follow(RDrive[0],false);
        }
    }
    
    public static void run(double lPower, double rPower) {
            LDrive[0].set(lPower);
            RDrive[0].set(-rPower);
            //LDrive[0].set(0);
            //RDrive[0].set(0);
    }
}