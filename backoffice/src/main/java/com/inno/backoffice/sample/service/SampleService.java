package com.inno.backoffice.sample.service;

import com.inno.backoffice.sample.repository.SampleMapper;
import com.inno.backoffice.sample.vo.SampleVO;
import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.gen.vo.TcIdsInBaseVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SampleService {

    @Resource
    private SampleMapper sampleMapper;

    @Resource
    private TcIdsInBaseMapper tcIdsInBaseMapper;

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

    public void insertTest() throws Exception{
        // 시나리오
        // TC_IDS_IN 테이블은 TBL_NM 컬럼이 PK 이므로
        // 동일한 이름의 테이블 명을 2번 insert하는 service가 롤백이 되는지 확인
        // 2021.03.08 성공 error 메세지 처리가 필요...
        TcIdsInBaseVO vo = new TcIdsInBaseVO();
        vo.setTblNm("TRANSACTION_TEST");
        vo.setNextId(0);
        tcIdsInBaseMapper.insertTcIdsInBase(vo);
        tcIdsInBaseMapper.insertTcIdsInBase(vo);
    }
}
