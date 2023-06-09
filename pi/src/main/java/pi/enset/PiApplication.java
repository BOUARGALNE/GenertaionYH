package pi.enset;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pi.enset.entities.Module;
import pi.enset.entities.*;
import pi.enset.entities.enums.JourDeLaSemaine;
import pi.enset.entities.enums.NumeroSemester;
import pi.enset.repository.*;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class PiApplication {
    public static void main(String[] args) {
        SpringApplication.run(PiApplication.class, args);
    }
    @Bean
    CommandLineRunner lineRunner(EnseignantRepository userRepository,
                                 DepartementRepostitory departementRepostitory,
                                 ClasseRepository classeRepository,
                                 ElementModuleRepository elementModuleRepository,
                                 SemestreRepository semestreRepository,
                                 TypeSalleRepository typeSalleRepository,
                                 SalleRepository salleRepository,
                                 FiliereRepository filiereRepository, ModuleRepository moduleRepository,
                                 NonDisponibiliteRepository nonDisponibiliteRepository, SeanceRepository seanceRepository) {
        return args -> {
            // add some data to test

            Filiere filiere = new Filiere();
            filiere.setChefFiliere("AHRIZ");
            filiere.setLibelle("GLSID");
            filiere.setNombreSem(5);
            filiereRepository.save(filiere);
            //******************************
            Filiere f = Filiere.builder().libelle("BDCC").chefFiliere("M.Khiat").nombreSem(6).build();
            filiereRepository.save(f);
            //**************************
            Salle salle = new Salle();
            salle.setNumSalle(2);
            salleRepository.save(salle);
            //******************************
            Salle s = Salle.builder().numSalle(10).build();
            salleRepository.save(s);
            //******************************************
            Enseignant enseignant = new Enseignant();
            enseignant.setNom("ELYoussfi");
            enseignant.setPrenom("Mohammed");
            enseignant.setEmail("abo@gmail.com");
            enseignant.setCivilite("Mr");
            enseignant.setPassword("1111");
            enseignant.setTel("08282993");
            enseignant.setLogin("admin");
            enseignant.setSpecialite("Info Java");
            userRepository.save(enseignant);
            Enseignant enseignant1 = new Enseignant();
            enseignant.setNom("Qbadou");
            enseignant.setPrenom("Mohammed");
            enseignant.setEmail("abo@gmail.com");
            enseignant.setCivilite("Mr");
            enseignant.setPassword("1111");
            enseignant.setTel("08282993");
            enseignant.setLogin("user");
            enseignant.setSpecialite("Info Java");
            userRepository.save(enseignant1);
            //*******************************
            Departement d = Departement.builder()
                    .libelle("INFO")
                    .build();
            departementRepostitory.save(d);
            Departement d2 = Departement.builder()
                    .libelle("mecinic")
                    .build();
            departementRepostitory.save(d2);
            Departement d3 = Departement.builder()
                    .libelle("economie")
                    .build();
            departementRepostitory.save(d3);
            //*******************************
            Classe classe1 = Classe.builder()
                    .libelle("BDCC 2").
                    nbrEleves(42).build();
            classeRepository.save(classe1);
            Classe classe2 = Classe.builder()
                    .libelle("GLSID 2").
                    nbrEleves(39).build();
            classeRepository.save(classe2);
            Classe classe3 = Classe.builder()
                    .libelle("GIL 2").
                    nbrEleves(30).build();
            classeRepository.save(classe3);
            //*******************************
            ElementDeModule elementDeModule1 = new ElementDeModule();
            elementDeModule1.setLibelle("Architecture distribuée J2EE");
            elementDeModule1.setVolumeHoraire(32);
            elementModuleRepository.save(elementDeModule1);
            //**********************************************//
            ElementDeModule elementDeModule2 = new ElementDeModule();
            elementDeModule2.setLibelle("Middlewares");
            elementDeModule2.setVolumeHoraire(24);
            elementModuleRepository.save(elementDeModule2);
            //**********************************************//
            ElementDeModule elementDeModule3 = new ElementDeModule();
            elementDeModule3.setLibelle("Initiation à l'entreprenariat ");
            elementDeModule3.setVolumeHoraire(26);
            elementModuleRepository.save(elementDeModule3);
            //*******************************
            Semestre s1 = Semestre.builder()
                    .anneeUniv("2022-2023")
                    .num(NumeroSemester.S1)
                    .dateDebut(new Date())
                    .dateFin(new Date())
                    .build();
            semestreRepository.save(s1);
            Semestre s2 = Semestre.builder()
                    .anneeUniv("2022-2023")
                    .num(NumeroSemester.S2)
                    .dateDebut(new Date())
                    .dateFin(new Date())
                    .build();
            semestreRepository.save(s2);
            TypeSalle typeSalle1 = TypeSalle.builder()
                    .capacite(12)
                    .libelle("tp")
                    .equipement(" reseaux , routeurs")
                    .build();
            //**********************************//
            typeSalleRepository.save(typeSalle1);
            TypeSalle typeSalle2 = TypeSalle.builder()
                    .capacite(50)
                    .libelle("td")
                    .equipement(" reseaux , routeurs")
                    .build();
            typeSalleRepository.save(typeSalle2);
            //*************************************
            Module module1 = new Module();
            module1.setLibelle("Architectures distribuée et Middlewares");
            module1.setVolumeHoraire(56);
            module1.getElementDeModules().add(elementDeModule1);
            module1.getElementDeModules().add(elementDeModule2);
            moduleRepository.save(module1);
            //*******************************************
            Module module2 = new Module();
            module2.setLibelle("Big Data:Fondements et Architectures");
            module2.setVolumeHoraire(56);
            moduleRepository.save(module2);
            //*******************************************
            Module module3 = new Module();
            module3.setLibelle("Intelligence artificielle et Systèmes Multi agents");
            module3.setVolumeHoraire(56);
            moduleRepository.save(module3);
            //******************************************
            NonDisponibilite nonDisponibilite = new NonDisponibilite();
            nonDisponibilite.setJour(JourDeLaSemaine.SAMEDI_MATIN);
            nonDisponibilite.setEnseignant(enseignant);
            nonDisponibiliteRepository.save(nonDisponibilite);
            //***********************************************
            Seance seance = Seance.builder()
                    .jour(JourDeLaSemaine.LUNDI_MATIN)
                    .heureDebut(LocalTime.of(11,10, 0))
                    .heureFin(LocalTime.of(12,20, 0))
                    .classe(classe1)
                    .elementDeModule(elementDeModule1)
                    .enseignant(enseignant)
                    .salle(salle)
                    .build();
            //System.out.println(seance.getHeureDebut());
            seanceRepository.save(seance);
            Seance seance2 = Seance.builder()
                    .jour(JourDeLaSemaine.MARDI_MATIN)
                    .heureDebut(LocalTime.of(9,00, 0))
                    .heureFin(LocalTime.of(10,20, 0))
                    .classe(classe1)
                    .elementDeModule(elementDeModule2)
                    .enseignant(enseignant1)
                    .salle(s)
                    .build();
            Seance seance3 = Seance.builder()
                    .jour(JourDeLaSemaine.MERCREDI_APRESMIDI)
                    .heureDebut(LocalTime.of(15,00, 0))
                    .heureFin(LocalTime.of(18,20, 0))
                    .classe(classe1)
                    .elementDeModule(elementDeModule2)
                    .enseignant(enseignant1)
                    .salle(s)
                    .build();
            //System.out.println(seance.getHeureDebut());
            seanceRepository.save(seance2);
            //******************************
               List<Seance> seances=seanceRepository.findAll();
            for (Seance sc: seances){
                System.out.println("-------------------");
                System.out.println(sc.getElementDeModule().getLibelle());
                System.out.println(sc.getEnseignant().getNom() +" "+ sc.getEnseignant().getPrenom());
                System.out.println(sc.getElementDeModule().getVolumeHoraire()+ "heures");
                System.out.println("Salle :"+sc.getSalle().getNumSalle());
            }



        };

    }
}
