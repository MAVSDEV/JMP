package com.epam.userapi.controllers;

import com.epam.userapi.models.User;
import com.epam.userapi.services.UserService;
import com.google.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import play.mvc.Http;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Slf4j
@Singleton
public class PictureProvider {

    private static final String STORAGE_OF_IMAGES = "public/images/";
    private static final String IMAGE_PATH = "/assets/images/";
    private static final String IMAGE_FORMAT = ".jpg";

    @Inject
    private UserService userService;

    public String save(Http.MultipartFormData.FilePart<Object> image, String userId) {
        log.warn("Start upload image!");
        if (image != null) {
            String imageName = image.getFilename().replace(IMAGE_FORMAT, "");
            imageName += new Date().getTime() + IMAGE_FORMAT;
            try {
                FileUtils.moveFile((File) image.getFile(), new File(STORAGE_OF_IMAGES, imageName));
                log.warn("Image " + image.getFilename() + " for user id: " + userId + " was saved!");


                User user = userService.getById(userId);
                if (user == null) {
                    return "firstly you need to create user!";
                }
                user.setAvatarUrl(IMAGE_PATH + imageName);
                userService.update(user);

                return "Image " + imageName + " was saved!";
            } catch (IOException e) {
                log.error("Image " + image.getFilename() + " for user id: " + userId + " wasn't stored on file system!", e);
            }
        } else {
            return "Missing file!";
        }
        return "Image wasn't uploaded by some reason!";
    }
}