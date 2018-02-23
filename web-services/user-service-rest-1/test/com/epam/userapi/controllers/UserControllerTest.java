package com.epam.userapi.controllers;

import com.epam.userapi.models.User;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

import static org.junit.Assert.*;
import static play.test.Helpers.*;

/**
 * User Controller Test.
 */
public class UserControllerTest extends WithApplication {

    private static final String USER_ID = "1";
    private static final String USER_FIRST_NAME = "Petya";
    private static final String USER_LAST_NAME = "Petrovich";
    private static final String USER_LOGIN = "redo";
    private static final String USER_LOGIN_CHANGED = "redo_new";
    private static final String USER_EMAIL = "bla@gmail.com";

    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Before
    public void init() throws Exception {
        saveUserTest();
    }

    @Test
    public void getByIdTest() {
        final String body = getUserById();
        assertNotNull(body);
        assertTrue(body.contains(USER_FIRST_NAME));
    }

    @Test
    public void updateUserTest() {

        User user = new User();
        user.setFirstName(USER_FIRST_NAME);
        user.setId(USER_ID);
        user.setLastName(USER_LAST_NAME);
        user.setEmail(USER_EMAIL);
        user.setLogin(USER_LOGIN_CHANGED);
        JsonNode userJson = Json.toJson(user);

        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(PUT)
                .bodyJson(userJson)
                .uri("/api/v1/user/update");

        Result result = route(app, request);
        String body = contentAsString(result);
        assertNotNull(body);
        assertEquals(body, "User was updated!");

        body = getUserById();
        assertTrue(body.contains(USER_LOGIN_CHANGED));
    }

    @Test
    public void deleteUserTest() {
        Http.RequestBuilder request = prepareGetRequestBuilder(DELETE, "/api/v1/user/delete/" + USER_ID);

        Result result = route(app, request);
        final String body = contentAsString(result);

        assertNotNull(body);
        assertEquals(body, "User with id '" + USER_ID + "' was deleted!");
    }

    private void saveUserTest() throws Exception {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(POST)
                .bodyXml(prepareXmlBody())
                .uri("/api/v1/user/save");

        Result result = route(app, request);
        final String body = contentAsString(result);
        assertEquals(body, "User was saved!");
    }

    private String getUserById() {
        Http.RequestBuilder request = prepareGetRequestBuilder(GET, "/api/v1/user/" + USER_ID);
        Result result = route(app, request);
        return contentAsString(result);
    }

    private Http.RequestBuilder prepareGetRequestBuilder(String method, String url) {
        return new Http.RequestBuilder()
                .method(method)
                .uri(url);
    }

    private Document prepareXmlBody() throws Exception {
        String xmlString = "<?xml version=\"1.0\" encoding=\"utf-8\"?><user>\n" +
                "    <id>" + USER_ID + "</id>\n" +
                "    <login>" + USER_LOGIN + "</login>\n" +
                "    <firstName>" + USER_FIRST_NAME + "</firstName>\n" +
                "    <lastName>" + USER_LAST_NAME + "</lastName>\n" +
                "    <email>" + USER_EMAIL + "</email>\n" +
                "</user>";

        return DocumentBuilderFactory.newInstance()
                .newDocumentBuilder().parse(new InputSource(new StringReader(xmlString)));
    }

}
