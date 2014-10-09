package uk.co.tpplc.local.overtime.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;

public class PropertyConfigReader {
	
	private static final String CONGIG_FILE_NAME = "config.properties";
	
	public String getPropertyValue(String key) {
		
		String result = StringUtils.EMPTY;
		Properties prop = new Properties();
		String propFileName = CONGIG_FILE_NAME;
		
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
		try {
			prop.load(inputStream);
			if (inputStream == null) {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
			result = prop.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
