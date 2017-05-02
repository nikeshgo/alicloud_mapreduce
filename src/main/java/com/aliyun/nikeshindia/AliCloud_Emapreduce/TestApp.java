package com.aliyun.nikeshindia.AliCloud_Emapreduce;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Hello world!
 *
 */
public class TestApp 
{
    public static void main( String[] args ) throws URISyntaxException, IOException
    {
        System.out.println( "Testing Empareduce" );
              
        Cluster cc = new Cluster();
        String cmclu=cc.callModifyCluster();
        
        Job jj = new Job();
        jj.callJobCreate();
    
    
    }
}
