package in.serosoft;

import org.springframework.data.repository.CrudRepository;

import in.serosoft.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
	public UserInfo findByUsername(String username);
}
