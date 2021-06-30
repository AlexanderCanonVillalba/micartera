package com.example.micartera.domain.entity;

import com.example.micartera.R;

import java.util.Date;


public class FinancialAdjustment {
      float value ;
      int adjustmentType ;
      String category;
      String description;
      Date date;

      public FinancialAdjustment(float value,  int adjustmentType, String category, String description, Date date){
            this.value =  value;
            this.category = category;
            this.adjustmentType = adjustmentType;
            this.description =  description;
            this.date = date;
      }

      public float getValue() {
            return value;
      }

      public void setValue(float value) {
            this.value = value;
      }

      public int getAdjustmentType() {
            return adjustmentType;
      }

      public void setAdjustmentType(int adjustmentType) {
            this.adjustmentType = adjustmentType;
      }

      public String getCategory() {
            return category;
      }

      public void setCategory(String category) {
            this.category = category;
      }

      public String getDescription() {
            return description;
      }

      public void setDescription(String description) {
            this.description = description;
      }

      public Date getDate() {
            return date;
      }

      public void setDate(Date date) {
            this.date = date;
      }

      public int getIdCategory() {
            int idCategory = 0;
            switch (category){
                  case "Mercado":
                        idCategory =  R.drawable.tienda;
                        break;
                  case "Transporte":
                        idCategory =  R.drawable.transporte_publico;
                  case "Servicios" :
                        idCategory =  R.drawable.factura;
                        break;
                  case "Ropa" :
                        idCategory =  R.drawable.navegador_web;
                        break;
                  case "Salud" :
                        idCategory =  R.drawable.reporte_de_salud;
                        break;
                  case "Hogar" :
                        idCategory =  R.drawable.casa;
                        break;
                  case "Gimnasio" :
                        idCategory =  R.drawable.gimnasio;
                        break;
                  case "Estudio" :
                        idCategory =  R.drawable.estudio;
                        break;
                  case "Entretenimiento" :
                        idCategory =  R.drawable.entretenimiento;
                        break;
                  case "Belleza" :
                        idCategory =  R.drawable.salon_de_belleza;
                        break;
            }
            return idCategory;
      }
}
