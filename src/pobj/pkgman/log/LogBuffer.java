package pobj.pkgman.log;

public class LogBuffer implements ILogger {
	private StringBuilder log;
	
	public LogBuffer() {
		log = new StringBuilder();
	}
	
	@Override
	public void log(String msg) {
		// TODO Auto-generated method stub
		log.append(msg).append("\n");
	}

	@Override
	public String getLog() {
		// TODO Auto-generated method stub
		return log.toString();
	}
	
}
