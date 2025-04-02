package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class C14_Post_ExpectedDataVeJsonPathIleAssertion {

    @Test
    public void test(){


        /*

                 https://restful-booker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST request
            gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.
             Request body
             {
             }
             "firstname" : "Ahmet",
             "lastname" : “Bulut",
             "totalprice" : 500,
             "depositpaid" : false,
             "bookingdates" : {
             "checkin" : "2021-06-01",
             "checkout" : "2021-06-10"
             },
             "additionalneeds" : "wi-fi"


                Response Body
                 {
                 }
                 "bookingid": 24,
                 "booking": {
                 "firstname": "Ahmet",
                 "lastname": "Bulut",
                 "totalprice": 500,
                 "depositpaid": false,
                 "bookingdates": {
                 "checkin": "2021-06-01",
                 "checkout": "2021-06-10"
                 },
                 "additionalneeds": "wi-fi"
                 }

         */


        // 1- Endpoint ve reqBody hazırlama

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject reqBody = new JSONObject();
        JSONObject rezervasyonTarih = new JSONObject();

        rezervasyonTarih.put("checkin", "2021-06-01");
        rezervasyonTarih.put("checkout","2021-06-10");

        reqBody.put( "firstname","Ahmet");
        reqBody.put( "lastname", "Bulut");
        reqBody.put( "totalprice",500);
        reqBody.put( "depositpaid",false);
        reqBody.put( "bookingdates",rezervasyonTarih);
        reqBody.put( "additionalneeds","wi-fi");



        // 2- Expected Data olusturma

        JSONObject expectedData = new JSONObject();

        expectedData.put("bookingid",3959);
        expectedData.put("booking",reqBody);

        // 3- request gonder ve donen respons2ı kaydet

        Response response = given().contentType(ContentType.JSON)
                            .when().body(reqBody.toString())
                            .post(url);


        // 4- Assertion

        JsonPath responseJsonPath = response.jsonPath();
        // ilk yazilan expected ==> olusturdugumuz JsonObject : expectedData
        // ikinci yazılan actual ==> response :responseJsonPath
        assertEquals(expectedData.getJSONObject("booking").get("firstname"),
                    responseJsonPath.get("booking.firstname"));
        assertEquals(expectedData.getJSONObject("booking").get("lastname"),
                    responseJsonPath.get("booking.lastname"));
        assertEquals(expectedData.getJSONObject("booking").get("totalprice"),
                    responseJsonPath.get("booking.totalprice"));
        assertEquals(expectedData.getJSONObject("booking").get("depositpaid"),
                    responseJsonPath.get("booking.depositpaid"));
        assertEquals(expectedData.getJSONObject("booking").get("additionalneeds"),
                    responseJsonPath.get("booking.additionalneeds"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));
        assertEquals(expectedData.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));











    }


}
