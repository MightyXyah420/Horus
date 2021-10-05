package com.gd.horus;

import com.gd.horus.model.Fighter;
import com.gd.horus.model.Role;
import com.gd.horus.model.User;
import com.gd.horus.repo.RoleRepo;
import com.gd.horus.service.UserService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HorusApplication {

	public static void main(String[] args) {
		SpringApplication.run(HorusApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(RoleRepo roleRepo, UserService usrService){
		return args -> {
			Role fighter = new Role("fighter","role for final user");
			Role referee = new Role("referee","User in charge of assistance and battles");
			Role admin = new Role("admin","user admin");
			fighter = roleRepo.save(fighter);
			referee = roleRepo.save(referee);
			admin = roleRepo.save(admin);
			User admUser = new User();
			admUser.setPassword("password");
			admUser.setUsername("admin");
			admUser.addAuthority(admin);
			admUser.addAuthority(referee);
			User refUser = new User();
			refUser.setPassword("password");
			refUser.setUsername("referee");
			refUser.addAuthority(referee);
			Fighter fighterUser = new Fighter();
			fighterUser.setPassword("password");
			fighterUser.setUsername("fighter");
			fighterUser.addAuthority(fighter);
			usrService.createUser(admUser);
			usrService.createUser(refUser);
			this.gatherInfo();
		};
	}

	public void gatherInfo(){
		
		System.out.println("I got out bitches");
	}
}
