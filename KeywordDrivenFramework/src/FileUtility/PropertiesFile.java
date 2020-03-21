package FileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import keywords.constants;

public class PropertiesFile {
	
	public static String getProperty(String key) {
		
		
		String value=null;
		
		try {
			constants.fin =new FileInputStream("input/ObjectRepository.properties");
			//Map<String,String> map=(Map<String, String>) new HashMapReadData();
			
			constants.prop=new Properties();
			//constants.prop.putAll(map);
			constants.prop.load(constants.fin);
			value=constants.prop.getProperty(key);
			
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file object repository");
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return value;
	
	

}
	public static String[]  getProperty(String key,String filename) {
		
		String[] value=null;
		try {
			constants.fin =new FileInputStream(filename);
			constants.prop=new Properties();
			constants.prop.load(constants.fin);
		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File could not load");
			e.printStackTrace();
		}
		
		return value;
	}
	
	public static String[] getLocator(String key)
	{
		String[] value=null;
		try {
			constants.fin=new FileInputStream("input/ObjectRepository.properties");
			constants.prop=new Properties();
			constants.prop.load(constants.fin);
			String newvalue=constants.prop.getProperty(key);
			value=newvalue.split("@@");
			System.out.println("Locator type is"+value[0]);
			System.out.println("Locator value is"+value[1]);
		} catch (FileNotFoundException e) {
			System.out.println("unale to find loctaor");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}
	
	

	
	
}
