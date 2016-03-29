package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import services.LoyaltyService;

public class Application extends Controller {

    public static void boot() {
        render();
    }

    public static void index() {
        render();
    }

    public static void viewSignUp() {
        render();
    }

    public static void welcome() {
        render();
    }

    public static void signup (String email) {
        LoyaltyController.enroll(email);
        welcome();
    }

}