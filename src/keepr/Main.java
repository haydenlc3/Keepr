/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keepr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.stage.FileChooser;

/**
 *
 * @author HLC
 */
public class Main {
    public static void main(String args[]) {
        File selectedFile;
        boolean run = true;
        Keepr keepr = new Keepr();
        Scanner keyboard = new Scanner(System.in);
        
        while (run) {
            System.out.println("Enter a command: ");
            String inp = keyboard.next();
            
            if (inp.equals("commands")) {
                System.out.println();
            } else if (inp.equals("open")) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Select .txt files");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".txt", "*.txt", ".file", "*.file"));
                selectedFile = fileChooser.showOpenDialog(null);

                if (selectedFile != null) {
                    System.out.println("Opened");
                    File file = new File(selectedFile.getAbsolutePath());
                    try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        keepr.setKeepr((ArrayList<Password>) ois.readObject());
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    System.out.println("Cancelled");
                }
            } else if (inp.equals("save")) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save file");
                fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter(".txt", "*.txt", ".file", "*.file"));
                selectedFile = fileChooser.showSaveDialog(null);

                if (selectedFile != null) {
                    ObjectOutputStream oos = null;
                    try {
                        System.out.println("Saved");
                        File file = new File (selectedFile.getAbsolutePath());
                        oos = new ObjectOutputStream(new FileOutputStream(file));
                        oos.writeObject(keepr.getData());
                        oos.flush();
                        oos.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            oos.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    System.out.println("Cancelled");
                }
            }
        }
    }
}
