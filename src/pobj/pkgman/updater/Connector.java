package pobj.pkgman.updater;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pobj.pkgman.IPkg;
import pobj.pkgman.loader.PkgLoader;

public class Connector implements IConnector{
	private String file;
	
	public Connector(String file) {
		this.file=file;
	}
	
	@Override
	public IDatabase getDatabase() {
		// TODO Auto-generated method stub
		Map<String, IPkg> map = new HashMap<>();
		try {
			PkgLoader pkg = new PkgLoader(file);
			List<IPkg> liste = pkg.getPackages();
			for(IPkg l : liste) {
				if(map.containsKey(l.getName())) {
					if(!(map.get(l.getName()).getVersion().compareTo(l.getVersion())>=0)) {
						map.put(l.getName(), l);
					}
					
				}
				else {
					map.put(l.getName(), l);
				}
							}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return null;
		}
		
		
		return new IDatabase() {
			
			@Override public IPkg getPackage(String name) {
				return map.get(name);
			}
			
			@Override public void close() {
						
			}
		};
	}

}
