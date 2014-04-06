#!/usr/bin/env groovy
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.amit.xargon.main;

import dev.amit.xargon.ui.Face;

/**
 *
 * @author Amit
 */
 class Xargon {

    /**
     * @param args the command line arguments
     */
     static void main(String[] args) {
    	
        println "runing..."
        println "(sample usage) Speak as /open/run/execute /firefox/terminal/texteditor"
        println "how to use ==>  click the \"mic\" button > speak > wait a sec >click the \"mute mic\" button "
        new Face()
    }
    
}
