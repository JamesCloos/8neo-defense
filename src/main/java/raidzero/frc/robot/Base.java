    
package raidzero.frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Base {
    private static CANSparkMax LDrive[] = new CANSparkMax[4];
    private static CANSparkMax RDrive[] = new CANSparkMax[4];
    private static final boolean REVERSED_GEARBOX = false;
    // there was a weird rev update where CAN ID may not be 0
    public static void init() {
            LDrive[0] = new CANSparkMax(8, MotorType.kBrushless);
            LDrive[1] = new CANSparkMax(1 , MotorType.kBrushless);
            RDrive[0] = new CANSparkMax(2, MotorType.kBrushless);
            RDrive[1] = new CANSparkMax(3, MotorType.kBrushless);
            LDrive[2] = new CANSparkMax(4 , MotorType.kBrushless);
            LDrive[3] = new CANSparkMax(5 , MotorType.kBrushless);
            RDrive[2] = new CANSparkMax(6, MotorType.kBrushless);
            RDrive[3] = new CANSparkMax(7, MotorType.kBrushless);
        for(int i = 0; i < 4; i++) {
            LDrive[i].setOpenLoopRampRate(1);
            RDrive[i].setOpenLoopRampRate(1);
            LDrive[i].setSmartCurrentLimit(40, 20);
            RDrive[i].setSmartCurrentLimit(40, 20);
            LDrive[i].setSecondaryCurrentLimit(45);
            RDrive[i].setSecondaryCurrentLimit(45);
            LDrive[i].setIdleMode(IdleMode.kBrake);
            RDrive[i].setIdleMode(IdleMode.kBrake);
            LDrive[i].burnFlash();
            RDrive[i].burnFlash();
        }
        for(int i = 1; i < 4; i++) {
            LDrive[i].follow(LDrive[0],false);
            RDrive[i].follow(RDrive[0],false);
        }
    }
    
    public static void run(double lPower, double rPower) {
            LDrive[0].set(Math.pow(lPower, 2)*(lPower/Math.abs(lPower)));
            RDrive[0].set(-1*Math.pow(rPower, 2)*(rPower/Math.abs(rPower)));
            //LDrive[0].set((lPower/Math.abs(lPower))*Math.sqrt(Math.abs(lPower)*0.5));
            //RDrive[0].set(-(rPower/Math.abs(rPower))*Math.sqrt(Math.abs(rPower))*0.5);
            //LDrive[0].set(0);
            //RDrive[0].set(0);
    }
}
