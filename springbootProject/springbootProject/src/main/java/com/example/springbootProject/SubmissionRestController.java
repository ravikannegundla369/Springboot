package com.example.springbootProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SubmissionRestController {

@Autowired
private SubmissionService submissionService;
@PostMapping("/submission")
public ResponseEntity<String> createSubmission(@RequestBody Submission submission)
{

    String status=submissionService.upsert(submission);
    return new ResponseEntity<>(status, HttpStatus.CREATED);

}

    @GetMapping("/submissions/{sid}")
public  ResponseEntity<Submission> getSubmission(@PathVariable Integer sid){

    Submission submission=submissionService.getById(sid);
    return new ResponseEntity<>(submission,HttpStatus.OK);
}


@GetMapping("/submissions")
public ResponseEntity<List<Submission>> getAllSubmissions()
{

    List<Submission> allSubmissions=submissionService.getAllSubmissions();
    return new ResponseEntity<>(allSubmissions,HttpStatus.OK);
}

    @PutMapping("/submission")
    public ResponseEntity<String> updateSubmission(@RequestBody Submission submission)
    {

        String status=submissionService.upsert(submission);
        return new ResponseEntity<>(status, HttpStatus.OK);

    }

    @DeleteMapping("/submissions/{sid}")
    public  ResponseEntity<String> deleteSubmission(@PathVariable Integer sid){

        String status= submissionService.deleteById(sid);

        return new ResponseEntity<>(status,HttpStatus.OK);
    }



}
