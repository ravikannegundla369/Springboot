package com.example.SpringProjectSQL.services;

import com.example.SpringProjectSQL.Repository.SubmissionRepository;
import com.example.SpringProjectSQL.model.Submission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;
    public Submission addSubmission(Submission submission) {

        return submissionRepository.save(submission);
    }

    public List<Submission> getAllSubmission() {
        return  submissionRepository.findAll();
    }

    public String  deleteSubmission(int id) {
        submissionRepository.deleteById(id);
        return "Success";
    }


    public Submission getSubmissionById(int id) {

        return submissionRepository.findById(id).get();
    }

   /* public List<Submission> getSubmissionByLeadAndTechnology(String lead, String technology) {
        return submissionRepository.findByLeadAndTechnology(lead,technology);
    }
*/
    public Submission editSubmission(int id,Submission submissionDetails) {
        Submission submission = submissionRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        submission.setSubmission_id(submissionDetails.getSubmission_id());
        submission.setConsultant_id(submissionDetails.getConsultant_id());
        submission.setSubmission_date(submissionDetails.getSubmission_date());
        submission.setVendor_company(submissionDetails.getVendor_company());
        submission.setVendor_name(submissionDetails.getVendor_name());
        submission.setVendor_email_address(submission.getVendor_email_address());
        submission.setVendor_phone_number(submission.getVendor_phone_number());
        submission.setImplementation_partner(submission.getImplementation_partner());
        submission.setClient_name(submissionDetails.getClient_name());
        submission.setPay_rate(submissionDetails.getPay_rate());
        submission.setSubmission_status(submissionDetails.getSubmission_status());
        submission.setSubmission_type(submissionDetails.getSubmission_type());
        submission.setCity(submissionDetails.getCity());
        submission.setState(submissionDetails.getState());
        submission.setZip(submissionDetails.getZip());


        return submission;
    }
}
