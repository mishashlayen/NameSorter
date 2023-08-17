<b>The Goal: Name Sorter</b>

Build a name sorter. Given a set of names, order that set first by last name, then by any given names the person may have. A name must have at least 1 given name
and may have up to 3 given names.

Example Usage
Given a a file called unsorted-names-list.txt containing the following list of names:

Janet Parsons</br>
Vaughn Lewis</br>
Adonis Julius Archer</br>
Shelby Nathan Yoder</br>
Marin Alvarez</br>
London Lindsey</br>
Beau Tristan Bentley</br>
Leo Gardner</br>
Hunter Uriah Mathew Clarke</br>
Mikayla Lopez</br>
Frankie Conner Ritter</br>

Executing the program in the following way: name-sorter ./unsorted-names-list.txt

Should result the sorted names to screen:

Marin Alvarez</br>
Adonis Julius Archer</br>
Beau Tristan Bentley</br>
Hunter Uriah Mathew Clarke</br>
Leo Gardner</br>
Vaughn Lewis</br>
London Lindsey</br>
Mikayla Lopez</br>
Janet Parsons</br>
Frankie Conner Ritter</br>
Shelby Nathan Yoder</br>

and a file in the working directory called sorted-names-list.txt containing the sorted names.</br>

If you have maven installed, you can run from the main project's directory command: mvn clean install</br>
It will build the project and run tests.
