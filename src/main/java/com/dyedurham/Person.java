package com.dyedurham;

public class Person {

  private String firstName;
  private String lastName;

  public Person(String fullName) {
    if(fullName != null) {
      int spacePos = fullName.lastIndexOf(" ");
      if(spacePos != -1) {
        this.firstName = fullName.substring(0, spacePos);
        this.lastName = fullName.substring(spacePos+1);
      }
    }
  }

  public String getFirstName()  {
    return firstName;
  }

  public void setFirstName(String firstName)  {
    this.firstName = firstName;
  }

  public String getLastName()  {
    return lastName;
  }

  public void setLastName(String lastName)  {
    this.lastName = lastName;
  }

  public String toString() {
    return this.firstName + " " + this.lastName;
  }
}
