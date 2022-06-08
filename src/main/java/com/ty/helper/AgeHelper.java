package com.ty.helper;

import java.time.LocalDate;
import java.time.Period;

public class AgeHelper {

	public static int ageCal(LocalDate dob) {
		LocalDate today = LocalDate.now();
		if ((dob != null) && (today != null)) {
			return Period.between(dob, today).getYears();
		} else {
			return 0;
		}
	}
}
