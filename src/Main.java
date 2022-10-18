import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Logger logger = Logger.getInstance();
            logger.log("Запускаем программу");
            logger.log("Просим пользователя ввести входные данные для списка");
            System.out.println("Введите размер списка:");
            int listSize = scanner.nextInt();
            System.out.println("Введите верхнюю границу для значений:");
            int maxValue = scanner.nextInt();
            List<Integer> source = createSource(listSize, maxValue);
            logger.log("Создаём и наполняем список");
            System.out.println("Вот случайный список: " + source);
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра:");
            int treshold = scanner.nextInt();
            if (treshold > maxValue) {
                logger.log("Порог для фильтра выше верхней границы значения списка, фильтрация не имеет смысла." +
                        "\n Попробуйте заново");
                continue;
            }
            logger.log("Запускаем фильтрацию");
            Filter filter = new Filter(treshold);
            List<Integer> result = filter.filterOut(source);
            logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
            logger.log("Выводим результат на экран:");
            System.out.println("Отфильтрованный список: " + result);
            logger.log("Завершаем программу");


        }
    }

    static List<Integer> createSource(int listSize, int maxValue) {
        List<Integer> source = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, listSize).forEach(i -> source.add(i, random.nextInt(maxValue)));
        return source;
    }
}
