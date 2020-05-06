package com.controlers;

public class IncognitoController extends Controller {
    IncognitoController() {
        this.actionMap.put("Sign in", this::signIn);
        // this.actionMap.put("Sign up", this::signUp); maybe in the future
        this.actionMap.put("Quit", this::quit);
    }

}
