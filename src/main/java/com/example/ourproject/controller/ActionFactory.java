package com.example.ourproject.controller;

import com.example.ourproject.controller.action.Action;
import com.example.ourproject.controller.action.JoinMemberAction;
import com.example.ourproject.controller.action.myInfoAction;

public class ActionFactory {

    private static ActionFactory instance = new ActionFactory();

    private ActionFactory() {}

    public static ActionFactory getInstance() {
        return instance;
    }

    public static Action getAction(String command) {
        Action action = null;

        if(command.equals("my_Info")){
            action = new myInfoAction();
        }else if(command.equals("login")) {
            action = new loginAction();
        }else if(command.equals("joinMember")) {
            action = new JoinMemberAction();
        }


        return action;
    }

}

