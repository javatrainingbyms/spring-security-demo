package in.serosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.serosoft.UserInfoService;
import in.serosoft.entity.UserInfo;

@RestController
public class UserController {
	@Autowired
	private UserInfoService userInfoService;
	
	@PostMapping(value="/newuser")
	public UserInfo createNewUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo);
	}
}
