package com.aries.eventlog;

public class LogProp {
	private String pattern;
	private String dateFormat;
	private String fullPath;
	private String rollingMode;
	private String maxHistory; // 기본값 30일

	public String getMaxHistory() {
		return maxHistory;
	}

	public void setMaxHistory(String maxHistory) {
		this.maxHistory = maxHistory;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getFullPath() {
		return fullPath;
	}

	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}

	public String getRollingMode() {
		return rollingMode;
	}

	public void setRollingMode(String rollingMode) {
		this.rollingMode = rollingMode;
	}

	public String toString() {
		return "pattern: " + pattern + ", " +
				"dateFormat: " + dateFormat + ", " +
				"fullPath: " + fullPath + ", " +
				"rollingMode: " + rollingMode + ", " +
				"maxHistory: " + maxHistory;
 	}
}
