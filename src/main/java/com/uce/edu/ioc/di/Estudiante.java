package com.uce.edu.ioc.di;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class Estudiante {
	
	private String cedula; //si no se va usar como valor numerico, se usa el string
	private String nombre;
	private String apellido;
	private BigDecimal salario; //es la clase adecuada cuando se va usar un valor monetario
	
	@Override
	public String toString() {
		return "Estudiante [cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", salario=" + salario
				+ "]";
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public BigDecimal getSalario() {
		return salario;
	}
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	
}
