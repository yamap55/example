package com.yamap55.lombok;

import java.util.List;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Hoge {
	private int id;
	private String name;
	private List<String> list;

}