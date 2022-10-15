package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadProperites {
   //Load the properties file from folder
	
	public static Properties userData=loadProperties(System.getProperty("user.dir")+"\\src\\main\\java\\properites\\userdata.properites");
	
	
	private static Properties loadProperties(String path) {
		
		Properties pro=new Properties();
		//stream for reading file
		try {
			FileInputStream stream=new FileInputStream(path);
			pro.load(stream);
		} catch (FileNotFoundException e) {
			System.out.println("error occuerd " + e.getMessage() );
		} catch (IOException e) {
			System.out.println("error occuerd " + e.getMessage() );
		}
		catch (NullPointerException e) {
			System.out.println("error occuerd " + e.getMessage() );
		}
		return pro;
	}
}
