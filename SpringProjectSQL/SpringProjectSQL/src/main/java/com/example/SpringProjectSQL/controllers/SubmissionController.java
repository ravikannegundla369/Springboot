package com.example.SpringProjectSQL.controllers;

import com.example.SpringProjectSQL.model.Submission;
import com.example.SpringProjectSQL.services.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {
    @Autowired
    private SubmissionService submissionService;
    @PostMapping
    public Submission addSubmission(@RequestBody Submission submission){
        return submissionService.addSubmission(submission);

    }
    @GetMapping
    public List<Submission> getAllSubmission(){
        return submissionService.getAllSubmission();

    }
    @GetMapping("/{id}")
    public Submission getSubmissionById(@PathVariable int id){

        return submissionService.getSubmissionById(id);
    }

    @GetMapping("/filter")
    public List<Submission> getSubmissionByLeadAndTechnology(@RequestParam String lead, @RequestParam String technology){
        return submissionService.getSubmissionByLeadAndTechnology(lead,technology);
    }
    @DeleteMapping("/{id}")
    public String deleteSubmission(@PathVariable int id){
        submissionService.deleteSubmission(id);
        return "deleted submission successfully";
    }

    @PutMapping("/{id}")
    public Submission editSubmission(@PathVariable int id,@RequestBody Submission submission){
        return submissionService.editSubmission(id,submission);
    }
}