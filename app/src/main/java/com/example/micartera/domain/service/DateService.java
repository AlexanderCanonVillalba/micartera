package com.example.micartera.domain.service;

import java.util.Calendar;
import java.util.Date;

public class DateService {
    public String GetMonth(int month) {
      String mes = "" ;
        System.out.println("validando cadena mes......." + month);
      switch (month){
          case 0:
            mes =  "ENERO"  ;
            break;
          case 1 :
              mes =  "FEBRERO";
          case 2 :
              mes =  "MARZO";
              break;
          case 3 :
              mes =  "ABRIL";
              break;
          case 4 :
              mes =  "MAYO";
              break;
          case 5 :
              mes =  "JUNIO";
              break;
          case 6 :
              mes =  "JULIO";
              break;
          case 7 :
              mes =  "AGOSTO";
              break;
          case 8 :
              mes =  "SEPTIEMBRE";
              break;
          case 9 :
              mes =  "OCTUBRE";
              break;
          case 10 :
              mes =  "NOVIEMBRE";
              break;
          case 11 :
              mes =  "DICIEMBRE";
              break;
      }
      System.out.println("validando cadena mes......." + mes);
        return mes;
    }
}


