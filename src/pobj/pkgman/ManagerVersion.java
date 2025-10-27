package pobj.pkgman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerVersion implements IManager {
	private Map<String, IPkg> installed = new HashMap<>();
	
	@Override
	public boolean installPkg(IPkg pkg) {
		// TODO Auto-generated method stub
		IPkg current  = installed.get(pkg.getName());
		if(current !=null) {
			if(!(current .getVersion().compareTo(pkg.getVersion())>=0)) {
				uninstallPkg(current);
				for(IPkg dep : current.getDependencies()) {
					boolean bool = installPkg(dep);
					if(bool==false) {
						return false;
					}
				}
				pkg.install();
	            installed.put(pkg.getName(), pkg);
	            return true;
			}
		}
		for(IPkg pk : pkg.getDependencies()) {
			boolean bool = installPkg(pk);
			if(bool==false) {
				return false;
			}
		}
		pkg.install();
        installed.put(pkg.getName(), pkg);
        return true;
				
	}

	@Override
	public void uninstallPkg(IPkg pkg) {
		// TODO Auto-generated method stub
		pkg.uninstall();               
		installed.remove(pkg.getName());
	}

	@Override
	public List<IPkg> getInstalled() {
		// TODO Auto-generated method stub
		return new ArrayList<>(installed.values());
	}

}
