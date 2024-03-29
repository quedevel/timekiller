package com.inno.backoffice.admin.service;

import com.inno.backoffice.admin.repository.AdminMapper;
import com.inno.backoffice.admin.vo.AdminVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.gen.repository.TcAdminMsBaseMapper;
import com.inno.common.util.SerialGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminService {

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private TcAdminMsBaseMapper tcAdminMsBaseMapper;

    @Resource(name = "adminSnIdService")
    private SerialGenerator adminSnIdService;

    /**
     * 중복 검사
     * @param adminVO
     * @return
     * @throws Exception
     */
    public Integer checkByAdminId(AdminVO adminVO) throws Exception{
        return adminMapper.checkByAdminId(adminVO);
    }

    /**
     * 관리자 등록
     * @param adminVO
     * @throws Exception
     */
    public void insertAdmin(AdminVO adminVO) throws Exception{
        adminVO.setAdminSn(adminSnIdService.getNextStringId());
        tcAdminMsBaseMapper.insertTcAdminMsBase(adminVO);
    }

    /**
     * 운영자 리스트 조회
     * @param adminVO
     * @return
     * @throws Exception
     */
    public List<AdminVO> selectAdminListPaging(AdminVO adminVO) throws Exception{
        return adminMapper.selectAdminListPaging(adminVO);
    }

    /**
     * 운영자 상세
     * @param adminVO
     * @return
     * @throws Exception
     */
    public AdminVO selectAdminByAdminSn(AdminVO adminVO) throws Exception{
        return adminMapper.selectAdminByAdminSn(adminVO);
    }

    /**
     * 운영자 수정
     * @param adminVO
     * @throws Exception
     */
    public void updateAdmin(AdminVO adminVO) throws Exception{
        adminMapper.updateAdmin(adminVO);
    }

    /**
     * 아이디 조회
     * @param username
     * @return
     * @throws Exception
     */
    public AdminVO selectAdminByUsername(String username) throws Exception{
        return adminMapper.selectAdminByUsername(username);
    }
}
