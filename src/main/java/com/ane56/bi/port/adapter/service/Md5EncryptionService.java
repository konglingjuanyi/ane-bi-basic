package com.ane56.bi.port.adapter.service;

import java.security.MessageDigest;

import com.ane56.bi.domain.AssertionConcern;
import com.ane56.bi.domain.user.EncryptionService;

public class Md5EncryptionService extends AssertionConcern implements EncryptionService {

	@Override
	public String encryptedValue(String aPlainTextValue) {
		this.assertArgumentNotEmpty(aPlainTextValue, "Plain text value to encrypt must be provided.");

		String encryptedValue = null;

		try {

			MessageDigest messageDigest = DigestUtils.getMd5Digest();

			DigestUtils.updateDigest(messageDigest, aPlainTextValue);

			encryptedValue = new String(Hex.encodeHex(messageDigest.digest()) );

		} catch (Exception e) {
			throw new IllegalStateException(e);
		}

		return encryptedValue;
	}
	
	public static void main(String[] args){
		Md5EncryptionService md5EncryptionService = new Md5EncryptionService();
		String a1 = md5EncryptionService.encryptedValue("ssssssdddss");
		System.out.println(a1);
	
		String a2 = md5EncryptionService.encryptedValue("abc");
		System.out.println(a2);
	}

}
