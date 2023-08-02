package yuki.fintech.api.loan.encrypt

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.util.*
import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.SecretKeySpec

@Component
class EncryptComponent {
    companion object {
        @Value("\${crypt.key}")
        lateinit var secretKey: String
    }

    private val encoder = Base64.getEncoder()
    private val decoder = Base64.getDecoder()
    fun encryptString(encryptString: String): String {
        val encryptedString = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey).doFinal(encryptString.toByteArray(Charsets.UTF_8))

        return String(encoder.encode(encryptedString))
    }

    fun decryptString(decryptString: String): String {
        val byteString = decoder.decode(decryptString.toByteArray(Charsets.UTF_8))

        return String(cipherPkcs5(Cipher.DECRYPT_MODE, secretKey).doFinal(byteString))
    }

    fun cipherPkcs5(opMode: Int, secretKey: String): Cipher {
        val c = Cipher.getInstance("/AES/CBC/PKCS5Padding")
        val sk = SecretKeySpec(secretKey.toByteArray(Charsets.UTF_8), "AES")
        val iv = IvParameterSpec(secretKey.substring(0, 16).toByteArray(Charsets.UTF_8))
        c.init(opMode, sk, iv)
        return c;
    }
}