/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jsuarez;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jsuarez
 */
public class TestHeroku {
    
    public static void main(String[] args){
        try{
            System.out.println("STARTING RETRIEVE");
            
            Runner.run();            
            
            System.out.println("PROCESS FINISHED");

//            try {    
//                File f = new File("zzzzout.xml");
//                if ( f.exists() ){
//                    System.out.println("EXISTE");
//                }
//                else{
//                    System.out.println("NO EXISTE");
//                }
//
//                BufferedReader br = new BufferedReader(new FileReader(f));
//                String linea = "";
//
//                while ((linea = br.readLine()) != null){
//                    System.out.println(linea);
//                }
//
//                br.close(); 
//
//
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }

            System.out.println("FINAL");
        }catch (Throwable t){
            t.printStackTrace();
        }
    }
    
}
