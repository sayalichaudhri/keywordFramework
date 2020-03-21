package FileUtility;
 
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;
 
public class ReadPropertyFile {
 
 public static void main(String args[]) {
 readPropertyFile();
 }
 
 public static void readPropertyFile() {
 System.out.println("In readPropertyFile method");
 Properties prop = new Properties();
 InputStream input;
 HashMap<String, String> propvals = new HashMap<String, String>();
 try {
 
 input = ReadPropertyFile.class
 .getResourceAsStream("input/AuthorInfo.properties");
 prop.load(input);
 System.out.println("Property File Loaded Succesfully");
 Set<String> propertyNames = prop.stringPropertyNames();
 for (String Property : propertyNames) {
 System.out.println(Property + ":" + prop.getProperty(Property));
 propvals.put(Property, prop.getProperty(Property));
 }
 System.out.println("HashMap generated::" + propvals);
 } catch (FileNotFoundException e) {
 e.printStackTrace();
 } catch (IOException e) {
 e.printStackTrace();
 } catch (Exception e) {
 e.printStackTrace();
 }
 }
}