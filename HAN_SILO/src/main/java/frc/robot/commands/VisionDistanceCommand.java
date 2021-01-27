package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.XboxConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.LimeLightSubsystem;

public class VisionDistanceCommand extends CommandBase {

    private final LimeLightSubsystem m_vision;
    private final DriveSubsystem m_drive;
    private final XboxController m_driverController;

    public VisionDistanceCommand(LimeLightSubsystem visionSubsystem, DriveSubsystem driveSubsystem, XboxController driveController){
        m_vision = visionSubsystem;
        m_drive = driveSubsystem;
        m_driverController = driveController;
    }

    @Override
    public void initialize(){
        m_drive.setVisionDistanceOverride(true);
        m_vision.enableLED();
    }

    @Override
    public void execute(){
        if(m_vision.hasTarget()){
            //Perhaps change the shooter motor speed to the optimal speed
        }
    }

    @Override
    public void end(boolean interrupted){
        m_drive.setVisionDistanceOverride(false);
        m_vision.disableLED();
    }

    @Override
    public boolean isFinished(){
        //When the left bumper is released, stop the command
        return !m_driverController.getRawButton(XboxConstants.kLBumper);
    } 

}