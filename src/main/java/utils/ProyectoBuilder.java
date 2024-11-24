package utils;

import models.Usuario;

public class ProyectoBuilder {
	private Usuario admin;
	private double presupuesto;
	public ProyectoBuilder(Usuario admin) {
		super();
		this.admin = admin;
		this.presupuesto=5000;
	}
	public Usuario getAdmin() {
		return admin;
	}
	public void setAdmin(Usuario admin) {
		this.admin = admin;
	}
	public double getPresupuesto() {
		return presupuesto;
	}
	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}
	
	
}
