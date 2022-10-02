package personal.records;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import personal.records.ui.PersonInfo;

import javax.swing.*;
import java.awt.*;
import personal.records.ui.AddRecordForm;

@SpringBootApplication
public class RecordsApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = createApplicationContext(args);
		displayMainFrame(context);
	}
	private static ConfigurableApplicationContext createApplicationContext(String[] args) {
		return new SpringApplicationBuilder(RecordsApplication.class)
				.headless(false)
				.run(args);
	}
	private static void displayMainFrame(ConfigurableApplicationContext context) {
		SwingUtilities.invokeLater(() -> {
			AddRecordForm mainForm = context.getBean(AddRecordForm.class);
			mainForm.setVisible(true);
		});
	}
}
