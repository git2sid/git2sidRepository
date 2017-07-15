package org.foodyspace.service;

import java.util.List;

import org.foodyspace.model.UserProfileModel;

public interface UserProfileService {
	public List<UserProfileModel> getUsersByLocation(String location);
}
