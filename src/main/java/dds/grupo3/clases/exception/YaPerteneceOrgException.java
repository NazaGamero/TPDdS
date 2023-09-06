package dds.grupo3.clases.exception;

public class YaPerteneceOrgException extends RuntimeException {
  public YaPerteneceOrgException() {
    super("Ya pertenece a una Organizacion");
  }
}