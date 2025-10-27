package pobj.pkgman.log;

import java.util.List;

import pobj.pkgman.IPkg;
import pobj.pkgman.IVersion;

public class PkgLogger implements IPkg{
	private IPkg pkg;
	private ILogger log;

	public PkgLogger(IPkg pkg, ILogger log){
		this.pkg=pkg;
		this.log=log;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return pkg.getName();
	}

	@Override
	public IVersion getVersion() {
		// TODO Auto-generated method stub
		return pkg.getVersion();
	}

	@Override
	public List<IPkg> getDependencies() {
		// TODO Auto-generated method stub
		return pkg.getDependencies();
	}

	@Override
	public boolean install() {
		// TODO Auto-generated method stub
		boolean res = pkg.install();
		log.log("Installing "+toString());
		
		if (res) {
			log.log("Success");
			return res;
		}
		log.log("Failure");
		return res;
		
	}

	@Override
	public void uninstall() {
		// TODO Auto-generated method stub
		pkg.uninstall();
		log.log("Uninstalling "+toString());
	}
	
	public boolean equals(Object o) {
		return pkg.equals(o);
	}
	
	/** Conversion en chaîne de la forme nom-version. */
	public String toString() {
		return pkg.toString();
	}

}
