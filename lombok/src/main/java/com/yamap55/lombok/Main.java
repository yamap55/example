package com.yamap55.lombok;

import java.util.ArrayList;

import lombok.val;

public class Main {
    public static void main(String[] args) {
    	Hoge hoge = new Hoge();
    	hoge.setId(10);
    	hoge.setName("ほげ");

    	val list = new ArrayList<String>();
    	list.add("a");
    	list.add("b");
    	hoge.setList(list);

    	System.out.println(hoge);

    }
}