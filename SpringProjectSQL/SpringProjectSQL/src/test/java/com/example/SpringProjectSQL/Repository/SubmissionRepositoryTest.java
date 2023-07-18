package com.example.SpringProjectSQL.Repository;

import com.example.SpringProjectSQL.model.Submission;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class SubmissionRepositoryTest {



    @Autowired
    private SubmissionRepository submissionRepository;
    Submission submission;

    @BeforeEach
    void setUp() {

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


    submissionRepository.save(submission);
    }

    @AfterEach
    void tearDown() {
        submission=null;
        submissionRepository.deleteAll();
    }

// Test case 1


    @Test
    void testfindByLeadAndTechnology(){

      List<Submission> submissionList = submissionRepository.findByLeadAndTechnology("vinay","java");
      assertThat(submissionList.get(0).getTechnology()).isEqualTo(submission.getTechnology());
      assertThat(submissionList.get(0).getLead()).isEqualTo(submission.getLead());



    }




}
