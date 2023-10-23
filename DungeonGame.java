package com.assign06;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DungeonGame {
   public DungeonGame() {
   }

   public static void main(String[] args) {
      GameState gameState = new GameState();
      Scanner inputUser = new Scanner(System.in);
      System.out.println("Enter level filename:");
      String levelName = inputUser.nextLine();
      inputUser.close();

      try {
         Throwable var4 = null;
         Object var5 = null;

         try {
            Scanner levelFile = new Scanner(new File(levelName));

            try {
               gameState.load(levelFile);
            } finally {
               if (levelFile != null) {
                  levelFile.close();
               }

            }
         } catch (Throwable var16) {
            if (var4 == null) {
               var4 = var16;
            } else if (var4 != var16) {
               var4.addSuppressed(var16);
            }

            throw var4;
         }
      } catch (FileNotFoundException var17) {
         System.err.println("Game File Error: " + levelName + " not found!");
      } catch (Exception var18) {
         System.err.println("Game File Error: " + var18.getMessage());
      }

      System.out.println(gameState);
   }
}
