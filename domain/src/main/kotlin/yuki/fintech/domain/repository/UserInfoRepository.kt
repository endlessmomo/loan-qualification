package yuki.fintech.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import yuki.fintech.domain.domain.UserInfo

interface UserInfoRepository : JpaRepository<UserInfo, Long>{
    fun findByUserKey(userKey:String):UserInfo
}