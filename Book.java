package com.assign06;

import java.util.Scanner;

public class Book extends Item {
   private String skill = "";

   public Book() {
   }

   public Book(String ID, int value, String skill) {
      super(ID, value);
      this.skill = skill;
   }

   public String getSkill() {
      return this.skill;
   }

   public void setSkill(String skill) {
      this.skill = skill;
   }

   public void read() {
      System.out.println("Skill " + this.skill + " increased!");
   }

   public String toString() {
      String s = super.toString() + ", enhances " + this.skill;
      return s;
   }

   public void load(Scanner input) throws GameFileException {
      try {
         super.load(input);
         this.skill = input.next();
      } catch (Exception var4) {
         this.setID("");
         this.setValue(0);
         this.skill = "";
         GameFileException G = new GameFileException("Error loading Book", var4);
         throw G;
      }
   }
}
