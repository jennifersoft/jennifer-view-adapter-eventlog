package prop;

public class LogProp {
	private String pattern;
	private String dateFormat;
	private String fullPath;

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

	public String toString() {
		return "pattern: " + pattern + ", " +
				"dateFormat: " + dateFormat + ", " +
				"fullPath: " + fullPath;
 	}
}
