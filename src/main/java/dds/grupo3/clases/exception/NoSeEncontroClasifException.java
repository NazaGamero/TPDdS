package dds.grupo3.clases.exception;

public class NoSeEncontroClasifException extends Exception {
  public NoSeEncontroClasifException() {
    super("La clasificacion de la organizacion no se encontró");
  }
}