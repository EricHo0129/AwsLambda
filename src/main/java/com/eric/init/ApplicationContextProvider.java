package com.eric.init;

import org.springframework.context.ApplicationContext;

public interface ApplicationContextProvider {
	/**
	 * 取得Spring環境設定檔
	 * @return {@link ApplicationContext}
	 */
	public ApplicationContext getApplicationContext();
}
