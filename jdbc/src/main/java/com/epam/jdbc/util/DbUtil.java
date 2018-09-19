package com.epam.jdbc.util;

import com.epam.jdbc.bean.Friendship;
import com.epam.jdbc.bean.Like;
import com.epam.jdbc.bean.Post;
import com.epam.jdbc.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Slf4j
public class DbUtil {

    public static void prepareDbStructure(JdbcTemplate jdbcTemplate) {
        log.info("Creating tables");

        jdbcTemplate.execute("DROP SCHEMA social_network IF EXISTS");

        jdbcTemplate.execute("CREATE SCHEMA social_network");

        jdbcTemplate.execute("CREATE TABLE users(id VARCHAR(255), name VARCHAR(255), surname VARCHAR(255), birthdate DATETIME)");
        jdbcTemplate.execute("CREATE TABLE posts(id VARCHAR(255), userId VARCHAR(255), text VARCHAR(255), timestamp DATETIME)");
        jdbcTemplate.execute("CREATE TABLE friendships(userId1 VARCHAR(255), userId2 VARCHAR(255), timestamp DATETIME)");
        jdbcTemplate.execute("CREATE TABLE likes(postId VARCHAR(255), userId VARCHAR(255), timestamp DATETIME)");
    }

    public static void insertUsers(List<User> users, JdbcTemplate jdbcTemplate) {
        String usersSql = "INSERT INTO users(id, name, surname, birthdate) VALUES (?,?,?,?)";
        jdbcTemplate.batchUpdate(usersSql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {

                User user = users.get(i);
                ps.setString(1, user.getId().toString());
                ps.setString(2, user.getName());
                ps.setString(3, user.getSurname());
                ps.setDate(4, user.getBirthdate());
            }

            @Override
            public int getBatchSize() {
                return users.size();
            }
        });
    }

    public static void insertPosts(List<Post> posts, JdbcTemplate jdbcTemplate) {
        String postsSql = "INSERT INTO posts(id, userId, text, timestamp) VALUES (?,?,?,?)";
        jdbcTemplate.batchUpdate(postsSql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {

                Post post = posts.get(i);
                ps.setString(1, post.getId().toString());
                ps.setString(2, post.getUserId().toString());
                ps.setString(3, post.getText());
                ps.setDate(4, post.getTimestamp());
            }

            @Override
            public int getBatchSize() {
                return posts.size();
            }
        });
    }

    public static void insertFriendships(List<Friendship> friendships, JdbcTemplate jdbcTemplate) {
        String friendshipsSql = "INSERT INTO friendships(userId1, userId2, timestamp) VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(friendshipsSql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {

                Friendship friendship = friendships.get(i);
                ps.setString(1, friendship.getUserId1().toString());
                ps.setString(2, friendship.getUserId2().toString());
                ps.setDate(3, friendship.getTimestamp());
            }

            @Override
            public int getBatchSize() {
                return friendships.size();
            }
        });
    }

    public static void insertLikes(List<Like> likes, JdbcTemplate jdbcTemplate) {
        String likesSql = "INSERT INTO likes(postId, userId, timestamp) VALUES (?,?,?)";
        jdbcTemplate.batchUpdate(likesSql, new BatchPreparedStatementSetter() {

            @Override
            public void setValues(PreparedStatement ps, int i)
                    throws SQLException {

                Like like = likes.get(i);
                ps.setString(1, like.getPostId().toString());
                ps.setString(2, like.getUserId().toString());
                ps.setDate(3, like.getTimestamp());
            }

            @Override
            public int getBatchSize() {
                return likes.size();
            }
        });
    }
}
