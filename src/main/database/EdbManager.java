package main.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import main.database.models.Empleado;

public class EdbManager {
	File file;
	String userDirectory;
	FileWriter writePerm;
	FileReader readPerm;
	PrintWriter writer;
	BufferedReader read;
	
	public EdbManager() {
		file = new File("");
		userDirectory = System.getProperty("user.dir");
		file = (File) new File(userDirectory + "\\src\\resources\\database", 
				File.separator + "BaseDeDatos_Empleados.edb");
	}
	
	public void evaluarDb() {
		if (!file.exists()) {
			try {
				file.getParentFile().mkdirs();
				file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void addObject(Empleado empleado){
		Empleado result;String rst;
		String id = "" + empleado.getdDn() + empleado.getmDn() + empleado.getaDn() + 
				empleado.getdDi() + empleado.getmDi() + empleado.getaDi();
		result = getObject(id);rst = result.getCDE();
		while(true) {
			if(!(rst == "NF")) {
				id += 1;
			}else {
				break;
			}
			result = getObject(id);rst = result.getCDE();
		}
		empleado.setId(id);
		evaluarDb();
		
		try {
			writePerm = new FileWriter(file,true);
			writer = new PrintWriter(writePerm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		writer.println(id + ".{\n" +"\tID: " + id + "\n" +
		         "\tNombres: " + empleado.getNombre() + "\n" + 
				 "\tApPat: " + empleado.getApPate() + "\n" +
				 "\tApMat: " + empleado.getApMate() + "\n" +
				 "\tDiaDN: " + empleado.getdDn() + "\n" + 
		         "\tMesDN: " + empleado.getmDn() + "\n" + 
				 "\tAnioDN: " + empleado.getaDn() + "\n" +
				 "\tColonia: " + empleado.getColonia() + "\n" + 
		         "\tCalle: " + empleado.getCalle() + "\n" + 
				 "\tNoExt: " + empleado.getNoExt() + "\n" +
		         "\tNoInt: " + empleado.getNoInt() + "\n" + 
				 "\tCodPos: " + empleado.getCpost() + "\n" +
		         "\tDep: " + empleado.getDep() + "\n" +
		         "\tPst: " + empleado.getPuesto() + "\n" +
		         "\tDiaDI: " + empleado.getdDi() + "\n" + 
		         "\tMesDI: " + empleado.getmDi() + "\n" + 
		         "\tAnioDI: " + empleado.getaDi() + "\n" +
		         "\tSal: " + empleado.getSalario() + "\n}");
		writer.close();
		try {
			writePerm.close();
			writer.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		JOptionPane.showInternalMessageDialog(null, "Empleado ingresado con el id: " + id, "Ingreso Exitoso", 3);
	}
	public DefaultTableModel getCantObjects(DefaultTableModel model) {
		String str[] = new String[18];
		String aux = "";
		evaluarDb();
		try {
			readPerm = new FileReader(file);
			read = new BufferedReader(readPerm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		do {
			try {
				aux = read.readLine();
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(aux != null && aux.contains(".{")) {
				do {
					try {
						aux = read.readLine();
					}catch (Exception e) {
						e.printStackTrace();
					}
					if(aux.contains("ID:")) {str[0] = getDat("ID", aux);}
					if(aux.contains("Nombres: ")) {str[1] = getDat("Nombres", aux);}
					if(aux.contains("ApPat: ")) {str[2] = getDat("ApPat", aux);}
					if(aux.contains("ApMat: ")) {str[3] = getDat("ApMat", aux);}
					if(aux.contains("DiaDN: ")) {str[4] = getDat("DiaDN", aux);}
					if(aux.contains("MesDN: ")) {str[5] = getDat("MesDN", aux);}
					if(aux.contains("AnioDN: ")) {str[6] = getDat("AnioDN", aux);}
					if(aux.contains("Colonia: ")) {str[7] = getDat("Colonia", aux);}
					if(aux.contains("Calle: ")) {str[8] = getDat("Calle", aux);}
					if(aux.contains("NoExt: ")) {str[9] = getDat("NoExt", aux);}
					if(aux.contains("NoInt: ")) {str[10] = getDat("NoInt", aux);}
					if(aux.contains("CodPos: ")) {str[11] = getDat("CodPos", aux);}
					if(aux.contains("Dep: ")) {str[12] = getDat("Dep", aux);}
					if(aux.contains("Pst: ")) {str[13] = getDat("Pst", aux);}
					if(aux.contains("DiaDI: ")) {str[14] = getDat("DiaDI", aux);}
					if(aux.contains("MesDI: ")) {str[15] = getDat("MesDI", aux);}
					if(aux.contains("AnioDI: ")) {str[16] = getDat("AnioDI", aux);}
					if(aux.contains("Sal: ")) {str[17] = getDat("Sal", aux);}
				}while(!aux.contains("}"));
			}
			for(int i = 0; i <= 17; i++) {
				System.out.println(str[i]);
			}
			if(!(aux == null)) {model.addRow(str);}
		}while(aux != null);
		
		try {
			readPerm.close();
			read.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return model;
	}
	public Empleado getObject(String id) {
		int cdo = 0;
		boolean band = false;
		Empleado empleado = new Empleado();
		String aux = "";
		evaluarDb();
		try {
			readPerm = new FileReader(file);
			read = new BufferedReader(readPerm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		do {
			try {
				aux = read.readLine();
			}catch (Exception e) {
				e.printStackTrace();
			}
			if(aux != null && aux.contains(".{") && aux.contains(id)) {
				cdo ++;
				do {
					try {
						aux = read.readLine();
					}catch (Exception e) {
						e.printStackTrace();
					}
					if(aux != null && aux.contains(".{")) {
						cdo ++;
					}
					if(aux != null && aux.contains("}") && cdo != 0) {
						cdo --;
						if(cdo == 0) {
							band = true;
						}
					}
					if(cdo != 0) {
						if(aux.contains("ID:")) {empleado.setId(getDat("ID", aux));}
						if(aux.contains("Nombres: ")) {empleado.setNombre(getDat("Nombres", aux));}
						if(aux.contains("ApPat: ")) {empleado.setApPate(getDat("ApPat", aux));}
						if(aux.contains("ApMat: ")) {empleado.setApMate(getDat("ApMat", aux));}
						if(aux.contains("DiaDN: ")) {empleado.setdDn(Integer.parseInt(getDat("DiaDN", aux)));}
						if(aux.contains("MesDN: ")) {empleado.setmDn(Integer.parseInt(getDat("MesDN", aux)));}
						if(aux.contains("AnioDN: ")) {empleado.setaDn(Integer.parseInt(getDat("AnioDN", aux)));}
						if(aux.contains("Colonia: ")) {empleado.setColonia(getDat("Colonia", aux));}
						if(aux.contains("Calle: ")) {empleado.setCalle(getDat("Calle", aux));}
						if(aux.contains("NoExt: ")) {empleado.setNoExt(Integer.parseInt(getDat("NoExt", aux)));}
						if(aux.contains("NoInt: ")) {empleado.setNoInt(Integer.parseInt(getDat("NoInt", aux)));}
						if(aux.contains("CodPos: ")) {empleado.setCpost(Integer.parseInt(getDat("CodPos", aux)));}
						if(aux.contains("Dep: ")) {empleado.setDep(getDat("Dep", aux));}
						if(aux.contains("Pst: ")) {empleado.setPuesto(getDat("Pst", aux));}
						if(aux.contains("DiaDI: ")) {empleado.setdDi(Integer.parseInt(getDat("DiaDI", aux)));}
						if(aux.contains("MesDI: ")) {empleado.setmDi(Integer.parseInt(getDat("MesDI", aux)));}
						if(aux.contains("AnioDI: ")) {empleado.setaDi(Integer.parseInt(getDat("AnioDI", aux)));}
						if(aux.contains("Sal: ")) {empleado.setSalario(Double.parseDouble(getDat("Sal", aux)));}
					}
				}while(band != true);
			}
		}while(aux != null);
		if(!band) {
			empleado.setCDE("NF");
		}
		try {
			readPerm.close();
			read.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empleado;
	}
	public String getDat(String dat,String str) {
		
		for(int i = 0; i<= str.length(); i++) {
			if(str.charAt(i) == dat.charAt(0)) {
				str = str.substring(i + dat.length() + 2);break;}}
		return str;
	}
	public void deleteData(String id) {
		String aux = "";int band = 1;
		String dev = "";int b2 = 0;
		evaluarDb();
		try {
			readPerm = new FileReader(file);
			read = new BufferedReader(readPerm);
		}catch(Exception e) {
			e.printStackTrace();
		}
		do {
			try {
				aux = read.readLine();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			if(aux != null && aux.contains(id + ".{")) {
				b2 = 1;
				for(int i = 1; i<= 26; i++) {
					try {
						aux = read.readLine();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			if(band == 1) {dev += aux;}
			if(aux != null && band == 0) {dev += "\n" + aux;}
			band=0;
		}while(aux != null);
		if(b2 == 0) {
			JOptionPane.showMessageDialog(null, "El id no se econtro", "Error", 0);
		}
		try {
			readPerm.close();
			read.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if (!file.delete()) {
            System.out.println("Error: El archivo no pudo ser eliminado");
            return;
        }else {
        	evaluarDb();
        	try {
    			writePerm = new FileWriter(file,true);
    			writer = new PrintWriter(writePerm);
    		}catch(Exception e) {
    			e.printStackTrace();
    		}
        	writer.println(dev);
        	try{writePerm.close();
        	writer.close();}catch(Exception e) {e.printStackTrace();}
        }
	}
}