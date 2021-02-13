package com.inno.backoffice.menu.service;

import com.inno.backoffice.menu.repository.MenuMapper;
import com.inno.backoffice.menu.vo.MenuVO;
import com.inno.common.constant.CommonConstants;
import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.util.SerialGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private TcIdsInBaseMapper tcIdsInBaseMapper;

    /**
     * 메뉴 등록
     * @param menuVO
     * @throws Exception
     */
    public void insertMenu(MenuVO menuVO) throws Exception{
        menuVO.setMenuSn(SerialGenerator
                .getInstance(CommonConstants.TC_ADMIN_MENU_LS.name(),CommonConstants.TC_ADMIN_MENU_LS.getValue(), tcIdsInBaseMapper)
                .getNextStringId());
        int dept = 1;
        if(CommonConstants.INNO_ROOT_SN.getValue().equals(menuVO.getSupiMenuSn())){
            menuVO.setDept(dept);
        } else {
            menuVO.setDept(menuMapper.selectDeptBySupiMenuSn(menuVO)+1);
        }
        menuMapper.insertAdminMenu(menuVO);
    }

    /**
     * 메뉴 수정
     * @param menuVO
     * @throws Exception
     */
    public void updateMenu(MenuVO menuVO) throws Exception{
        menuMapper.updateAdminMenu(menuVO);
    }

    /**
     * 메뉴 리스트 조회
     * @return
     * @throws Exception
     */
    public List<Map<String,String>> selectMenuAllList() throws Exception{
        return menuMapper.selectMenuAllList();
    }

    /**
     * 메뉴 상세
     * @param menuVO
     * @return
     * @throws Exception
     */
    public MenuVO selectMenuByMenuSn(MenuVO menuVO) throws Exception{
        return menuMapper.selectMenuByMenuSn(menuVO);
    }
}
