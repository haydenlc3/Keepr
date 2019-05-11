/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keepr;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author HLC
 */
public class Password implements java.io.Serializable {
    private String user;
    private String pass;
    private String site;
    private String date;
    private String email;
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    
    public Password(String user, String pass, String site, String email) {
        this.user = user;
        this.pass = pass;
        this.site = site;
        this.email = email;
        
        Date date1 = new Date();  
        date = formatter.format(date1);  
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDate() {
        return date;
    }

    public void setDate() {
        Date date1 = new Date();  
        date = formatter.format(date1);
    }
}
