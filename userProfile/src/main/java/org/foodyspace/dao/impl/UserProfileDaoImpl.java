package org.foodyspace.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.foodyspace.constants.QueryConstants;
import org.foodyspace.dao.UserProfileDao;
import org.foodyspace.model.UserProfileModel;

import com.mysql.cj.jdbc.PreparedStatement;
//import org.springframework.stereotype.Service;

//@Component(value="profileDAO")

public class UserProfileDaoImpl extends AbstractDaoImpl implements UserProfileDao {

	//final static Logger logger = LogManager.getLogger(UserProfileDaoImpl.class);
	private static String FETCH_USERS_PROFILE_QUERY = "SELECT * FROM profile WHERE UPPER(location)=";

	/*
	 * public ProfileDAO() { System.out.println("inside dao"); }
	 * 
	 * public String showService() { return "service"; } private JdbcTemplate
	 * jdbc;
	 * 
	 * @Inject public void setDataSource(DataSource jdbc) { this.jdbc = new
	 * JdbcTemplate(jdbc); }
	 * 
	 * public List<DataModel> getDataModel() { return
	 * jdbc.query("select * from student", new RowMapper<DataModel>() {
	 * 
	 * public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
	 * DataModel dataModel = new DataModel();
	 * 
	 * dataModel.setId(rs.getString("studentId"));
	 * 
	 * 
	 * 
	 * return dataModel; }
	 * 
	 * });
	 * 
	 * }
	 */
	public List<UserProfileModel> getUsersByLocation(String location) throws Exception {
		System.out.println("-->>> getUsersByLocation(String location) method");
		Connection con = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserProfileModel> usersList = new ArrayList<UserProfileModel>();
		try {
			StringBuilder query = new StringBuilder();
			query.append(FETCH_USERS_PROFILE_QUERY)
				.append(QueryConstants.UPPER)
					.append(QueryConstants.OPENNING_BRACE)
						.append(QueryConstants.SINGLE_QUOTE)
							.append(location)
								.append(QueryConstants.SINGLE_QUOTE)
									.append(QueryConstants.CLOSING_BRACE);
			System.out.println("query :" + query);
			ps = (PreparedStatement) con.prepareStatement(query.toString());

			rs = ps.executeQuery();
			while (rs.next()) {
				UserProfileModel profileModel = new UserProfileModel();
				profileModel.setClose(rs.getString(QueryConstants.CLOSE));
				profileModel.setClose1(rs.getString(QueryConstants.CLOSE1));
				profileModel.setClose2(rs.getString(QueryConstants.CLOSE2));
				profileModel.setClose3(rs.getString(QueryConstants.CLOSE3));
				profileModel.setClose4(rs.getString(QueryConstants.CLOSE4));
				profileModel.setClose5(rs.getString(QueryConstants.CLOSE5));
				profileModel.setClose6(rs.getString(QueryConstants.CLOSE6));
				profileModel.setContact(rs.getString(QueryConstants.CONTACT));
				profileModel.setDel_time(rs.getString(QueryConstants.DEL_TIME));
				profileModel.setDescription(rs.getString(QueryConstants.DESCRIPTION));
				profileModel.setEmail(rs.getString(QueryConstants.EMAIL));
				profileModel.setLocation(rs.getString(QueryConstants.LOCATION));
				profileModel.setOpen(rs.getString(QueryConstants.OPEN));
				profileModel.setOpen1(rs.getString(QueryConstants.OPEN1));
				profileModel.setOpen2(rs.getString(QueryConstants.OPEN2));
				profileModel.setOpen3(rs.getString(QueryConstants.OPEN3));
				profileModel.setOpen4(rs.getString(QueryConstants.OPEN4));
				profileModel.setOpen5(rs.getString(QueryConstants.OPEN5));
				profileModel.setOpen6(rs.getString(QueryConstants.OPEN6));
				profileModel.setShort_des(rs.getString(QueryConstants.SHORT_DES));
				profileModel.setUsername(rs.getString(QueryConstants.USERNAME));
				profileModel.setWebsite(rs.getString(QueryConstants.WEBSITE));
				usersList.add(profileModel);
			}
			System.out.println("<<<-- getUsersByLocation(String location) method");
			System.out.println("Records : " + usersList.size());
			return usersList;
		} catch (Exception e) {
			System.out.println("ERROR inside >>> getUsersByLocation(String location) method : " + e);
			throw e;
		} finally {
			rs.close();
			ps.close();
			con.close();
		}
	}

}
