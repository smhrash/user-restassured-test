package com.perficient;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public abstract class AbstractServiceTest {

    public RequestSpecification req;

    private PrintStream printStream = null;
    protected JsonPath jsonPath;

    {
        try {
            printStream = new PrintStream(new FileOutputStream("log.json"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public RequestSpecification requestSpec() {
        if (req == null) {
            req = new RequestSpecBuilder()
                    .setBaseUri(getGlobalValue("QA_URL"))
                    .addFilter(RequestLoggingFilter.logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                    .setContentType(ContentType.JSON)
                    .build();
            return req;
        }

        return req;
    }

    public String getGlobalValue(String url) {
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("src/main/resources/application.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return prop.getProperty(url);
    }

    public String getJsonPath(Response response, String key) {
        String resp = response.asString();
        jsonPath = new JsonPath(resp);
        return jsonPath.get(key).toString();
    }
}
