package dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.controller.dto.ReservationDTO;
import dev.domain.Reservation;
import dev.domain.StatutVehicule;
import dev.exception.EmptyRepositoryException;
import dev.exception.ReservationInvalideException;
import dev.repository.ReservationRepository;
import dev.repository.VehiculeRepo;

@Service
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepo;

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
			ReservationDTO reservationDTO = new ReservationDTO(reservation);
			listeDeReservation.add(reservationDTO);
		}
		return listeDeReservation;
	}

	public List<ReservationDTO> afficherListeReservationVehicule(String immatriculation)
			throws EmptyRepositoryException {

		List<ReservationDTO> listeResasDTO = new ArrayList<>();
		List<Reservation> listeResas = reservationRepo.findByVehiculeImmatriculation(immatriculation);

		if (listeResas.isEmpty()) {
			throw new EmptyRepositoryException("Aucune réservation enregistrée pour ce véhicule");
		}

		for (Reservation resa : listeResas) {
			ReservationDTO resaDTO = new ReservationDTO(resa);
			listeResasDTO.add(resaDTO);
		}

		return listeResasDTO;

	}

}
