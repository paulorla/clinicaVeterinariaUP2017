package com.up.clinicaveterinaria.util;

import java.util.Properties;

public class PropertiesUtil {
	private static PropertiesUtil instance = null;
	
	private Properties properties;
	
	private PropertiesUtil(){
		try{
			properties = new Properties();
			properties.load(getClass().getResourceAsStream("../../../../messages.properties"));
		}catch(Exception e){
			e.printStackTrace();//logar
		}
	}

	public static PropertiesUtil getInstance() {
		if(instance == null)
			instance = new PropertiesUtil();
		return instance;
	}

	public String get(String key) {
		return (String)properties.get(key);
	}
}