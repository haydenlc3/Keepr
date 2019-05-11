/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keepr;

import java.util.ArrayList;

/**
 *
 * @author HLC
 */
public class Keepr {
    private ArrayList<Password> keepr;
    
    public Keepr() {
        keepr = new ArrayList<>();
    }
    
    public void addPassword(Password pass) {
        keepr.add(pass);
    }
    
    public void addPassword(String user, String pass, String site, String email) {
        keepr.add(new Password(user, pass, site, email));
    }
    
    public void setKeepr(ArrayList<Password> keepr) {
        this.keepr.clear();
        
        for (Password entry: keepr) {
            this.keepr.add(entry);
        }
    }
    
    public void removePassword(int index) {
        keepr.remove(index);
    }
    
    public void removeAll() {
        keepr.clear();
    }
    
    public ArrayList<Password> getData() {
        return keepr;
    }
    
    public String getLatestDate() {
        return keepr.get(keepr.size()-1).getDate();
    }
}
