package com.yaryy.SpringBootREST.repo;

import com.yaryy.SpringBootREST.model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer> { }

