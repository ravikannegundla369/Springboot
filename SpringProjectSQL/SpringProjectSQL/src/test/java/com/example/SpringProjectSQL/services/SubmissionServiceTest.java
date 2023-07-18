package com.example.SpringProjectSQL.services;

import com.example.SpringProjectSQL.Repository.SubmissionRepository;
import com.example.SpringProjectSQL.model.Submission;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubmissionServiceTest {

    @Mock
    private SubmissionRepository submissionRepository;

    private SubmissionService submissionService;
    AutoCloseable autoCloseable;
    Submission submission;

    @BeforeEach
    void setUp() {
        autoCloseable= MockitoAnnotations.openMocks(this);
        submissionService=new SubmissionService();
        Submission submission=new Submission();
        submission.setId(35);
        submission.setDate("07/10/2023");
        submission.setTechnology("Java11");
        submission.setVendor("Sbase");
        submission.setEmail("rahul@sbase.com");
        submission.setMobile("8979797987");
        submission.setClient("Apple");
        submission.setImplementation("Sbase");
        submission.setLead("Vinay");
        submission.setStudent("Ravi");
        submission.setPayRate(57);
        submission.setSubmitted(true);



    }


    @AfterEach
    void tearDown() throws Exception {
    autoCloseable.close();
    }

    @Test
    void testaddSubmission(){
        mock(Submission.class);
        mock(SubmissionRepository.class);
        when(submissionRepository.save(submission)).thenReturn(submission);
        assertThat(submissionService.addSubmission(submission)).isEqualTo("Success");

    }



}
