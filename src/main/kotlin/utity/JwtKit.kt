package utity

import com.xjjxmm.esimate.vo.UserVo
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.LoggerFactory
import java.time.LocalDateTime


object  JwtKit {
    private val log = LoggerFactory.getLogger(this.javaClass)


    private const val Issuer = "xjjxmm"

    // 携带token的请求头名字
    val TOKEN_HEADER = "Authorization"

    //token的前缀
    val TOKEN_PREFIX = "Bearer "

    // 默认密钥
    private const val DEFAULT_SECRET = "djfdemel"

    // 用户身份
    private val ROLES_CLAIM = "roles"

    // token有效期,单位分钟；
    private const val EXPIRE_TIME = 30L

    // 创建token
    fun createToken(user: UserVo): String? {
        val now = LocalDateTime.now()
        val expireDate = now.plusMinutes(EXPIRE_TIME)

        val signatureAlgorithm: SignatureAlgorithm =
            SignatureAlgorithm.HS256 //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。

        //构建Jwt
        val builder = Jwts.builder()
            //jwt的唯一标识
            .setId(user.id)
            //jwt面向用户
            .setSubject(user.username)
            //jwt的签发者
            .setIssuer(Issuer)
            //jwt的签发时间
            .setIssuedAt(Date2LocalTime.localDateTime2JavaDate(now))
            .setExpiration(Date2LocalTime.localDateTime2JavaDate(expireDate))
            //设置签名使用的签名算法和签名使用的秘钥
            .signWith(signatureAlgorithm, DEFAULT_SECRET)

        //自定义payload的claim信息
        //builder.claim("role", "admin");

        return builder.compact()
    }


    /**
     * 解析jwt，解析时若过期会抛出ExpiredJwtException异常
     * @param jwt token
     * @return jwt对象
     */
    fun  parseJwt( jwt: String) : Claims {
        //解析jwt
        //val parser = Jwts.parser()
        //获取解析后的对象
        val claims = Jwts.parser()
            //设置签名秘钥，和生成的签名的秘钥一模一样
            .setSigningKey(DEFAULT_SECRET)
            //设置需要解析的jwt
            .parseClaimsJws(jwt)
            .body
        return claims
    }

}