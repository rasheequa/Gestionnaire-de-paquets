package pobj.pkgman.updater;

import java.util.ArrayList;
import java.util.List;

import pobj.pkgman.IManager;
import pobj.pkgman.IPkg;

public class Updater {
	private IConnector connector;
	private IManager manager;
	
	public Updater(IConnector c,IManager man){
		connector=c;
		manager=man;
	}
	
	public List<String> getInstalled(){
		List<IPkg> liste = manager.getInstalled();
		List<String> installed = new ArrayList<>();
		for(IPkg l : liste) {
			installed.add(l.getName());
		}
		return installed;
	}
	
	public void installPkgs(List<String> pkgs) throws UpdateException {
		IDatabase db = connector.getDatabase();
		for(String name : pkgs) {
			IPkg pkg = db.getPackage(name);
			if(pkg!=null) {
				manager.installPkg(pkg);
			}
			else {
				throw new UpdateException(name);
			}
			
		}
		db.close();
	}
	
	public void updateWorld() {
		List<IPkg> installed = manager.getInstalled();
		for(IPkg pkg : installed) {
			pkg.install();
		}
		
	}
}
