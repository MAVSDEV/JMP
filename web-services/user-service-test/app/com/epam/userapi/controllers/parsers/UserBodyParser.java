package com.epam.userapi.controllers.parsers;

import com.epam.userapi.models.User;
import com.google.inject.Inject;

import java.util.concurrent.Executor;

/**
 * User parser from rest api request.
 */
public class UserBodyParser extends AbstractBodyParser<User> {
    @Inject
    public UserBodyParser(Json jsonParser, Executor executor) {
        super(jsonParser, executor);
    }
}
