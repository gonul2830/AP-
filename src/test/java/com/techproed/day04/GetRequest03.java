package com.techproed.day04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
    /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 200
ve content type'inin "application/json"
ve firstname'in "Sally"
ve lastname'in "Ericsson"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */

    @Test
    public void test03(){
        String url ="https://restful-booker.herokuapp.com/booking/7";
        Response response = given().accept("application/json").when().get(url);
        response.prettyPrint();
        /*
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                body("firstname", Matchers.equalTo("Sally")).
                body("lastname",Matchers.equalTo("Jones")).
                body("totalprice",Matchers.equalTo(238)).
                body("bookingdates.checkin",Matchers.equalTo("2018-11-30")).
                body("bookingdates.checkout",Matchers.equalTo("2021-05-21"));

         */

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname",equalTo("Mary"),"lastname", equalTo("Wilson"),
                        "totalprice", equalTo(220),
                        "bookingdates.checkin", equalTo("2016-12-20"),
                        "bookingdates.checkout", equalTo("2019-04-07"));
        System.out.println("butun hearslar"+ response.getHeaders());
        System.out.println("firstname"+ response.getHeader("firstname"));
    }
}
