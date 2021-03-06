package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Project;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
 
    //Project getByPid(long pid);
	List<Project> findBySkillsIgnoreCase(String skills);
	
	public List<Project> findByDaysleftLessThanEqual(long daysleft);
	
	
	
	@Query("select  p from Project p where p.pid NOT IN (select pid from Employee)")
	
    public List<Project> findByNotStaffedProject();
}