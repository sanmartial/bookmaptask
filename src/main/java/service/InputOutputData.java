package service;

import java.util.List;

public interface InputOutputData {

    List<String> inputDataFromFile(String path);

    void outputDataToFile(String path, List<Integer> outcomes);
}
