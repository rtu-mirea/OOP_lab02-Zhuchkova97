package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TRETIEZADANIE {
    String t;
    String REPLACE = " * ";
    Pattern pattern = Pattern.compile("(\\d)\\1");


    public String ghetText(){return t;}

    public void changeNum(){
        Matcher m = pattern.matcher(t);
        t = m.replaceAll(REPLACE);
    }

    public static Boolean checkNum(String str){
        if (str.length() == 2) {
            if (str.charAt(0) == str.charAt(1) && str.charAt(0) >= '0' && str.charAt(0) <= '9')
                    return true;
                else return false;
            }
        else return false;
    }

    public void inputText(String str){
        if (str.charAt(str.length() - 1) != ' ')
            str += ' ';
        t = str;
    }
}
