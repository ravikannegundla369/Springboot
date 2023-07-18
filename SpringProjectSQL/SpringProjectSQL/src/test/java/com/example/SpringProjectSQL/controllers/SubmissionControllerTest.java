package com.example.SpringProjectSQL.controllers;

import com.example.SpringProjectSQL.model.Submission;
import com.example.SpringProjectSQL.services.SubmissionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SubmissionController.class)
class SubmissionControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SubmissionService submissionService;

    Submission submissionOne;
    Submission submissionTwo;

    List<Submission> submissionList=new ArrayList<>();

    @BeforeEach
    void setUp() {

        Submission submissionOne=new Submission();
        submissionOne.setId(35);
        submissionOne.setDate("07/10/2023");
        submissionOne.setTechnology("Java11");
        submissionOne.setVendor("Sbase");
        submissionOne.setEmail("rahul@sbase.com");
        submissionOne.setMobile("8979797987");
        submissionOne.setClient("Apple");
        submissionOne.setImplementation("Sbase");
        submissionOne.setLead("Vinay");
        submissionOne.setStudent("Ravi");
        submissionOne.setPayRate(57);
        submissionOne.setSubmitted(true);



        Submission submissionTwo=new Submission();
        submissionTwo.setId(36);
        submissionTwo.setDate("07/10/2023");
        submissionTwo.setTechnology("Java11");
        submissionTwo.setVendor("Sbase");
        submissionTwo.setEmail("rahul@sbase.com");
        submissionTwo.setMobile("8979797987");
        submissionTwo.setClient("Apple");
        submissionTwo.setImplementation("Sbase");
        submissionTwo.setLead("Vinay");
        submissionTwo.setStudent("Ravi");
        submissionTwo.setPayRate(57);
        submissionTwo.setSubmitted(true);

        submissionList.add(submissionOne);
        submissionList.add(submissionTwo);



    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testaddSubmission() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(submissionOne);

        when(submissionService.addSubmission(submissionOne))
                .thenReturn(submissionOne);

        this.mockMvc.perform(post("/submission")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)).andDo(print()).andExpect(status().isOk());





    }

    @Test
    void testgetAllSubmission() throws Exception {
        when(submissionService.getAllSubmission())
                .thenReturn(submissionList);
        this.mockMvc.perform(get("/submission"))
                .andDo(print()).andExpect(status().isOk());

    }

    @Test
    void testgetSubmissionById() throws Exception {

        when(submissionService.getSubmissionById(35))
                .thenReturn(submissionOne);
        this.mockMvc.perform(get("/submission/35"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getSubmissionByLeadAndTechnology() {
    }

    @Test
    void testdeleteSubmission() throws Exception {

       when(submissionService.deleteSubmission(35))
               .thenReturn("Cloud Vendor Deleted Successfully");
               this.mockMvc.perform(delete("/submission/35"))
                       .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void editSubmission() {
    }
}