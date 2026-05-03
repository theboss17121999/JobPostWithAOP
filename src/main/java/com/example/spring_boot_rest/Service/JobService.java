package com.example.spring_boot_rest.Service;

import com.example.spring_boot_rest.Repo.JobRepo;
import com.example.spring_boot_rest.model.JobPost;
import com.example.spring_boot_rest.Repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class JobService {



    @Autowired
    private JobRepo repo;
    public void addJob(JobPost jobPost){
        repo.save(jobPost);
    }

    public List<JobPost> getAllJobs(){
        return repo.findAll();
    }

    public JobPost getJob(int postId) {
//        to simulate error
//        int a = 10/0;
        return repo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
        repo.save(jobPost);
    }

    public void deleteJob(int postId) {
        repo.deleteById(postId);
    }

    public void load() {
        List<JobPost> jobs = new ArrayList<>(Arrays.asList(
                new JobPost(
                        1,
                        "Java Developer",
                        "Develop and maintain Java-based applications",
                        3,
                        Arrays.asList("Java", "Spring Boot", "Hibernate")
                ),

                new JobPost(
                        2,
                        "Frontend Developer",
                        "Build responsive UI using modern frameworks",
                        2,
                        Arrays.asList("HTML", "CSS", "JavaScript", "React")
                ),

                new JobPost(
                        3,
                        "Backend Developer",
                        "Design REST APIs and handle server-side logic",
                        4,
                        Arrays.asList("Node.js", "Express", "MongoDB")
                ),

                new JobPost(
                        4,
                        "Full Stack Developer",
                        "Work on both frontend and backend systems",
                        5,
                        Arrays.asList("Java", "Spring Boot", "React", "MySQL")
                ),

                new JobPost(
                        5,
                        "DevOps Engineer",
                        "Manage CI/CD pipelines and cloud infrastructure",
                        3,
                        Arrays.asList("Docker", "Kubernetes", "AWS", "Jenkins")
                )
        ));

        repo.saveAll(jobs);
    }

    public List<JobPost> search(String keyword) {
        return repo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
