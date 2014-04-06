package dev.amit.xargon.stt;

import dev.amit.xargon.HostInfo;
import java.io.File;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.TargetDataLine;



class AudioStreamCreater{

    AudioFormat audioFormat
    static TargetDataLine targetDataLine
		
    AudioStreamCreater(){
			
        captureAudio()
    }

    void captureAudio(){
        try{
            audioFormat = new AudioFormat(16000F /*sampleRate*/,16/*sampleSizeInBits*/,2/*channels*/,true/*signed*/,false/*bigEndian*/)
            DataLine.Info dataLineInfo =new DataLine.Info(TargetDataLine.class,audioFormat)
            targetDataLine = (TargetDataLine)AudioSystem.getLine(dataLineInfo)
      
            new CaptureThread().start()
      
        }catch (Exception e) {
            e.printStackTrace()
            System.exit(0)
        }
    }
    class CaptureThread extends Thread{
        void run(){
            AudioFileFormat.Type fileType = AudioFileFormat.Type.WAVE
            File audioFile = new File(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"/audio.wav")

            try{
                targetDataLine.open(audioFormat)
                targetDataLine.start()
                AudioSystem.write(new AudioInputStream(targetDataLine),fileType,audioFile)
            }catch (Exception e){
                e.printStackTrace()
            }
        }
    }

}