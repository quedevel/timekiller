package com.inno.backoffice.gen.service;

import com.inno.backoffice.gen.repository.GenMapper;
import com.inno.innotree.common.gen.vo.GenVO;
import com.inno.innotree.common.util.StringUtil;
import com.inno.innotree.common.util.ThymeleafUtil;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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
                List<GenVO> list = genMapper.selectAllColumns(tableName);
                setList(list);
                //ThymeleafUtil.parseVOHtmlToFile("",tableName,list);
                //ThymeleafUtil.parseMapperHtmlToFile("",tableName,list);
                ThymeleafUtil.parseXmlHtmlToFile("",tableName,list);
            }
        }
    }

    private void setList(List<GenVO> list) throws Exception{
        list.stream().forEach( genVO -> {
            genVO.setColumnName2(StringUtil.convert2CamelCase("_"+genVO.getColumnName()));
            genVO.setColumnName(StringUtil.convert2CamelCase(genVO.getColumnName()));
        });
    }
}
