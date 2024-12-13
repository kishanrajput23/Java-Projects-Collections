/**
 * Kazunori Hayashi
* Version 1.0 29/7/2013
 */
import java.util.*;
import java.text.*;

public abstract class Staff
{
    private int ID;
    private String lastName;
    private String firstName;
    private String password;
    private byte    state;
    
    private Order[] orderList;

    //protected byte  workState;  //0:not active  1:active (on wark)  2:finish work
    protected Date  startWorkTime;
    protected Date  finishWorkTime;
    protected double    wageRate;

    //------------------------------------------------------------
    // constructor
    //------------------------------------------------------------
    public Staff()
    {
        ID = 0;
        lastName="";
        firstName="";
        startWorkTime = null;
        finishWorkTime = null;
        state = 0;
    }
    
    public Staff( int newID, String newLastName, String newFirstName, String newPassword)
    {
        setID( newID);
        setLastName(newLastName);
        setFirstName(newFirstName);
        setPassword( newPassword);
        startWorkTime = null;
        finishWorkTime = null;
        state = 0;
        //workState = 0;
    }
 
    //------------------------------------------------------------
    // setter
    //------------------------------------------------------------
    protected void setID( int newID)
    {
        this.ID = newID;
    }
    protected void setLastName(String newLastName)
    {
        this.lastName = newLastName;
    }
    protected void setFirstName(String newFirstName)
    {
        this.firstName = newFirstName;
    }
    protected void setPassword(String newPassword)
    {
        this.password = newPassword;
    }
    protected void setWorkState(byte newState)
    {
        this.state = newState;
    }

    /*protected void setState(byte newState)
    {
        this.workState = newState;
    }*/
    //------------------------------------------------------------
    // getter
    //------------------------------------------------------------
    public int getID()
    {
        return this.ID;
    }
    public String getLastName()
    {
        return this.lastName;
    }
    public String getFirstName()
    {
        return this.firstName;
    }
    public String getFullName()
    {
        String fullName = this.firstName + " " + this.lastName;
        return fullName;
    }
    public String getPassword()
    {
        return this.password;
    }
    public double getWageRate()
    {
        return this.wageRate;
    }
    
    public static final byte WORKSTATE_NON_ACTIVE = 0;
    public static final byte WORKSTATE_ACTIVE = 1;
    public static final byte WORKSTATE_FINISH = 2;
    public byte getWorkState()
    {
        return this.state;
    }
    
    public String getStartTime()
    {
        if(startWorkTime == null)
            return "getStartTime Error";
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(startWorkTime);
    }
    
    public String getFinishTime()
    {
        if(finishWorkTime == null)
            return "getFinishTime Error";
        DateFormat df = new SimpleDateFormat("HH:mm");
        return df.format(finishWorkTime);
    }
    //------------------------------------------------------------
    // other methods
    //------------------------------------------------------------
    public void clockIn()
    {
        startWorkTime = new Date(System.currentTimeMillis());
        state = WORKSTATE_ACTIVE;
    }
    
    public boolean clockOut()
    {
        if(state != WORKSTATE_ACTIVE)
            return false;
        finishWorkTime = new Date(System.currentTimeMillis());
        state = WORKSTATE_FINISH;
        return true;
    }
    
    public boolean changeStartTime(Date newStartTime)
    {
        if(state == WORKSTATE_FINISH && newStartTime.after(finishWorkTime))
        {
            return false;
        }
        
        if( newStartTime.after(new Date(System.currentTimeMillis())))
        {
            return false;
        }

        startWorkTime = newStartTime;
        return true;
    }
    
    public boolean changeFinishTime(Date newFinishTime)
    {
        if(newFinishTime.before(startWorkTime))
        {
            return false;
        }
        
        if( newFinishTime.after(new Date(System.currentTimeMillis())))
        {
            return false;
        }
        
        finishWorkTime = newFinishTime;
        return true;
    }
    
    public double culculateWorkTime()
    {
        if(getWorkState() != WORKSTATE_FINISH)
            return 0;
            
        long diffTimeMin = (finishWorkTime.getTime() - startWorkTime.getTime()) / 60000;//convert Milli sec to Minutes
        long  baseTime = diffTimeMin / 60;
        long  fraction = diffTimeMin % 60;
        double addTime;
        
        if( fraction < 15)
            addTime = 0;
        else if(fraction < 30)
            addTime = 0.25;
        else if(fraction < 45)
            addTime = 0.5;
        else
            addTime = 0.75;  
        
        double workTime = (double)baseTime + addTime;
        return workTime;
    }
    
    protected abstract void setWageRate(double newRate);
    protected abstract double culculateWages();
}
