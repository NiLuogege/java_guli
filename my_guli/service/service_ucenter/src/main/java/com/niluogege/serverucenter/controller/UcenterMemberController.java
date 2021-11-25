package com.niluogege.serverucenter.controller;


import com.niluogege.commonutils.R;
import com.niluogege.serverucenter.entity.UcenterMember;
import com.niluogege.serverucenter.service.UcenterMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 会员表 前端控制器
 * </p>
 *
 * @author niluogege
 * @since 2021-11-25
 */
@RestController
@RequestMapping("/serverucenter/ucenter-member")
@Api(tags = "UcenterMemberController")
public class UcenterMemberController {


    @Autowired
    private UcenterMemberService memberService;

    @ApiOperation("添加")
    @PostMapping("/")
    public R save(
            @RequestBody UcenterMember member
    ) {
        return R.simpleReturn(memberService.save(member));
    }


    @ApiOperation("list")
    @GetMapping("/")
    public R list(
    ) {
        return R.ok().data("list", memberService.list(null));
    }

}
