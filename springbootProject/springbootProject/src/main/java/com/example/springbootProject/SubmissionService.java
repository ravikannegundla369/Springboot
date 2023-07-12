package com.example.springbootProject;

import java.util.List;

public interface SubmissionService {

    public String upsert(Submission submission);
    public Submission getById(Integer sid);
    public List<Submission> getAllSubmissions();

    public String deleteById(Integer sid);

}
