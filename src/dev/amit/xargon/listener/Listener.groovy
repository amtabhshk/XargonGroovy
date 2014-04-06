#!/usr/bin/env groovy
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.amit.xargon.listener;

import dev.amit.xargon.HostInfo;
import dev.amit.xargon.common.StringProcessing;
import dev.amit.xargon.processor.DecisionTree;
import dev.amit.xargon.processor.Runner;
import dev.amit.xargon.stt.AudioStreamCreater;
import dev.amit.xargon.stt.FlacConverter;
import dev.amit.xargon.stt.SpeachToText;
import dev.amit.xargon.ui.Face;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Amit
 */
class Listener implements ActionListener{
    
    Face                             face
    static AudioStreamCreater        streamCreater                         
    static FlacConverter             converter
    static SpeachToText              speachToText
    static String                    hypothesis
    static StringProcessing          processing
    static DecisionTree              decisionTree
                             
                        
                        
                        
    Listener(Face face) {
        this.face = face
    }

    @Override
    void actionPerformed(ActionEvent e) {
        
        String buttonID=e.getActionCommand()
        println "ID:"+buttonID
        
        if(buttonID.equals(".")){
            
            streamCreater   =new AudioStreamCreater();
            Face.infoDisplayInPut.setText("wait,it's processing...")
            Face.infoDisplayOutPut.setText("")
            Face.speakButton.setEnabled(false)
            Face.stopSpeak.setEnabled(true)
            
        }
        else{
            
            streamCreater.targetDataLine.stop()
            streamCreater.targetDataLine.close()
            
            converter       =new FlacConverter()
            speachToText    =new SpeachToText()
            
            Face.stopSpeak.setEnabled(false)
            Face.speakButton.setEnabled(true)
            
            new Thread(new Runnable() {

                    @Override
                    void run() {
                    
                        try {
                            hypothesis=speachToText.SpeachToTextt(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"/audio.flac")
                            processing=new StringProcessing()
                                println "hy:"+hypothesis            
                            def s_peach=processing.speachHypothesis(hypothesis)[0]
                                            
                            Face.infoDisplayInPut.setText(System.getProperty(HostInfo.OS_USER_NAME)+" (Me): "+s_peach)
                                            
                            decisionTree=new DecisionTree()
                                            
                            def b=decisionTree.programDecider(s_peach)
                                            
                            Logger.getLogger(Listener.class.getName()).log(Level.WARNING,"in Listener isRunning="+b)
                                            
                            Face.infoDisplayOutPut.setText("running?:"+b)
                                            
                        } catch (Exception ex) {
                            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, "hypothesis is null", ex)
                        }
                    }
                }).start()
                                
            
           
        }
        
    }
    
    
    
}


 