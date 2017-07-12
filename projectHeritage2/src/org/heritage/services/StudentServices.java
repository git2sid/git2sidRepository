package org.heritage.services;

import java.util.List;

import org.heritage.dao.StudentDAO;
import org.heritage.model.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {
	StudentDAO studentDAO;
@Autowired
private void setStudentDao(StudentDAO studentDAO)
{
this.studentDAO=studentDAO;
}

public List<DataModel> getData()
{
	List<DataModel> list=studentDAO.getDataModel();
	return list;
}

}
