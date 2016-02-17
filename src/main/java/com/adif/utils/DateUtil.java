package com.adif.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalDate;

public class DateUtil {
	
	public static Date moisSuivant(Date dateCourante){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateCourante);
		cal.add(Calendar.MONTH, 1);
		return cal.getTime();
	
	}
	public static Date moisPrecedent(Date dateCourante){
		Calendar cal = Calendar.getInstance();
		cal.setTime(dateCourante);
		cal.add(Calendar.MONTH, -1);
		return cal.getTime();
	
	}
	public static List<Date> getDatesIntervale(Date dateDebut , Date dateFin ) {
		List<Date> dates = new ArrayList<Date>();
		int days = Days.daysBetween(LocalDate.fromDateFields(dateDebut), LocalDate.fromDateFields(dateFin)).getDays()+1;
		for (int i=0; i < days; i++) {
		    LocalDate d = LocalDate.fromDateFields(dateDebut).withFieldAdded(DurationFieldType.days(), i);
		    dates.add(d.toDateMidnight().toDate());
		}
		return dates;
	}
	public static List<Date> createMonthLabels(Date date) {
		// add labels
		List<Date> daysInMonthLabels = new ArrayList<Date>();
		LocalDate firstDay =  new LocalDate(date).withDayOfMonth(1);
		LocalDate nextMonthFirstDay = firstDay.plusMonths(1);
		while (firstDay.isBefore(nextMonthFirstDay)) {
			daysInMonthLabels.add(firstDay.toDateTimeAtStartOfDay().toDate());
			firstDay = firstDay.plusDays(1);
		}
		return daysInMonthLabels;
	}
	public static boolean compare(Date date1){
		Date date2=Calendar.getInstance().getTime();
	
	if(date1.compareTo(date2)>0){
		return true;
	}
	return false;
	}
}
