package com.assign06;

import java.util.Scanner;

public abstract class Creature implements Drawable, Loadable {
   private int row;
   private int col;

   protected Creature() {
      this.row = 0;
      this.col = 0;
   }

   protected Creature(int row, int col) {
      this.row = row;
      this.col = col;
   }

   public int getRow() {
      return this.row;
   }

   public int getCol() {
      return this.col;
   }

   public void setRow(int row) {
      this.row = row;
   }

   public void setCol(int col) {
      this.col = col;
   }

   public void load(Scanner input) throws GameFileException {
      try {
         this.row = input.nextInt();
         this.col = input.nextInt();
      } catch (Exception var4) {
         this.row = 0;
         this.col = 0;
         GameFileException G = new GameFileException("Error loading Creature", var4);
         throw G;
      }
   }
}
