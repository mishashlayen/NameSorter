package com.dyedurham;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class NameSorter {

  private static final String OUTPUT_FILE = "sorted-names-list.txt";

  public static void main(String[] args) {
    if(args.length == 0) {
      System.out.println("Valid file path must be provided!");
      System.exit(-1); // error
    }

    NameSorter ns = new NameSorter();
    try {
      List<Person> unsortedNames = ns.readUnsortedFile(args[0]);
      List<Person> sortedNames = ns.sortNames(unsortedNames);

      System.out.println("Sorted names are:");
      for(Person p : sortedNames) {
        System.out.println(p);
      }

      ns.writeSortedListToFile(sortedNames);
	    System.out.println();
      System.out.println("Output also have been saved to file: " + OUTPUT_FILE);

    } catch(Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public NameSorter() {}

  /**
   * Reads file into List. A name must have at least 1 given name
   * and may have up to 3 given names. Otherwise it will be skipped.
   * Assuming all names contains only valid alphabetic characters, and do not contain any digits or special characters.
   * @param unsortedFile - String
   * @return List<Person>
   * @throws FileNotFoundException
   */
  public List<Person> readUnsortedFile(String unsortedFile) throws FileNotFoundException
  {
    Scanner s = new Scanner(new File(unsortedFile));
    List<Person> names = new ArrayList<>();
    while(s.hasNextLine()) {
      String fullName = s.nextLine();
      // has to be not blank
      if(!fullName.trim().isEmpty()) {
        String[] allNames = fullName.split(" ");
        // should be at least one first name and not more than 3 first names + 1 last name
        if(allNames.length > 1 && allNames.length < 5) {
          names.add(new Person(fullName));
        } else {
          System.out.println("Invalid name: " + fullName);
        }
      } else {
        System.out.println("Blank name...");
      }
    }

    s.close();

    return names;
  }

  /**
   * Sorts list of Person first by last name, then by first name
   * @param names - List<Person>
   * @return sorted list
   */
  public List<Person> sortNames(List<Person> names)
  {
    names.sort(Comparator.comparing(Person::getLastName).thenComparing(Person::getFirstName));

    return names;
  }

  /**
   * Writes list into output txt file in the working directory
   * @param names - List<Person>
   * @throws IOException
   */
  public void writeSortedListToFile(List<Person> names) throws IOException
  {
    File f = new File("./" + OUTPUT_FILE);
    if(f.exists()){
      f.delete();
    }

    FileWriter writer = new FileWriter("./" + OUTPUT_FILE);
    for(Person p : names){
      writer.append(p.toString()).append(System.lineSeparator());
    }

    writer.flush();
    writer.close();
  }
}
