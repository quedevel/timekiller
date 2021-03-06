package com.inno.backoffice.sample.controller;

import com.inno.common.constant.CommonConstants;
import com.inno.common.gen.repository.TcIdsInBaseMapper;
import com.inno.common.gen.vo.TcIdsInBaseVO;
import com.inno.common.serial.service.SerialIdnService;
import com.inno.common.util.SerialGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.stream.IntStream;

@RequestMapping("/sample")
@Controller
public class SampleController {

    @Resource
    private TcIdsInBaseMapper mapper;

    @GetMapping("/sample")
    public void sample() throws Exception{
        System.out.println("Sample.......................................");
        System.out.println(CommonConstants.TC_ADMIN_MS.name()+" "+CommonConstants.TC_ADMIN_MS.getValue());
        System.out.println(SerialGenerator.getInstance(CommonConstants.TC_ADMIN_MS.name(),CommonConstants.TC_ADMIN_MS.getValue(), mapper).getNextStringId());
        System.out.println("Sample.......................................");
    }

    @GetMapping("/insert")
    public void insert() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            vo.setNextId(i);
            try {
                mapper.insertTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/update")
    public void update() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            vo.setNextId(i+100);
            try {
                mapper.updateTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/delete")
    public void delete() throws Exception{
        IntStream.rangeClosed(1,100).forEach(i->{
            TcIdsInBaseVO vo = new TcIdsInBaseVO();
            vo.setTblNm("tblNm..."+i);
            try {
                mapper.deleteTcIdsInBase(vo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("/select")
    public void select() throws Exception{
        TcIdsInBaseVO vo = new TcIdsInBaseVO();
        vo.setTblNm("tblNm...10");
        System.out.println("=========================>>>>>>    "+mapper.selectTcIdsInBase(vo));
    }

    @GetMapping("/paging")
    public void paging() throws Exception{
        TcIdsInBaseVO vo = new TcIdsInBaseVO();
        vo.setPage(1);
        vo.setPageSize(10);
        vo.setTblNm("TC_ADMIN_MS");
        System.out.println("-------------------------------------------------------------");
        mapper.selectTcIdsInBasePaging(vo).forEach(v -> {
            System.out.println(v.getTblNm());
        });
        System.out.println("-------------------------------------------------------------");
    }

    @GetMapping("/transaction")
    public void transaction() throws Exception{

    }
}
