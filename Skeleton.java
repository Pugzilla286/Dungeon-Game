package com.assign06;

public class Skeleton extends Creature {
   public Skeleton() {
   }

   public Skeleton(int row, int col) {
      super(row, col);
   }

   public String toString() {
      String s = "Skeleton at " + this.getRow() + "," + this.getCol();
      return s;
   }

   public void draw(CharImage map) {
      map.setPos(this.getRow(), this.getCol(), 'S');
   }
}
