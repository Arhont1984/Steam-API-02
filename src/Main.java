import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }


        //подсчёт несовереннолетних

//        long count = persons.stream()
//                .filter(x -> x.getAge() < 18)
//                .count();
//        System.out.println( "Количество несовершеннолетних" + count + "человек");




        //Призыники и их фамилии
//        List<String> nameList = persons.stream()
//                .filter(x -> x.getAge() < 27)
//                .filter(x -> x.getAge() > 18)
//                .map(Person::getName)
//                .collect(Collectors.toList());
//        System.out.println(nameList);

        //потенциально работоспособные женщины
//        List<Person> womanList = persons.stream()
//                .filter(x->x.getSex()==Sex.WOMAN)
//                .filter(x->x.getEducation()== Education.HIGHER)
//                .filter(x -> x.getAge() < 60)
//                .filter(x -> x.getAge() > 18)
//                .sorted(Comparator.comparing(Person::getFamily))
//                .collect(Collectors.toList());
//        System.out.println(womanList);

        //потенциально работоспособные мужчины
        List<Person> manList = persons.stream()
                .filter(x->x.getSex()==Sex.MAN)
                .filter(x->x.getEducation()== Education.HIGHER)
                .filter(x -> x.getAge() < 65)
                .filter(x -> x.getAge() > 18)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(manList);

    }


    public enum Sex {
        MAN,
        WOMAN
    }

    public enum Education {
        ELEMENTARY,
        SECONDARY,
        FURTHER,
        HIGHER
    }
}
