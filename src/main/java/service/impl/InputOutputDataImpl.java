package service.impl;


import service.InputOutputData;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InputOutputDataImpl implements InputOutputData {

    @Override
    public List<String> inputDataFromFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            throw new RuntimeException("Error! Can not read data from file " + path, e);
        }
    }

    @Override
    public void outputDataToFile(String path, List<Integer> outcomes) {
        try {
            Files.write(Paths.get(path), outcomes.stream().map(Object::toString).collect(Collectors.toList()));
        } catch (IOException e) {
            throw new RuntimeException("Error! Can not write data to file " + path, e);
        }
    }
}
