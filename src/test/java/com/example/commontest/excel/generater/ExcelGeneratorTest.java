package com.example.commontest.excel.generater;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ExcelGeneratorTest {

    @Autowired
    private ExcelGenerator excelGenerator;

    List<ExcelTestDto> excelTestDtos = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        ExcelTestDto row1 = ExcelTestDto.builder()
                .companyName("test1")
                .companyType("testType1")
                .businessNumber(010101)
                .managerName("manager1")
                .build();

        ExcelTestDto row2 = ExcelTestDto.builder()
                .companyName(null)
                .companyType("testType2")
                .businessNumber(020202)
                .managerName("manager2")
                .build();

        ExcelTestDto row3 = ExcelTestDto.builder()
                .companyName("test3")
                .companyType("testType3")
                .businessNumber(030303)
                .managerName("manager3")
                .build();

        excelTestDtos.add(row1);
        excelTestDtos.add(row2);
        excelTestDtos.add(row3);
    }

    @Test
    @DisplayName("데이터가 없는 경우 빈 엑셀인지")
    void 데이터가없는경우빈엑셀인지() throws Exception{
        List<ExcelTestDto> emptyList = new ArrayList<>();
        Workbook result = excelGenerator.generateExcel(emptyList, "샘플");

        //데이터가 없는 경우 헤더라도 제대로 설정 되었는지
        Row firstRow = result.getSheetAt(0).getRow(0);
        Assertions.assertEquals(firstRow, null);
    }

    @Test
    @DisplayName("데이터가 존재하는 경우 헤더값 잘 선언 되었는지")
    void 데이터가존재하는경우헤더값잘선언되었는지() throws Exception{
        List<ExcelTestDto> emptyList = new ArrayList<>();
        ExcelTestDto emptyData = ExcelTestDto.builder().build();
        emptyList.add(emptyData);

        Workbook result = excelGenerator.generateExcel(emptyList, "샘플");

        //데이터가 없는 경우 헤더라도 제대로 설정 되었는지
        Row firstRow = result.getSheetAt(0).getRow(0);
        Assertions.assertEquals(firstRow.getCell(0).getStringCellValue(), "회사명");
        Assertions.assertEquals(firstRow.getCell(1).getStringCellValue(), "회사타입");
        Assertions.assertEquals(firstRow.getCell(2).getStringCellValue(), "법인코드");
        Assertions.assertEquals(firstRow.getCell(3).getStringCellValue(), "매니저명");
    }

    @Test
    @DisplayName("데이터가 존재하는 경우 데이터 잘 들어갔는지")
    void 데이터가존재하는경우데이터잘들어갔는지() throws Exception{
        Workbook result = excelGenerator.generateExcel(excelTestDtos, "샘플");

        Assertions.assertEquals(result.getSheetAt(0).getPhysicalNumberOfRows(), 4);
        Assertions.assertEquals(result.getSheetAt(0).getRow(1).getCell(0).getStringCellValue(), "test1");
        Assertions.assertEquals(result.getSheetAt(0).getRow(1).getCell(1).getStringCellValue(), "testType1");
    }

    @Test
    @DisplayName("특정 셀에 null이 들어간 경우 다음 셀에 값이 제대로 들어가는지")
    void 특정셀에null이들어간경우다음셀에값이제대로들어가는지() throws Exception{
        Workbook result = excelGenerator.generateExcel(excelTestDtos, "샘플");

        //특정 셀에 null이 들어간 경우 다음 셀의 값이 제대로 들어가는지
        Row row = result.getSheetAt(0).getRow(2);
        Assertions.assertTrue(StringUtils.isBlank(row.getCell(0).getStringCellValue()));
        Assertions.assertEquals(row.getCell(0).getStringCellValue(), "");
        Assertions.assertEquals(row.getCell(1).getStringCellValue(), "testType2");
    }

}