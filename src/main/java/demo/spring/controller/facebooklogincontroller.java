package demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import demo.spring.info.info;
import demo.spring.service.facebookService;

@Controller
public class facebooklogincontroller {
	@Autowired
	private facebookService sv;

	@GetMapping("/trangchu")
	public String home() {
		return "hello";
	}

	@GetMapping(value = "/facebookLogin")
	public String facebookLogin() {
		return "redirect:" + sv.facebookLogin();
	}

	@GetMapping(value = "/doLogin")
	public String doLogin(@RequestParam("code") String code,ModelMap model) {
		Connection<Facebook> connection = sv.connection(sv.createAccessToken(code));
		Facebook facebook = connection.getApi();
		info ifo = new info();
		String[] fields = { "id", "name", "email" };
		User userProfile = facebook.fetchObject("me", User.class, fields);
		System.out.println("id........... " + userProfile.getId());
		System.out.println("name........... " + userProfile.getName());
		System.out.println("email........... " + userProfile.getEmail());
		ifo.setId(userProfile.getId());
		ifo.setName(userProfile.getName());
		ifo.setEmail(userProfile.getEmail());
		model.addAttribute("info", ifo);
		return "success";
	}

}
