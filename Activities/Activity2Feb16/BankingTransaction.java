package Activities.Activity2Feb16;

import java.util.*;

enum ActionType {
    DEPOSIT, WITHDRAW, TRANSFER, LOGIN, FAILED_LOGIN
}

enum Status {
    SUCCESS, FAILED
}

class LogEntry {
    private static int counter = 1;

    private int id;
    private String acc;
    private ActionType type;
    private double amt;
    private Status status;

    public LogEntry(String acc, ActionType type, double amt, Status status) {
        this.id = counter++;
        this.acc = acc;
        this.type = type;
        this.amt = amt;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getAcc() {
        return acc;
    }

    public ActionType getType() {
        return type;
    }

    public double getAmt() {
        return amt;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return String.format("ID:%d | Acc:%s | %s | Amt:%.2f | %s",
                id, acc, type, amt, status);
    }
}

class LogManager {
    private List<LogEntry> logs = new ArrayList<>();
    private Map<String, List<LogEntry>> accMap = new HashMap<>();
    private Map<ActionType, List<LogEntry>> typeMap = new HashMap<>();

    public void add(String acc, ActionType type, double amt, Status status) {
        LogEntry log = new LogEntry(acc, type, amt, status);
        logs.add(log);
        accMap.computeIfAbsent(acc, k -> new ArrayList<>()).add(log);
        typeMap.computeIfAbsent(type, k -> new ArrayList<>()).add(log);
        System.out.println("Added: " + log);
    }

    public List<LogEntry> getByAcc(String acc) {
        return accMap.getOrDefault(acc, new ArrayList<>());
    }

    public List<LogEntry> getRecent(int n) {
        if (n <= 0 || logs.isEmpty())
            return new ArrayList<>();
        int start = Math.max(0, logs.size() - n);
        List<LogEntry> recent = new ArrayList<>(logs.subList(start, logs.size()));
        Collections.reverse(recent);
        return recent;
    }

    public List<LogEntry> getSuspicious() {
        Set<LogEntry> sus = new HashSet<>();

        for (String acc : accMap.keySet()) {
            List<LogEntry> list = accMap.get(acc);
            int start = Math.max(0, list.size() - 5);
            List<LogEntry> last5 = list.subList(start, list.size());

            long failed = last5.stream()
                    .filter(l -> l.getType() == ActionType.FAILED_LOGIN)
                    .count();

            if (failed > 3) {
                last5.stream()
                        .filter(l -> l.getType() == ActionType.FAILED_LOGIN)
                        .forEach(sus::add);
            }
        }

        logs.stream()
                .filter(l -> l.getType() == ActionType.WITHDRAW && l.getAmt() > 50000)
                .forEach(sus::add);

        return new ArrayList<>(sus);
    }

    public List<LogEntry> getByType(ActionType type) {
        return typeMap.getOrDefault(type, new ArrayList<>());
    }

    public void show(List<LogEntry> list) {
        if (list.isEmpty()) {
            System.out.println("No logs found.");
        } else {
            list.forEach(System.out::println);
        }
    }
}

class BankingTransaction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LogManager mgr = new LogManager();

        while (true) {
            System.out.println("\n1.Add 2.GetByAcc 3.Recent 4.Suspicious 5.ByType 6.Exit");
            System.out.print("Choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                System.out.print("Account: ");
                String acc = sc.nextLine();
                System.out.print("Type(1-5): ");
                ActionType[] types = ActionType.values();
                ActionType type = types[sc.nextInt() - 1];
                System.out.print("Amount: ");
                double amt = sc.nextDouble();
                System.out.print("Status(1=SUCCESS,2=FAILED): ");
                Status st = sc.nextInt() == 1 ? Status.SUCCESS : Status.FAILED;
                sc.nextLine();
                mgr.add(acc, type, amt, st);

            } else if (ch == 2) {
                System.out.print("Account: ");
                String acc = sc.nextLine();
                mgr.show(mgr.getByAcc(acc));

            } else if (ch == 3) {
                System.out.print("N: ");
                int n = sc.nextInt();
                mgr.show(mgr.getRecent(n));

            } else if (ch == 4) {
                mgr.show(mgr.getSuspicious());

            } else if (ch == 5) {
                System.out.print("Type(1-5): ");
                ActionType type = ActionType.values()[sc.nextInt() - 1];
                mgr.show(mgr.getByType(type));

            } else if (ch == 6) {
                System.out.println("Bye!");
                break;
            }
        }
        sc.close();
    }
}