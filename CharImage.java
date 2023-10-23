package com.assign06;

public class CharImage {
   private int rowCnt;
   private int colCnt;
   private char defChar = '$';
   private char[][] data;

   public CharImage(int rowCnt, int colCnt, char fillChar) {
      this.data = new char[rowCnt][colCnt];
      this.defChar = fillChar;

      for(int i = 0; i < rowCnt; ++i) {
         for(int j = 0; j < colCnt; ++j) {
            this.data[i][j] = fillChar;
         }
      }

   }

   public void clear() {
      for(int i = 0; i < this.data.length; ++i) {
         for(int j = 0; j < this.data[0].length; ++j) {
            this.data[i][j] = this.defChar;
         }
      }

   }

   public int getRowCnt() {
      this.rowCnt = this.data.length;
      return this.rowCnt;
   }

   public int getColCnt() {
      this.colCnt = this.data[0].length;
      return this.colCnt;
   }

   public boolean isValidPosition(int row, int col) {
      return row < this.data.length && row >= 0 && col < this.data[row].length && col >= 0;
   }

   public char getPos(int row, int col) {
      return this.isValidPosition(row, col) ? this.data[row][col] : ' ';
   }

   public boolean setPos(int row, int col, char c) {
      if (this.isValidPosition(row, col)) {
         this.data[row][col] = c;
         return true;
      } else {
         return false;
      }
   }

   public String toString() {
      String s = this.getRowCnt() + " x " + this.getColCnt() + " CharImage (default: " + this.defChar + ")";
      return s;
   }

   public String getMapString() {
      String s = "";

      for(int i = 0; i < this.data.length; ++i) {
         for(int j = 0; j < this.data[0].length; ++j) {
            s = s + this.data[i][j];
         }

         s = s + '\n';
      }

      return s;
   }
}

