package com.example.micartera.domain.entity;

import com.example.micartera.R;

import java.sql.Timestamp;

public class FinancialAdjustment {
      float value ;
      int adjustmentType ;
      String category;
      String description;
      Timestamp date;

      public FinancialAdjustment(float value,  int adjustmentType, String category, String description, Timestamp date){
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

      public Timestamp getDate() {
            return date;
      }

      public void setDate(Timestamp date) {
            this.date = date;
      }

      public int getIdCategory() {
            int idCategory = 0;
            switch (category){
                  case "Mercado":
                        idCategory =  R.drawable.home;
                  case "":
            }
            return idCategory;
      }
}
