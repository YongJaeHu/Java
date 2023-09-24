/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author wengj
 */
public class Appt {
    public String id;
    public String ppname;
    public String centrename;
    public String time;    
    public String date;
    public String vacname;
    public String fstatus;
    public String sstatus;    
      
    public Appt(String id, String ppname, String centrename, String time,String date){
        this.id = id;
        this.ppname = ppname;
        this.centrename = centrename;        
        this.time = time;
        this.date = date;
    }

    public Appt(String id, String ppname, String centrename, String time,String date, String vacname, String fstatus, String sstatus){
        this.id = id;
        this.ppname = ppname;
        this.centrename = centrename;        
        this.time = time;
        this.date = date;
        this.vacname = vacname;
        this.fstatus = fstatus;
        this.sstatus = sstatus;
    }
    
    public Appt(String id, String time,String date, String vacname, String fstatus, String sstatus){
        this.id = id;      
        this.time = time;
        this.date = date;
        this.vacname = vacname;
        this.fstatus = fstatus;
        this.sstatus = sstatus;
    }    

    public Appt (){}
    
    public String toString(){
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s", id, ppname, centrename, time, date, vacname, fstatus, sstatus);
    }
    
    public Boolean addAppt (Appt newAppt){
        Appttxt Apptfile = new Appttxt();
        ArrayList<Appt> ApptList = Apptfile.getapptList();
        for(Appt ApptDatabase:ApptList){
            if(ApptDatabase.id.equals(newAppt.id)){
                return false;
            }          
        }    
        Apptfile.addAppt(newAppt);
        return true;
    }

    public void remAppt(String id){
        Appttxt Apptfile = new Appttxt();
        ArrayList<Appt> ApptList = Apptfile.getapptList();
        Iterator removeAppt = ApptList.iterator();
        while (removeAppt.hasNext()){
            Appt removedAppt = (Appt)removeAppt.next();
            if (removedAppt.id.equals(id)){
                removeAppt.remove();
            }
        }
        Apptfile.overwriteAppt(ApptList);
    } 

    public void modifyAppt(Appt newAppt){
        Appttxt Apptfile = new Appttxt();
        ArrayList<Appt> ApptList = Apptfile.getapptList();
        for(Appt item:ApptList){
            if(item.id.equals(newAppt.id)){
               item.time = newAppt.time;
               item.date = newAppt.date;
               item.vacname = newAppt.vacname;
               item.fstatus = newAppt.fstatus;
               item.sstatus = newAppt.sstatus;
            }
            Apptfile.overwriteAppt(ApptList);
        }
    }   
    
    public ArrayList<Appt> viewAppt(){
        Appttxt Apptfile = new Appttxt();
        ArrayList<Appt> ApptList = Apptfile.getapptList();
        return ApptList;
    }    
}
