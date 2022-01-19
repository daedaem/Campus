package com.ssafy.project.service;

import java.util.List;

import com.ssafy.project.dao.CampSiteDao;
import com.ssafy.project.dto.CampSiteDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CampSiteServiceImpl implements CampSiteService {

    @Autowired
    CampSiteDao campSiteDao;

    @Override
    public List<CampSiteDto> campSiteList() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<CampSiteDto> campSiteSearch(String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> campSiteDo() {
        return campSiteDao.campSiteDo();
    }

    @Override
    public List<String> campSiteSigungu(String doNm) {
        return campSiteDao.campSiteSigungu(doNm);
    }

}
