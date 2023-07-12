package com.example.springbootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class SubmissionServiceImpl  implements SubmissionService{

    @Autowired
    private SubmissionRepository submissionRepository;
    @Override
    public String upsert(Submission submission) {

        submissionRepository.save(submission);

        return "success";
    }

    @Override
    public Submission getById(Integer sid) {

        Optional<Submission> findById= submissionRepository.findById(sid);

        if(findById.isPresent())
        {
            return findById.get();
        }

        return null;
    }

    @Override
    public List<Submission> getAllSubmissions() {

    return submissionRepository.findAll();

    }

    @Override
    public String deleteById(Integer sid) {
        if(submissionRepository.existsById(sid)){
            submissionRepository.deleteById(sid);
            return "deleted successfully";
        }

        return "No record Found";
    }

}
