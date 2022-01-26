package com.ssafy.project.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MateDto {
    private int mateNo;
    private String mateTitle;
    private String mateCampsite;
    private int lowestAge;
    private int highestAge;
    private String mateContent;
    private String mateCampstyle;
    private String mateCamptype;
    private Date mateCampstart;
    private Date mateCampend;
    private int userNo;

    private Date mateCreateTime;
    private Date mateUpdateTime;

    private int fileId;
    private String fileName;
    private long fileSize;
    private String fileContentType;
	private String fileUrl;

    
}
