package com.inno.backoffice.sample.service;

import com.inno.backoffice.sample.repository.SampleMapper;
import com.inno.backoffice.sample.vo.SampleVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SampleService {

    @Resource
    private SampleMapper sampleMapper;

    public String getNow() throws Exception{
        System.out.println("SampleService getNow() : "+ sampleMapper);
        return sampleMapper.getNow();
    }

    public Map<String, String> selectAllTables(String schemaName){
        return sampleMapper.selectAllTables(schemaName);
    }

    public List<SampleVO> selectAllColumns(String tableName){
        return sampleMapper.selectAllColumns(tableName);
    }

}
