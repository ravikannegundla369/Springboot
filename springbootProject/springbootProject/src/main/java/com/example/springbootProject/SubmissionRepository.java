package com.example.springbootProject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface  SubmissionRepository extends JpaRepository<Submission,Serializable>
{



}
