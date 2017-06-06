/*
 * Copyright (C) 2016-2017 Lightbend Inc. <https://www.lightbend.com>
 */
package com.rccl.cp.ive.VacationItineraryService.impl;

import static com.lightbend.lagom.javadsl.testkit.ServiceTest.defaultSetup;
import static com.lightbend.lagom.javadsl.testkit.ServiceTest.startServer;
import static org.junit.Assert.assertFalse;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.atlassian.oai.validator.SwaggerRequestResponseValidator;
import com.atlassian.oai.validator.model.Request;
import com.atlassian.oai.validator.model.Response;
import com.atlassian.oai.validator.model.SimpleRequest;
import com.atlassian.oai.validator.model.SimpleResponse;
import com.atlassian.oai.validator.report.ValidationReport;
import com.lightbend.lagom.javadsl.api.transport.Method;
import com.lightbend.lagom.javadsl.testkit.ServiceTest.TestServer;
import com.rccl.cp.ive.get.myitinerary.api.GetMyItineraryService;

import io.swagger.jackson.SwaggerModule;
import io.swagger.models.Swagger;
import io.swagger.parser.SwaggerResolver;

public class VacationItineraryServiceServiceTest {
    final Logger logger = LoggerFactory.getLogger(VacationItineraryServiceServiceTest.class);
    private static TestServer testServer;
    @BeforeClass
    public static void setupDatabase() {
        testServer = startServer(defaultSetup().withCassandra(true));
        testServer.client(GetMyItineraryService.class);
    }

    @Test
    public void shouldPayloadFromFileConformToSchema() throws Exception {
        // first test the plain json is valid with schema
        SwaggerRequestResponseValidator validator = SwaggerRequestResponseValidator
            .createFor("ive-service-schema.yaml").build();
        final Request validRequest = SimpleRequest.Builder.get("/myItineraries/AL20170730/11111555556161/191919")
            .withHeader("api-key", "TESTKEY")
            .build();
        Response validResponse = SimpleResponse.Builder.ok()
            .withBody(ValidatorTestUtil.loadResponse("my_itinerary_sample_response_2017_03_16")).build();
        ValidationReport reportForText = validator.validate(validRequest, validResponse);
        logger.info(
            "shouldPayloadFromFileConformToSchema() ################# VALIDATION PAYLOAD REPORT ##################");
        reportForText.getMessages().forEach((m) -> {
            logger.info("{}", m);
        });
        assertFalse(reportForText.hasErrors());
        logger.info(
            "shouldPayloadFromFileConformToSchema() ################# VALIDATION PAYLOAD REPORT END ##################");
        logger.info(validRequest.getHeaders().toString());
        SwaggerModule swagger = new SwaggerModule();
        
        
    }

    ////////
    /*
     * @Test public void formatValidation() throws Exception { // first test the
     * plain json is valid with schema SwaggerRequestResponseValidator validator
     * = SwaggerRequestResponseValidator
     * .createFor("ive-service-schema.yaml").build(); final Request validRequest
     * =
     * SimpleRequest.Builder.get("/myItineraries/HM20170304/4967331/5102034165")
     * .build(); Response validResponse = SimpleResponse.Builder.ok()
     * .withBody(ValidatorTestUtil.loadResponse(
     * "my_itinerary_sample_response_2017_04_12")).build(); //
     * 
     * ValidationReport reportForText = validator.validate(validRequest,
     * validResponse); // logger.info("shouldPayloadFromFileConformToSchema()
     * ################# // VALIDATION PAYLOAD REPORT ##################");
     * reportForText.getMessages().forEach((m) -> { logger.info("{}", m); });
     * assertFalse(reportForText.hasErrors()); //// assertTrue(true); //
     * logger.info("shouldPayloadFromFileConformToSchema() #################
     * //// VALIDATION PAYLOAD REPORT END ##################");
     * 
     * }
     * 
     * @Test public void addingServiceForDiningTest() throws Exception {
     * SwaggerRequestResponseValidator validator =
     * SwaggerRequestResponseValidator
     * .createFor("ive-service-schema.yaml").build(); JSONParser parser = new
     * JSONParser(); // Object obj = parser.parse(new // FileReader(
     * "C:\\Users\\dineshreddy\\git\\commerce-ive\\VacationItineraryService-impl\\src\\test\\java\\requests\\post_request.json"
     * ));
     * 
     * String path = VacationItineraryServiceServiceTest.class.getClassLoader()
     * .getResource("requests/commerce_post_request.json").getFile();
     * 
     * if (System.getProperty("os.name").startsWith("Windows")) { path =
     * path.substring(1); }
     * 
     * String json = new String(Files.readAllBytes(Paths.get(path))); Object obj
     * = parser.parse(json);
     * 
     * JSONObject jsonObject = (JSONObject) obj;
     * 
     * final Request validRequest =
     * SimpleRequest.Builder.post("/api/v1/events/commerce/HM20170304").withBody
     * (jsonObject.toString()) .withHeader("Content-Type", "application/json")
     * .build(); Response validResponse = SimpleResponse.Builder.ok()
     * .withBody(ValidatorTestUtil.loadResponse("update_response")).build(); //
     * ValidationReport reportForText = validator.validate(validRequest,
     * validResponse); reportForText.getMessages().forEach((m) -> {
     * logger.info("{}", m); }); assertFalse(!reportForText.hasErrors()); }
     * 
     * @Test public void addingServiceForCruiseCompassTest() throws Exception {
     * SwaggerRequestResponseValidator validator =
     * SwaggerRequestResponseValidator
     * .createFor("ive-service-schema.yaml").build(); JSONParser parser = new
     * JSONParser(); // Object obj = parser.parse(new // FileReader(
     * "C:\\Users\\dineshreddy\\git\\commerce-ive\\VacationItineraryService-impl\\src\\test\\java\\requests\\post_request.json"
     * )); // change request for cruise compass String path =
     * VacationItineraryServiceServiceTest.class.getClassLoader()
     * .getResource("requests/commerce_post_request.json").getFile(); if
     * (System.getProperty("os.name").startsWith("Windows")) { path =
     * path.substring(1); }
     * 
     * String json = new String(Files.readAllBytes(Paths.get(path))); Object obj
     * = parser.parse(json);
     * 
     * JSONObject jsonObject = (JSONObject) obj;
     * 
     * final Request validRequest =
     * SimpleRequest.Builder.post("/api/v1/events/commerce/HM20170304").withBody
     * (jsonObject.toString()) .withHeader("Content-Type", "application/json")
     * .build(); Response validResponse = SimpleResponse.Builder.ok()
     * .withBody(ValidatorTestUtil.loadResponse("update_response")).build(); //
     * ValidationReport reportForText = validator.validate(validRequest,
     * validResponse); reportForText.getMessages().forEach((m) -> {
     * logger.info("{}", m); }); assertFalse(!reportForText.hasErrors()); }
     */

}
