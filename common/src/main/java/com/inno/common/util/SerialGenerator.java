package com.inno.common.util;

import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.gen.vo.TcIdsInBaseVO;

import javax.annotation.Resource;

public class SerialGenerator {

    private String tblNm;

    private int nextId;

    private String prefix;

    private int ciper = 10;

    private char filChar = '0';

    private TcIdsInBaseMapper tcIdsInBaseMapper;

    public void setTblNm(String tblNm) {
        this.tblNm = tblNm;
    }

    public void setNextId(int nextId) {
        this.nextId = nextId;
    }

    public String getNextStringId() throws Exception{
        if(StringUtil.isNotEmpty(this.tblNm)){
            StringBuilder str = new StringBuilder(this.prefix);
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm(this.tblNm);
            TcIdsInBaseVO result = tcIdsInBaseMapper.selectTcIdsInBase(vo);
            if(result == null){
                // 없다면 insert
                vo.setNextId(1);
                tcIdsInBaseMapper.insertTcIdsInBase(vo);

                // prefix 길이를 제외한 나머지를 filChar로 채워서 리턴한다.
                for (int i = 0; i < this.ciper-this.prefix.length(); i++) {
                    str.append(this.filChar);
                }
                return str.toString();
            } else {
                String nxtId = result.getNextId()+"";
                if(this.ciper < this.prefix.length()+nxtId.length()){
                    // error 다음 일련번호가 전체 자리를 넘을때 CustomException 예정
                    return null;
                } else {
                    for (int i = 0; i < this.ciper-this.prefix.length()-nxtId.length(); i++) {
                        str.append(this.filChar);
                    }
                    str.append(nxtId);
                    vo.setNextId(result.getNextId()+1);
                    tcIdsInBaseMapper.updateTcIdsInBase(vo);
                    return str.toString();
                }
            }
        } else {
            return null;
        }
    }
}
