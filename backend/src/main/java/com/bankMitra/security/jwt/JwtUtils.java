package com.bankMitra.security.jwt;

import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;

import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;
import java.security.spec.X509EncodedKeySpec;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.ExpiredJwtException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.bankMitra.security.services.UserDetailsImpl;

/**
 * @author BankMitra
 *
 */
@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);

	@Value("${bankmitra.app.jwtSecret}")
	private String jwtSecret;

	@Value("${bankmitra.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication)  throws NoSuchAlgorithmException, InvalidKeySpecException {

		String userName =  String.valueOf(authentication.getPrincipal());
		
		PrivateKey privateKey = getPrivateKey();

		Instant now = Instant.now();
		return Jwts.builder()
				.setSubject(userName)
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(Date.from(now))
				.setExpiration(Date.from(now.plus(jwtExpirationMs, ChronoUnit.MINUTES)))
				.signWith(privateKey).compact();
		
	}

	public String getUserNameFromJwtToken(String jwtToken)  throws InvalidKeySpecException, NoSuchAlgorithmException {
		return parseJwt(jwtToken).getBody().getSubject();
	}

	public boolean validateJwtToken(String authToken) throws NoSuchAlgorithmException, InvalidKeySpecException {
		try {
			Jws<Claims> jwtDetails = parseJwt(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
	
	private PrivateKey getPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
	    String rsaPrivateKey = "-----BEGIN PRIVATE KEY-----" +
	            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDK7c0HtOvefMRM" +
	            "s1tkdiJm+A16Df85lQlmXjQvMHNgY4P/znvl4kRON9DdBdo3K81OG7pR/0H9XvdB" +
	            "TEojj/6vCVuMDeeIiBrgx0OJjhv0r8oUD4d52+1kXXITaniyZcbJ08s4sF7fUSCu" +
	            "IZOhvvwQTd/tIwXGU1qqfg+bsomQ6h2czPSKXAux54vUiRO2IWf/Y6twyk8cy1PH" +
	            "IOfelCVUJ4kzmP+CsOH7Rh3JMwZ0Mc4GAzndWpKwNXKjVM20/bKE9FgIiIjzmEQd" +
	            "VpSdUz2MbAKM1kskdaHXQyuaHoHfPwESYuEwBld4vh9AGMF3jYMu8ggnAzVRIoWG" +
	            "Mr5eCE2tAgMBAAECggEBAKBPXiKRdahMzlJ9elyRyrmnihX7Cr41k7hwAS+qSetC" +
	            "kpu6RjykFCvqgjCpF+tvyf/DfdybF0mPBStrlkIj1iH29YBd16QPSZR7NkprnoAd" +
	            "gzl3zyGgcRhRjfXyrajZKEJ281s0Ua5/i56kXdlwY/aJXrYabcxwOvbnIXNxhqWY" +
	            "NSejZn75fcacSyvaueRO6NqxmCTBG2IO4FDc/xGzsyFKIOVYS+B4o/ktUOlU3Kbf" +
	            "vwtz7U5GAh9mpFF+Dkr77Kv3i2aQUonja6is7X3JlA93dPu4JDWK8jrhgdZqY9p9" +
	            "Q8odbKYUaBV8Z8CnNgz2zaNQinshzwOeGfFlsd6H7SECgYEA7ScsDCL7omoXj4lV" +
	            "Mt9RkWp6wQ8WDu5M+OCDrcM1/lfyta2wf7+9hv7iDb+FwQnWO3W7eFngYUTwSw5x" +
	            "YP2uvOL5qbe7YntKI4Q9gHgUd4XdRJJSIdcoY9/d1pavkYwOGk7KsUrmSeoJJ2Jg" +
	            "54ypVzZlVRkcHjuwiiXKvHwj2+UCgYEA2w5YvWSujExREmue0BOXtypOPgxuolZY" +
	            "pS5LnuAr4rvrZakE8I4sdYjh0yLZ6qXJHzVlxW3DhTqhcrhTLhd54YDogy2IT2ff" +
	            "0GzAV0kX+nz+mRhw0/u+Yw6h0QuzH9Q04Wg3T/u/K9+rG335j/RU1Tnh7nxetfGb" +
	            "EwJ1oOqcXikCgYEAqBAWmxM/mL3urH36ru6r842uKJr0WuhuDAGvz7iDzxesnSvV" +
	            "5PKQ8dY3hN6xfzflZoXssUGgTc55K/e0SbP93UZNAAWA+i29QKY6n4x5lKp9QFch" +
	            "dXHw4baIk8Z97Xt/kw07f6FAyijdC9ggLHf2miOmdEQzNQm/9mcJ4cFn+DECgYEA" +
	            "gvOepQntNr3gsUxY0jcEOWE3COzRroZD0+tLFZ0ZXx/L5ygVZeD4PwMnTNrGvvmA" +
	            "tAFt54pomdqk7Tm3sBQkrmQrm0+67w0/xQ9eJE/z37CdWtQ7jt4twHXc0mVWHa70" +
	            "NdPhTRVIAWhil7rFWANOO3Gw2KrMy6O1erW7sAjQlZECgYBmjXWzgasT7JcHrP72" +
	            "fqrEx4cg/jQFNlqODNb515tfXSBBoAFiaxWJK3Uh/60/I6cFL/Qoner4trNDWSNo" +
	            "YENBqXLZnWGfIo0vAIgniJ6OD67+1hEQtbenhSfeE8Hou2BnFOTajUxmYgGm3+hx" +
	            "h8TPOvfHATdiwIm7Qu76gHhpzQ==" +
	            "-----END PRIVATE KEY-----";

	    rsaPrivateKey = rsaPrivateKey.replace("-----BEGIN PRIVATE KEY-----", "");
	    rsaPrivateKey = rsaPrivateKey.replace("-----END PRIVATE KEY-----", "");

	    PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(rsaPrivateKey));
	    KeyFactory kf = KeyFactory.getInstance("RSA");
	    PrivateKey privKey = kf.generatePrivate(keySpec);
	    return privKey;
	}
	
	private Jws<Claims> parseJwt(String jwtString) throws InvalidKeySpecException, NoSuchAlgorithmException {

	    PrivateKey privateKey = getPrivateKey();

	    Jws<Claims> jwt = Jwts.parserBuilder()
	            .setSigningKey(privateKey)
	            .build()
	            .parseClaimsJws(jwtString);

	    return jwt;
	}

}
