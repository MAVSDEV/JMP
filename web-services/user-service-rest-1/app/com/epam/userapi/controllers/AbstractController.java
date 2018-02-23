package com.epam.userapi.controllers;

import com.epam.userapi.services.CommonService;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

/**
 * Abstract Controller.
 */
public abstract class AbstractController <T> extends Controller {

    private final Class<T> type;
    private final CommonService<T> commonService;

    public AbstractController(CommonService<T> commonService, Class<T> type) {
        this.commonService = commonService;
        this.type = type;
    }

    public Result getById(String id) {
        T object = commonService.getById(id);
        if (object != null) {
            return ok(Json.toJson(object));
        } else {
            return noContent();
        }
    }

    public Result getAll() {
        return ok(Json.toJson(commonService.getAll()));
    }

    public Result save(T t) {
        commonService.save(t);
        return ok(type.getSimpleName() + " was saved!");
    }

    public Result update() {
        commonService.update(request().body().as(type));
        return ok(type.getSimpleName() + " was updated!");
    }

    public Result delete(String id) {
        commonService.remove(id);
        return ok(type.getSimpleName() + " with id '" + id + "' was deleted!");
    }
}
