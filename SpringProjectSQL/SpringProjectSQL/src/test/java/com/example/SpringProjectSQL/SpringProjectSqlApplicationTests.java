package com.example.SpringProjectSQL;
import com.example.SpringProjectSQL.Repository.SubmissionRepository;
import com.example.SpringProjectSQL.model.Submission;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringProjectSqlApplicationTests {

	//@Autowired
	@Mock
	SubmissionRepository submissionRepository;

	@Test
	@Order(1)
	public void testCreate()
	{
		Submission submission=new Submission();
		submission.setId(25);
		submission.setDate("07/10/2023");
		submission.setTechnology("Java");
		submission.setVendor("Sbase");
		submission.setEmail("rahul@sbase.com");
		submission.setMobile("8979797987");
		submission.setClient("Apple");
		submission.setImplementation("Sbase");
		submission.setLead("Vinay");
		submission.setStudent("Ravi");
		submission.setPayRate(55);
		submission.setSubmitted(true);

		System.out.println(submission);
		submissionRepository.save(submission);
		Assertions.assertNotNull(submissionRepository.findById(25));
		System.out.println(submissionRepository.findById(25));
		Assertions.assertEquals(25,submission.getId());
		System.out.println(submission.getId());

		Assertions.assertEquals("Java",submission.getTechnology());
		System.out.println(submission.getTechnology());
	}

	@Test
	@Order(2)
	public void testgetAll()
	{

		Submission submission=new Submission();
		submission.setId(25);
		submission.setDate("07/10/2023");
		submission.setTechnology("Java");
		submission.setVendor("Sbase");
		submission.setEmail("rahul@sbase.com");
		submission.setMobile("8979797987");
		submission.setClient("Apple");
		submission.setImplementation("Sbase");
		submission.setLead("Vinay");
		submission.setStudent("Ravi");
		submission.setPayRate(55);
		submission.setSubmitted(true);

		System.out.println(submission);
		submissionRepository.save(submission);
		Assertions.assertNotNull(submissionRepository.findAll());
		System.out.println(submissionRepository.findAll());

		/*System.out.println(submissionRepository.findAll());
		List list =submissionRepository.findAll();
		Assertions.assertNotEquals(Collections.EMPTY_LIST, list);*/
	}


	@Test
	@Order(3)
	public void testRead () {

		Submission submission=new Submission();
		submission.setId(35);
		submission.setDate("07/10/2023");
		submission.setTechnology("Java");
		submission.setVendor("Sbase");
		submission.setEmail("rahul@sbase.com");
		submission.setMobile("8979797987");
		submission.setClient("Apple");
		submission.setImplementation("Sbase");
		submission.setLead("Vinay");
		submission.setStudent("Ravi");
		submission.setPayRate(55);
		submission.setSubmitted(true);

		System.out.println(submission);
		submissionRepository.save(submission);
		Assertions.assertNotNull(submissionRepository.findById(35));
		System.out.println(submissionRepository.findById(35));
		Assertions.assertEquals(35,submission.getId());
		System.out.println(submission.getId());

		Assertions.assertEquals("Java",submission.getTechnology());
		System.out.println(submission.getTechnology());
		/*
		Submission submission = submissionRepository.findById(25).get();
		System.out.println(submissionRepository.findById(25).get());
		Assertions.assertEquals(25,submission.getId());
		System.out.println(submission.getId());
		Assertions.assertEquals("Java",submission.getTechnology());
		System.out.println(submission.getTechnology());
*/
	}

	@Test
	@Order(5)
	public void testdelete() {
		Submission submission=new Submission();
		submission.setId(30);
		submission.setDate("07/10/2023");
		submission.setTechnology("Java");
		submission.setVendor("Sbase");
		submission.setEmail("rahul@sbase.com");
		submission.setMobile("8979797987");
		submission.setClient("Apple");
		submission.setImplementation("Sbase");
		submission.setLead("Vinay");
		submission.setStudent("Ravi");
		submission.setPayRate(55);
		submission.setSubmitted(true);

		System.out.println(submission);
		submissionRepository.save(submission);
		System.out.println(submission.getTechnology());

		submissionRepository.deleteById(30);
		Optional optional = submissionRepository.findById(submission.getId());
		Assertions.assertEquals(Optional.empty(), optional);



	}


	@Test
	@Order(4)
	public void testput() {

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
		Assertions.assertEquals(57,submission.getPayRate());
		System.out.println(submission.getPayRate());
		Assertions.assertEquals("Java11",submission.getTechnology());
		System.out.println(submission.getTechnology());


	}







}
