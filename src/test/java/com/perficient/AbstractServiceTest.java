//package com.perficient;
//
//import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.filter.log.RequestLoggingFilter;
//import io.restassured.filter.log.ResponseLoggingFilter;
//import io.restassured.http.ContentType;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import io.restassured.specification.RequestSpecification;
//
//import java.io.*;
//import java.util.Properties;
//
//public abstract class AbstractServiceTest {
//
//    private static final String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";
//    private RequestSpecification req;
//    private PrintStream printStream;
//    protected JsonPath jsonPath;
//
//    public AbstractServiceTest() {
//        try {
//            this.printStream = new PrintStream(new FileOutputStream("log.json"));
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    public RequestSpecification requestSpec() {
//        if (req == null) {
//            req = new RequestSpecBuilder()
//                    .setBaseUri(getGlobalValue("QA_URL"))
//                    .addFilter(RequestLoggingFilter.logRequestTo(printStream))
//                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
//                    .setContentType(ContentType.JSON)
//                    .build();
//        }
//
//        return req;
//    }
//
//    public String getGlobalValue(String url) {
//        Properties prop = new Properties();
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(PROPERTIES_FILE_PATH);
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            prop.load(fis);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return prop.getProperty(url);
//    }
//
//    public String getJsonPath(Response response, String key) {
//        String resp = response.asString();
//        jsonPath = new JsonPath(resp);
//        return jsonPath.get(key).toString();
//    }
//}



package com.perficient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public abstract class AbstractServiceTest {

    private static final String PROPERTIES_FILE_PATH = "src/main/resources/application.properties";
    private RequestSpecification req;
    private PrintStream logPrintStream;
    protected JsonPath jsonPath;

    public AbstractServiceTest() {
        try {
            this.logPrintStream = new PrintStream(new FileOutputStream("log.json", true), true); // true for append and auto-flush
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Error initializing the log file.", e);
        }
    }

    public RequestSpecification requestSpec() {
        if (req == null) {
            req = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("QA_URL"))
                    .addFilter(new RequestLoggingFilter(logPrintStream))
                    .addFilter(new ResponseLoggingFilter(logPrintStream))
                    .addFilter(new ErrorLoggingFilter(logPrintStream))
                    .setContentType(ContentType.JSON)
                    .build();
        }
        return req;
    }

    public String getGlobalValue(String key) {
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(PROPERTIES_FILE_PATH)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Error reading the properties file.", e);
        }
        return prop.getProperty(key);
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
