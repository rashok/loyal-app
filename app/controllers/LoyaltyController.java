package controllers;

import com.google.gson.JsonObject;
import play.Logger;
import play.Play;
import play.libs.WS;
import play.mvc.Before;
import play.mvc.Controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

/**
 * Created by rashok on 3/29/16.
 */
public class LoyaltyController extends Controller{

    private static String accountId;
    private static String baseUrl;
    private static String secretKey;
    private static String md5Hash;

    @Before
    private static void getProperties() {
        accountId = Play.configuration.getProperty("loyalty.account.id");
        baseUrl = Play.configuration.getProperty("loyalty.api.baseurl");
        secretKey = Play.configuration.getProperty("loyalty.api.secret");
        Logger.debug("Account Id fetched - " + accountId);
        Logger.debug("API URL fetched - " + baseUrl);
    }

    private static byte[] getMd5Hash(String email, String accountId) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String baseString = secretKey + "email" + email + "uuid" + accountId;
        byte[] bytesOfMessage = baseString.getBytes("UTF-8");

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        return thedigest;
    }

    public static void enroll(String email) {
        //Play.configuration.getProperty()
        System.out.println(accountId);
        HashMap payload = new HashMap();
        payload.put("email", email);
        payload.put("uuid", accountId);
        WS.HttpResponse res = WS.url(baseUrl + "/api/enroll.json").params(payload).get();

        WS.url("https://yourapihere-com-gwo5ia8n4ee8.runscope.net/").params(payload).get();
        Logger.debug(res.getString());
        renderJSON("ok");
    }
}
