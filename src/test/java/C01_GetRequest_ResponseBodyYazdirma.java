import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_ResponseBodyYazdirma {

    @Test
    public void get01(){

        // https://restfull-booker.herokuapp.com/booking/10  url'ine
        // bir GET request gonderdigimizde donen response'u yazdırın

        // 1- Request body ve endpoint hazirlama

        String url = "https://restful-booker.herokuapp.com/booking/10";


        // 2- Expected data hazirlama


        // 3- Request gönderip, donen response'i kaydetme

        Response response = given().when().get(url);

        response.prettyPrint();



        // 4- Assetion







    }
}
