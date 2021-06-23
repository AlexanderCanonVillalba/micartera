package com.example.micartera.domain.service;

import java.util.Calendar;
import java.util.Date;

public class DateService {
    Calendar calendario = Calendar.getInstance();
    int mesInt = calendario.get(Calendar.MONTH);


    public String GetMonth() {
      String mes = "" ;
      switch (mesInt){
          case 0:
            mes =  "ENERO"  ;
          case 1 :
              mes =  "FEBRERO";
          case 2 :
              mes =  "MARZO";
          case 3 :
              mes =  "ABRIL";
          case 4 :
              mes =  "MAYO";
          case 5 :
              mes =  "JUNIO";
          case 6 :
              mes =  "JULIO";
          case 7 :
              mes =  "AGOSTO";
          case 8 :
              mes =  "SEPTIEMBRE";
          case 9 :
              mes =  "OCTUBRE";
          case 10 :
              mes =  "NOVIEMBRE";
          case 11 :
              mes =  "DICIEMBRE";
      }
        return mes;
    }
}


