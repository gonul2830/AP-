package com.techproed.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
public class GetRequest01 {
    /*
    GetRequest01:
https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
ØHTTP status kodunun 200
ØContent Type’in Json
ØVe Status Line’in HTTP/1.1 200 OK
Oldugunu test edin.
     */
    @Test
    public void test01(){
        //1.adım : url belirlenmeli
        String url = "https://restful-booker.herokuapp.com/booking/3 ";
         // 2. Adim: expected result olustur..
        Response response = given().accept("application/json").when().get(url);
        //3.Adim: Request gönder
        response.prettyPrint();

        //4.Adim : Response yi al (accual result)

        //5.Adim : Assetion islemini yapalım

      response.then().
              assertThat().
              statusCode(200).
              contentType(ContentType.JSON).
              statusLine("HTTP/1.1 200 OK");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeaders());
        System.out.println(response.getContentType());


    }
}
