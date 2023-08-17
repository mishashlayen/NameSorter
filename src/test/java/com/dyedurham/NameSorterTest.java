package com.dyedurham;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NameSorterTest {

  NameSorter ns;

  final String RESOURCE_PATH = "./src/test/resources/";

  @BeforeEach
  public void init() {
    ns = new NameSorter();
  }

  @Test
  public void test_sortNames() {
    List<Person> unsortedList = createUnsortedList();

    List<Person> sortedList = ns.sortNames(unsortedList);

    assertNotNull(sortedList);
    assertEquals(unsortedList.size(), sortedList.size());
    assertEquals("Martin", sortedList.get(0).getFirstName());
    assertEquals("Mike", sortedList.get(4).getFirstName());
  }

  @Test
  public void test_readUnsortedFile() {
    try {
      List<Person> unsortedList = ns.readUnsortedFile(RESOURCE_PATH + "unsorted-names-list.txt");

      assertNotNull(unsortedList);
      assertEquals(13, unsortedList.size());
    } catch(Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void test_readUnsortedFile_invalidNames() {
    try {
      List<Person> unsortedList = ns.readUnsortedFile(RESOURCE_PATH + "list-with-invalid-names.txt");

      assertNotNull(unsortedList);
      assertEquals(5, unsortedList.size());
    } catch(Exception e) {
      fail(e.getMessage());
    }
  }

  @Test
  public void test_readUnsortedFile_exception() {
    assertThrows(FileNotFoundException.class, ()-> ns.readUnsortedFile("unsorted-names-list.txt"));
  }

  @Test
  public void test_writeSortedListToFile() {
    List<Person> unsortedList = createUnsortedList();

    try {
      File f = new File("sorted-names-list.txt");
      if(f.exists()) {
        f.delete();
      }

      ns.writeSortedListToFile(unsortedList);

      assertTrue(f.exists() && f.isFile());

      // clean up
      f.delete();
    } catch(Exception e) {
      fail(e.getMessage());
    }
  }

  private List<Person> createUnsortedList() {
    return Arrays.asList(new Person("Janet Parsons"),
                         new Person("Adonis Julius Archer"),
                         new Person("Mike Parsons"),
                         new Person("Hunter Uriah Mathew Clarke"),
                         new Person("Frankie Conner Ritter"),
                         new Person("Martin Alvarez"));
  }
}
