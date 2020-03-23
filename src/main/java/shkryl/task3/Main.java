package shkryl.task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        Helper helper = new Helper();
        //1. Заполнить ArrayList этими объектами.
        List<Human> listHuman = new ArrayList<>();
        helper.fillList(listHuman);

        System.out.println("--------------------------------------");
        System.out.println("Коллекция с дублями:");

        for (int i = 0; i < listHuman.size(); i++) {
            System.out.println((i + 1) + " " + listHuman.get(i));
        }

        //2. Найти дубли в коллекции и вывести их в консоль.
        Map<Human, Integer> mapHuman = helper.getDuplicateWithMap(listHuman);

        //2.2 а давай попробуем без дополнительной коллекции еще? (вывести дубли без доп коллекции)
        System.out.println("--------------------------------------");
        System.out.println("Выводим дубли коллекции без доп. коллекции");
        List<Human> dublicateList = helper.getDuplicateList(listHuman);
        System.out.println("Количество дубликатов: " + dublicateList.size());
        for (Human human : dublicateList) {
            System.out.println(human);
        }

        //3.Выводим коллекцию без дубей
        helper.printWithoutDublicate(listHuman, mapHuman);


        //4. Отсортировать людей по ФИО
        helper.sortHumanFio(listHuman);

        //5. Отсортировать людей по возрасту
        helper.sortHumanAge(listHuman);

        //6. Отсортировать людей по адресу (лексикографическая сортировка полного адреса)
        helper.sortHumanAddress(listHuman);

        //7. Создать класс User добавить в него поля ФИО, и роль которое является перечислением и
        //содержит в себе ADMIN, USER, MODERATOR
        User u1 = new User("Шкрыль Андрей", Role.ADMIN);
        User u2 = new User("Иванов Иван", Role.USER);
        User u3 = new User("Петров Семен", Role.MODERATOR);

        //8. Необходимо написать метод в который входным значением будет являтся объект класса User,
        //метод должен на основании роли пользователя выводить приветственное сообщение, что-то вроде
        //"Приветствуем ФИО с ролью " + ОПИСАНИЕ_РОЛИ
        //описание роли должно вычисляться на основании роли пользователя, запрещено использовать
        //if и switch, а так же описание роли в перечислении.
        System.out.println("--------------------------------------");
        System.out.println("Приветствие пользователей");
        u1.greeting();
        u2.greeting();
        u3.greeting();


        //9. Написать программу сортирующую HashMap по ключу. (Создание и генерация данными какими захотите)
        Map<Integer, String> map = new HashMap<>();
        helper.sortedMapOnKey(map);


        //10. Написать программу сортирующую HashMap по значнию. (Создание и генерация данными какими захотите)
        //используем туже самую Map<Integer,String> map
        helper.sortedMapOnvalue(map);

        //11. Заполнить рандомными значениями LinkedList, вывести содержимое каждого элемента и его индекс.
        helper.generateLinkedList();

    }


}
