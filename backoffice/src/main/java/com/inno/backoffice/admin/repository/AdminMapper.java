package com.inno.backoffice.admin.repository;

import com.inno.backoffice.admin.vo.AdminVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    /**
     * 중복 검사
     * @param adminVO
     * @return
     * @throws Exception
     */
    Integer checkByAdminId(AdminVO adminVO) throws Exception;

    /**
     * 운영자 리스트 검색
     * @param adminVO
     * @return
     * @throws Exception
     */
    List<AdminVO> selectAdminListPaging(AdminVO adminVO) throws Exception;

}
