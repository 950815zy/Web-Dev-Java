package com.itlize.project2.Controller;
import com.itlize.project2.Service.UserService;
import com.itlize.project2.DAO.UserDAO;
import com.itlize.project2.Entity.Product;
import com.itlize.project2.Entity.UserDTO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
//	
	@GetMapping("/getUser/{uid}")
	public UserDTO getPass(@PathVariable("uid") Integer uid) {
		return userService.getbyUser(uid);
	}
	
	
	@GetMapping("/getProd/{pid}")
	public Product getProd(@PathVariable("pid") Integer pid) {
		return userService.getbyProduct(pid);
	}
////	
//	@PostMapping("/signup")
//	public UserDTO signUp(@RequestBody UserDTO user){
//		userService.signUp(user);
//		return user;
//	}
////	
////	@PostMapping("/login")
////	public User logIn(@RequestBody User user){
////		System.out.println("login request..."+user.toString());
////		userService.verification(user.getUsername(),user.getPassword());
////		return user;
////	}
//	
	@PostMapping("/add")
	public UserDTO add(@RequestBody ArrayList<Integer> arr) {
		return userService.add(arr.get(0),arr.get(1));
	}
	
	@RequestMapping({"/hello"})
	public String firstPage() {
		return "hello world!";
	}
}
