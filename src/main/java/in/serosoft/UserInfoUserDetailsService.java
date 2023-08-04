package in.serosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import in.serosoft.config.UserInfoUserDetails;
import in.serosoft.entity.UserInfo;

public class UserInfoUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserInfo userInfo=repository.findByUsername(username);
		if(userInfo==null) {
			throw new UsernameNotFoundException("User : "+username +" Is Not Valid...!");
		}
		UserInfoUserDetails userDetails=new UserInfoUserDetails(userInfo);
		return userDetails;
	}

}
