package com.bard.davol.util;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bard.davol.bean.Usertoken;

public class UsertokenLRUCache {
	private static final Logger logger = LoggerFactory
			.getLogger(UsertokenLRUCache.class);
	static private long MAX_TIME = CommonUtil.LRU_CACHE_TIME;

	static private Map<String, Usertoken> privateMap = new LinkedHashMap<String, Usertoken>(
			1000, 0.75f, true) {
		private final int MAX_ENTRIES = CommonUtil.LRU_MAX_ENTRIES;

		protected boolean removeEldestEntry(Map.Entry eldest) {
			if (size() < MAX_ENTRIES) {
				Usertoken bean = (Usertoken) eldest.getValue();
				if (bean != null) {
					if ((System.currentTimeMillis() - bean.getTimestamp()) < MAX_TIME) {
						return false;
					}
				}
			}
			return true;
		}
	};

	public static synchronized Usertoken getUsertoken(String udid) {
		Usertoken bean = (Usertoken) privateMap.get(udid);
		if (bean != null) {
			if (System.currentTimeMillis() - bean.getTimestamp() < MAX_TIME) {
				return bean;
			}
			privateMap.remove(udid);
		}

		return null;
	}

	public static synchronized void addUsertoken(Usertoken bean) {
		if ((bean != null) && (StringUtils.isNotEmpty(bean.getUdid()))) {
			bean.setTimestamp(System.currentTimeMillis());
			privateMap.put(bean.getUdid(), bean);
		}
	}

	public static synchronized void removeUsertoken(String udid) {
		privateMap.remove(udid);
	}
}
