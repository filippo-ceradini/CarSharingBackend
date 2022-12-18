package com.example.carsharing.service;

import com.example.carsharing.model.Member;
import com.example.carsharing.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id).orElse(null);
    }

    @Transactional
    public void updatedMember(Long id, Member updatedMember) {
        Member member = (Member) memberRepository.findAllById(id).orElseThrow(() -> new IllegalStateException("Member with ID " +id +" does not exist in the Database."));
        if(id.equals(updatedMember.getId())){
            memberRepository.save(updatedMember);
        }
    }


    public Member save(Member member) {
        return memberRepository.save(member);
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }
}
