import service.DataService;
import service.InputOutputData;
import service.impl.DataServiceImpl;
import service.impl.InputOutputDataImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String PATH_TO_FILE_READ = "input.txt";
    private static final String PATH_TO_FILE_WRITE = "output.txt";

    public static void main(String[] args) {
        final InputOutputData inputOutputData = new InputOutputDataImpl();
        final DataService dataService = new DataServiceImpl();

        List<String> inputDataFromFiles = inputOutputData.inputDataFromFile(PATH_TO_FILE_READ);
        String baseLine = inputDataFromFiles.get(1);

        List<Integer> outcomes = inputDataFromFiles.stream()
                .skip(2)
                .parallel()
                .map(data -> dataService.processingData(baseLine, data))
                .collect(Collectors.toList());

        inputOutputData.outputDataToFile(PATH_TO_FILE_WRITE, outcomes);
    }
}
