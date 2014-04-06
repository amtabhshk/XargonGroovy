package dev.amit.xargon.stt;

import dev.amit.xargon.listener.Listener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;



class SpeachToText {

    /**
     *@author Bapu
     * @param args
     * @throws Exception 
     */
	
    def SpeachToTextt(def pathh) throws Exception{
		
        def hypothesis=null
        Path path = Paths.get(pathh)
	   
        byte[] data = Files.readAllBytes(path)
	  
	           
        def request = "https://www.google.com/"+
	                    "speech-api/v1/recognize?"+
	                    "xjerr=1&client=chromium&lang=en-IN&maxresults=10&pfilter=0"
        URL url = new URL(request)
        HttpURLConnection connection = (HttpURLConnection) url.openConnection()         
        connection.setDoOutput(true)
        connection.setDoInput(true)
        connection.setInstanceFollowRedirects(false)
        connection.setRequestMethod("POST")
        connection.setRequestProperty("Content-Type", "audio/x-flac; rate=16000")
        //connection.setRequestProperty("chromium", "speech2text");
        connection.setConnectTimeout(60000)
        connection.setUseCaches (false)
        try{
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream ())
            //wr.writeBytes(new String(data));
            wr.write(data)
            wr.flush()
            wr.close()
            // connection.disconnect();
	          
            Logger.getLogger(Listener.class.getName()).log(Level.INFO, "Upload Done...")
	         
        }catch(Exception n){
	        	  
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE,"in speachtotext exception",n)
        }
	          
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))
                            
	          
            def decodedString="default string";
            while ((decodedString=br.readLine())!= null) {
                Logger.getLogger(Listener.class.getName()).log(Level.INFO, "Decoding...")
	                    	
                hypothesis=decodedString
                //System.out.println("Decoded..:"+decodedString);
	                    	
	                    
            }
        }catch(java.io.IOException e){
	        	 
            Logger.getLogger(Listener.class.getName()).log(Level.SEVERE,"Server returned HTTP response code: 500",e)
	        	 
        }
	                    
        hypothesis;
    }
	
}
