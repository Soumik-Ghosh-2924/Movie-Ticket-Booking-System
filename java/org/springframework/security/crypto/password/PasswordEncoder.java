package org.springframework.security.crypto.password;

public interface PasswordEncoder {

	String encode(String string);

}
