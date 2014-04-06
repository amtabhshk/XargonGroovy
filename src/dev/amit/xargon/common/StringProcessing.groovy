#!/usr/bin/env groovy
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.amit.xargon.common;


import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amit
 */
class StringProcessing {
    
    def speachHypothesis(def googleReturnedHypothesis){
	 
        String[] actuallHypothesis=new String[2]
         println "dhy:"+actuallHypothesis
         println "g hy:"+googleReturnedHypothesis
        def confidenceIndex=googleReturnedHypothesis.indexOf("confidence")
         println "d co:"+confidenceIndex
        def utteranceIndex=googleReturnedHypothesis.indexOf("utterance")
         println "d ui:"+utteranceIndex
	
        actuallHypothesis[0]=googleReturnedHypothesis.substring(utteranceIndex+12,confidenceIndex-3)
         println "ah 0:"+actuallHypothesis[0]
        actuallHypothesis[1]=googleReturnedHypothesis.substring(confidenceIndex+12,confidenceIndex+21)
         println "ah 1:"+actuallHypothesis[1]
         
        Logger.getLogger(StringProcessing.class.getName()).log(Level.INFO, "GoogleHypothesis:"+googleReturnedHypothesis)
        Logger.getLogger(StringProcessing.class.getName()).log(Level.INFO, "utterenecIndex:"+utteranceIndex)        
        Logger.getLogger(StringProcessing.class.getName()).log(Level.INFO, "confidenceIndex:"+confidenceIndex)
        Logger.getLogger(StringProcessing.class.getName()).log(Level.INFO, "actuallHypothesis:"+actuallHypothesis[0])
        Logger.getLogger(StringProcessing.class.getName()).log(Level.INFO, "confidence:"+actuallHypothesis[1])
	 
        actuallHypothesis;
	 
    }
     
    def getPossibleProgram(def originalString, def fromword) {
	
        originalString=originalString.replaceAll("  ", " ")
        def arrayWord=originalString.split(" ")
        def string="";
        def i=0;
        try{
            for(def j=0;j<arrayWord.length;j++){
                if(arrayWord[j].equals(fromword)){
                    i=j;
                }
            }
            for(def k=i;k<arrayWord.length;k++){
                if(k+1>=arrayWord.length){break;}
                else{string+=arrayWord[k+1]+" ";}
				
            }
        }catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            string= "arrayIndexOutOfBoundsException error in StringCalculation.java "	
        }
        string
    }

	
    
}
