package br.com.makeProva.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import br.com.makeProva.controller.HomeController;
import br.com.makeProva.infra.saveFile;

@EnableWebMvc
@ComponentScan(basePackageClasses  = {HomeController.class, saveFile.class})
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	@Bean
	public InternalResourceViewResolver configure() {
		InternalResourceViewResolver ir = new InternalResourceViewResolver();
		ir.setPrefix("WEB-INF/view/");
		ir.setSuffix(".jsp");
		return ir;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	
	}
	
	@Bean(name = "multipartResolver")
    public MultipartResolver multiPartResolver() {
        return new StandardServletMultipartResolver();
    }
}
