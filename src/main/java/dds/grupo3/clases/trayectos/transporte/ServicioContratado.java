package dds.grupo3.clases.trayectos.transporte;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("3")
public class ServicioContratado extends Transporte {
	@Column(name="nombre_servicio")
	//"Uber" por ejemplo
	private String nombreServicio;

}