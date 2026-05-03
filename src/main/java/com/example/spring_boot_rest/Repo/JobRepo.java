package com.example.spring_boot_rest.Repo;

import com.example.spring_boot_rest.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> {
    List<JobPost> findByPostProfileContainingOrPostDescContaining(String postProfile,String postDesc);
}

//public List<JobPost> getAllJobs(){
//    return jobs;
//}
//
//public void addJob(JobPost job){
//    jobs.add(job);
//    System.out.println(jobs);
//}
//
//public JobPost getJob(int i) {
//    for(JobPost job : jobs){
//        if(job.getPostId()==i)
//            return job;
//    }
//    return null;
//}
//
//public void updateJob(JobPost jobPost) {
//    for(JobPost job:jobs){
//        if(job.getPostId()==jobPost.getPostId()){
//            job.setPostProfile(jobPost.getPostProfile());
//            job.setPostDesc(jobPost.getPostDesc());
//        }
//    }
//}
//
//public void deleteJob(int postId) {
//    Iterator<JobPost> iterator = jobs.iterator();
//
//    while(iterator.hasNext()) {
//        JobPost job = iterator.next();
//        if(job.getPostId() == postId) {
//            iterator.remove();   // ✅ safe removal
//        }
//    }
//}
