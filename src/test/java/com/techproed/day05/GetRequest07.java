package com.techproed.day05;

import com.techproed.testBase.TestBaseHerokuapp;
import com.techproed.testBase.TestBaseJsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest07 extends TestBaseHerokuapp {
/*
https://restful-booker.herokuapp.com/booking/5 url’ine bir request yolladigimda
 HTTP Status Code’unun 200
 ve response content type’inin “application/JSON” oldugunu
ve response body’sinin asagidaki gibi oldugunu test edin
{"firstname": Sally,
 "lastname": "Smith",
 "totalprice": 789,
 "depositpaid": false,
 "bookingdates": { "checkin": "2017-12-11",
 "checkout":"2020-02-20" }
 }
 */

    @Test
    public void test(){
        spec02.pathParams("para1","booking","para2",5);
        Response response = given().accept("application/json").
                spec(spec02).when().get("/{para1}/{para2}");
        response.prettyPrint();
/*
        response.then().assertThat().
                statusCode(200).
                contentType(ContentType.JSON).body("firstname", Matchers.equalTo("Mark"),
                "lastname",Matchers.equalTo("Brown"),
                "totalprice",Matchers.equalTo(797),
                "bookingdates.checkin",Matchers.equalTo("2019-06-21"));

 */

        JsonPath json = response.jsonPath();
        Assert.assertEquals("Mary",json.getString("firstname"));
        Assert.assertEquals("Smith",json.getString("lastname"));
         Assert.assertEquals(649,json.getInt("totalprice"));
         Assert.assertEquals(true,json.getBoolean("depositpaid"));
        Assert.assertEquals(200,response.getStatusCode());

    }

}
