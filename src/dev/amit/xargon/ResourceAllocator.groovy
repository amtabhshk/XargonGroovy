#!/usr/bin/env groovy
package dev.amit.xargon;

import java.net.URL;

/**
 * @author Bapu
 *
 */
class ResourceAllocator {
	
    static ResourceAllocator rl=new ResourceAllocator()
    static URL getFile(String filename){
        rl.getClass().getResource(""+filename)
    }	
}
