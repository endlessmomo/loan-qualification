package yuki.fintech.domain.domain

import javax.persistence.*

@Entity
@Table(name = "LOAN_REVIEW")
class LoanReview(
    @Column(name = "usr_key")
    val userKey: String,

    // 대출 한도 금액
    @Column(name = "loan_lmt_amt")
    val loanLimitedAmount: Long,

    // 대출 이자율
    @Column(name = "loan_intrt")
    val loanInterest: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}