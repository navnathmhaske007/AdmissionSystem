package com.rscoe.admissionsystem.repository;

import javax.persistence.criteria.Path;

import org.springframework.data.jpa.domain.Specification;

import com.rscoe.admissionsystem.model.Branches;
import com.rscoe.admissionsystem.model.College;

public class CollegeSpecification {
	public static Specification<College> withBranchNameAndCategeory(final String branchName, final double marks,
			final String categeory) {
		return (root, query, cb) -> {
			final Path<Branches> brandPath = root.join("branches");
			return cb.and(cb.lessThanOrEqualTo(brandPath.<Double>get(branchName), marks),
					cb.equal(brandPath.<String>get("categeory"), categeory));
		};
	}

	public static Specification<College> withBranchNameAndCategeoryAndCity(final String branchName, final double marks,
			final String categeory, final String city) {
		return (root, query, cb) -> {
			final Path<Branches> brandPath = root.join("branches");
			return cb.and(cb.lessThanOrEqualTo(brandPath.<Double>get(branchName), marks),
					cb.equal(brandPath.<String>get("categeory"), categeory),
					cb.equal(brandPath.<String>get("city"), city));
		};
	}
}