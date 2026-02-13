package Feb13;

import java.util.*;

public class StringLogs2DArray {
    public static void main(String[] args) {
        List<List<String>> logs = new ArrayList<>();

        logs.add(Arrays.asList("01-01-2023", "14:00", "ERROR", "failed"));
        logs.add(Arrays.asList("01-01-2023", "15:00", "INFO", "established"));
        logs.add(Arrays.asList("01-01-2023", "01:30", "ERROR", "failed"));

        List<List<String>> result = Result.extractErrorLogs(logs);

        for (List<String> log : result) {
            System.out.println(log);
        }

    }

}

class Result {
    public static List<List<String>> extractErrorLogs(List<List<String>> logs) {

        return logs.stream()
                .filter(log -> log.get(2).equals("ERROR")
                        || log.get(2).equals("CRITICAL"))
                .sorted(Comparator.comparingLong(Result::getTime))
                .toList();
    }

    private static long getTime(List<String> log) {
        String[] d = log.get(0).split("-");
        String[] t = log.get(1).split(":");
        return Long.parseLong(d[2] + d[1] + d[0] + t[0] + t[1]);
    }
}
