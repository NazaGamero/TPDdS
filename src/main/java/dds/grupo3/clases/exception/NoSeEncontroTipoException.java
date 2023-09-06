package dds.grupo3.clases.exception;

public class NoSeEncontroTipoException extends Exception {
  public NoSeEncontroTipoException() {
    super("El tipo de la organizacion no se encontró");
  }
}