package pea2.onpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.CorsRegistry;



import pea2.onpe.services.IGrupoVotacionService;
import pea2.onpe.services.IexamenService;

@Configuration
@CrossOrigin
@Controller

public class OnpeController extends  WebMvcAutoConfiguration {
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
		
	}
	 @GetMapping("/index")
	    public String Onpe() {
		return "index";
	     }
@Autowired
private IGrupoVotacionService IGrupoVotacion;
		
	  @RequestMapping("/actas_info") 
	  public String ListarActasNumero(Model modelo,@RequestParam("nroMesa") String nroMesa ) {
		  modelo.addAttribute("actas", IGrupoVotacion.getGrupoVotacion(nroMesa));
		  return "actas_info";
	  }


	    @GetMapping("/actas_info/{id}")
	    public String listarpornumero(Model modelo,@PathVariable("id")String id) {
	    	modelo.addAttribute("actas", IGrupoVotacion.getGrupoVotacion(id));
	    	return"actas_info";
	    }
		@Autowired
		private IexamenService iexamen;
		
		@RequestMapping("/resumen")
		public String resumen(Model modelo){
			modelo.addAttribute("resumenes", iexamen.getExamen());
		    return "resumen";
		}


}
