package yuki.fintech.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = ["yuki.fintech.domain"])
@SpringBootApplication
@EntityScan(basePackages = ["yuki.fintech.domain"])
class ApiApplication

fun main(args: Array<String>){
    runApplication<ApiApplication>(*args)
}
