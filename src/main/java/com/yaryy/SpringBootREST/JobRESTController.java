package com.yaryy.SpringBootREST;

import com.yaryy.SpringBootREST.model.JobPost;
import com.yaryy.SpringBootREST.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller // @RestController to return data everywhere
public class JobRESTController {

    @Autowired
    private JobService service;

    @GetMapping("jobPosts")
    @ResponseBody  // to return a data not a view
    public List<JobPost> getAllJobs(){
        return service.getAllJobs();
    }

}
