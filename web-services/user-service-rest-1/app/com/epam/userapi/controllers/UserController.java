package com.epam.userapi.controllers;


import com.epam.userapi.controllers.parsers.UserBodyParser;
import com.epam.userapi.models.User;
import com.epam.userapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import play.mvc.BodyParser;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * User Controller.
 */
@Slf4j
@Singleton
public class UserController extends AbstractController<User> {

    @Inject
    public UserController(UserService userService) {
        super(userService, User.class);
    }

    @BodyParser.Of(BodyParser.Xml.class)
    public Result save() {
        try {
            return super.save(getUserFromRequestBody(request().body().asXml()));
        } catch (JAXBException e) {
            return internalServerError("Xml wasn't parsed!");
        }
    }

    @BodyParser.Of(UserBodyParser.class)
    public Result update() {
        return super.update();
    }

    private User getUserFromRequestBody(Document document) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(User.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return  (User) jaxbUnmarshaller.unmarshal(document);
    }
}
