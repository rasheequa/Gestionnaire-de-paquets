package pobj.pkgman;

import java.util.List;

public abstract class AbstractPkg implements IPkg{
	private String name;
	private IVersion version;
	private List<IPkg> dependencies;
	
	public AbstractPkg(String nom, IVersion version, List<IPkg> dependencies) {
		name=nom;
		this.version = version;
		this.dependencies = dependencies;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public IVersion getVersion() {
		// TODO Auto-generated method stub
		return version;
	}

	@Override
	public List<IPkg> getDependencies() {
		// TODO Auto-generated method stub
		return dependencies;
	}

	
	@Override
	public boolean equals(Object o) {
		if(o instanceof AbstractPkg a) {
			return this.getName().equals(a.getName())&&this.getVersion().equals(a.getVersion());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name+"-"+version.toString();
	}

}
