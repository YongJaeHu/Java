/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author wengj
 */
public class ComLog {
    private String id;
    private String password;
    
    public boolean verify(String id, String password){
        return id.equals("comvac19")&&password.equals("Cov19f44");
    }
}
