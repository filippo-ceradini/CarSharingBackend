package com.example.carsharing.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.example.carsharing.controller.MemberController;
import com.example.carsharing.model.Member;
import com.example.carsharing.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testFindAll() throws Exception {
        List<Member> members = Arrays.asList(
                new Member(1L, "John", "Doe", "123 Main St", "New York", "10001", true, 1),
                new Member(2L, "Jane", "Smith", "456 Park Ave", "Los Angeles", "90210", false, 2)
        );
        when(memberService.findAll()).thenReturn(members);

        mockMvc.perform(get("/members"))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindById() throws Exception {
        Member member = new Member(1L, "John", "Doe", "123 Main St", "New York", "10001", true, 1);
        when(memberService.findById(1L)).thenReturn(member);

        mockMvc.perform(get("/members/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testSave() throws Exception {
        // Set up mock behavior and test data
        Member member = new Member("Bob", "Johnson", "789 Pine St", "Chicago", "60606", true, 3);
        when(memberService.save(member)).thenReturn(member);

        // Make request and verify response
        mockMvc.perform(post("/members")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(member)))
                .andExpect(status().isOk());
    }
}