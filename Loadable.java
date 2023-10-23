package com.assign06;

import java.util.Scanner;

public interface Loadable {
   Scanner input = new Scanner(System.in);

   void load(Scanner var1) throws GameFileException;
}
