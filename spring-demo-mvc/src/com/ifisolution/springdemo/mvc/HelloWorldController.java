package com.ifisolution.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}

	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}

	@RequestMapping("/processFormV3")
	public String letShouteDude(@RequestParam("studentName") String name, Model model) {

		name = name.toUpperCase();

		String result = "Hey my friend from v3 " + name;

		model.addAttribute("message", result);
		return "helloworld";
	}
}
