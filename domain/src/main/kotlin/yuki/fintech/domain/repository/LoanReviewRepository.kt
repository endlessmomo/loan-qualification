package yuki.fintech.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import yuki.fintech.domain.domain.LoanReview

interface LoanReviewRepository : JpaRepository<LoanReview, Long>