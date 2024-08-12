package com.epam.learn.scripts;

import com.epam.learn.JsonPlaceHolderService;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class RestFunctionalTest {

    @Test(dataProvider = "getResourcesTestData")
    public void getAllResourcesCountTest(String resourcePath, int expectedCount) {
        JsonPlaceHolderService.getAll(resourcePath)
                .statusCode(200)
                .body("size()", equalTo(expectedCount));
    }

    @Test
    public void getSpecificPostTest() {
        JsonPlaceHolderService.getResourceById(JsonPlaceHolderService.POSTS, 100)
                .body("userId", equalTo(10))
                .body("id", equalTo(100))
                .body("title", equalTo("at nam consequatur ea labore ea harum"))
                .body("body", equalTo("cupiditate quo est a modi nesciunt soluta\nipsa voluptas error itaque dicta in\nautem qui minus magnam et distinctio eum\naccusamus ratione error aut"));
    }

    @Test
    public void createPostTest() {
        Map<String, Object> post = new HashMap<>();
        post.put("userId", 1);
        post.put("title", "Mobile");
        post.put("body", "Apple iPhone 15 Pro Max");

        ValidatableResponse vResp = JsonPlaceHolderService.createResource(JsonPlaceHolderService.POSTS, post);

        for (Map.Entry<String, Object> entry : post.entrySet()) {
            vResp.body(entry.getKey(), equalTo(entry.getValue()));
        }
    }

    @Test
    public void updatePostTest() {
        Map<String, Object> post = new HashMap<>();
        post.put("id", 1);
        post.put("userId", 1);
        post.put("title", "XXX");
        post.put("body", "YYYY");

        ValidatableResponse vResp = JsonPlaceHolderService.updateResource(JsonPlaceHolderService.POSTS, 1, post);

        for (Map.Entry<String, Object> entry : post.entrySet()) {
            vResp.body(entry.getKey(), equalTo(entry.getValue()));
        }
    }

    @Test
    public void deletePostTest() {
        JsonPlaceHolderService.deleteResource(JsonPlaceHolderService.POSTS, 1)
                .body(equalTo("{}"));
    }

    @Test
    public void getSpecificCommentTest() {
        JsonPlaceHolderService.getResourceById(JsonPlaceHolderService.COMMENTS, 1)
                .body("postId", equalTo(1))
                .body("id", equalTo(1))
                .body("name", equalTo("id labore ex et quam laborum"))
                .body("email", equalTo("Eliseo@gardner.biz"))
                .body("body", equalTo("laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"));
    }

    @Test
    public void createCommentTest() {
        Map<String, Object> comment = new HashMap<>();
        comment.put("postId", 1);
        comment.put("name", "Satyajit");
        comment.put("email", "satyajit.barman@gmail.com");
        comment.put("body", "Unknown...");

        ValidatableResponse vResp = JsonPlaceHolderService.createResource(JsonPlaceHolderService.COMMENTS, comment);

        for (Map.Entry<String, Object> entry : comment.entrySet()) {
            vResp.body(entry.getKey(), equalTo(entry.getValue()));
        }
    }

    @Test
    public void updateCommentTest() {
        Map<String, Object> comment = new HashMap<>();
        comment.put("id", 1);
        comment.put("postId", 1);
        comment.put("name", "Satyajit");
        comment.put("email", "satyajit.barman@gmail.com");
        comment.put("body", "Unknown...");

        ValidatableResponse vResp = JsonPlaceHolderService.updateResource(JsonPlaceHolderService.COMMENTS, 1, comment);

        for (Map.Entry<String, Object> entry : comment.entrySet()) {
            vResp.body(entry.getKey(), equalTo(entry.getValue()));
        }
    }

    @Test
    public void deleteCommentTest() {
        JsonPlaceHolderService.deleteResource(JsonPlaceHolderService.COMMENTS, 1)
                .body(equalTo("{}"));
    }

    @DataProvider
    public Object[][] getResourcesTestData() {
        Object[][] data = new Object[6][2];

        data[0][0] = JsonPlaceHolderService.POSTS;
        data[0][1] = 100;

        data[1][0] = JsonPlaceHolderService.COMMENTS;
        data[1][1] = 500;

        data[2][0] = JsonPlaceHolderService.ALBUMS;
        data[2][1] = 100;

        data[3][0] = JsonPlaceHolderService.PHOTOS;
        data[3][1] = 5000;

        data[4][0] = JsonPlaceHolderService.TODOS;
        data[4][1] = 200;

        data[5][0] = JsonPlaceHolderService.USERS;
        data[5][1] = 10;

        return data;
    }

}
