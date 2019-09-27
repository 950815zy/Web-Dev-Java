package com.itlize.project2.Controller;
import com.itlize.project2.Service.UserService;
import com.itlize.project2.DAO.UserDAO;
import com.itlize.project2.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/getPass")
	public User getPass(@RequestBody String uname) {
		return userService.getbyUser(uname);
	}
}
