package util;

import com.jennifersoft.view.adapter.util.LogUtil;
import com.jennifersoft.view.config.ConfigValue;
import prop.LogProp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LogConfig {
	private static Properties properties = null;

	public static void loadConfig() {
		properties = new Properties();
		
		FileInputStream file = null;
		String path = ConfigValue.adapter_config_path;
		
		try {
			if(path != null) {
				file = new FileInputStream(path);
				properties.load(file);
			}
		} catch (IOException e) {
			LogUtil.error(e.toString());
		}
	}
	
	public static String getValue(String key) {
		if(properties == null) {
			loadConfig();
		}
		
		return properties.getProperty(key);
	}
	
	public static LogProp getLog() {
		String pattern = getValue("log.pattern");
		String date_format = getValue("log.date_format");
		String full_path = getValue("log.full_path");
		String rolling_mode = getValue("log.rolling_mode");

		LogProp log = new LogProp();
		log.setPattern(pattern != null ? pattern : "[%time] domain=%domainName(%domainId), instance=%instanceName(%instanceId), level=%eventLevel, name=%eventName, value=%value");
		log.setDateFormat(date_format != null ? date_format : "yyyy-MM-dd HH:mm:ss");
		log.setFullPath(full_path != null ? full_path : "../logs/eventlog.%d{yyyy-MM-dd}.log");
		log.setRollingMode(rolling_mode != null ? rolling_mode : "true");

		return log;
	}
}
