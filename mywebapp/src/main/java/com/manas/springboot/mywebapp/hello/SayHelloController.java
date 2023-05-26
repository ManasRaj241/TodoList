package com.manas.springboot.mywebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayhello() {
		return "Hiiiiiiiiiiiiiiiiiiiiiiiiiii";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayhelloHTML() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>HomePage</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my first web app");
		sb.append("</body>");
		sb.append("</html>");
		return sb.toString();

	}

	@RequestMapping("say-hello-jsp")
	public String sayhelloJSP() {
		return "sayHello";
	}
}
