package com.escom.b074.amber.app.model.form.in;

import com.escom.b074.amber.app.model.form.shared.NationalityFormDto;

import java.util.List;


public class ListNationalitiesFormDtoIn {
	List<NationalityFormDto> nationalities;

	public List<NationalityFormDto> getNationalities() {
		return nationalities;
	}

	public void setNationalities(List<NationalityFormDto> nationalities) {
		this.nationalities = nationalities;
	}
	
}
