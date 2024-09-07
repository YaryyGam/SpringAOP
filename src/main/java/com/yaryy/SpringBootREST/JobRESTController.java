package com.yaryy.SpringBootREST;

import com.yaryy.SpringBootREST.model.JobPost;
import com.yaryy.SpringBootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController // to return a data not a view
public class JobRESTController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    // @ResponseBody  // to return a data not a view
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }
    @GetMapping("jobPost/{postId}")
    public JobPost getJob(@PathVariable("postId") int postId){
        return service.getJob(postId);
    }
    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){ // to return json data
        service.addJob(jobPost);
    }

}
