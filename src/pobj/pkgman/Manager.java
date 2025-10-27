package pobj.pkgman;

import java.util.ArrayList;
import java.util.List;

public class Manager implements IManager{
	private List<IPkg> installed;
	
	public Manager() {
		installed=new ArrayList<>();
	}
	
	@Override
	public boolean installPkg(IPkg pkg) {
		// TODO Auto-generated method stub
		if (installed.contains(pkg)) return true;

        // Installer récursivement les dépendances
        for (IPkg dep : pkg.getDependencies()) {
	        	if (!installPkg(dep)) {
				return false;
			}
        }

        if (!pkg.install()) {
			return false;
		}
        
        installed.add(pkg);
		return true;
	}

	@Override
	public void uninstallPkg(IPkg pkg) {
		// TODO Auto-generated method stub
		if(!installed.contains(pkg)) {return;}
		pkg.uninstall();
		installed.remove(pkg);
		
		
		
	}

	@Override
	public List<IPkg> getInstalled() {
		// TODO Auto-generated method stub
		return installed;
	}

}
