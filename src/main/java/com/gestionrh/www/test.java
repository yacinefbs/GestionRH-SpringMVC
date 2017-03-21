package com.gestionrh.www;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gestionrh.www.entities.Banques;
import com.gestionrh.www.metier.IBanqueMetier;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});
		IBanqueMetier metier = (IBanqueMetier) context.getBean("metier");
		
		metier.ajouterBanque(new Banques("Banque populaire"));
	}
}