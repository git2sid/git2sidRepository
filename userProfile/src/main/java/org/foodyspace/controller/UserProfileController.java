package org.foodyspace.controller;

import java.util.List;

//import java.awt.PageAttributes.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.foodyspace.model.UserProfileModel;
import org.foodyspace.service.UserProfileService;
import org.foodyspace.service.impl.UserProfileServiceImpl;


@Path("/")
public class UserProfileController {
	//final static Logger logger = LogManager.getLogger(UserProfileController.class);
	//StudentService student=new StudentService();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{location}")
	public List<UserProfileModel> getUsersByLocation(@PathParam("location") String location) {
		System.out.println("location :" + location);
		List<UserProfileModel> usersList = null;
		UserProfileService userProfileService = new UserProfileServiceImpl();
		usersList= userProfileService.getUsersByLocation(location);
		return usersList;
	}
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> showTester()
	{
		//System.out.println(dao.showService());
		System.out.println(student.showCustomer());
		return student.showCustomer();
	}*/

}
