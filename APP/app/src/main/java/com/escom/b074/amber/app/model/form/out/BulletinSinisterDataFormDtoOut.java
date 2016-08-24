package com.escom.b074.amber.app.model.form.out;


import com.escom.b074.amber.app.model.form.shared.PlaceFormDto;

public class BulletinSinisterDataFormDtoOut {
	private long factsDate;
	private PlaceFormDto place;
	public long getFactsDate() {
		return factsDate;
	}
	public void setFactsDate(long factsDate) {
		this.factsDate = factsDate;
	}
	public PlaceFormDto getPlace() {
		return place;
	}
	public void setPlace(PlaceFormDto place) {
		this.place = place;
	}
}
