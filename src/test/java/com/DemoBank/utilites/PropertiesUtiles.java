package com.DemoBank.utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtiles {

	public static Properties set(String filePath) throws IOException {
		// TODO Auto-generated method stub
		Properties pro = new Properties();
		FileInputStream ip = new FileInputStream(filePath);
		pro.load(ip);
		return pro;
	}
  
}
