package com.epam.userapi.controllers;


import com.epam.userapi.services.UserService;
import lombok.extern.slf4j.Slf4j;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;

/**
 * Picture Controller.
 */
@Slf4j
@Singleton
public class PictureController extends Controller {

    private static final String IMAGE_FILE_NAME = "image";
    private static final String STORAGE_OF_IMAGES = "public/images/";
    private static final String IMAGE_PATH = "/assets/images/";

    @Inject
    private PictureProvider pictureProvider;

    @Inject
    private UserService userService;

    public Result save(String userId) {
        return ok(pictureProvider.save(request().body().asMultipartFormData().getFile(IMAGE_FILE_NAME), userId));
    }

    public Result download(String userId) {
        return ok(new File(STORAGE_OF_IMAGES +
                userService.getById(userId).getAvatarUrl().replace(IMAGE_PATH, "")), Boolean.FALSE);
    }
}
