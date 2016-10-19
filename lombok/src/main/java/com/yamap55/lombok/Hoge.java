package com.yamap55.lombok;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // Hoge(int id, String name, List<String> list)
@NoArgsConstructor // Hoge()
@ToString // toString
@Data // getter setter
@EqualsAndHashCode // equals, hashcode
public class Hoge {
	private int id;
	private String name;
	private List<String> list;
}