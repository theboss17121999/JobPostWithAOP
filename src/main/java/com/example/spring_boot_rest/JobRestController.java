package com.example.spring_boot_rest;

import com.example.spring_boot_rest.model.JobPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.example.spring_boot_rest.Service.JobService;
import org.springframework.web.bind.annotation.*;

import java.security.PrivateKey;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobRestController {
    @Autowired
    private JobService service;

    @GetMapping(path="jobPosts", produces = {"application/json"})
//    @ResponseBody  // if it was @Controller
    public List<JobPost> getAlljobs(){
        return service.getAllJobs();
    }

    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }

    @PostMapping("jobPost")
    public JobPost addJob(@RequestBody JobPost jobPost){
        service.addJob(jobPost);
        return service.getJob(jobPost.getPostId());
    }

    @PutMapping(path="jobPost",consumes = {"application/json"})
    public JobPost updateJob(@RequestBody JobPost jobpost){
        service.updateJob(jobpost);
        return service.getJob(jobpost.getPostId());
    }

    @DeleteMapping("jobPost/{postId}")
    public String deleteJob(@PathVariable("postId") int postId){
        service.deleteJob(postId);
        return "Deleted";
    }

    @GetMapping("jobPosts/keyword/{keyword}")
    public List<JobPost> searchBYKeyword(@PathVariable("keyword") String keyword){
        return service.search(keyword);
    }

    @GetMapping("load")
    public String loadData(){
        service.load();
        System.out.println("hello");
        return "Success";
    }
}
