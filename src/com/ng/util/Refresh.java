package com.ng.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.netease.dagger.BrowserEmulator;

public class Refresh {

	private static final Log log = LogFactory.getLog(ImportExcel.class);
	
	private BrowserEmulator be;

	public void refresh(BrowserEmulator be) {
		this.be = be;
		log.info("come on refresh....");
		threadRefresh(be);
	}

	private void threadRefresh(BrowserEmulator be) {
		ThreadRefresh getThreadRefresh = new ThreadRefresh(be);
		getThreadRefresh.start();
	}
}
