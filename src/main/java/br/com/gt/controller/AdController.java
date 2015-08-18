package br.com.gt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdController {

	@RequestMapping("/")
	public String ad() {
		return "/ad";
	}
}
