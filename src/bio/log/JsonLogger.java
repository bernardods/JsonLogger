package bio.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import com.google.gson.GsonBuilder;

public class JsonLogger {

	static Logger logger = Logger.getLogger(JsonLogger.class);

	static String WHOIS = "LOG_FOR_KIBANA";
	static String TOKEN = "114ffs234134134";
	static String OPERATION = "WGG";
	static String LOGIN = "bduarte";

	public static void main(String[] args) {
		BasicConfigurator.configure();
		start();
	}

	public static void start() {

		long start = System.nanoTime();

		try {

			Thread.sleep(5000);
			
			long end = System.nanoTime();

			LogEntry comp = new LogEntry.LogEntryBuilder(WHOIS, TOKEN).withOperation(OPERATION)
					.setExecutionTime(end - start)
					.toLogin(LOGIN)
					.build();

			logger.info(new GsonBuilder().create().toJson(comp));

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}