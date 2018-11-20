package dataProvider;

import enums.DriverType;
import enums.EnvironmentType;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sakib on 11/19/2018.
 */
public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath= "configs//Configurations.properties";

    public ConfigFileReader(){
    BufferedReader reader;
        try {
            reader=new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getDeviceName(){
        String deviceName = properties.getProperty("deviceName");
        if(deviceName!= null) return deviceName;
        else throw new RuntimeException("deviceName not specified in the Configuration.properties file.");
    }

    public DriverType getDriver() {
        String driverName = properties.getProperty("driver");
        if(driverName == null || driverName.equals("chrome")) return DriverType.CHROME;
        else if(driverName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
        else if(driverName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
        else if(driverName.equals("appium")) return DriverType.APPIUM_LOCAL_APP;
        //else if(driverName.equals("appium")) return DriverType.APPIUM_INSTALLED_APP;
        else throw new RuntimeException("Driver Name Key value in Configuration.properties is not matched : " + driverName);
    }

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if(environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if(environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

}
