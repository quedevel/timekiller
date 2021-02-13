package com.inno.backoffice.auth.repository;

import com.inno.backoffice.auth.vo.AuthVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AuthMapper {

    /**
     * 권한 수정
     * @param authVO
     * @throws Exception
     */
    void updateAuth(AuthVO authVO) throws Exception;

    /**
     * 권한 상세
     * @param authVO
     * @return
     * @throws Exception
     */
    AuthVO selectAuthByAuthSn(AuthVO authVO) throws Exception;

    /**
     * 권한 리스트
     * @param authVO
     * @return
     * @throws Exception
     */
    List<AuthVO> selectAuthListPaging(AuthVO authVO) throws Exception;
}
