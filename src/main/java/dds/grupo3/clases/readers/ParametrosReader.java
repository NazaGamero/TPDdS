package dds.grupo3.clases.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParametrosReader {

  public Map<String, Float> leerParametros(String path) throws IOException {
    Map<String, Float> parametros = new HashMap<>();
    String line;
    BufferedReader reader = new BufferedReader(new FileReader(path));
    try {
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("=", 2);
        if (parts.length >= 2) {
          String key = parts[0];
          Float value = Float.valueOf(parts[1]);
          parametros.put(key, value);
        } else {
          System.out.println("ignoring line: " + line);
        }
      }
    } catch (FileNotFoundException e) {
    } catch (NumberFormatException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    reader.close();

    return parametros;
  }
}