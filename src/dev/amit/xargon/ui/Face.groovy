#!/usr/bin/env groovy
package dev.amit.xargon.ui;

import dev.amit.xargon.HostInfo;
import dev.amit.xargon.ResourceAllocator;
import dev.amit.xargon.listener.Listener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

class Face {
	
    JFrame mainfFrame
    static JButton speakButton,stopSpeak
    static JTextArea infoDisplayInPut,infoDisplayOutPut
	
    Face() {
		
        mainfFrame=new JFrame()
        mainfFrame.setTitle("Xargon:~OS:"+System.getProperty(HostInfo.OS_NAME)+",~user:"+System.getProperty(HostInfo.OS_USER_NAME))
        mainfFrame.getContentPane().setLayout(null)
        createComponent()
		
        mainfFrame.setSize(400, 250)
        mainfFrame.setLocation(400, 300)

        mainfFrame.getContentPane().setBackground(Color.DARK_GRAY)
        mainfFrame.setResizable(false)
        mainfFrame.setVisible(true)
			
    }
	
    private void createComponent(){
		
        speakButton=new JButton(".")
        stopSpeak=new JButton("_")
        infoDisplayOutPut=new JTextArea(350,30)
        infoDisplayOutPut.setEditable(false)
        infoDisplayOutPut.setBackground(Color.GRAY)
        infoDisplayOutPut.setForeground(Color.CYAN)
        Font font1=new Font("Calibri", Font.BOLD, 15)
        infoDisplayOutPut.setFont(font1)
                    
        infoDisplayInPut=new JTextArea(350,30)
        infoDisplayInPut.setEditable(false)
        infoDisplayInPut.setBackground(Color.GRAY)
        infoDisplayInPut.setForeground(Color.CYAN)
        Font font2=new Font("Calibri", Font.BOLD, 15)
        infoDisplayInPut.setFont(font2)

        mainfFrame.add(infoDisplayOutPut).setBounds(25, 170, 350, 25)
        mainfFrame.add(infoDisplayInPut).setBounds(25, 130, 350, 25)
        mainfFrame.add(speakButton).setBounds(120, 60, 70, 50)
        mainfFrame.add(stopSpeak).setBounds(220, 60, 70, 50)
                
        Image iconspeak=null
        try {
            iconspeak = ImageIO.read(ResourceAllocator.getFile("resource/microphone-icon.jpg"))
        } catch (IOException ex) {
            Logger.getLogger(Face.class.getName()).log(Level.WARNING,"speakbutton image not found", ex)
        }
        speakButton.setIcon(new ImageIcon(iconspeak))
                            
        Image iconstopspeak=null
        try {
            iconstopspeak = ImageIO.read(ResourceAllocator.getFile("resource/micoff.png"))
        } catch (IOException ex) {
            Logger.getLogger(Face.class.getName()).log(Level.WARNING,"stopspeakbutton image not found", ex)
        }
        stopSpeak.setIcon(new ImageIcon(iconstopspeak))
                
        speakButton.addActionListener(new Listener(this))
        stopSpeak.addActionListener(new Listener(this))
                
        stopSpeak.setEnabled(false);
		
		
    }
}
