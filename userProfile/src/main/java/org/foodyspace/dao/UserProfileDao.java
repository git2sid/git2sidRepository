package org.foodyspace.dao;

import java.util.List;

import org.foodyspace.model.UserProfileModel;

public interface UserProfileDao {
	public List<UserProfileModel> getUsersByLocation(String location) throws Exception;
}
