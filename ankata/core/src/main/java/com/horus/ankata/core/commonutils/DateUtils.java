package com.horus.ankata.core.commonutils;

/*import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;*/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class DateUtils {
	
	public static final long trois_mois = 90;
	public static final long six_mois = 180;
	public static final long douze_mois = 365;
	public static final long heure_to_ms = 3600000;
	public static final long mitune_to_ms = 60000;
	public static final long s_to_ms = 1000;
	public static final long jour_to_heure = 24;
	
	public static String dateToString(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	public static String dateToStringddMMyyyy(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("ddMMyyyy");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	public static String dateToStringddMMyy(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yy");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	
	public static String longToDateToString(long ldate) {
		Date laDate = new Date(ldate);
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}

	public static String ConvertMinToDay(int SommeDeTEMPS) {
		String s = "";
		s += (SommeDeTEMPS / 24 / 60) + "/";
		s += ((SommeDeTEMPS - (((SommeDeTEMPS / 24 / 60)) * 60 * 24)) / 60)
				+ "/";
		s += SommeDeTEMPS
				- ((SommeDeTEMPS / 24 / 60) * 24 * 60)
				- (((SommeDeTEMPS - (((SommeDeTEMPS / 24 / 60)) * 60 * 24)) / 60) * 60)
				+ "";
		return s;
	}
	public static String ConvertMinToDay(int SommeDeTEMPS,int heureparJour) {
		String s = "";
		s += (SommeDeTEMPS / heureparJour / 60) + "/";
		s += ((SommeDeTEMPS - (((SommeDeTEMPS / heureparJour / 60)) * 60 * heureparJour)) / 60)
				+ "/";
		s += SommeDeTEMPS
				- ((SommeDeTEMPS / heureparJour / 60) * heureparJour * 60)
				- (((SommeDeTEMPS - (((SommeDeTEMPS / heureparJour / 60)) * 60 * heureparJour)) / 60) * 60)
				+ "";
		return s;
	}
	public static String ConvertSecToDayString(int SommeDeTEMPS,int heureparJour) {
		String s = "";
		int jour =SommeDeTEMPS / (3600*heureparJour);
		SommeDeTEMPS = SommeDeTEMPS % (3600*heureparJour);
		int heures =SommeDeTEMPS / 3600;
		SommeDeTEMPS = SommeDeTEMPS % 3600;
		int minutes = SommeDeTEMPS / 60;
		int secondes = SommeDeTEMPS % 60;
		
		
		return jour+" Jours "+heures+" Heures "+minutes+" Minutes "+secondes+" Secondes";
	}

	
	public static String ConvertSecToDayString(int SommeDeTEMPS) {
		String s = "";
		
		int jour =SommeDeTEMPS / (3600*24);
		SommeDeTEMPS = SommeDeTEMPS % (3600*24);
		int heures =SommeDeTEMPS / 3600;
		SommeDeTEMPS = SommeDeTEMPS % 3600;
		int minutes = SommeDeTEMPS / 60;
		int secondes = SommeDeTEMPS % 60;		
		
		return jour+" Jours "+heures+" Heures "+minutes+" Minutes "+secondes+" Secondes";
	}
	public static String delayString(long SommeDeTEMPS) {
		String s = "";
		SommeDeTEMPS=SommeDeTEMPS/1000;
		long jour =SommeDeTEMPS / (3600*24);
		SommeDeTEMPS = SommeDeTEMPS % (3600*24);
		long heures =SommeDeTEMPS / 3600;
		SommeDeTEMPS = SommeDeTEMPS % 3600;
		long minutes = SommeDeTEMPS / 60;
		long secondes = SommeDeTEMPS % 60;		
		
		return jour+"d "+heures+"h "+minutes+"m "+secondes+"s ";
	}
	public static String dateheureToString(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	
	public static String dateheureAToString(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	
	public static String dateToMatricule(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("yyMMddHHmmss");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	
	public static String dateheureToStringSql(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}

	public static String heureToString(Date laDate) {
		SimpleDateFormat simple = new SimpleDateFormat("HH:mm:ss");
		if (laDate != null)
			return simple.format(laDate);
		else
			return "";
	}
	public static Date stringToDate(String sVal) {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			//e.printStackTrace();
			return null;
		}
	}
	public static String dateToStringSql(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String sDate = dateFormat.format(date);
		String jour = sDate.substring(0, 2);
		String mois = sDate.substring(3, 5);
		String annee = sDate.substring(6, 10);
		sDate = annee + "-" + mois + "-" + jour;
		return sDate;
	}

	public static String dateToStringSql(String sDate) {
		String jour = sDate.substring(0, 2);
		String mois = sDate.substring(3, 5);
		String annee = sDate.substring(6, 10);
		sDate = annee + "-" + mois + "-" + jour;
		return sDate;
	}
	public static String dateToStringSqlVs(String sDate) {
		String jour = sDate.substring(0, 2);
		String mois = sDate.substring(3, 5);
		String annee = sDate.substring(6, 10);
		sDate = annee + "-" + mois + "-" + jour;
		return sDate+" 00:00:00";
	}

	public static String splitDate(Date date, String format) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"dd/MM/yyyy HH:mm:ss");
		String sDate = dateFormat.format(date);
		String jour = sDate.substring(0, 2);
		String mois = sDate.substring(3, 5);
		String annee = sDate.substring(6, 10);
		String heure = sDate.substring(11, 13);
		String minute = sDate.substring(14, 16);
		String seconde = sDate.substring(17, 19);
		if (format.equals("D")) {
			sDate = jour;
		}
		if (format.equals("M")) {
			sDate = mois;
		}
		if (format.equals("Y")) {
			sDate = annee;
		}
		if (format.equals("H")) {
			sDate = heure;
		}
		if (format.equals("Mn")) {
			sDate = minute;
		}
		if (format.equals("S")) {
			sDate = seconde;
		}
		return sDate;
	}

	public static String dateSqlToDateFr(String sDate) {
		String annee = sDate.substring(0, 4);
		String mois = sDate.substring(5, 7);
		String jour = sDate.substring(8, 10);
		sDate = jour + "/" + mois + "/" + annee;
		return sDate;
	}

	// ////////////////////////////////// MEMBRES
	// ///////////////////////////////////////////////
	public static Date getFirstDayeOfyear(Date date) {
		Calendar d = Calendar.getInstance();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		d.set(cal.get(Calendar.YEAR), 0, 1);
		return d.getTime();
	}

	public static Date addYear(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, delai);
		return cal.getTime();
	}

	public static Date removeYear(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, -delai);
		return cal.getTime();
	}

	public static Date addDay(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, delai);
		return cal.getTime();
	}

	public static Date removeDay(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_MONTH, -delai);
		return cal.getTime();
	}

	public static Date addMonth(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, delai);
		return cal.getTime();
	}

	public static Date removeMonth(Date date, int delai) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, -delai);
		return cal.getTime();
	}

	public static int getCourantYear() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dat = dateFormat.format(new Date());
		return Integer.parseInt(dat.substring(6, 10));
	}

	public static long DifferenceDate(Date date1, Date date2, String r) {
		long resultat = 0;
		long msjour = 0;
		long heure = 0;

		if (r == "ss") {
			msjour = date1.getTime() - date2.getTime();
			resultat = Math.abs(msjour) / s_to_ms;

		}
		if (r == "mm") {
			msjour = date1.getTime() - date2.getTime();
			resultat = Math.abs(msjour) / mitune_to_ms;

		}
		if (r == "hh") {
			msjour = date1.getTime() - date2.getTime();
			heure = Math.abs(msjour) / heure_to_ms;
			resultat = heure;
		}
		if (r == "jj") {
			msjour = date1.getTime() - date2.getTime();
			heure = Math.abs(msjour) / heure_to_ms;
			resultat = heure / jour_to_heure;
		}
		return resultat;
	}

	public static long DifferenceDate(Date date1, Date date2, String jourf,
			String jours, String jourd, List<Date> ljf) {
		long resultat = 0;
		Date d = date1;
		boolean b = true;
		while (b) {
			boolean add = true;
			if (d.after(date2)) {
				b = false;
				break;
			} else {
				if (jours.equals("N")) {
					if (DateUtils.getDayOfWeek(d) == 7)
						add = false;
				}
				if (jours.equals("N")) {
					if (DateUtils.getDayOfWeek(d) == 1)
						add = false;
				}
				if (jourf.equals("N") && ljf.size() > 0) {
					if (ljf.contains(d))
						add = false;
				}
				if (add)
					resultat++;
				d = addDay(d, 1);
			}
		}

		return resultat;
	}

	public static String StringDateToStringSql(String sDate) {
		String jour = sDate.substring(0, 2);
		String mois = sDate.substring(3, 5);
		String annee = sDate.substring(6, 10);
		sDate = annee + "-" + mois + "-" + jour;
		return sDate;
	}

	public static Date stringMysqlToDate(String sVal) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static Date stringMysqlToDateHeure(String sVal) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		//"2012-02-07 08:27:00"
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date stringHeure(String sVal) {

		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Date sgloclToDate(String sVal) {

		SimpleDateFormat df = new SimpleDateFormat("yyyy/M/d");
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int getCoeeficiantInteret(Date date) {
		// date du 31/12/
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int m = cal.get(Calendar.MONTH) + 1;
		int j = cal.get(Calendar.DAY_OF_MONTH);
		int nb = (12 - m) * 2;
		if (j >= 16 && j <= 31)
			nb = nb + 1;
		if (j >= 1 && j <= 15)
			nb = nb + 2;

		return nb;
	}

	/** Determiner si une ann�e est bissextile */
	public static boolean estBessextile(int year) {
		return new GregorianCalendar().isLeapYear(year);
	}

	/** Determiner le jour de la semaine */
	public static int getDayOfWeek(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		return cal.get(Calendar.DAY_OF_WEEK);
	}

	

	
	public static Date getFirsDayOfWeek(int year, int week) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.YEAR, year);

		// Now get the first day of week.
		return calendar.getTime();
	}

	public static Date getLastDayOfWeek(int year, int week) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		calendar.set(Calendar.YEAR, year);

		// Now get the first day of week.
		return DateUtils.addDay(calendar.getTime(), 6);
	}
	
	public static Date createDate(int year, int month,int day,int h,int m,int s) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		calendar.set(Calendar.HOUR, h);
		calendar.set(Calendar.MINUTE, m);
		calendar.set(Calendar.SECOND, s);

		return calendar.getTime();
	}
	public static Date createDate(int year, int month,int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		
		calendar.set(Calendar.MONTH, month-1);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();
	}
	

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.YEAR);
	}
	
	public static int getYear(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	public static int getMonth(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MONTH)+1;
	}
	public static int getDay(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	public static int getHour(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	public static int getMinute(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MINUTE);
	}
	
	public static int getSeconde(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.SECOND);
	}
	public static int getMilliSeconde(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		return cal.get(Calendar.MILLISECOND);
	}

	public static int getCurrentWeek() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		return cal.get(Calendar.WEEK_OF_YEAR);
	}
	
	
	
	public static List<Date> getDateWeekEnd(Date dateDebut,Date dateFin) {
		List<Date> l=new ArrayList<Date>();
		dateFin=addDay(dateFin, 1);
		while (dateDebut.before(dateFin)) {
			
			if(getDayOfWeek(dateDebut)==1 || getDayOfWeek(dateDebut)==7){
				l.add(dateDebut);
			}
			dateDebut=addDay(dateDebut, 1);
		}
		
		return l;
	}
	
	public static boolean estJourWeekEnd(Date date) {
		boolean err=true;
		if(getDayOfWeek(date)==1 || getDayOfWeek(date)==7){
			err=false;
		}
		return err;
	}
	public static Date duree(Date d1, Date d2) {
		Calendar calendar1 = Calendar.getInstance();
		  Calendar calendar2 = Calendar.getInstance();
		  calendar1.set(2010, 01, 01,getHour(d1),getMinute(d1));
		  calendar2.set(2010, 01, 01,getHour(d2),getMinute(d2));
		  long milliseconds1 = calendar1.getTimeInMillis();
		  long milliseconds2 = calendar2.getTimeInMillis();
		  
		  long diff = milliseconds2 - milliseconds1;
		  //long diffSeconds = diff / 1000;
		  long diffMinutes = diff / (60 * 1000);
		  long diffHours = diff / (60 * 60 * 1000);
		//  long diffDays = diff / (24 * 60 * 60 * 1000);
		  
		  Calendar calendar = Calendar.getInstance();
			calendar.clear();
			calendar.set(Calendar.HOUR, Integer.parseInt(diffHours+""));
			calendar.set(Calendar.MINUTE, Integer.parseInt(diffMinutes+""));
		return calendar.getTime();
	}
	
	/*public static boolean ControleValiditeDate(String date) {
		boolean correct = false;
		// Date au format :dd/MM/yyyy a verifier
		RegularExpression reg = new RegularExpression(
				"^[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}$");
		if (reg.matches(date)) {
			String[] d = date.split("/");
			int j = Integer.parseInt(d[0]);
			int m = Integer.parseInt(d[1]);
			int a = Integer.parseInt(d[2]);
			if (j < 1 || j > 31) {
				correct = false;
			} else {
				if (m < 1 || m > 12) {
					correct = false;
				} else {
					correct = true;
				}
			}

		}
		return correct;
	}
	*/
	public static String stringToDateString(String val) {
		String[] tab = val.split(" ");
		if(tab[1].equals("Jan")) tab[1] = "01";
		if(tab[1].equals("Feb")) tab[1] = "02";
		if(tab[1].equals("Mar")) tab[1] = "03";
		if(tab[1].equals("Apr")) tab[1] = "04";
		if(tab[1].equals("May")) tab[1] = "05";
		if(tab[1].equals("Jun"))tab[1] = "06";
		if(tab[1].equals("Jul")) tab[1] = "07";
		if(tab[1].equals("Aug")) tab[1] = "08";
		if(tab[1].equals("Sep")) tab[1] = "09";
		if(tab[1].equals("Oct")) tab[1] = "10";
		if(tab[1].equals("Nov")) tab[1] = "11";
		if(tab[1].equals("Dec")) tab[1] = "12";
		val = tab[2] + "/" + tab[1] + "/" + tab[5] ;
		return val;
	}
	public static Date stringToDate(String sVal, String ff) {

		SimpleDateFormat df = new SimpleDateFormat(ff);
		try {
			return df.parse(sVal);
		} catch (ParseException e) {
			//e.printStackTrace();
			return null;
		}
	}
	public static String stringDateFormater(String val) {
		String[] tab = val.split("-");
		return tab[2] + "/" + tab[1] + "/" +tab[0];
	}
}
