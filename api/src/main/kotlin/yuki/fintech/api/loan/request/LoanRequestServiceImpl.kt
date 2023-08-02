package yuki.fintech.api.loan.request

import org.springframework.stereotype.Service
import yuki.fintech.api.loan.GenerateKey
import yuki.fintech.api.loan.encrypt.EncryptComponent
import yuki.fintech.domain.repository.UserInfoRepository

@Service
class LoanRequestServiceImpl(
    private val generateKey: GenerateKey,
    private val userInfoRepository: UserInfoRepository,
    private val encryptComponent: EncryptComponent
) : LoanRequestService {
    override fun loanRequestMain(
        loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): LoanRequestDto.LoanRequestResponseDto {
        val userKey = generateKey.generateUserKey()

        loanRequestInputDto.userRegistrationNumber =
            encryptComponent.encryptString(loanRequestInputDto.userRegistrationNumber)

        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey))

        loanRequestReview(userKey)

        return LoanRequestDto.LoanRequestResponseDto(userKey)
    }

    override fun saveUserInfo(userInfoDto: UserInfoDto) =
        userInfoRepository.save(userInfoDto.toEntity())


    override fun loanRequestReview(userKey: String) {
    }
}