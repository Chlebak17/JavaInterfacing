package exercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CityRead {

    static HashMap<String, HashMap<String, HashSet<String>>> bigMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("source\\Cities.txt"));
        //přidávání:
        String[] parts;
        for (String line :
             lines) {
            parts = line.split(",");
            //kontinent
            if (!bigMap.containsKey(parts[2])) {
                bigMap.put(parts[2], new HashMap<>());
            }

            //země kontinentu:
            if (!bigMap.get(parts[2]).containsKey(parts[1])) {
//                vezmi kontinent, vloz do nej, zemi a hashmapu mest
                bigMap.get(parts[2]).put(parts[1], new HashSet<>());
            }

            bigMap.get(parts[2]).get(parts[1]).add(parts[0]);
        }

        System.out.println(bigMap.toString());
    }
}
