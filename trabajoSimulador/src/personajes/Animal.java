package personajes;

import exceptions.AunNoConfiguradaException;
/**
 * Superclase que hereda de SerVivo con la intencion de poner diferentes niveles de comida a los animales
 * 
 * @author Adrian Mata
 *
 */
public abstract class Animal extends SerVivo{

	private byte comida;//Indica el nivel de comida del animal 0 - 100, siendo 100 completamente lleno

	/**
	 * Constructor de la clase Animal con todas sus variables
	 * 
	 * @param comida
	 */
	public Animal(byte comida) {
		
		this.comida=comida;
	}
	
	/**
	 * Getter de la clase animal para la variable comida
	 * 
	 * @return
	 */
	public byte getComida() {
        return comida;
    }

	/**
	 * Setter de la clase Animal para la variable comida
	 * 
	 * @param comida
	 */
    public void setComida(byte comida) {
        this.comida = comida;
    }
    
    /**
     * Funcion que aumenta la comida de un Animal siempre que no vaya a superar el 100,lanza una excepcion de ser asi
     * 
     * @throws AunNoConfiguradaException mensaje personalizado advirtiendonos de nuestro error
     */
    public void comer() throws AunNoConfiguradaException {

		if (this.comida + 10 > 100 ||this.comida==0) {
			throw new AunNoConfiguradaException("No puedes dar de comer mas a este animal");
		} else {
			this.comida += 10;
		}
    	
    	
    }
    
    /**
     * Funcion que simula el paso del tiempo en Animales sin llegar a bajar de 100 sus variables agua y comida
     * 
     * @param cantidadHambre
     */
    public void tiempo(byte cantidadHambre) {
        super.tiempo();
        
        if(this.comida+cantidadHambre<0) {
        	
        }else {
        	this.comida += cantidadHambre;
        }
        
        
    }
    
    @Override
    public String toString() {
        return super.toString() + " comida: " + comida;
    }
}
