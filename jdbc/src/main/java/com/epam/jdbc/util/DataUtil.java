package com.epam.jdbc.util;

import com.epam.jdbc.bean.Friendship;
import com.epam.jdbc.bean.Like;
import com.epam.jdbc.bean.Post;
import com.epam.jdbc.bean.User;
import com.google.common.collect.Lists;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataUtil {

    public static List<User> prepareUsersList() {
        List<User> users = Stream.of("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")
                .map(name -> {
                    String[] fullName = name.split(" ");
                    return new User(UUID.randomUUID(), fullName[0], fullName[1], getRandomDateOfBirth());
                })
                .collect(Collectors.toList());

        for (int i = 0; i <= 1001; i++) {
            User user = users.get(getRandomNumberInRange(0, 3));
            users.add(new User(UUID.randomUUID(), user.getName() + "-" + UUID.randomUUID(), user.getSurname(), getRandomDateOfBirth()));
        }
        return users;
    }

    public static List<Post> preparePosts(List<UUID> userIds) {
        List<Post> posts = Lists.newArrayList();

        for (int i = 0; i <= 2000; i++) {
            Post post = new Post(UUID.randomUUID(),
                    userIds.get(getRandomNumberInRange(0, userIds.size())),
                    "text of post: " + UUID.randomUUID(), generateDate());
            posts.add(post);
        }
        return posts;
    }

    public static List<Friendship> prepareFriendships(List<UUID> userIds) {
        List<Friendship> friendships = Lists.newArrayList();
        for (int i = 0; i <= 75000; i++) {
            UUID user1Id = userIds.get(getRandomNumberInRange(0, userIds.size()));
            UUID user2Id = userIds.get(getRandomNumberInRange(0, userIds.size()));
            while (user2Id.equals(user1Id)) {
                user2Id = userIds.get(getRandomNumberInRange(0, userIds.size()));
            }
            friendships.add(new Friendship(user1Id, user2Id, generateDate()));
        }
        return friendships;
    }

    public static List<Like> prepareLikes(List<UUID> userIds, List<UUID> postIds) {
        List<Like> likes = Lists.newArrayList();
        for (int i = 0; i <= 305000; i++) {
            UUID postId = postIds.get(getRandomNumberInRange(0, postIds.size()));
            UUID userId = userIds.get(getRandomNumberInRange(0, userIds.size()));
            likes.add(new Like(postId, userId, generateDate()));
        }
        return likes;
    }

    private static Date getRandomDateOfBirth() {
        return new Date(-946771200000L + Math.abs(new Random().nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
    }

    private static int getRandomNumberInRange(int min, int max) {
        return new Random().ints(min, (max)).findFirst().getAsInt();
    }

    private static Date generateDate() {
        long start = LocalDate.of(2018, 2, 20).toEpochDay();
        long end = LocalDate.of(2018, 4, 20).toEpochDay();
        long randomEpochDay = ThreadLocalRandom.current().longs(start, end).findAny().getAsLong();
        return Date.valueOf(LocalDate.ofEpochDay(randomEpochDay));
    }
}
