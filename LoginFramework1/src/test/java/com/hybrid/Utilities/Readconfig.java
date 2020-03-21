package com.hybrid.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import keywords.constants;

public class Readconfig {

	public Readconfig() {
		try {
			constants.fin = new FileInputStream("./configFile/config.properties");
			constants.prop = new Properties();
			constants.prop.load(constants.fin);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public String getUsername()
	{
		String uname=constants.prop.getProperty("email");
		return uname;
	}
	
	public static String getPassword()
	{
		String pass=constants.prop.getProperty("pass");
		return pass;
	}
}
