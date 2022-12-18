package com.example.carsharing.controller;

import com.example.carsharing.model.Member;
import com.example.carsharing.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @PostMapping
    public Member save(@RequestBody Member member) {
        return memberService.save(member);
    }

    @PutMapping
    public void updateMember(@RequestBody Member member) {
        memberService.updatedMember(member.getId(), member);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        memberService.deleteById(id);
    }
}
