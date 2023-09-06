package dds.grupo3.clases.exception;

public class ParametrosIngresadosInvalidosException extends RuntimeException {
  public ParametrosIngresadosInvalidosException() {
    super("Error, los parametros ingresados no son validos");
  }
}