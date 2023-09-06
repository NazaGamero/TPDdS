package dds.grupo3.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FactorEmisionDTO {
    private long id;
    private String nombre;
    private float valor;
}
