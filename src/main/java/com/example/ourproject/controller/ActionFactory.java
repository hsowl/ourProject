package com.example.ourproject.controller;

import com.example.ourproject.controller.action.*;

public class ActionFactory {

    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {
    }

    public static ActionFactory getInstance() {
        return instance;
    }

    public static Action getAction(String command) {
        Action action = null;

        if (command.equals("my_Info")) {
            action = new myInfoAction();
        } else if (command.equals("login")) {
            action = new loginAction();
        } else if (command.equals("joinMember")) {
            action = new joinMemberAction();
        } else if (command.equals("cartUpdate")) {
            action = new cartUpdateAction();
        } else if (command.equals("main")) {
            action = new MainAction();
        } else if (command.equals("productDetail")) {
            action = new productDetailAction();
        } else if (command.equals("Board_write_form")) {
            action = new boardWriteAction();
        } else if (command.equals("orderSearch")) {
            action = new orderSearchAction();
        } else if (command.equals("cart")) {
            action = new cartAction();
        } else if (command.equals("idCheck")) {
            action = new idCheckAction();
        } else if (command.equals("infoUpdate")) {
            action = new infoUpdateAction();
        }
        return action;
    }

}

