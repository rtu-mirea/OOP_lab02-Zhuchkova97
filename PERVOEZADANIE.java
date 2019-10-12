package com.company;

public class PERVOEZADANIE{
    private String t;
    private int indOfPar = 0;

    public String get(){return t;}

    public void input(String Text){t = Text;}

    public void toUpperWords(){
        String buf = "";
        int parArr[] = new int[indOfPar + 1];
        parArr[0] = 0;
        for (int i = 0, n = 1; i < t.length() && n < parArr.length; i++){
            if (t.charAt(i) == '\n'){
                parArr[n] = i;
                n++;
            }
        }
        for (int i = 0; i < parArr.length - 1; i++){
            buf+= toUpper(t.substring(parArr[i], parArr[i+1]));
        }
        t = buf + '\n';
    }

    private String toUpper(String str){
        String buf = "";
        int start = 0, end;
        end = str.indexOf(' ');
        start = str.lastIndexOf(' ');
        buf += str.substring(0, end).toUpperCase()+ str.substring(end, start) + str.substring(start).toUpperCase();
        return buf;
    }

    public void paragraphDivision(){
        String b = "";
        for(int i = 0; i < t.length(); i++){
            if(t.charAt(i) != '.' && t.charAt(i) != '?' && t.charAt(i) != '!')
                b += t.charAt(i);
            else{
                b += t.charAt(i);
                b+='\n';
                i++;
                indOfPar++;
            }
        }
        t = b;
    }

    public int findAmIn(int n){
        String s = '\n' + t;
        int start = 0, end = 0, count = 0;
        for (int i = 0; i <= s.length();i++){
            if (count < n){
                start = s.indexOf('\n', i) + 1;
                i = start;
                end = s.indexOf('\n', i + 1) - 1;
                i = end;
                count++;
            }
            else break;
        }
        s = s.substring(start, end);
        count = 0;
        for (int i = 0; i < s.length(); i++){
            i = s.indexOf("ам", i) + 1;
            if (i > 0)
                count++;
            else return count;
        }
        return count;
    }

    public String wordNum(){
        Integer count = 1;
        String s = t;
        for(int i =0 ; i< t.length(); i++){
            if(t.charAt(i) == ' ' || t.charAt(i) == '\n') count++;
        }
        return s += "Количество слов в тексте = " + (--count);
    }
}
