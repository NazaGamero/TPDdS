package dds.grupo3;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import dds.grupo3.api.service.impl.EmailServiceImpl;

@EnableFeignClients
@SpringBootApplication
public class DdsGrupo3Application {

	public static void main(String[] args) {
		ScheduledExecutorService executorService;
		executorService = Executors.newSingleThreadScheduledExecutor();
		executorService.scheduleAtFixedRate(DdsGrupo3Application::envioDeReportes, 0, 5, TimeUnit.DAYS);
		System.setProperty("spring.devtools.restart.enabled", "false");
		SpringApplication.run(DdsGrupo3Application.class, args);

	}

	public static void envioDeReportes() {
		new EmailServiceImpl().enviarMensaje("mopup2017@gmail.com", "Reporte de huella de carbono: ");
	}

}
