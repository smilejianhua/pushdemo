package com.wondersgroup.push;

import java.util.HashMap;
import java.util.Map;

import com.wondersgroup.eda.client.PushletClient;
import com.wondersgroup.eda.client.PushletClientListener;
import com.wondersgroup.eda.core.Event;
import com.wondersgroup.eda.core.Protocol;

public class JavaClientDemo implements PushletClientListener {
	
	private PushletClient pushletClient;
	private String host = "10.1.9.108";
	private int port = 8080;
	private String subject = "/system/jvm";
	
	private Map<String,String> resultInfo = new HashMap<String,String>();
	
	
	public JavaClientDemo(){
		pushletClient = new PushletClient(host,port);
	}
	
	public void run(){
		try {
			pushletClient = new PushletClient(host,port);
			pushletClient.setDebug(false);			
			pushletClient.join();
			pushletClient.listen(this, Protocol.MODE_PULL,subject);
			pushletClient.publish(subject, resultInfo);
		}
		catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	@Override
	public void onAbort(Event event) {
	}


	@Override
	public void onData(Event event) {
		String memoryInfo = event.getField("totalMemory");
	}


	@Override
	public void onError(String arg0) {
		// TODO Auto-generated method stub		
	}


	@Override
	public void onHeartbeat(Event arg0) {
		// TODO Auto-generated method stub	
	}
}
