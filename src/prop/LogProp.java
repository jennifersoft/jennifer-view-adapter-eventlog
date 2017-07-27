package prop;

public class LogProp {
	private String pattern;
	private String dateFormat;
	private String fullPath;
	private String rollingMode;

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
				"rollingMode: " + rollingMode;
	}
}