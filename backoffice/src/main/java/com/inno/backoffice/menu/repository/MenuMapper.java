package com.inno.backoffice.menu.repository;

import com.inno.backoffice.menu.vo.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {

    /**
     * 관리자 메뉴 등록
     * @param menuVO
     * @throws Exception
     */
    void insertAdminMenu(MenuVO menuVO) throws Exception;

    /**
     * 관리자 메뉴 수정
     * @param menuVO
     * @throws Exception
     */
    void updateAdminMenu(MenuVO menuVO) throws Exception;

    /**
     * 관리자 리스트 조회
     * @return
     * @throws Exception
     */
    List<Map<String,String>> selectMenuAllList() throws Exception;

    /**
     * 메뉴 깊이 조회
     * @param menuVO
     * @return
     * @throws Exception
     */
    int selectDeptBySupiMenuSn(MenuVO menuVO) throws Exception;

    /**
     * 메뉴 상세
     * @param menuVO
     * @return
     * @throws Exception
     */
    MenuVO selectMenuByMenuSn(MenuVO menuVO) throws Exception;
}
