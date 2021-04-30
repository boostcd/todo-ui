package io.boostcd.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import io.jaegertracing.Configuration;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration(System.getenv("JAEGER_SERVICE_NAME"))
				.withReporter(Configuration.ReporterConfiguration.fromEnv())
				.withSampler(Configuration.SamplerConfiguration.fromEnv())
				.getTracer();
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}

}
