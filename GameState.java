package com.assign06;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class GameState implements Loadable {
   private CharImage c = new CharImage(12, 30, '.');
   private ArrayList<Object> a = new ArrayList();

   public GameState() {
   }

   public Loadable createLoadable(String typeName) throws GameFileException {
      switch (typeName) {
         case "Rat":
            Rat r = new Rat();
            return r;
         case "Book":
            Book b = new Book();
            return b;
         case "Item":
            Item i = new Item();
            return i;
         case "Skeleton":
            Skeleton s = new Skeleton();
            return s;
      }

      GameFileException G = new GameFileException("Unknown type: " + typeName);
      throw G;
   }

   public void load(Scanner input) throws GameFileException {
      String typeName = "";
      this.a.clear();
      this.c.clear();
      int cnt = input.nextInt();

      for(int i = 0; i < cnt; ++i) {
         typeName = input.next();
         Loadable m = this.createLoadable(typeName);
         m.load(input);
         this.a.add(m);
         if (m instanceof Creature C) {
            C.draw(this.c);
         }
      }

   }

   public String toString() {
      String s = "MAP:\n";
      s = s + this.c.getMapString() + "\n";
      s = s + "CREATURES:\n";

      int i;
      for(i = 0; i < this.a.size(); ++i) {
         if (this.a.get(i) instanceof Creature) {
            Creature C = (Creature)this.a.get(i);
            s = s + C.toString() + "\n";
         }
      }

      s = s + "INVENTORY:\n";

      for(i = 0; i < this.a.size(); ++i) {
         if (this.a.get(i) instanceof Item) {
            Item I = (Item)this.a.get(i);
            s = s + I.toString() + "\n";
         }
      }

      return s;
   }

   public void save(String filename) throws GameFileException {
      try {
         PrintWriter p = new PrintWriter(filename);
         p.print(this.toString());
         p.close();
      } catch (Exception var4) {
         GameFileException G = new GameFileException("Failed to save file!", var4);
         throw G;
      }
   }
}

