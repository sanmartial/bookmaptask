package service.impl;

import service.DataService;

public class DataServiceImpl implements DataService {

    @Override
    public int processingData(String line, String data) {
        String[] datas = data.split(" ");

        int start = Integer.parseInt(datas[0]);
        int end = Integer.parseInt(datas[1]);
        int position = Integer.parseInt(datas[2]);
        int countInput = 0;

        String subLine = line.substring(start - 1, end);

        char target = subLine.charAt(position - 1);

        for (int i = 0; i < subLine.length(); i++) {
            if (target == subLine.charAt(i) && i < position) {
                countInput++;
            }
        }

        char opposite = target == 'A' ? 'B' : 'A';

        int i = 0;
        while (countInput > 0 && i < subLine.length()) {
            if (subLine.charAt(i) == opposite) {
                countInput--;
            }

            if (i == subLine.length() - 1) {
                return -1;
            }
            i++;
        }

        return i;
    }
}
