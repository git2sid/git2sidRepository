package org.heritage.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.heritage.model.DataModel;
import org.springframework.web.servlet.view.document.AbstractExcelView;



public class ExcelClassUserListView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment: filename=\"userList.xls\"");
		@SuppressWarnings("unchecked")
		List<DataModel> list=(List<DataModel>) model.get("userList");
		HSSFSheet sheet=workbook.createSheet("User List");
		
		Row header =sheet.createRow(0);
		header.createCell(0).setCellValue("username");
		header.createCell(1).setCellValue("id");
		header.createCell(2).setCellValue("address");
		header.createCell(3).setCellValue("age");
		
		int rowNum=1;
		for(DataModel dataModel :list)
		{
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(dataModel.getUsername());
			row.createCell(1).setCellValue(dataModel.getId());
			row.createCell(2).setCellValue(dataModel.getAddress());
			row.createCell(3).setCellValue(dataModel.getAge());
		}

		}

}
