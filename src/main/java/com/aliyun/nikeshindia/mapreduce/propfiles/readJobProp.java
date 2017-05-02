package com.aliyun.nikeshindia.mapreduce.propfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readJobProp {
	
		public String CreateJobURL;
		public String ModifyJobURL;
		public String Name="";
		public String Type="";
		public String FailAct="";
		public String RunParameter="";
		public String RegionId="";
		public String Id="";
		public String EnvParam="";

		Properties prop = new Properties();

		InputStream input = null;

		
	public void ReadPropertFile() throws IOException {
		
        String current = new java.io.File( "." ).getCanonicalPath();

       	input = new FileInputStream(current+"/src/main/java/aliyun_config_job.properties");

		// load a properties file
		try {
			prop.load(input);
			
			CreateJobURL=prop.getProperty("CreateJobURL");
			
			ModifyJobURL=prop.getProperty("ModifyURL");

			Name=prop.getProperty("Name");

			Type=prop.getProperty("Type");

			FailAct=prop.getProperty("FailAct");

			RunParameter=prop.getProperty("RunParamter");

			RegionId=prop.getProperty("RegionId");

			
			Id=prop.getProperty("Id");
			
			EnvParam=prop.getProperty("EnvParam");
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
