package com.assign06;

public class Rat extends Creature {
   public Rat() {
   }

   public Rat(int row, int col) {
      super(row, col);
   }

   public String toString() {
      String s = "Rat at " + this.getRow() + "," + this.getCol();
      return s;
   }

   public void draw(CharImage map) {
      map.setPos(this.getRow(), this.getCol(), 'R');
   }
}
