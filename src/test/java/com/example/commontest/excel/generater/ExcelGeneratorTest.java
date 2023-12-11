package com.example.commontest.excel.generater;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
        ExcelTestDto dto1 = ExcelTestDto.builder()
                .companyName("test1")
                .companyType("testType1")
                .businessNumber("010101")
                .managerName("manager1")
                .build();

        ExcelTestDto dto2 = ExcelTestDto.builder()
                .companyName("test2")
                .companyType("testType2")
                .businessNumber("020202")
                .managerName("manager2")
                .build();

        ExcelTestDto dto3 = ExcelTestDto.builder()
                .companyName("test3")
                .companyType("testType3")
                .businessNumber("030303")
                .managerName("manager3")
                .build();

        excelTestDtos.add(dto1);
        excelTestDtos.add(dto2);
        excelTestDtos.add(dto3);
    }

    @Test
    void generateExcel() throws Exception{
        Workbook result = excelGenerator.generateExcel(excelTestDtos, "샘플");

        Assertions.assertNotNull(result);

        //헤더
        //dto1
        //dto2
        //dto3
        Assertions.assertEquals(result.getSheetAt(0).getPhysicalNumberOfRows(), 4);
        Assertions.assertEquals(result.getSheetAt(0).getRow(1).getCell(0).getStringCellValue(), "test1");
        Assertions.assertEquals(result.getSheetAt(0).getRow(1).getCell(1).getStringCellValue(), "testType1");
    }
}