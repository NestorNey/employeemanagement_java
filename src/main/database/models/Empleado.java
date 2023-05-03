package main.database.models;

public class Empleado{
	int dDi;
	int mDi;
	int aDi;
	int dDn;
	int mDn;
	int aDn;
	int noExt;
	int noInt;
	int cpost;
	double salario;
	String id;
	String Dep;
	String colonia;
	String calle;
	String nombre;
	String apPate;
	String apMate;
	String puesto;
	
	String CDE;
	
	
	public Empleado() {
		id = "";
		dDi = 0;
		mDi = 0;
		aDi = 0;
		dDn = 0;
		mDn = 0;
		aDn = 0;
		noExt = 0;
		noInt = 0;
		cpost = 0;
		salario = 0;
		Dep = "";
		colonia = "";
		calle = "";
		nombre = "";
		apPate = "";
		apMate = "";
		puesto = "";
		
		CDE = "";
	}
	
	public String getCDE() {
		return CDE;
	}
	
	public void setCDE(String CDE) {
		this.CDE = CDE;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public int getdDi() {
		return dDi;
	}


	public void setdDi(int dDi) {
		this.dDi = dDi;
	}


	public int getmDi() {
		return mDi;
	}


	public void setmDi(int mDi) {
		this.mDi = mDi;
	}


	public int getaDi() {
		return aDi;
	}


	public void setaDi(int aDi) {
		this.aDi = aDi;
	}


	public int getdDn() {
		return dDn;
	}


	public void setdDn(int dDn) {
		this.dDn = dDn;
	}


	public int getmDn() {
		return mDn;
	}


	public void setmDn(int mDn) {
		this.mDn = mDn;
	}


	public int getaDn() {
		return aDn;
	}


	public void setaDn(int aDn) {
		this.aDn = aDn;
	}


	public int getNoExt() {
		return noExt;
	}


	public void setNoExt(int noExt) {
		this.noExt = noExt;
	}


	public int getNoInt() {
		return noInt;
	}


	public void setNoInt(int noInt) {
		this.noInt = noInt;
	}


	public int getCpost() {
		return cpost;
	}


	public void setCpost(int cpost) {
		this.cpost = cpost;
	}


	public double getSalario() {
		return salario;
	}


	public void setSalario(double salario) {
		this.salario = salario;
	}


	public String getDep() {
		return Dep;
	}


	public void setDep(String dep) {
		Dep = dep;
	}


	public String getColonia() {
		return colonia;
	}


	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	public String getCalle() {
		return calle;
	}


	public void setCalle(String calle) {
		this.calle = calle;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApPate() {
		return apPate;
	}


	public void setApPate(String apPate) {
		this.apPate = apPate;
	}


	public String getApMate() {
		return apMate;
	}


	public void setApMate(String apMate) {
		this.apMate = apMate;
	}


	public String getPuesto() {
		return puesto;
	}


	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
}