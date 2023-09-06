package dds.grupo3.clases.readers;

import dds.grupo3.clases.medible.FactorEmision;
import dds.grupo3.clases.medible.Medible;
import java.util.List;

public interface MedicionesReader {
  List<Medible> leerArchivoMediciones(String path, List<FactorEmision> factores);
}