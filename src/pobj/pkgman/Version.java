package pobj.pkgman;

public class Version implements IVersion, Comparable<IVersion> {
	private final int major;
	private final int minor;
	private final static Version def = new Version(1,0);
	
	public Version(int major, int minor) {
		this.minor =minor;
		this.major = major;
	}
	
	@Override
	public int getMajor() {
		// TODO Auto-generated method stub
		return major;
	}

	@Override
	public int getMinor() {
		// TODO Auto-generated method stub
		return minor;
	}

	@Override
	public int compareTo(IVersion v) {
		// TODO Auto-generated method stub
		if (v.getMajor()<this.getMajor()) {
			return 1;
		}
		else if(v.getMajor()>this.getMajor()){
			return -1;
		}
		else if(v.getMajor()==this.getMajor()) {
			if(v.getMinor()<this.getMinor()) {
				return 1;
			}
			else if (v.getMinor()>this.getMinor()) {
				return -1;
			}
		}
		return 0;	
	}
	
	@Override
	 public boolean equals(Object o) {

		 if (o instanceof Version v ) {
			 return v.getMajor()==this.getMajor()&&v.getMinor()==this.getMinor();
		 }
		return false;
	}
		
	public static IVersion getDefaultVersion() {
		return def;
	}
	
	 
	@Override
	 public String toString() {
		 StringBuilder sb = new StringBuilder(major+"."+minor);
		 return sb.toString();
	 }

}
