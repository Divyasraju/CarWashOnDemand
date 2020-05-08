package com.casestudy.ondemandcarwash.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.casestudy.ondemandcarwash.model.CarWasher;

public class ExcelGenerator {

	public static ByteArrayInputStream CarWashersToExcel(List<CarWasher> carWashers) throws IOException {
		String[] COLUMNs = { "id", "washerName", "washerNo", "mailId","washerId"};
		try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
			CreationHelper createHelper = workbook.getCreationHelper();

			Sheet sheet = workbook.createSheet("CarWashers");

			Font headerFont = workbook.createFont();
			headerFont.setBold(true);
			headerFont.setColor(IndexedColors.BLUE.getIndex());

			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			// Row for Header
			Row headerRow = sheet.createRow(0);

			// Header
			for (int col = 0; col < COLUMNs.length; col++) {
				Cell cell = headerRow.createCell(col);
				cell.setCellValue(COLUMNs[col]);
				cell.setCellStyle(headerCellStyle);
			}

			int rowIdx = 1;
			for (CarWasher carWasher : carWashers) {
				Row row = sheet.createRow(rowIdx++);

				row.createCell(0).setCellValue(carWasher.getId());
				row.createCell(1).setCellValue(carWasher.getWasherName());
				row.createCell(2).setCellValue(carWasher.getWasherNo());
				row.createCell(3).setCellValue(carWasher.getMailId());
				row.createCell(4).setCellValue(carWasher.getWasherId());

			}

			workbook.write(out);
			return new ByteArrayInputStream(out.toByteArray());
		}
	}
}
