package com.techproed.TestData;

import java.util.HashMap;

public class TestDataHerokuApp {
    /*
        {
            "firstname": "Eric",
                "lastname": "Smith",
                "totalprice": 555,
                "depositpaid": false,
                "bookingdates": {
            "checkin": "2016-09-09",
                    "checkout": "2017-09-21"
        }
        } gibi olduğunu test edin
       */
    public HashMap<String, Object> setUpTestData(){


        //bookingdates içerisinde ayrı bir map yapısı vardır. bu sebeple bu kısım ayrı map oluşturulur
        // mapin type i String, String olur çünkü checkin ve checout değerleri Stringtir.

        HashMap<String,String> bookingDatesMap=new HashMap<String, String>();
        bookingDatesMap.put("checkin","2015-09-21");
        bookingDatesMap.put("checkout","2020-12-13");


        HashMap<String,Object> expectedDataMap=new HashMap<String, Object>();
        expectedDataMap.put("firstname","Mary");
        expectedDataMap.put("lastname","Ericsson");
        expectedDataMap.put("totalprice",267);
        expectedDataMap.put("depositpaid",false);
        expectedDataMap.put("bookingdates",bookingDatesMap);// ilk oluşturduğumuz mapi ikinci mapin içerisine aldık
        return expectedDataMap;

    }



}