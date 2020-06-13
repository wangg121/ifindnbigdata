package com.ifindn.elk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class ElkApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElkApplication.class, args);


        Pattern regx = Pattern.compile("a");
        Matcher matcher = regx.matcher("aa");
        matcher.find();
    }

}
