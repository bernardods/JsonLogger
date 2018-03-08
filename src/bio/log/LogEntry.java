package bio.log;

public class LogEntry {

	private String whois;
	private String token;
	private String operation;
	private long executionTime;
	private String login;

	private LogEntry(LogEntryBuilder builder) {
		this.whois = builder.whois;
		this.token = builder.token;
		this.operation = builder.operation;
		this.executionTime = builder.executionTime;
		this.login = builder.login;
	}

	public String getWhois() {
		return whois;
	}

	public String getToken() {
		return token;
	}

	public String getOperation() {
		return operation;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public String getLogin() {
		return login;
	}

	public static class LogEntryBuilder {

		private String whois;
		private String token;
		private String operation;
		private long executionTime;
		private String login;

		public LogEntryBuilder(String whois, String token) {
			this.whois = whois;
			this.token = token;
		}

		public LogEntryBuilder withOperation(String operation) {
			this.operation = operation;
			return this;
		}

		public LogEntryBuilder setExecutionTime(long executionTime) {
			this.executionTime = executionTime;
			return this;
		}

		public LogEntryBuilder toLogin(String login) {
			this.login = login;
			return this;
		}

		public LogEntry build() {
			return new LogEntry(this);
		}
	}

}