package com.inno.backoffice.auth.service;

import com.inno.backoffice.auth.repository.AuthMapper;
import com.inno.backoffice.auth.vo.AuthVO;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.gen.repository.TcAuthMenuMppgLsBaseMapper;
import com.inno.common.gen.repository.TcAuthMsBaseMapper;
import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.gen.vo.TcAuthMenuMppgLsBaseVO;
import com.inno.common.util.SerialGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthService {

    @Resource
    private AuthMapper authMapper;

    @Resource(name = "authSnIdService")
    private SerialGenerator authSnIdService;

    @Resource
    private TcAuthMsBaseMapper tcAuthMsBaseMapper;

    @Resource
    private TcAuthMenuMppgLsBaseMapper tcAuthMenuMppgLsBaseMapper;

    /**
     * 권한 등록
     * @param authVO
     * @throws Exception
     */
    public void insertAuth(AuthVO authVO) throws Exception{
        authVO.setAuthSn(authSnIdService.getNextStringId());
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

    /**
     * 메뉴 권한 등록 및 삭제
     * @param menuVO
     * @throws Exception
     */
    public void insertAuthMenu(MenuVO menuVO) throws Exception{
        // state === 'Y' 권한 부여
        if(CommonConstants.DEFAULT_YES.getValue().equals(menuVO.getState())){
            // 일단 부여된 권한 모두 제거
            //authMapper.deleteAuthMenuAll(menuVO);
            for (String menuSn : menuVO.getMenuSnList()){
                TcAuthMenuMppgLsBaseVO vo = new TcAuthMenuMppgLsBaseVO();
                vo.setAuthSn(menuVO.getAuthSn());
                vo.setMenuSn(menuSn);
                // 권한 부여
                if(tcAuthMenuMppgLsBaseMapper.selectTcAuthMenuMppgLsBase(vo) == null){
                    tcAuthMenuMppgLsBaseMapper.insertTcAuthMenuMppgLsBase(vo);
                }
            }
        } else {
            for (String menuSn : menuVO.getMenuSnList()){
                TcAuthMenuMppgLsBaseVO vo = new TcAuthMenuMppgLsBaseVO();
                vo.setAuthSn(menuVO.getAuthSn());
                vo.setMenuSn(menuSn);
                // 권한 미부여
                tcAuthMenuMppgLsBaseMapper.deleteTcAuthMenuMppgLsBase(vo);
            }
        }
    }

    /**
     * 모든 권한 리스트
     * @return
     * @throws Exception
     */
    public List<AuthVO> authList() throws Exception{
        return authMapper.authList();
    }
}
