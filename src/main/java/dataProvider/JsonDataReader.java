package dataProvider;

import com.google.gson.Gson;
import manager.FileReaderManager;
import testDataTypes.TestNumbers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonDataReader {
    private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "testData.json";
    private List<TestNumbers> numberList;

    public JsonDataReader(){
        numberList = getCustomerData();
    }

    private List<TestNumbers> getCustomerData() {
        Gson gson = new Gson();
        BufferedReader bufferReader = null;
        try {
            bufferReader = new BufferedReader(new FileReader(customerFilePath));
            TestNumbers[] testNumbers = gson.fromJson(bufferReader, TestNumbers[].class);
            return Arrays.asList(testNumbers);
        }catch(FileNotFoundException e) {
            throw new RuntimeException("Json file not found at path : " + customerFilePath);
        }finally {
            try { if(bufferReader != null) bufferReader.close();}
            catch (IOException ignore) {}
        }
    }

    public final TestNumbers getCustomerByName(int customerNumber){
        for(TestNumbers number : numberList) {
            if(number.number==customerNumber) return number;
        }
        return null;
    }
}