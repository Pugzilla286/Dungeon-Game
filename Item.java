package com.assign06;

import java.util.Scanner;

public class Item implements Loadable {
   private String ID;
   private int value;

   public Item() {
      this.ID = "";
      this.value = 0;
   }

   public Item(String ID, int value) {
      this.ID = ID;
      this.value = value;
   }

   public String getID() {
      return this.ID;
   }

   public int getValue() {
      return this.value;
   }

   public void setID(String ID) {
      this.ID = ID;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public String toString() {
      String s = this.ID + " with value " + this.value;
      return s;
   }

   public void load(Scanner input) throws GameFileException {
      try {
         this.ID = input.next();
         this.value = input.nextInt();
      } catch (Exception var4) {
         this.ID = "";
         this.value = 0;
         GameFileException G = new GameFileException("Error loading Item", var4);
         throw G;
      }
   }
}
