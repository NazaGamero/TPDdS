package dds.grupo3.clases.exception;

public class MiembroNoVinculadoException extends RuntimeException {
  public MiembroNoVinculadoException() {
    super("El miembro no esta vinculado.");
  }
}