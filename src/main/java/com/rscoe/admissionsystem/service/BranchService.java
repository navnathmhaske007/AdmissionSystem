package com.rscoe.admissionsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rscoe.admissionsystem.model.Branches;
import com.rscoe.admissionsystem.repository.BranchRepository;

@Service
public class BranchService {

	private BranchRepository branchRepository;

	@Autowired
	public BranchService(BranchRepository branchRepository) {
		super();
		this.branchRepository = branchRepository;
	}

	Branches findById(String id) {
		return branchRepository.findById(id);
	}

	public Branches saveUser(Branches branches) {

		return branchRepository.save(branches);
	}

}
