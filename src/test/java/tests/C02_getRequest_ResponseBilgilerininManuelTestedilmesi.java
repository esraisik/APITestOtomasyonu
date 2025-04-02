package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_getRequest_ResponseBilgilerininManuelTestedilmesi {

    @Test
    public void test01(){

        /*

                    https://restful-booker.herokuapp.com/booking/10 url’ine bir GET request
                gonderdigimizde donen Response’un,
                 status code’unun 200,
                 ve content type’inin application/json; charset=utf-8,
                 ve Server isimli Header’in degerinin Cowboy,
                 ve status Line’in HTTP/1.1 200 OK
                 ve response suresinin 5 sn’den kisa oldugunu manuel olarak test ediniz.


         */

        // 1- Request body ve endpoint hazirlama

        String url = "https://restful-booker.herokuapp.com/booking/10";


        // 2- Expected data hazirlama


        // 3- Request gönderip, donen response'i kaydetme

        Response response = given().when().get(url);

        response.prettyPrint();

        System.out.println("status code :" + response.getStatusCode()+
                "\nContent type :" + response.getContentType()+
                    "\nServer Header Degeri : " + response.getHeader("Server")+
                "\n Status Line : " + response.statusLine()+
                "\nResponse Suresi : " + response.getTime()+ "ms");



        // 4- Assetion




    }
}
