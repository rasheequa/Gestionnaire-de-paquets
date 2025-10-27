package pobj.pkgman;

import java.util.ArrayList;

public class SimplePkgAdapter extends AbstractPkg{
	private ISimplePkg pkg;
	
	public SimplePkgAdapter(ISimplePkg pkg){
		super(pkg.name(),  Version.getDefaultVersion(), new ArrayList<>());
		// TODO Auto-generated constructor stub
		this.pkg = pkg;
	}

	

	@Override
	public boolean install() {
		// TODO Auto-generated method stub
		pkg.install();
		return true;
	}

	@Override
	public void uninstall() {
		// TODO Auto-generated method stub
		
	}
	
	

}
