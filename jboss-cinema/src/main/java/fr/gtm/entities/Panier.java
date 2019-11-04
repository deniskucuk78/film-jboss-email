package fr.gtm.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;


@SessionScoped
public class Panier implements Serializable {
	
	
	
	private List<FilmDTO> filmsDto = new ArrayList<FilmDTO>();
	private double prixTotal = 0;
	
	public Panier() {
		
	}
	
	public void addFilmDto(FilmDTO dto) {
		filmsDto.add(dto);
		this.prixTotal = this.prixTotal + dto.getPrixHT();
	}

	public List<FilmDTO> getFilmsDto() {
		return filmsDto;
	}

	public void setFilmsDto(List<FilmDTO> filmsDto) {
		this.filmsDto = filmsDto;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}
	
	//Il nous faut un iterator 
	
	public void deleteFilm(FilmDTO dto) {
		this.prixTotal = this.prixTotal - dto.getPrixHT();
		filmsDto.remove(dto);
		
		
	}
	
	
	
	
	
	
	
	

}
