package dataProvider;

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

}
