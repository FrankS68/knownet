package de.witchcafe.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;

@Controller
public class StatusController {

	public String getPageTitle() {
		return "Status Overview";
	}

	public enum Status{
		trace,info,warn,error,fatal
	}
	
	public class LogEntry{
		String reporter;
		public String getReporter() {
			return reporter;
		}

		public void setReporter(String reporter) {
			this.reporter = reporter;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Date getReported() {
			return reported;
		}

		public void setReported(Date reported) {
			this.reported = reported;
		}

		Status status;
		String message;
		Date reported;
		
		LogEntry(String reporter,Status status,String message){
			this.reporter = reporter;
			this.status = status;
			this.message = message;
			reported = new Date();
			logs.add(this);
			ArrayList<LogEntry> logByReporter = logsByReporter.get(reporter);
			if (logByReporter == null) {
				logByReporter = new ArrayList<StatusController.LogEntry>();
				logsByReporter.put(reporter, logByReporter);
			}
			logByReporter.add(this);
		}
	}
	
	private ArrayList<StatusController.LogEntry> logs = new ArrayList<StatusController.LogEntry>();
	
	private HashMap<String, ArrayList<StatusController.LogEntry>> logsByReporter = new HashMap<String, ArrayList<StatusController.LogEntry>>(); 

	public void log(String reporter,Status status,String message) {
		new LogEntry(reporter, status, message);
	}
	
	public List<LogEntry> getLogs(){
		return logs;
	}

}
