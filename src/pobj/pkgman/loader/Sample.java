package pobj.pkgman.loader;

import java.io.IOException;
import java.util.List;

import pobj.pkgman.IPkg;

public class Sample {
	public static void printPkgs(List<IPkg> lst) {
		for (IPkg pkg : lst) {
            StringBuilder sb = new StringBuilder();
            sb.append(pkg.toString()).append(":");
            
            for (IPkg dep : pkg.getDependencies()) {
                sb.append(" ").append(dep.toString());
            }
            System.out.println(sb.toString());
		}
		
	}
	
	public static void main(String args[]) {
		
		PkgLoader pkg;
		
		try {
			pkg = new PkgLoader("src/pobj/pkgman/loader/example.txt");
			printPkgs(pkg.getPackages());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
