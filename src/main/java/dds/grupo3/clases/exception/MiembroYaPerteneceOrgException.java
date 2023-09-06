package dds.grupo3.clases.exception;

public class MiembroYaPerteneceOrgException extends RuntimeException {
  public MiembroYaPerteneceOrgException() {
    super("El miembro ya pertenece a otro sector de la organizacion.");
  }
}