package com.trabajo.utn.trabajo_practico;

import android.app.Application;
import android.net.Uri;
import android.test.ApplicationTestCase;

import com.trabajo.utn.trabajo_practico.utils.HttpManager;

import junit.framework.Assert;

import java.io.IOException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void test(){
        Uri.Builder params = new Uri.Builder();
        params.appendQueryParameter("email","julian.a.moreno@hotmail.com");
        params.appendQueryParameter("password", "123");

        try {
            HttpManager.getBytesDataByPOST(params,"http://lkdml.myq-see.com/login");
            Assert.assertEquals(200,HttpManager.response);
        } catch (IOException e) {
            fail();
        }
    }

}