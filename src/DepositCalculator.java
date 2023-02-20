import java.util.Scanner;

public class DepositCalculator {
    double сalculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return rounding(pay, 2);
    }

    double сalculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return rounding(amount + amount * yearRate * depositPeriod, 2);
    }

    double rounding(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void activateMenu() {
        int period;
        int action;
        int amount;
        double out = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();

        if (action == 1) {
            out = сalculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            out = сalculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().activateMenu();
    }


}
