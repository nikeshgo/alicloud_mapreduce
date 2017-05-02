package com.aliyun.nikeshindia.mapreduce.propfiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class readClusterProp {
	
		public String CreateURL;
		public String ModifyURL;
		public String Name="";
		public String Type="";
		public String FailAct="";
		public String ClusterType="";
		public String HighAvailabilityEnable="";
		public String SecurityGroupId="";
		public String LogEnable="";
		public String EmrVer="";
		public String ZoneId="";
		public String IsOpenPublicIp="";
		public String RegionId="";
		public String MasterPwdEnable="";
		public String VpcId="";
		public String VSwitch="";
		public String NetType="";
		public String EcsOrder="";
		public String Id="";

		Properties prop = new Properties();

		InputStream input = null;

		
	public void ReadPropertFile() throws IOException {
		
		input = new FileInputStream("/Users/nikeshgogia/Documents/AliCloud/AliCloud_Emapreduce/src/main/java/aliyun_config_cluster.properties");

		// load a properties file
		try {
			prop.load(input);
			CreateURL=prop.getProperty("CreateURL");
			
			ModifyURL=prop.getProperty("ModifyURL");

			Name=prop.getProperty("Name");

			Type=prop.getProperty("Type");

			FailAct=prop.getProperty("FailAct");

			ClusterType=prop.getProperty("ClusterType");

			HighAvailabilityEnable=prop.getProperty("StringHighAvailabilityEnable");

			SecurityGroupId=prop.getProperty("SecurityGroupId");

			LogEnable=prop.getProperty("LogEnable");

			ZoneId=prop.getProperty("ZoneId");

			IsOpenPublicIp=prop.getProperty("IsOpenPublicIp");

			RegionId=prop.getProperty("RegionId");

			MasterPwdEnable=prop.getProperty("MasterPwdEnable");

			VpcId=prop.getProperty("VpcId");
			
			VSwitch=prop.getProperty("VSwitch");
			
			NetType=prop.getProperty("NetType");

			EcsOrder=prop.getProperty("EcsOrder");
			
			Id=prop.getProperty("Id");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
