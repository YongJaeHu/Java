/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccine;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author wengj
 */
public class Vac {   
    public String id;
    public String vacname;
    public String vacid;
    public String centrename;
    public String quantity;

    public Vac(String id, String vacname, String vacid, String centrename, String quantity){
        this.id = id;
        this.vacname = vacname;
        this.vacid = vacid;
        this.centrename = centrename;
        this.quantity = quantity;
    }

    public Vac(String id, String quantity){
        this.id = id;
        this.quantity = quantity;
    }    
   
    public Vac (){}
    
    public String toString(){
        return String.format("%s,%s,%s,%s,%s", id, vacname, vacid, centrename, quantity);
    }    
    
    public Boolean addVac (Vac newVac){
        Vactxt vacfile = new Vactxt();
        ArrayList<Vac> vacList = vacfile.getvacList();
        for(Vac vacDatabase:vacList){
            if(vacDatabase.id.equals(newVac.id)){
                return false;
            }        
        }    
        vacfile.addvac(newVac);
        return true;
    }

    public void delVac(String id){
        Vactxt vacfile = new Vactxt();
        ArrayList<Vac> vacList = vacfile.getvacList();
        Iterator deleteVac = vacList.iterator();
        while (deleteVac.hasNext()){
            Vac deletedVac = (Vac)deleteVac.next();
            if (deletedVac.id.equals(id)){
                deleteVac.remove();
            }
        }
        vacfile.overwritevac(vacList);
    }    
    
    public void modifyVac(Vac newVac){
        Vactxt vacfile = new Vactxt();
        ArrayList<Vac> vacList = vacfile.getvacList();
        for(Vac item:vacList){
            if(item.id.equals(newVac.id)){
               item.quantity = newVac.quantity;
            }
            vacfile.overwritevac(vacList);
        }
    }     
    
    public ArrayList<Vac> viewVac(){
        Vactxt vacfile = new Vactxt();
        ArrayList<Vac> vacList = vacfile.getvacList();
        return vacList;
    }

}
