package com.company;

public class VTOROEZADANIE {
    private StringBuilder text;
    private int indexOfPar = 0;

    public StringBuilder get() {
        return text;
    }

    public void input(StringBuilder Text) {
        text = Text.append('\n');
    }

    public void toUpperWords(){
        StringBuilder bb = new StringBuilder();
        int arr[] = new int[indexOfPar + 1];
        arr[0] = 0;
        for (int i = 0, n = 1; i < text.length() && n < arr.length; i++){
            if (text.charAt(i) == '\n'){
                arr[n] = i;
                n++;
            }
        }
        for (int i = 0; i < arr.length - 1; i++){
            bb.append(toUpper(arr[i], arr[i+1]));
        }
        //text = buf + '\n';
        text = bb.append('\n');
    }

    private StringBuilder toUpper(int a, int b){
        StringBuilder s = new StringBuilder(text.substring(a, b));
        String bb = "";
        int st = 0, e;
        e = s.indexOf(" ");
        st = s.lastIndexOf(" ");
        bb += s.substring(0, e).toUpperCase()+ s.substring(e, st) + s.substring(st).toUpperCase();

        return new StringBuilder(bb);
    }

    public void paragDivision() {
        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == '?' || text.charAt(i) == '!') {
                text.setCharAt(i + 1, '\n');
                i++;
                indexOfPar++;
            }
        }
    }

    public void paragCount(){
        text.append("Количество предложений в тексте = " + indexOfPar + ".\n");
        indexOfPar++;
    }
}
