/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;

/**
 *
 * @author wengj
 */
public class PpLog{
    private String Id;
    private String password;

    public PpLog(String Id, String password){
        this.Id = Id;
        this.password = password;
    }
   
    public PpLog (){}
    
    public String toString(){
        return String.format("%s,%s", Id, password);
    }        
    
    public PpLog login(String IdInput,String passwordInput){   
        Pptxt ppfile = new Pptxt();        
        PpLog ppLogin = null;        
        ArrayList<PpLog> ppLogList = ppfile.getppList();        
        for(PpLog databasepp: ppLogList){
            if(databasepp.Id.equals(IdInput)&& databasepp.password.equals(passwordInput)   ){
                ppLogin = databasepp;
            }
        }
        return ppLogin;
    }
    
    public Boolean regPpLog (PpLog newppLog){
        Pptxt ppfile = new Pptxt();
        ArrayList<PpLog> ppList = ppfile.getppList();
        for(PpLog ppDatabase:ppList){
            if(ppDatabase.Id.equals(newppLog.Id)){
                return false;
            }         
        }    
        ppfile.addpp(newppLog);
        return true;
    }
    
    public void editpwd(PpLog newPpLog){
        Pptxt ppfile = new Pptxt();
        ArrayList<PpLog> editpwd = ppfile.getppList();
        for(PpLog item:editpwd){
            if(item.Id.equals(newPpLog.Id)){
               item.password = newPpLog.password;
            }
            ppfile.overwritepp(editpwd);
        }
    } 
}
