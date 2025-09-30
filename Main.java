import java.util.Scanner;

public class Main {
    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarnings(int earnings) {
        return earnings * 6 / 100;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;
        int spendings = 0;
        while (true) {
            System.out.println("Выберите операцию и введите её номер:\n" +
                    "1. Добавить новый доход\n" +
                    "2. Добавить новый расход\n" +
                    "3. Выбрать систему налогообложения");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            int index = Integer.parseInt(input);
            switch (index) {
                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int moneySum = Integer.parseInt(moneyStr);
                    earnings += moneySum;
                    break;
                case 2:
                    System.out.println("Введите сумму расхода:");
                    String expensesStr = scanner.nextLine();
                    int expensesSum = Integer.parseInt(expensesStr);
                    spendings += expensesSum;
                    break;
                case 3:
                    int taxE = taxEarnings(earnings);
                    int taxEMS = taxEarningsMinusSpendings(earnings, spendings);
                    if (taxE < taxEMS) {
                        System.out.println("Мы советуем вам УСН доходы\n" +
                                "Ваш налог составит: " + taxE + " рублей\n" +
                                "Налог на другой системе: " + taxEMS + " рублей\n" +
                                "Экономия: " + (taxEMS - taxE) + " рублей\n");
                    } else if (taxE > taxEMS) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы\n" +
                                "Ваш налог составит: " + taxEMS + " рублей\n" +
                                "Налог на другой системе: " + taxE + " рублей\n" +
                                "Экономия: " + (taxE - taxEMS) + " рублей\n");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения\n" +
                                "Ваш налог составит: " + taxE + " рублей\n" +
                                "Налог на другой системе: " + taxEMS + " рублей\n");
                    }
                    break;
                default:
                    System.out.println("Ошибка: неверный номер операции.");
            }
        }
        System.out.println("Программа завершена!");
    }
}