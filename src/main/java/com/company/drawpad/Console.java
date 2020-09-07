package com.company.drawpad;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Console {

    private BufferedInputStream bf;
    private BufferedReader r;

    public Console() {
        bf = new BufferedInputStream(System.in);
        r = new BufferedReader(
                new InputStreamReader(bf, StandardCharsets.UTF_8));
    }

    public void println(String msg) {
        System.out.println(msg);
    }

    public void print(char msg) {
        System.out.print(msg);
    }

    public void print(String msg) {
        System.out.print(msg);
    }



    public String readLine() {
        String line = "";
        try {
            line = r.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
