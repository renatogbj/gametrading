package br.com.gt.model.enums;

import java.util.ArrayList;
import java.util.List;

public enum Platform {
	PS4("PlayStation 4"),
	XBOX_ONE("XBox One");
	
	private String name;
	
	Platform(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static List<String> nameValues() {
		List<String> names = new ArrayList<String>();
		for (Platform platform : values()) {
			names.add(platform.getName());
		}
		return names;
	}
}
