package com.inno.backoffice.gen.service;

import com.inno.backoffice.gen.repository.GenMapper;
import com.inno.innotree.common.vo.GenVO;
import com.inno.innotree.common.util.StringUtil;
import com.inno.innotree.common.util.ThymeleafUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GenService {

    @Resource
    private GenMapper genMapper;

    /**
     * 테이블 목록 조회
     * @param genVO
     * @return
     * @throws Exception
     */
    public List<String> selectAllTables(GenVO genVO) throws Exception{
        return genMapper.selectAllTables(genVO);
    }

    /**
     * 테이블 컬럼 조회
     * @param genVO
     * @throws Exception
     */
    public void selectTableColumns(GenVO genVO) throws Exception{
        // table is not empty
        if(StringUtil.isNotEmpty(genVO.getTableName())){
            for(String tableName : genVO.getTableName().split(",")){
                // Table 정보 조회
                List<GenVO> list = genMapper.selectAllColumns(tableName);

                // VO, Mapper, XMl 생성
                ThymeleafUtil.parseVOHtmlToFile("",tableName,list);
                ThymeleafUtil.parseMapperHtmlToFile("",tableName,list);
                ThymeleafUtil.parseXmlHtmlToFile("",tableName,list);
            }
        }
    }
}
