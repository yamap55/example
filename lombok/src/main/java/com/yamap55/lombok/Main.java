package com.yamap55.lombok;

import java.util.ArrayList;

import lombok.val;

public class Main {
    public static void main(String[] args) {
    	Hoge hoge1 = new Hoge();

    	val list = new ArrayList<String>();
    	list.add("a");
    	list.add("b");

    	hoge1.setId(10);
    	hoge1.setName("ほげ");
    	hoge1.setList(list);

    	Hoge hoge2 = new Hoge(20, "ほげ2",list);


    	System.out.println(hoge1);
    	System.out.println(hoge2);
    }
}