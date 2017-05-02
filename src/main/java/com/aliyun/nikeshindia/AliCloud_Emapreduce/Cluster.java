package com.aliyun.nikeshindia.AliCloud_Emapreduce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.aliyun.nikeshindia.mapreduce.propfiles.readClusterProp;
import com.aliyun.nikeshindia.mapreduce.propfiles.readJobProp;

public class Cluster {
	
	
	public static String callCreateCluster() throws URISyntaxException {
		
		String resposneret="null";
		try {
			
		readClusterProp rcc = new readClusterProp();
		rcc.ReadPropertFile();
				
		URIBuilder ur = new URIBuilder(rcc.CreateURL);
		ur.addParameter("Name", rcc.Name);
		ur.addParameter("LogEnable",rcc.LogEnable);
		ur.addParameter("EmrVer",URLEncoder.encode(rcc.EmrVer,"UTF-8"));
		ur.addParameter("ZoneId", URLEncoder.encode(rcc.ZoneId,"UTF-8"));
		ur.addParameter("IsOpenPublicIp",rcc.IsOpenPublicIp);
		ur.addParameter("RegionId", URLEncoder.encode(rcc.RegionId,"UTF-8"));
		ur.addParameter("MasterPwdEnable",rcc.MasterPwdEnable);
		ur.addParameter("VpcId",URLEncoder.encode("VpcId","UTF-8"));
		ur.addParameter("VSwitch", URLEncoder.encode(rcc.VSwitch,"UTF-8"));
		ur.addParameter("NetType",rcc.NetType);
		ur.addParameter("EcsOrder", URLEncoder.encode(rcc.EcsOrder,"UTF-8"));
		
		String urll = ur.build().toString();
		
		System.out.println(urll);
		
		resposneret = executeClusterURL(urll);
		


	} catch (ClientProtocolException e) {
		e.printStackTrace();

	} catch (IOException e) {
		e.printStackTrace();
	}
	return resposneret;
	
	}
	
	
public static String callModifyCluster() throws URISyntaxException {
		
		String resposneret="null";
		try {
			
			readClusterProp rcc = new readClusterProp();
			rcc.ReadPropertFile();
					
			URIBuilder ur = new URIBuilder(rcc.ModifyURL);
			ur.addParameter("Id", rcc.Id);
			ur.addParameter("RegionId", rcc.RegionId);
			ur.addParameter("Name", rcc.Name);
			
			String urll = ur.build().toString();
			
			System.out.println(urll);
			
			resposneret = executeClusterURL(urll);


		}
		
		catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resposneret;

		
}
	
	
	
	private static String executeClusterURL(String urll) {
		
		StringBuilder sbr = new StringBuilder();
		String resposneret = "No Response";

		try {
			
			HttpClient httpClient = HttpClientBuilder.create().build();

			
			HttpGet getRequest = new HttpGet(urll);

			// Execute your request and catch response
			
			HttpResponse response = httpClient.execute(getRequest);

			// Check for HTTP response code: 200 = success

			// Get-Capture Complete application/xml body response
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));
			String output;
			System.out.println("============Output:============");

			// Simply iterate through XML response and show on console.
			
			
			while ((output = br.readLine()) != null) {
				System.out.println(output);
				sbr.append(output);
			}
			resposneret = sbr.toString();

		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return resposneret;

		}
	}
	
	
	



