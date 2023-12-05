package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();

    public Request(String command) {
        System.out.println(command);
        String[] commandSplit = command.split("\\?", 2);

        actionCode = commandSplit[0];

        if (commandSplit.length == 1) return;

        String[] paramsList = commandSplit[1].split("&");

        for (String paramsRow : paramsList) {
            String[] paramsStr = paramsRow.split("=", 2);

            if (commandSplit.length == 1) return; //예외처리

            String key = paramsStr[0];
            String value = paramsStr[1]; //d

            params.put(key, value);
        }
        System.out.println("actionCode : " + actionCode);
        System.out.println("params : " + params);
    }

    public String getActionCode() {
        return actionCode;
    }

    public String getParams(String key) {
        return params.get(key);
    }
}
