package com.example.commontest.excel.generater;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.List;

@Component
public class ExcelGenerator {

    public Workbook generateExcel(List<?> data, String excelName) throws Exception {
        Workbook workbook = WorkbookFactory.create(true);
        Sheet sheet = workbook.createSheet(excelName);

        if(data.isEmpty()){
            return workbook;
        }

        //엑셀 헤더 설정
        Row headerRow = sheet.createRow(0);
        setExcelHeader(data.get(0).getClass(), headerRow);

        //엑셀 데이터 설정
        int rowNum = 1;
        for(Object obj : data){
            Row row = sheet.createRow(rowNum++);
            setExcelRow(obj, row);
        }

        return workbook;
    }

    private void setExcelHeader(Class<?> clazz, Row headerRow) {
        Field[] fields = clazz.getDeclaredFields();
        int columnIndex = 0;

        for (Field field : fields) {
            ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
            if (annotation != null) {
                String headerName = annotation.headerName();
                Cell cell = headerRow.createCell(columnIndex++);
                cell.setCellValue(headerName);
            }
        }
    }

    private void setExcelRow(Object obj, Row row) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        int columnIndex = 0;

        for (Field field : fields) {
            ExcelColumn annotation = field.getAnnotation(ExcelColumn.class);
            if (annotation != null) {
                field.setAccessible(true);
                Object value = field.get(obj);

                Cell cell = row.createCell(columnIndex++);
                setCellValue(cell, value);
            }
        }
    }

    private void setCellValue(Cell cell, Object value) {
       if (value == null) {
           cell.setCellValue("");
       } else if (value instanceof String) {
           cell.setCellValue((String) value);
       } else if (value instanceof Integer) {
           cell.setCellValue((Integer) value);
       }
       // Add more conditions for different data types as needed
   }

}
