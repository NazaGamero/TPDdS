package dds.grupo3.clases.exception;

public class SectorNoPerteneceOrgException extends RuntimeException {
  public SectorNoPerteneceOrgException() {
    super("El miembro no esta vinculado.");
  }
}