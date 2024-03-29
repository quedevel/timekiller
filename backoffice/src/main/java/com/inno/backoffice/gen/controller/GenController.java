package com.inno.backoffice.gen.controller;

import com.inno.backoffice.common.controller.BaseController;
import com.inno.backoffice.gen.service.GenService;
import com.inno.common.vo.GenVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/gen")
public class GenController extends BaseController {

    private final String tableSchema = "bootex";

    @Resource
    private GenService genService;

    /**
     * gen 리스트
     * @param vo
     * @param model
     * @throws Exception
     */
    @GetMapping("/genList")
    public void genList(GenVO vo,Model model) throws Exception {
        vo.setTableSchema(tableSchema);
        model.addAttribute("genList", genService.selectAllTables(vo));
    }

    /**
     * gen
     * @param vo
     * @return
     * @throws Exception
     */
    @PostMapping("/gen")
    public String gen(GenVO vo) throws Exception {
        genService.selectTableColumns(vo);
        return "redirect:/gen/genList";
    }
}
