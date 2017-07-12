
package org.heritage.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.jar.Attributes.Name;

import javax.sql.DataSource;

import org.heritage.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;



//import com.caveofprogramming.spring.test.Offer;
@Component(value="studentDAO")
public class StudentDAO {

	public StudentDAO()
	{
		System.out.println("successfulllyy loded studentdao");
		System.out.println("successfulllyy loded studentdao");
	}
	private JdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new JdbcTemplate(jdbc);
	}

	public List<DataModel> getDataModel() {
		return jdbc.query("select * from student", new RowMapper<DataModel>() {

			public DataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
				DataModel dataModel = new DataModel();
/*
				offer.setId(rs.getInt("id"));
				offer.setName(rs.getString("name"));
				offer.setText(rs.getString("text"));
				offer.setEmail(rs.getString("email"));*/
				
				dataModel.setId(rs.getString("studentId"));
			
			
			
				return dataModel;
			}
		
		});
	
	}
}
