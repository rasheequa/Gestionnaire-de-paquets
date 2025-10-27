package pobj.pkgman;

import java.util.List;

public class LimitPkg extends AbstractPkg{
	private static int counter = 0;
	
	public LimitPkg(String nom, IVersion version, List<IPkg> dependencies) {
		super(nom, version, dependencies);
		// TODO Auto-generated constructor stub
	}
	
	public static int getNbInstalled() {
		return counter;
	}

	@Override
	public boolean install() {
		// TODO Auto-generated method stub
		if (counter>=10) {
			return false;
		}
		counter++;
		return true;
	}

	@Override
	public void uninstall() {
		// TODO Auto-generated method stub
		counter--;
	}

}
