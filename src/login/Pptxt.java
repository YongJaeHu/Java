/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

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
public class Pptxt {
    
    public ArrayList<PpLog> getppList(){
        ArrayList<PpLog> ppList = new ArrayList<PpLog>();
        File pplogFile = new File("PeopleID.txt");
        try(Scanner fileScanner = new Scanner(pplogFile)){
            while(fileScanner.hasNext()){
                String foundpp = fileScanner.nextLine();
                String[] ppLogDetails = foundpp.split(",");
                PpLog ppLogObjects = new PpLog(ppLogDetails[0],ppLogDetails[1]);
                ppList.add(ppLogObjects);
            }            
        }
        catch (FileNotFoundException ex){            
        }
        return ppList;
    }
    
    
    public void addpp(PpLog newppLog){
      File ppLogFile = new File("PeopleID.txt");
      try(FileWriter fileWriter = new FileWriter(ppLogFile, true)){
          try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
              try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                  printWriter.write(newppLog.toString());
                  bufferedWriter.newLine();
              }
          }
      }
      catch(IOException ex){          
      }
    }
    
    public void overwritepp(ArrayList<PpLog> ppList){
        File ppLogFile = new File("PeopleID.txt");
        try (FileWriter fileWriter = new FileWriter(ppLogFile)){
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                    for(PpLog editpwd:ppList){
                        printWriter.write(editpwd.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
        }
        catch(IOException ex){            
        }
    }    
}
