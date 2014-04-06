#!/usr/bin/env groovy
package dev.amit.xargon;


import java.util.HashMap;
import java.util.Map;

class LookUpTable {
	
    static Map <String,String>program;

    LookUpTable() {
		
        program=new HashMap<String,String>()
	
        program.put("fire fox", "/usr/bin/firefox")
        program.put("mozilla", "/usr/bin/firefox")
        program.put("browser", "/usr/bin/firefox")
        program.put("text editor", "gedit")
        program.put("terminal", "xterm")
	
		
    }

}
