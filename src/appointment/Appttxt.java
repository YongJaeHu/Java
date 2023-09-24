/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointment;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author wengj
 */
public class Appttxt {
    public ArrayList<Appt> getapptList(){
        ArrayList<Appt> ApptList = new ArrayList<Appt>();
        File ApptFile = new File("Appointment.txt");
        try(Scanner fileScanner = new Scanner(ApptFile)){
            while(fileScanner.hasNext()){
                String foundAppt = fileScanner.nextLine();
                String[] ApptDetails = foundAppt.split(",");
                Appt ApptObjects = new Appt(ApptDetails[0],ApptDetails[1],ApptDetails[2],ApptDetails[3],ApptDetails[4],ApptDetails[5],ApptDetails[6],ApptDetails[7]);
                ApptList.add(ApptObjects);
            }            
        }
        catch (FileNotFoundException ex){            
        }
        return ApptList;
    }
    
    
    public void addAppt(Appt newAppt){
      File ApptFile = new File("Appointment.txt");
      try(FileWriter fileWriter = new FileWriter(ApptFile, true)){
          try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
              try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                  printWriter.write(newAppt.toString());
                  bufferedWriter.newLine();
              }
          }
      }
      catch(IOException ex){          
      }
    }
    public void overwriteAppt(ArrayList<Appt> ApptList){
        File ApptFile = new File("Appointment.txt");
        try (FileWriter fileWriter = new FileWriter(ApptFile)){
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                    for(Appt editAppt:ApptList){
                        printWriter.write(editAppt.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
        }
        catch(IOException ex){            
        }
    }    
}
