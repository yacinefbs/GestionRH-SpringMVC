package com.gestionrh.www;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.gestionrh.www.entities.Banques;
import com.gestionrh.www.entities.JourFeries;
import com.gestionrh.www.entities.Salaries;
import com.gestionrh.www.metier.IBanqueMetier;
import com.gestionrh.www.metier.JoursFeriesMetierImpl;
import com.gestionrh.www.models.BanqueForm;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private IBanqueMetier metier;
	
	@Autowired
	private JoursFeriesMetierImpl metierJour = new JoursFeriesMetierImpl();
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="/AjouterBanques")
	public String ajouterBanque(@Valid BanqueForm bf, BindingResult bindingResult, Model model){
		
		//pour uploader un fichier : this.uploadFileHandler(name, file);@RequestParam("name") String name,
		//@RequestParam("file") MultipartFile file
		
		
		if(bindingResult.hasErrors()){
			return "banques";
		}
		
		Banques b = new Banques();
		b.setNomBanque(bf.getNomBanque());
		
		System.err.println("Ajouter banque");
		b = metier.ajouterBanque(b);
		
		bf.setNomBanque("");
		bf = this.chargerBanques(bf);
		model.addAttribute("banqueForm", bf);
		
		return "banques";
	}
	
	@RequestMapping(value="/banques")
	public String banques(BanqueForm bf, Model model){
		bf = this.chargerBanques(bf);
		model.addAttribute("banqueForm", bf);
		return "banques";
	}
	
	@RequestMapping(value="/editerBanque", method= RequestMethod.GET)
	public String editerBanque(@RequestParam("idBanque") Long idBanque, BanqueForm bf, Model model){
		System.out.println("idbanquennn : " + idBanque );
		
		Banques b = new Banques();
		b=metier.getBanqueById(idBanque);
		bf.setIdBanque(b.getIdBanque());
		bf.setNomBanque(b.getNomBanque());
		bf=this.chargerBanques(bf);
		model.addAttribute("banqueForm", bf);
		return "banques";
	}
	
	@RequestMapping(value="modifierbanque", method=RequestMethod.POST)
	public String modifierBanque(@Valid BanqueForm bf, BindingResult bindingResult, Model model){
		if(bindingResult.hasErrors()){
			return "banques";
		}
		
		System.out.println("modifier banque");
		
		Banques b = new Banques();
		b.setIdBanque(bf.getIdBanque());
		b.setNomBanque(bf.getNomBanque());
		b = metier.modifierBanque(b);
		
		bf = this.chargerBanques(bf);
		
		return "banques";
	}
	
	@RequestMapping(value="/supprimerBanque", method= RequestMethod.GET)
	public String supprimerBanque(@RequestParam("idBanque") Long idBanque, BanqueForm bf, Model model){
		
		metier.supprimerBanque(idBanque);
		
		bf.setIdBanque(null);
		bf.setNomBanque("");
		bf = this.chargerBanques(bf);
		model.addAttribute("banqueForm", bf);
		return "banques";
	}
	
	public BanqueForm chargerBanques(BanqueForm bf){
		List<Banques> liBanques = metier.getAllBanques();
		System.out.println("Nombre de banques : " +liBanques.size());
		bf.setBanques(liBanques);
		for (Banques banques : liBanques) {
			System.out.println("++++" + banques.getNomBanque().toString());
		}
		return bf;
	}
	
	
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/index")
	public String index(){
		return "index";
	}
	
	//------------------------Upload
	/*@RequestMapping(value="uploadFile")
	public String upload(){
		
		return "upload";
	}
	
	//------------------------------
	
	public String uploadFileHandler(String name, MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "C:/Application"; //System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "images");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}
	
//	@REQUESTMAPPING(VALUE="/UPLOAD")
//	PUBLIC STRING UPLO(){
//		RETURN "UPLOAD";
//	} */
	
}
