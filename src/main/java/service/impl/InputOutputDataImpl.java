package service.impl;


import service.InputOutputData;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputOutputDataImpl implements InputOutputData {


    @Override
    public List<String> inputDataFromFile(String path) {
        List<String> list = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;
            while ((line = br.readLine()) != null){
                list.add(line);
            }
        }
        catch (IOException e){
            throw new RuntimeException("Error! Can not read data from file " + path);
        }

   return list;

    }

    @Override
    public void outputDataToFile(String path, List<String> outcomes) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (String line : outcomes) {
                bw.write(line);
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error! Can not write data to file " + path);
        }
    }
}
