/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peopledetail;

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
public class PpDettxt {
    public ArrayList<PpDet> getppDetList(){
        ArrayList<PpDet> ppDetList = new ArrayList<PpDet>();
        File ppDetFile = new File("PeopleDetail.txt");
        try(Scanner fileScanner = new Scanner(ppDetFile)){
            while(fileScanner.hasNext()){
                String foundppDet = fileScanner.nextLine();
                String[] ppDetDetails = foundppDet.split(",");
                PpDet ppDetObjects = new PpDet(ppDetDetails[0],ppDetDetails[1],ppDetDetails[2],ppDetDetails[3]);
                ppDetList.add(ppDetObjects);
            }            
        }
        catch (FileNotFoundException ex){            
        }
        return ppDetList;
    }
    
    
    public void addppDet(PpDet newPpDet){
      File ppDetFile = new File("PeopleDetail.txt");
      try(FileWriter fileWriter = new FileWriter(ppDetFile, true)){
          try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
              try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                  printWriter.write(newPpDet.toString());
                  bufferedWriter.newLine();
              }
          }
      }
      catch(IOException ex){          
      }
    }
    public void overwriteppDet(ArrayList<PpDet> ppDetList){
        File ppDetFile = new File("PeopleDetail.txt");
        try (FileWriter fileWriter = new FileWriter(ppDetFile)){
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                    for(PpDet editppDet:ppDetList){
                        printWriter.write(editppDet.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
        }
        catch(IOException ex){            
        }
    }     
}

