package tests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C13_Get_ExpectedDataOlusturma {

    @Test
    public void test() {

        /*


                 https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request
        yolladigimizda donen response body’sinin asagida verilen ile ayni oldugunutest ediniz
         Response body :
         {
         }
         "userId": 3,
         "id": 22,
         "title": "dolor sint quo a velit explicabo quia nam",



         */

        // 1- Endpoınt ve req body olustur

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- Expected Data olustur

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId", 3);
        expectedData.put("id", 22);
        expectedData.put("title", "dolor sint quo a velit explicabo quia nam");


        // 3- Request gonder, donen response kaydet

        Response response = given().when().get(url);

        // 4- Assertion

      /* Bugune kadar yaptigimiz yontemle de testimizi yapabiliriz
               Ancak framework'umuzu gelistirmeye devam etmeliyiz

        response
                .then()
                .assertThat()
                .body("userId", equalTo(3),
        "id",equalTo(22),
        "title",equalTo("dolor sint quo a velit explicabo quia nam"));


       */

        JsonPath responseLsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("id"),responseLsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseLsonPath.get("title"));
        Assert.assertEquals(expectedData.get("userId"),responseLsonPath.get("userId"));












    }
}
