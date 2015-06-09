# as400ListAPI
This project contains classes that work with the iSeries User Space List APIs and other related topics. Core classes to pay attention to are AS400ListAPI and the stuff in the packages org.rplgleparser.api.*

The AS400ListAPI object will invoke code that conforms to the ListApiCallback interface for each entry found (unless you return false to terminate the traversal early).

Each of the QUSL* classes have a main method and a callback method specified so you can change the parms in the main method and run the class to get the results output to the console.

In addition an object named ObjectListToArrayList has been placed into each package to show how one could extend the base QUSL* class to do whatever you like. These classes serve as examples of how to use this in code of your own.

Another class of interest is the Library List class. Seeing as JTOpen does not have a class to manage a library list as an entity, it fell to us to implement it. The class will allow you to add library list entries, remove library list entries, and do a wholesale replacement of library list entries. The changes are not sent to the iSeries until you issue a commit. This class requires you to give it a valid AS400 object and either a Job object or a ProgramCall object (which contains a Job object).
