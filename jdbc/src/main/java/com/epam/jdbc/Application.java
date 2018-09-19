package com.epam.jdbc;

import com.epam.jdbc.bean.Friendship;
import com.epam.jdbc.bean.Like;
import com.epam.jdbc.bean.Post;
import com.epam.jdbc.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.epam.jdbc.util.DataUtil.*;
import static com.epam.jdbc.util.DbUtil.*;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String args[]) {
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        prepareDbStructure(jdbcTemplate);

        List<User> users = prepareUsersList();
        insertUsers(users, jdbcTemplate);
        List<UUID> userIds = users.stream().map(User::getId).collect(Collectors.toList());

        List<Post> posts = preparePosts(userIds);
        insertPosts(posts, jdbcTemplate);
        List<UUID> postIds = posts.stream().map(Post::getId).collect(Collectors.toList());

        List<Friendship> friendships = prepareFriendships(userIds);
        insertFriendships(friendships, jdbcTemplate);

        List<Like> likes = prepareLikes(userIds, postIds);
        insertLikes(likes, jdbcTemplate);

        List<Map<String, Object>> maps = jdbcTemplate.queryForList(
                "SELECT distinct(u.name) FROM users u " +
                        "WHERE " +
                        "(SELECT count(*) FROM friendships f WHERE MONTH(f.timestamp) = 3 AND YEAR(f.timestamp) = 2018 AND f.userId1=u.id) > 100 " +
                        "AND (SELECT count(*) FROM likes l where MONTH(l.timestamp) = 3 AND YEAR(l.timestamp) = 2018 AND l.userId=u.id) > 100;");

        log.info("Print out all names (only distinct) of users who has more when 100 friends and 100 likes in March 2018.\n ------------------------------------------------------------------------------------");
        maps.stream().map(map -> map.get("NAME").toString()).collect(Collectors.toList()).forEach(log::info);
    }
}