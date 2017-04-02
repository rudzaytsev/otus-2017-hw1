package app;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by rudolph on 02.04.17.
 */
public class Main {

  public static void main(String[] args) throws IOException {
    System.out.println("Hello otus!");

    String pathToFile = "emails.csv";
    System.out.println("Reading emails from: " + pathToFile);

    List<String> emails = readEmails(pathToFile);
    emails.forEach(System.out::println);
  }

  private static List<String> readEmails(String pathToFile) throws IOException {
    CSVReader reader = new CSVReader(new FileReader(pathToFile));
    List<String> emails = reader.readAll().stream().map(line -> line[0].trim()).collect(toList());
    return emails;
  }
}
