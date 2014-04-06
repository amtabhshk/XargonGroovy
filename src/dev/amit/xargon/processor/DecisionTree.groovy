#!/usr/bin/env groovy
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.amit.xargon.processor;

import dev.amit.xargon.LookUpTable;
import dev.amit.xargon.common.StringProcessing;
import dev.amit.xargon.listener.Listener;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amit
 */
class DecisionTree {
    
    static Runner          runner;
    private boolean          isRunning=false;
    String[] words = ["open", "run", "execute"]
     
    static StringProcessing          stringProcessing;
    static      LookUpTable		     upTable;

   
    boolean programDecider(def _speach) {
        
        for (def w : words) {

            if (_speach.contains(w)) {
                    
                stringProcessing     =new StringProcessing()
                def possibleProgram     =stringProcessing.getPossibleProgram(_speach, w)
                upTable     =new LookUpTable();					
                def 		  _program	   =LookUpTable.program.get(possibleProgram.trim())
                
                Logger.getLogger(DecisionTree.class.getName()).log(Level.WARNING,"possibleProgram:"+possibleProgram.trim()+" and Program="+_program)
                
                if(_program==null){
                    break
                }
                
                runner                     = new Runner()
                isRunning                  = runner.RunnerMethod(_program)
               
                break
                
            } else {

                isRunning = false
                
            }

        }

       
       
        
    
    
    
        isRunning;
    }
}
