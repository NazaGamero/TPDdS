package dds.grupo3.clases.tipoDeMediciones;


import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Unidad {
	@Column(name="UNIDAD")
  private String nombre;
}

/*
m3,
lt,
kg,
lts,
Kwh,
km
*/