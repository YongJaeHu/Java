/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopledetail;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author wengj
 */
public class PpDet {  
    public String id;
    public String ppname;
    public String states;
    public String identity;
        

    public PpDet(String id, String ppname, String states, String identity){
        this.id = id;
        this.ppname = ppname;
        this.states = states;
        this.identity = identity;
    }

    public PpDet(String id, String states){
        this.id = id;
        this.states = states;
    }       
    
    public PpDet (){}
    
    public String toString(){
        return String.format("%s,%s,%s,%s", id, ppname, states, identity);
    }
    
    public Boolean addPpDet (PpDet newPpDet){
        PpDettxt ppDetfile = new PpDettxt();
        ArrayList<PpDet> ppDetList = ppDetfile.getppDetList();
        for(PpDet ppDetDatabase:ppDetList){
            if(ppDetDatabase.id.equals(newPpDet.id)){
                return false;
            }         
        }      
        ppDetfile.addppDet(newPpDet);
        return true;
    }

    public void remPpDet(String id){
        PpDettxt ppDetfile = new PpDettxt();
        ArrayList<PpDet> ppDetList = ppDetfile.getppDetList();
        Iterator removePpDet = ppDetList.iterator();
        while (removePpDet.hasNext()){
            PpDet removedPpDet = (PpDet)removePpDet.next();
            if (removedPpDet.id.equals(id)){
                removePpDet.remove();
            }
        }
        ppDetfile.overwriteppDet(ppDetList);
    } 

    public void modifyPpDet(PpDet newPpDet){
        PpDettxt ppDetfile = new PpDettxt();
        ArrayList<PpDet> ppDetList = ppDetfile.getppDetList();
        for(PpDet item:ppDetList){
            if(item.id.equals(newPpDet.id)){
               item.states = newPpDet.states;
            }
            ppDetfile.overwriteppDet(ppDetList);
        }
    }   
    
    public ArrayList<PpDet> viewPpDet(){
        PpDettxt ppDetfile = new PpDettxt();
        ArrayList<PpDet> ppDetList = ppDetfile.getppDetList();
        return ppDetList;
    }    
}
