package com.horus.ankata.core.commonutils;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
	public static String CapitalLetter(String ch) {
		String sch = "";
		if (!ch.equals(""))
			sch = ch.substring(0, 1).toUpperCase()
					+ ch.substring(1, ch.length()).toLowerCase();
		return sch;
	}
	public static String encodeSHA1Password(String password) {
		byte[] uniqueKey = password.getBytes();
		byte[] hash = null;

		try {
			hash = MessageDigest.getInstance("SHA1").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("No SHA1 support in this VM.");
		}

		StringBuilder hashString = new StringBuilder();
		for (int i = 0; i < hash.length; i++) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else
				hashString.append(hex.substring(hex.length() - 2));
		}
		return hashString.toString();
	}

	public static String generateMatricule(){
		return "TMP"+DateUtils.dateToMatricule(new Date());
    }
	public static String generatePassword(int length){
    	String alphabet = 
    	        new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); //9
    	int n = alphabet.length(); //10

    	String result = new String(); 
    	Random r = new Random(); //11

    	for (int i=0; i<length; i++) //12
    	    result = result + alphabet.charAt(r.nextInt(n)); //13

    	return result;
    }
	public static String generateCaptcha(int length){
    	String alphabet = 
    	        new String("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"); //9
    	int n = alphabet.length(); //10

    	String result = new String(); 
    	Random r = new Random(); //11

    	for (int i=0; i<length; i++) //12
    	    result = result + alphabet.charAt(r.nextInt(n)); //13

    	return result;
    }
	
	public static String getEncodedMD5Password(String key) throws IOException {
		byte[] uniqueKey = key.getBytes();
		byte[] hash = null;
		try {
			hash = MessageDigest.getInstance("MD5").digest(uniqueKey);
		} catch (NoSuchAlgorithmException e) {
			throw new Error("no MD5 support in this VM");
		}
		StringBuffer hashString = new StringBuffer();
		for (int i = 0; i < hash.length; ++i) {
			String hex = Integer.toHexString(hash[i]);
			if (hex.length() == 1) {
				hashString.append('0');
				hashString.append(hex.charAt(hex.length() - 1));
			} else {
				hashString.append(hex.substring(hex.length() - 2));
			}
		}
		return hashString.toString();
	}
	
	public static String convertIntToString(int intToString) {
		String result = "";
		String r = "";
		int valeur = intToString;
		int error = 0;
		try {

			if (valeur != 1000000000 && valeur != 1000000 && valeur != 100000
					&& valeur != 1000 && valeur != 100 && valeur != -1000000000
					&& valeur != -1000000 && valeur != -100000
					&& valeur != -1000 && valeur != -100) {

				if (valeur < 0) {
					result = "-";
					valeur = -1 * valeur; // On le met en positif
				}

				// Nous allons commencer par convertir les chiffres sup�rieure �
				// 1 000 000 000
				if (valeur > 1000000000) {
					int valeurSupMilliard = valeur / 1000000000;
					result = result + " "
							+ convertIntToString(valeurSupMilliard)
							+ " milliard";
					valeur = valeur - (valeurSupMilliard * 1000000000);
				}

				// Nous allons convertir les chifres entre 1 000 000 et 999 999
				// 999
				if (valeur > 1000000) {
					int valeurMillion = valeur / 1000000;
					result = result + " " + convertIntToString(valeurMillion)
							+ " million";
					valeur = valeur - (valeurMillion * 1000000);
				}

				// Nous allons convertir les chiffres entre 1000 et 999 999
				if (valeur > 1000) {
					int valeurMille = valeur / 1000;

					if (valeurMille > 1) {
						result = result + " " + convertIntToString(valeurMille)
								+ " mille";
					} else {
						result = result + " mille";
					}

					valeur = valeur - (valeurMille * 1000);
				}

				// Nous allons convertir les chiffres entre 100 et 999
				if (valeur > 100) {
					int valeurCent = valeur / 100;

					if (valeurCent > 1) {
						result = result + " " + convertIntToString(valeurCent)
								+ " cent";
					} else {
						result = result + " cent";
					}

					valeur = valeur - (valeurCent * 100);
				}

				// Nous allons convertir les chiffres entre 0 et 99
				switch (valeur) {
				case 0:
					if (result == "" || result == "-") {
						result = "z�ro";
					}
					break;
				case 1:
					result = result + " un";
					break;
				case 2:
					result = result + " deux";
					break;
				case 3:
					result = result + " trois";
					break;
				case 4:
					result = result + " quatre";
					break;
				case 5:
					result = result + " cinq";
					break;
				case 6:
					result = result + " six";
					break;
				case 7:
					result = result + " sept";
					break;
				case 8:
					result = result + " huit";
					break;
				case 9:
					result = result + " neuf";
					break;
				case 10:
					result = result + " dix";
					break;
				case 11:
					result = result + " onze";
					break;
				case 12:
					result = result + " douze";
					break;
				case 13:
					result = result + " treize";
					break;
				case 14:
					result = result + " quatorze";
					break;
				case 15:
					result = result + " quinze";
					break;
				case 16:
					result = result + " seize";
					break;
				case 17:
					result = result + " dix-sept";
					break;
				case 18:
					result = result + " dix-huit";
					break;
				case 19:
					result = result + " dix-neuf";
					break;
				case 20:
					result = result + " vingt";
					break;
				case 30:
					result = result + " trente";
					break;
				case 40:
					result = result + " quarante";
					break;
				case 50:
					result = result + " cinquante";
					break;
				case 60:
					result = result + " soixante";
					break;
				case 70:
					result = result + " soixante-dix";
					break;
				case 80:
					result = result + " quatre-vingts";
					break;
				case 81:
					result = result + " quatre-vingts un";
					break;
				case 90:
					result = result + " quatre-vingts-dix";
					break;
				case 91:
					result = result + " quatre-vingts onze";
					break;
				default:
					int valeurDizaine = (valeur / 10) * 10;
					int valeurUnite = valeur % 10;

					// Les valeurs entre 16 et 20, 70 et 80, et entre 90 et 100
					// sont des cas
					// particuliers, nous devons faire un triatment particulier
					if ((valeur > 70 && valeur < 80)
							|| (valeur > 90 && valeur < 100)) {
						valeurDizaine -= 10;
						valeurUnite += 10;
					}

					if (valeurDizaine == 0) {
						result = result + " " + convertIntToString(valeurUnite);
					} else if (valeurUnite == 0) {
						result = result + " "
								+ convertIntToString(valeurDizaine);
					} else if (valeurUnite == 1) {
						result = result + " "
								+ convertIntToString(valeurDizaine) + " et "
								+ convertIntToString(valeurUnite);
					} else {
						result = result + " "
								+ convertIntToString(valeurDizaine) + "-"
								+ convertIntToString(valeurUnite);
					}

				}
			} else {
				if (valeur == 1000000000)
					result = result + "un milliard";
				if (valeur == 1000000)
					result = result + "un million";
				if (valeur == 100000)
					result = result + "cent millle";
				if (valeur == 1000)
					result = result + "mille";
				if (valeur == 100)
					result = result + "cent";
			}
		} catch (Exception e) {
			error = 1;
		} finally {
			if (error == 1) {
				r = "Inconnue";
			} else {
				r = result.trim();
			}

		}

		return r;
	}
	
	public static String Random(List<String> l){
		Random rand = new Random();
		int replaceTo = rand.nextInt(l.size()); 
	    return  l.get(replaceTo);	      
    }
	
	public static String getPersonneKey(String ch){
		ch=ch.toUpperCase();
		ch=ch.replaceAll(" ", "");
		ch=ch.replaceAll("VERS", "0101");    	
    	ch=ch.replaceAll("/", "");
    	ch=ch.replaceAll("-", "");
    	return ch;
    }
	public static String extractNumber(String ch){
		if(ch!=null) {
			ch=ch.toUpperCase();
			ch=ch.replaceAll(" ", "");
			Pattern p = Pattern.compile("\\d+"); // Ici ton regex => ta chaine de caractere a trouver
			Matcher m = p.matcher(ch); // s ta chaine titi23�de
			while(m.find()) // tant qu'il arrive a matcher ton regex ds la chaine de caractere s
			   ch=m.group();
			//System.out.println(m.group());
		}
		
    	return ch;
    }
}
