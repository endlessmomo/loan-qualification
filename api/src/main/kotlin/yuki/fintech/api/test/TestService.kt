package yuki.fintech.api.test

import org.springframework.stereotype.Service
import yuki.fintech.domain.domain.UserInfo
import yuki.fintech.domain.repository.UserInfoRepository

@Service
class TestService(
    private val userInfoRepository: UserInfoRepository
) {
    fun testGetService(userKey: String) = userInfoRepository.findByUserKey(userKey).toDto()

    fun UserInfo.toDto() = TestDto.UserInfoDto(userKey, userRegistrationNumber, userName, userIncomeAmount)
}