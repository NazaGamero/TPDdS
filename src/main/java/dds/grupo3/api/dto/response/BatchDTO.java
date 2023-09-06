package dds.grupo3.api.dto.response;

import dds.grupo3.api.dto.request.MedicionDTO;
import dds.grupo3.clases.medible.BatchMediciones;
import dds.grupo3.clases.medible.Medible;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BatchDTO {
  private long id;
  private List<MedicionDTO> mediciones = new ArrayList<>();
  public BatchDTO(BatchMediciones batch){
    for(Medible medible : batch.getMediciones()){
      MedicionDTO medicionDTO= new MedicionDTO(medible);
      this.mediciones.add(medicionDTO);
    }
  }
}
