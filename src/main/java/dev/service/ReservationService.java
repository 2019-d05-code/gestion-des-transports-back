package dev.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.controller.dto.AjoutChauffeurReservationDTO;
import dev.controller.dto.ReservationChauffeurDTO;
import dev.controller.dto.ReservationDTO;
import dev.domain.Collegue;
import dev.domain.Reservation;
import dev.domain.StatutVehicule;
import dev.exception.CollegueNonTrouveException;
import dev.exception.EmptyRepositoryException;
import dev.exception.ReservationInvalideException;
import dev.exception.ReservationNonTrouveException;
import dev.repository.CollegueRepo;
import dev.repository.ReservationRepository;
import dev.repository.VehiculeRepo;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepo;

	@Autowired
	CollegueRepo collegueRepo;

	@Autowired
	VehiculeRepo vrepo;

	public ReservationService() {

	}

	public ReservationService(ReservationRepository reRepo) {

		reservationRepo = reRepo;

	}

	public ReservationRepository getReservationRepo() {
		return reservationRepo;
	}

	public void setReservationRepo(ReservationRepository reservationRepo) {
		this.reservationRepo = reservationRepo;
	}

	// ajouter une réservation

	public Reservation ajouterReservation(Reservation reservation) throws ReservationInvalideException {

		if (reservation.getUneVoiture().getStatutVehicule() != StatutVehicule.EN_SERVICE) {
			throw new ReservationInvalideException("Le véhicule séletionné n'est actuellement pas en service");

		} else if (reservation.getDateDeReservation() == null || reservation.getDateDeRetour() == null) {
			throw new ReservationInvalideException("on ne peut pas ajouter cette réservation");
		} else {

			reservationRepo.save(reservation);
			return reservation;
		}

	}

	// afficher toutes les réservations
	public List<ReservationDTO> afficherToutesLesReservations() {

		List<ReservationDTO> listeDeReservation = new ArrayList<>();
		List<Reservation> maListesDeReservation = reservationRepo.findAll();

		for (Reservation reservation : maListesDeReservation) {

			if (reservation != null) {
				ReservationDTO reservationDTO = new ReservationDTO(reservation);
				listeDeReservation.add(reservationDTO);

			} else {
				throw new ReservationNonTrouveException("cette réservation n'existe pas ! ");
			}

		}
		return listeDeReservation;
	}

	public List<ReservationDTO> afficherListeReservationVehicule(String immatriculation)
			throws EmptyRepositoryException {

		List<ReservationDTO> listeResasDTO = new ArrayList<>();
		List<Reservation> listeResas = reservationRepo.findByUneVoitureImmatriculation(immatriculation);

		if (listeResas.isEmpty()) {
			throw new EmptyRepositoryException("Aucune réservation enregistrée pour ce véhicule");
		}

		for (Reservation resa : listeResas) {
			ReservationDTO resaDTO = new ReservationDTO(resa);
			listeResasDTO.add(resaDTO);
		}

		return listeResasDTO;

	}

	public List<ReservationChauffeurDTO> afficherReservationAvecNomChauffeur() {

		List<ReservationChauffeurDTO> listeDeReservation = new ArrayList<>();
		List<Reservation> maListesDeReservation = reservationRepo.findAll();

		for (Reservation reservation : maListesDeReservation) {
			if (reservation != null) {
				if (reservation.getUnChauffeur() != null) {
					ReservationChauffeurDTO reservationChauffeurDTO = new ReservationChauffeurDTO(reservation);
					listeDeReservation.add(reservationChauffeurDTO);
				} else {
					ReservationChauffeurDTO reservationChauffeurDTO = new ReservationChauffeurDTO(reservation, "", "");
					listeDeReservation.add(reservationChauffeurDTO);
				}

			} else {
				throw new ReservationNonTrouveException("cette réservation n'existe pas ! ");
			}

		}
		return listeDeReservation;
	}

	@Transactional
	public AjoutChauffeurReservationDTO ajouterChauffeurAReservation(
			AjoutChauffeurReservationDTO ajoutChauffeurReservationDTO) {
		Optional<Reservation> reservation = reservationRepo.findById(ajoutChauffeurReservationDTO.getIdResa());
		Optional<Collegue> col = collegueRepo.findById(ajoutChauffeurReservationDTO.getIdChauffeur());
		if (reservation.isPresent()) {
			if (col.isPresent()) {
				reservation.get().setUnChauffeur(col.get());
				AjoutChauffeurReservationDTO ajoutChauffeurResDTO = new AjoutChauffeurReservationDTO();
				return ajoutChauffeurResDTO;
			} else {
				throw new CollegueNonTrouveException("Le collegue n'a pas été trouvé");
			}
		} else {
			throw new ReservationNonTrouveException("cette réservation n'existe pas ! ");
		}
	}

}
