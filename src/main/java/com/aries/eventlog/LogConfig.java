package com.aries.eventlog;

import com.aries.extension.util.PropertyUtil;

public class LogConfig {
	static final LogProp prop = new LogProp();
	static final String PATTERN = "[%time] domain=%domainName(%domainId), instance=%instanceName(%instanceId), level=%eventLevel, name=%eventName, value=%value";
	static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
	static final String FULL_PATH = "../logs/eventlog.%d{yyyy-MM-dd}.log";
	static final String ROLLING_MODE = "true";

	public static LogProp getLog() {
		prop.setPattern(PropertyUtil.getValue("eventlog", "pattern", PATTERN));
		prop.setDateFormat(PropertyUtil.getValue("eventlog", "date_format", DATE_FORMAT));
		prop.setFullPath(PropertyUtil.getValue("eventlog", "full_path", FULL_PATH));
		prop.setRollingMode(PropertyUtil.getValue("eventlog", "rolling_mode", ROLLING_MODE));

		return prop;
	}
}
