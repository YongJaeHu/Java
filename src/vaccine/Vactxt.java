/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vaccine;

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
public class Vactxt {
    public ArrayList<Vac> getvacList(){
        ArrayList<Vac> vacList = new ArrayList<Vac>();
        File vacFile = new File("Vaccine.txt");
        try(Scanner fileScanner = new Scanner(vacFile)){
            while(fileScanner.hasNext()){
                String foundvac = fileScanner.nextLine();
                String[] vacDetails = foundvac.split(",");
                Vac vacObjects = new Vac(vacDetails[0],vacDetails[1],vacDetails[2],vacDetails[3],vacDetails[4]);
                vacList.add(vacObjects);
            }            
        }
        catch (FileNotFoundException ex){            
        }
        return vacList;
    }
    
    
    public void addvac(Vac newvac){
      File vacFile = new File("Vaccine.txt");
      try(FileWriter fileWriter = new FileWriter(vacFile, true)){
          try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
              try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                  printWriter.write(newvac.toString());
                  bufferedWriter.newLine();
              }
          }
      }
      catch(IOException ex){          
      }
    }
    
    public void overwritevac(ArrayList<Vac> vacList){
        File vacFile = new File("Vaccine.txt");
        try (FileWriter fileWriter = new FileWriter(vacFile)){
            try(BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)){
                try(PrintWriter printWriter = new PrintWriter(bufferedWriter)){
                    for(Vac editvac:vacList){
                        printWriter.write(editvac.toString());
                        bufferedWriter.newLine();
                    }
                }
            }
        }
        catch(IOException ex){            
        }
    }    

}    
