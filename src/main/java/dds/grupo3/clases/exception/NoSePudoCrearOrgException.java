package dds.grupo3.clases.exception;

public class NoSePudoCrearOrgException extends Exception {
  public NoSePudoCrearOrgException() {
    super("No se pudo crear la organizacion");
  }
}