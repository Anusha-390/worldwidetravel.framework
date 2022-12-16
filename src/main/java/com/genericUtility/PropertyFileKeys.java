package com.genericUtility;

/**
 * This enum is used to get the property file keys
 * @author Anusha M
 *
 */
public enum PropertyFileKeys {
	BROWSER("browser1"),URL("url"),ADMIN_LOGIN("admin_login"),ADMIN_PWD("admin_pwd"),TIMEOUT("timeout"),USER_LOGIN("user_login"),USER_PWD("user_pwd");
	
	private String keys;
	
	
	//setter
	private PropertyFileKeys(String key) {
		this.keys=key;
	}
   
	
	//getter
	public String convertToString()
	{
		return keys.toString();
	}
}
