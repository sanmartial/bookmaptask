import service.DataService;
import service.InputOutputData;
import service.impl.DataServiceImpl;
import service.impl.InputOutputDataImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String PATH_TO_FILE_READ = "input.txt";
    private static final String PATH_TO_FILE_WRITE = "output.txt";




    public static void main(String[] args) {

        final InputOutputData inputOutputData = new InputOutputDataImpl();
        final DataService dataService = new DataServiceImpl();
        List<String> inputDataFromFiles = inputOutputData.inputDataFromFile(PATH_TO_FILE_READ);
        List<String> outcomes = new ArrayList<>();
        for (int i = 2; i < inputDataFromFiles.size(); i++) {
            outcomes.add(String.valueOf(dataService.processingData(inputDataFromFiles.get(1), inputDataFromFiles.get(i))));
        }

        inputOutputData.outputDataToFile(PATH_TO_FILE_WRITE, outcomes);


    }
}
