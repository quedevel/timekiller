package com.inno.backoffice.auth.service;

import com.inno.backoffice.auth.repository.AuthMapper;
import com.inno.backoffice.auth.vo.AuthVO;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.gen.repository.TcAuthMsBaseMapper;
import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.util.SerialGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthService {

    @Resource
    private AuthMapper authMapper;

    @Resource
    private TcIdsInBaseMapper tcIdsInBaseMapper;

    @Resource
    private TcAuthMsBaseMapper tcAuthMsBaseMapper;

    /**
     * 권한 등록
     * @param authVO
     * @throws Exception
     */
    public void insertAuth(AuthVO authVO) throws Exception{
        authVO.setAuthSn(SerialGenerator
                .getInstance(CommonConstants.TC_AUTH_MS.name(),CommonConstants.TC_AUTH_MS.getValue(), tcIdsInBaseMapper)
                .getNextStringId());
        tcAuthMsBaseMapper.insertTcAuthMsBase(authVO);
    }

    /**
     * 권한 수정
     * @param authVO
     * @throws Exception
     */
    public void updateAuth(AuthVO authVO) throws Exception{
        authMapper.updateAuth(authVO);
    }

    /**
     * 권한 상세 조회
     * @param authVO
     * @return
     * @throws Exception
     */
    public AuthVO selectAuthByAuthSn(AuthVO authVO) throws Exception{
        return authMapper.selectAuthByAuthSn(authVO);
    }

    /**
     * 권한 리스트
     * @param authVO
     * @return
     * @throws Exception
     */
    public List<AuthVO> selectAuthListPaging(AuthVO authVO) throws Exception{
        return authMapper.selectAuthListPaging(authVO);
    }

    /**
     * 메뉴 권한 리스트
     * @param menuVO
     * @return
     * @throws Exception
     */
    public List<MenuVO> selectAuthMenuListPaging(MenuVO menuVO) throws Exception{
        return authMapper.selectAuthMenuListPaging(menuVO);
    }
}
