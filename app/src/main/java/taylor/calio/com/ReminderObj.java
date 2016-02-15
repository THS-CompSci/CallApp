package taylor.calio.com;

/**
 * Created by c0302006 on 2/15/2016.
 */
public class ReminderObj {
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;
    private String alarm;
    private boolean active;



    public ReminderObj(){
        title="";
        description="";
        date="";
        time="";
        location="";
        alarm="";
        active=false;

    }
    public ReminderObj(String title,String description, String date, String time, String location, String alarm, boolean bool){
        this.title=title;
        this.description=description;
        this.date=date;
        this.time=time;
        this.location=location;
        this.alarm=alarm;
        this.active=bool;
    }

    public void setTitle(String str){
        title=str;
    }
    public void setDescription(String str){
        description=str;
    }
    public void setDate(String str){
        date=str;
    }
    public void setTime(String str){
        time=str;
    }
    public void setLocation(String str){
        location=str;
    }
    public void setAlarm(String str){
        alarm=str;
    }
    public void setActive(boolean bool){
        active=bool;
    }
    public String getTitle(){
        return title;
    }
    public String getDescription(){
        return description;
    }
    public String getDate(){
        return date;
    }
    public String getTime(){
        return time;
    }
    public String getLocation(){
        return location;
    }
    public String getAlarm(){
        return alarm;
    }
    public boolean getActive(){
        return active;
    }


}
