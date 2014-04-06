package dev.amit.xargon.stt;

import dev.amit.xargon.HostInfo;
import java.io.File;
import javaFlacEncoder.FLAC_FileEncoder;

class FlacConverter {

    FlacConverter(){
        FLAC_FileEncoder ffe = new FLAC_FileEncoder()
        ffe.encode(new File(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"/audio.wav"), new File(System.getProperty(HostInfo.OS_TEMP_PATH_LOC)+""+"/audio.flac"))
    }
}
