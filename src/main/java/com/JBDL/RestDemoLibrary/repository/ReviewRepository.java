package com.JBDL.RestDemoLibrary.repository;

import com.JBDL.RestDemoLibrary.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
