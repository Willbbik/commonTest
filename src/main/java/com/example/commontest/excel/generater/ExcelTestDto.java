package com.example.commontest.excel.generater;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class ExcelTestDto {

    @ExcelColumn(headerName = "회사명")
    private String companyName;

    @Getter
    @ExcelColumn(headerName = "회사타입")
    private String companyType;

    @ExcelColumn(headerName = "법인코드")
    private Integer businessNumber;

    @ExcelColumn(headerName = "매니저명")
    private String managerName;

}
