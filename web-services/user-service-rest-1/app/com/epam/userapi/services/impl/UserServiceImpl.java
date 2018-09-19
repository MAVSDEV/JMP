package com.epam.userapi.services.impl;

import com.epam.userapi.models.User;
import com.epam.userapi.services.UserService;
import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import play.cache.SyncCacheApi;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

/**
 * Implementation of {@link UserService}
 */
@Singleton
public class UserServiceImpl implements UserService {

    private static final String ALL_CACHE_ATTR = "all";

    @Inject
    private SyncCacheApi cache;

    @Override
    public List<User> getAll() {
        Object usersFromCache = cache.get(ALL_CACHE_ATTR);
        return usersFromCache != null ? (List<User>) usersFromCache : Lists.newArrayList();
    }

    @Override
    public User getById(String objectId) {
        return cache.get(objectId);
    }

    @Override
    public void save(User object) {
        cache.set(object.getId(), object);

        Object users = cache.get(ALL_CACHE_ATTR);
        if (users != null) {
            ((List<User>) users).add(object);
        } else {
            cache.set(ALL_CACHE_ATTR, Lists.newArrayList(object));
        }
    }

    @Override
    public void update(User object) {
        cache.set(object.getId(), object);

        Object usersFromCache = cache.get(ALL_CACHE_ATTR);
        if (usersFromCache != null) {
            remove(object.getId());

            cache.set(object.getId(), object);
            ((List<User>) usersFromCache).add(object);
        } else {
            cache.set(ALL_CACHE_ATTR, Lists.newArrayList(object));
        }
    }

    @Override
    public void remove(String objectId) {
        cache.remove(objectId);

        Object usersFromCache = cache.get(ALL_CACHE_ATTR);
        if (usersFromCache != null) {
            List<User> users = (List<User>) usersFromCache;
            Optional<User> userOptional = users.stream().filter(user -> objectId.equalsIgnoreCase(user.getId())).findFirst();
            userOptional.ifPresent(users::remove);
        }
    }
}
