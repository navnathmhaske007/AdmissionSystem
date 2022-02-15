package com.rscoe.admissionsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rscoe.admissionsystem.model.Branches;

@Repository
public interface BranchRepository extends JpaRepository<Branches, Long> {

	Branches findById(String id);
}
