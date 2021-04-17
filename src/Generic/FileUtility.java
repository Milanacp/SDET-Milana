package Generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	
	/**
	 * @author Milana
	 * To read the data from property file
	 * @param path
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropFile(String path, String key) throws IOException
	{
		FileInputStream fis = new FileInputStream (path);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}

}
