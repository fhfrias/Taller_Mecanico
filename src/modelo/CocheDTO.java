package modelo;

public class CocheDTO {
	
	private String numeroBastidor;
	private String marca;
	private String modelo;
	private String matriculacion;
	
	public CocheDTO() {}
	public CocheDTO(String numeroBastidor, String marca, String modelo, String matriculacion) throws ExceptionCocheDTO {
		super();
		if (validarCampos(numeroBastidor, marca, modelo, matriculacion)) {
			this.numeroBastidor = numeroBastidor;
			this.marca = marca;
			this.modelo = modelo;
			this.matriculacion = matriculacion;
		} else {
			throw new ExceptionCocheDTO("Coche no valido, datos incompatibles");
		}
		
	}

	public String getNumeroBastidor() {
		return numeroBastidor;
	}

	public void setNumeroBastidor(String numeroBastidor) {
		if(numeroBastidor.length() == 17) {
			this.numeroBastidor = numeroBastidor;
		}
		else
			System.out.println("Numero de Bastidor erroneo");
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		if(marca.length() <= 40){
		this.marca = marca;
		}
		else {
			System.out.println("Marca demasiado larga");
		}
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		if(modelo.length() <= 40){
			this.modelo = modelo;
			}
			else {
				System.out.println("Modelo demasiado largo");
			}
	}

	public String getMatriculacion() {
		return matriculacion;
	}

	public void setMatriculacion(String matriculacion) {
		if(matriculacion.matches("^[12]{1}[09]{1}[0-9]{2}$")) {
			this.matriculacion = matriculacion;
		} else {
			System.out.println("Matricula erronea");
		}
	}

	@Override
	public String toString() {
		return "CocheDTO [numeroBastidor=" + numeroBastidor + ", marca=" + marca + ", modelo=" + modelo
				+ ", matriculacion=" + matriculacion + "]";
	}
	
	public boolean validarCampos(String numeroBastidor, String Marca, String Modelo, String Matriculacion) {
		if(numeroBastidor.length() == 17 && Marca.length() <= 40 
				&& Modelo.length() <= 40 && Matriculacion.matches("^[12]{1}[09]{1}[0-9]{2}$")) {
			return true;
		} else {
			return false;
		}
		
	}	
	

}