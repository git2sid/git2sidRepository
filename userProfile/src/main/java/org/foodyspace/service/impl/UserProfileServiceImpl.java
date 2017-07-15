package org.foodyspace.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.foodyspace.dao.UserProfileDao;
import org.foodyspace.dao.impl.UserProfileDaoImpl;
import org.foodyspace.model.UserProfileModel;
import org.foodyspace.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService{

	@Override
	public List<UserProfileModel> getUsersByLocation(String location) {
		List<UserProfileModel> usersProfileList = null;
		try {
			UserProfileDao userProfileDao= new UserProfileDaoImpl();
			usersProfileList = userProfileDao.getUsersByLocation(location);
		} catch(Exception e) {
			usersProfileList = new ArrayList<UserProfileModel>();
			System.out.println("Exception caught in UserProfileServiceImpl.getUsersByLocation(): " +e.getMessage());
		}
		return usersProfileList;
	}

}
