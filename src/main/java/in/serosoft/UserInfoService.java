package in.serosoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.serosoft.entity.UserInfo;

@Service
public class UserInfoService {

		@Autowired
		private UserInfoRepository userInfoRepository;
		
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		public UserInfo addUser(UserInfo userInfo) {
			userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
			return userInfoRepository.save(userInfo);
		}
}
