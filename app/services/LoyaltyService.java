package services;

import play.Logger;
import play.Play;
import play.mvc.Before;
import play.mvc.Controller;

/**
 * Created by rashok on 3/29/16.
 */
public class LoyaltyService extends Controller {

    private String accountId;

    @Before
    private void getProperties() {
        accountId = Play.configuration.getProperty("loyalty.account.id");
        Logger.debug("Account Id fetched - " + accountId);
    }

    public static void enroll(String email) {
        //Play.configuration.getProperty()
        renderJSON("ok");
    }
}
