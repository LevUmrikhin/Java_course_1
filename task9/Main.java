import java.util.*;
import java.util.stream.Collectors;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String a = "Имена для девочки на букву А:\n" +
                "Августа\n" +
                "\n" +
                "Аврора — латинское: «утренняя заря».\n" +
                "\n" +
                "Агата — то же, что и Агафья.\n" +
                "\n" +
                "Агафья (Агата) — греческое: «добрая, хорошая».\n" +
                "\n" +
                "Аглая — греческое: «блистающая, великолепная».\n" +
                "\n" +
                "Агнесса\n" +
                "\n" +
                "Агния — латинское: «чистота, непорочность, овечка».\n" +
                "\n" +
                "Ада — древнееврейское: «нарядная».\n" +
                "\n" +
                "Аделаида — древнегерманское: «благородная, высокородная».\n" +
                "\n" +
                "Адель — древнегерманское: «благочестивая, благородная».\n" +
                "\n" +
                "Адина — арабское: «праздник, пятничное веселье».\n" +
                "\n" +
                "Азиза — арабское: «хранящая Бога».\n" +
                "\n" +
                "Аида — арабское: «польза, вознаграждение».\n" +
                "\n" +
                "Акулина   \n" +
                "\n" +
                "Алевтина — греческое: «благовония, без дурного запаха».\n" +
                "\n" +
                "Александра — древнегреческое: «защитница людей», от мужского имени Александр.\n" +
                "\n" +
                "Алена\n" +
                "\n" +
                "Алина — древнегерманское: «благородная, стойкая».\n" +
                "\n" +
                "Алиса — германское: «значимая, весомая, достойная».\n" +
                "\n" +
                "Алия — арабское: «возвышенная».\n" +
                "\n" +
                "Алла — два происхождения: древнегреческое — «другая», древнегерманское — «стать, благородство».\n" +
                "\n" +
                "Альбина — латинское: «белая».\n" +
                "\n" +
                "Анастасия — древнегреческое: «воскресающая», от мужского имени Анастас.\n" +
                "\n" +
                "Ангелина — древнегреческое: «вестница, ангел».\n" +
                "\n" +
                "Анжела, Анжелика — древнегреческое: «ангельская».\n" +
                "\n" +
                "Анисия (Анисья)\n" +
                "\n" +
                "Анита\n" +
                "\n" +
                "Анна — древнееврейское: «миловидная, симпатичная».\n" +
                "\n" +
                "Антонина — латинское: «противница»; в Древнем Риме обозначало принадлежность девушки к определенному роду.\n" +
                "\n" +
                "Анфиса — древнегреческое: «цветущая».\n" +
                "\n" +
                "Ариадна\n" +
                "\n" +
                "Арина — русская форма имени Ирина.\n" +
                "\n" +
                "Ася — греческое: «воскресающая», произошло от имени Анастасия.\n" +
                "\n" +
                "Аэлита — древнегреческое: «воздушная».\n" +
                "\n" +
                "Имена для девочки на букву Б:\n" +
                "Барбара — то же, что и Варвара.\n" +
                "\n" +
                "Беатриса (Беата) — латинское: «счастливая».\n" +
                "\n" +
                "Белла — латинское: «красавица».\n" +
                "\n" +
                "Береслава\n" +
                "\n" +
                "Богдана\n" +
                "\n" +
                "Божена — другая форма имени Богдана: «данная Богом, божественная».\n" +
                "\n" +
                "Борислава\n" +
                "\n" +
                "Бронислава\n" +
                "\n" +
                "Имена для девочки на букву В:\n" +
                "Валентина — латинское: «здоровая», от мужского имени Валентин.\n" +
                "\n" +
                "Валерия — латинское: «сильная», от мужского имени Валерий. Возникло как римское родовое имя.\n" +
                "\n" +
                "Ванда\n" +
                "\n" +
                "Варвара — древнегреческое: «чужеземка».\n" +
                "\n" +
                "Василиса — древнегреческое: «царица».\n" +
                "\n" +
                "Васса — древнегреческое: «пустыня».\n" +
                "\n" +
                "Веда — болгарское: «русалка».\n" +
                "\n" +
                "Венера\n" +
                "\n" +
                "Вера — русское: «вера».\n" +
                "\n" +
                "Вероника — древнегреческое: «победоносная, несущая победу».\n" +
                "\n" +
                "Виктория — латинское: «победа», от мужского имени Виктор.\n" +
                "\n" +
                "Виолетта, Виола, Виоланта — латинское: «фиалка», «фиалочка».\n" +
                "\n" +
                "Виргиния (Вирджиния)\n" +
                "\n" +
                "Виталина\n" +
                "\n" +
                "Виталия\n" +
                "\n" +
                "Влада, Владислава — славянское: «владеющая», от мужского имени Влад.\n" +
                "\n" +
                "Владлена\n" +
                "\n" +
                "Власта — чешское: «родина».\n" +
                "\n" +
                "Имена для девочки на букву Г:\n" +
                "Габриэлла (Габриела)\n" +
                "\n" +
                "Галина — греческое: «спокойная, безмятежная».\n" +
                "\n" +
                "Гаяне — тюркское: «красавица».\n" +
                "\n" +
                "Гелена\n" +
                "\n" +
                "Гелла\n" +
                "\n" +
                "Генриетта — древнегерманское: «благородная красавица, красивая»\n" +
                "\n" +
                "Георгина\n" +
                "\n" +
                "Герда — скандинавское: «защитница».\n" +
                "\n" +
                "Глафира — древнегреческое: «изящная».\n" +
                "\n" +
                "Глория\n" +
                "\n" +
                "Грация\n" +
                "\n" +
                "Гульнара — арабское: «красивый цветок».\n" +
                "\n" +
                "Имена для девочки на букву Д:\n" +
                "Дайна (Дина) — древнееврейское: «отомщенная».\n" +
                "\n" +
                "Дана\n" +
                "\n" +
                "Дарина — персидское: «владеющая дарами».\n" +
                "\n" +
                "Дарья (Дария) — древнегреческое: «сильная, побеждающая».\n" +
                "\n" +
                "Джамиля — арабское: «прекрасная».\n" +
                "\n" +
                "Джулия\n" +
                "\n" +
                "Джульетта\n" +
                "\n" +
                "Диана — латинское имя богини охоты.\n" +
                "\n" +
                "Дина\n" +
                "\n" +
                "Динара\n" +
                "\n" +
                "Домна (Доминика)\n" +
                "\n" +
                "Дорофея — древнегреческое: «дар Божий», от мужского имени Дорофей.\n" +
                "\n" +
                "Имена для девочки на букву Е:\n" +
                "Ева — древнееврейское: «живая, сама жизнь», первое женское имя.\n" +
                "\n" +
                "Евгения — древнегреческое: «благородная», от мужского имени Евгений.\n" +
                "\n" +
                "Евдокия — греческое: «благоволение».\n" +
                "\n" +
                "Екатерина — древнегреческое: «чистая, непорочная».\n" +
                "\n" +
                "Елена — древнегреческое: «прекрасная, светлая, сияющая».\n" +
                "\n" +
                "Елизавета — древнееврейское: «клянусь Богом».\n" +
                "\n" +
                "Ефросиния (Ефросинья)\n" +
                "\n" +
                "Имена для девочки на букву Ж:\n" +
                "Жанна — древнееврейское: «милость Божья».\n" +
                "\n" +
                "Жозефина\n" +
                "\n" +
                "Имена для девочки на букву З:\n" +
                "Зара — арабское: «золото».\n" +
                "\n" +
                "Зарема — тюркское: «алая заря».\n" +
                "\n" +
                "Земфира — латинское: «непокорная».\n" +
                "\n" +
                "Зинаида — древнегреческое: «принадлежащая Зевсу».\n" +
                "\n" +
                "Злата\n" +
                "\n" +
                "Зоя — древнегреческое: «жизнь».\n" +
                "\n" +
                "Имена для девочки на букву И:\n" +
                "Ида — древнегреческое: «плодородная».\n" +
                "\n" +
                "Изабелла — испанское: «красавица».\n" +
                "\n" +
                "Изольда — древнегерманское: «блеск золота».\n" +
                "\n" +
                "Илона\n" +
                "\n" +
                "Инга — древнескандинавское: «зимняя».\n" +
                "\n" +
                "Инесса\n" +
                "\n" +
                "Инна — латинское: «бурный поток».\n" +
                "\n" +
                "Ирина — древнегреческое: «мир».\n" +
                "\n" +
                "Имена для девочки на букву К:\n" +
                "Карина (Карине) — латинское: «смотрит вперед».\n" +
                "\n" +
                "Каролина — германское: «королева, королевская кровь».\n" +
                "\n" +
                "Кира (Кириена) — древнегреческое: «госпожа, хозяйка».\n" +
                "\n" +
                "Клавдия — латинское: «хромая». В Римской империи было родовым именем.\n" +
                "\n" +
                "Кристина (Христина) — греческое: «посвященная Христу», возникло после установления христианства.\n" +
                "\n" +
                "Ксения — древнегреческое: «чужестранка, гостья».\n" +
                "\n" +
                "Имена для девочки на букву Л:\n" +
                "Лада — славянское: «милая, ладная».\n" +
                "\n" +
                "Лариса — греческое: «чайка».\n" +
                "\n" +
                "Лейла — арабское: «ночь».\n" +
                "\n" +
                "Лидия — древнегреческое имя для жительницы Лидии.\n" +
                "\n" +
                "Лилия\n" +
                "\n" +
                "Линда — испанское: «красивая».\n" +
                "\n" +
                "Лолита — испанское: «скорбь, печаль».\n" +
                "\n" +
                "Любовь — старославянское: «любимая».\n" +
                "\n" +
                "Людмила — старославянское: «милая людям».\n" +
                "\n" +
                "Имена для девочки на букву М:\n" +
                "Мавра — древнегреческое: «темная, непрозрачная».\n" +
                "\n" +
                "Мадина — арабское: «город».\n" +
                "\n" +
                "Майя — два происхождения: в древнегреческой мифологии — «богиня, мать Гермеса»; в индийской религиозной мифологии — «прародительница всего живого, Вселенной».\n" +
                "\n" +
                "Мальвина — германское: «слабость, нежность».\n" +
                "\n" +
                "Маргарита — латинское: «жемчужина».\n" +
                "\n" +
                "Марианна — рассматривают как слияние имен Мария и Анна со значением «морская».\n" +
                "\n" +
                "Марина — латинское: «морская».\n" +
                "\n" +
                "Мария — древнееврейское: «желанная, печальная».\n" +
                "\n" +
                "Марта (Марфа) — арамейское: «наставница, госпожа».\n" +
                "\n" +
                "Матрена (Матрона) — латинское: «почетная дама».\n" +
                "\n" +
                "Мелания\n" +
                "\n" +
                "Мила — славянское: «милая».\n" +
                "\n" +
                "Милена (Милана)\n" +
                "\n" +
                "Мирослава\n" +
                "\n" +
                "Мирра — два источника происхождения: древнееврейское — «миртовое дерево»; в советскую эпоху воспринималось как аббревиатура «мировая революция».\n" +
                "\n" +
                "Имена для девочки на букву Н:\n" +
                "Надежда — славянское: «надежда».\n" +
                "\n" +
                "Наиль (Наиля) — тюркское: «дар, подарок».\n" +
                "\n" +
                "Наина — древнееврейское: «невинная».\n" +
                "\n" +
                "Нана\n" +
                "\n" +
                "Наталья (Наталия) — латинское: «родная».\n" +
                "\n" +
                "Нелли — древнегреческое: «светлая».\n" +
                "\n" +
                "Ника\n" +
                "\n" +
                "Нина — греческое, образовано от имени основателя Сирийского государства Ниноса.\n" +
                "\n" +
                "Нонна — латинское: «девятая».\n" +
                "\n" +
                "Имена для девочки на букву О:\n" +
                "Оксана — возникло как украинская форма имени Ксения.\n" +
                "\n" +
                "Олеся — белорусское: «лесная».\n" +
                "\n" +
                "Ольга — древнескандинавское: «священная, святая».\n" +
                "\n" +
                "Имена для девочки на букву П:\n" +
                "Пелагея — древнегреческое: «морская».\n" +
                "\n" +
                "Полина — древнегреческое, означает принадлежность богу Аполлону, образовано как краткая форма имени Аполлинария.\n" +
                "\n" +
                "Прасковья — греческое имя для обозначения тех, кто родился в пятницу.\n" +
                "\n" +
                "Имена для девочки на букву Р:\n" +
                "Рахиль — древнееврейское: «овечка».\n" +
                "\n" +
                "Ребекка (Ревекка) — древнееврейское: «верная, захватывающая в плен».\n" +
                "\n" +
                "Регина — латинское: «царица, королева».\n" +
                "\n" +
                "Рената — латинское: «возрождающаяся».\n" +
                "\n" +
                "Рада — славянское: «веселая, радость».\n" +
                "\n" +
                "Раиса — греческое: «легкая».\n" +
                "\n" +
                "Регина\n" +
                "\n" +
                "Рената\n" +
                "\n" +
                "Римма — латинское: «римлянка».\n" +
                "\n" +
                "Рита — краткая форма имени Маргарита.\n" +
                "\n" +
                "Роза — латинское название цветка роза.\n" +
                "\n" +
                "Розалина\n" +
                "\n" +
                "Роксана\n" +
                "\n" +
                "Ростислава\n" +
                "\n" +
                "Руслана\n" +
                "\n" +
                "Руфина\n" +
                "\n" +
                "Руфь (Рут) — древнееврейское: «подруга».\n" +
                "\n" +
                "Имена для девочки на букву С:\n" +
                "Сабина\n" +
                "\n" +
                "Светлана — славянское: «свет, чистота».\n" +
                "\n" +
                "Селена (Селина)\n" +
                "\n" +
                "Серафима — древнееврейское: «огненный ангел».\n" +
                "\n" +
                "Сима\n" +
                "\n" +
                "Снежана — болгарское: «снежная».\n" +
                "\n" +
                "София (Софья) — древнегреческое: «мудрость».\n" +
                "\n" +
                "Станислава\n" +
                "\n" +
                "Стелла (Эстелла) — латинское: «звезда».\n" +
                "\n" +
                "Стефания (Степанида)\n" +
                "\n" +
                "Сусанна (Сосанна, Сузанна, Сюзанна) — древнееврейское название цветка белая лилия.\n" +
                "\n" +
                "Имена для девочки на букву Т:\n" +
                "Таисия — латинское: «плодородная».\n" +
                "\n" +
                "Тамара — древнееврейское: «финиковая пальма».\n" +
                "\n" +
                "Татьяна — греческое: «устроительница, расставляющая правила».\n" +
                "\n" +
                "Тереза\n" +
                "\n" +
                "Имена для девочки на букву У:\n" +
                "Ульяна — второй вариант имени Юлиана.\n" +
                "\n" +
                "Устинья (Юстина) — латинское: «справедливая».\n" +
                "\n" +
                "Имена для девочки на букву Ф:\n" +
                "Фаина — древнегреческое: «сияющая».\n" +
                "\n" +
                "Фая\n" +
                "\n" +
                "Фатима — арабское: «отнятая от груди».\n" +
                "\n" +
                "Феврония (Февронья)\n" +
                "\n" +
                "Федора (Феодора)\n" +
                "\n" +
                "Фелиция\n" +
                "\n" +
                "Феодосия (Феодосья)\n" +
                "\n" +
                "Фекла\n" +
                "\n" +
                "Флора — латинское название цветов или имя римской богини цветов и весны.\n" +
                "\n" +
                "Фрида — древнегерманское: «верная».\n" +
                "\n" +
                "Имена для девочки на букву Х:\n" +
                "Харита (Харитина)\n" +
                "\n" +
                "Хельга — вариант имени Ольга.\n" +
                "\n" +
                "Христина — второй вариант имени Кристина.\n" +
                "\n" +
                "Имена для девочки на букву Э:\n" +
                "\n" +
                "Эвелина — французское: «лесной орех».\n" +
                "\n" +
                "Эдда\n" +
                "\n" +
                "Эдита\n" +
                "\n" +
                "Элеонора — еврейское: «Бог — мой свет».\n" +
                "\n" +
                "Элиза — древнегерманское: «милость Божья».\n" +
                "\n" +
                "Элла — древнегерманское: «светлая».\n" +
                "\n" +
                "Эллина (Элина)\n" +
                "\n" +
                "Эльвира — древнегерманское: «защитница людей».\n" +
                "\n" +
                "Эльза — древнегерманское: «неспокойная».\n" +
                "\n" +
                "Эмилия\n" +
                "\n" +
                "Эмма — древнегерманское: «льстивая».\n" +
                "\n" +
                "Эрика\n" +
                "\n" +
                "Эстер — древнееврейское: «звезда».\n" +
                "\n" +
                "Имена для девочки на букву Ю:\n" +
                "Юлиана — еще один вариант имени Ульяна.\n" +
                "\n" +
                "Юлия — латинское: «кудрявая, пушистая». В Римской империи родовое имя.\n" +
                "\n" +
                "Юна (Уна, Юнна) — латинское: «единственная».\n" +
                "\n" +
                "Юнона — латинское: «вечно молодая». Так звали римскую богиню — жену Юпитера, покровительницу брака.\n" +
                "\n" +
                "Имена для девочки на букву Я:\n" +
                "Ядвига\n" +
                "\n" +
                "Яна (Янина) — древнееврейское: «Богом данная на милость всем».\n" +
                "\n" +
                "Янита\n" +
                "\n" +
                "Ярослава — славянское: «яркая слава».";
        Stream<String> stream = Stream.of(a.split("\n"))
                .filter(s -> !s.contains("Имена для девочки на букву"))
                .filter(s -> !s.trim().isEmpty())
                .map(s -> {
                    int firstIndex = s.indexOf(" ");
                    return firstIndex == -1 ? s : s.substring(0, firstIndex);
                }).filter(s -> !s.contains(",")).sorted();


        List<String> list = stream.collect(Collectors.toList());

        System.out.println(list);
        List<String> list1 = list.stream().filter(s -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'а' || s.charAt(i) == 'и' || s.charAt(i) == 'у' || s.charAt(i) == 'э' || s.charAt(i) == 'я' || s.charAt(i) == 'е' || s.charAt(i) == 'ы'|| s.charAt(i) == 'ю'|| s.charAt(i) == 'о'||
                s.charAt(i) == 'А' || s.charAt(i) == 'И' || s.charAt(i) == 'У' || s.charAt(i) == 'Э' || s.charAt(i) == 'Я' || s.charAt(i) == 'Е' || s.charAt(i) == 'Ы' || s.charAt(i) == 'Ю' || s.charAt(i) == 'О') {
                    count++;
                }
            }

            return count == 3 ;
        }).collect(Collectors.toList());
        System.out.println(list1);

        List<String> list2 = list.stream().filter(s -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'а' || s.charAt(i) == 'и' || s.charAt(i) == 'у' || s.charAt(i) == 'э' || s.charAt(i) == 'я' || s.charAt(i) == 'е' || s.charAt(i) == 'ы'|| s.charAt(i) == 'ю'|| s.charAt(i) == 'о'||
                        s.charAt(i) == 'А' || s.charAt(i) == 'И' || s.charAt(i) == 'У' || s.charAt(i) == 'Э' || s.charAt(i) == 'Я' || s.charAt(i) == 'Е' || s.charAt(i) == 'Ы' || s.charAt(i) == 'Ю' || s.charAt(i) == 'О') {
                    count++;
                }
            }

            return count == 4 ;
        }).collect(Collectors.toList());
        System.out.println(list2);

        List<String> list3 = list.stream().filter(s -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'а' || s.charAt(i) == 'и' || s.charAt(i) == 'у' || s.charAt(i) == 'э' || s.charAt(i) == 'я' || s.charAt(i) == 'е' || s.charAt(i) == 'ы'|| s.charAt(i) == 'ю'|| s.charAt(i) == 'о'||
                        s.charAt(i) == 'А' || s.charAt(i) == 'И' || s.charAt(i) == 'У' || s.charAt(i) == 'Э' || s.charAt(i) == 'Я' || s.charAt(i) == 'Е' || s.charAt(i) == 'Ы'|| s.charAt(i) == 'Ю' || s.charAt(i) == 'О') {
                    count++;
                }
            }

            return count == 5 ;
        }).collect(Collectors.toList());
        System.out.println(list3);


        Optional<String> list4 = list.stream().max((s1, s2)-> Integer.compare(s1.length(), s2.length()));
        list4.ifPresent(System.out::println);

        Optional<String> list5 = list.stream().min((s1, s2)-> Integer.compare(s1.length(), s2.length()));
        list5.ifPresent(System.out::println);

        Optional<String> list6 = list.stream().filter(s -> s.charAt(0) == 'Е').findFirst();
        list6.ifPresent(System.out::println);


        Boolean list7 = list.stream().allMatch(s -> {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'а' || s.charAt(i) == 'и' || s.charAt(i) == 'у' || s.charAt(i) == 'э' || s.charAt(i) == 'я' || s.charAt(i) == 'е' || s.charAt(i) == 'ы'|| s.charAt(i) == 'ю'|| s.charAt(i) == 'о'||
                        s.charAt(i) == 'А' || s.charAt(i) == 'И' || s.charAt(i) == 'У' || s.charAt(i) == 'Э' || s.charAt(i) == 'Я' || s.charAt(i) == 'Е' || s.charAt(i) == 'Ы' || s.charAt(i) == 'Ю' || s.charAt(i) == 'О') {
                    count++;
                }
            }

            return count != 0;

        });
        System.out.println(list7);

        Map<String, Integer> list8 = list.stream().collect(Collectors.toMap(
                Function.identity(),
                String::length,
                (existing, replacement) -> existing,
                LinkedHashMap::new
        ));
        list8.forEach((key, value) -> System.out.println(key + " => " + value));

        Map<Integer, List<String>> list9 = list.stream().collect(Collectors.groupingBy(s -> s.length()));
        list9.forEach( (key, value)-> System.out.println(key + " => " + value));

        //the same without streamAPI
        Map<Integer, List<String>> list11 = new TreeMap<>();
        for(String s : list) {
            list11.putIfAbsent(s.length(), new ArrayList<>()); // put empty lists first
        }
        for(String s : list){
            if(list11.get(s.length()) != null) {
                list11.get(s.length()).add(s);        //append each list
            }
        }

        list11.forEach((key, value) -> System.out.println(key + " => " + value));

        Map<Boolean, List<String>> list10 = list.stream().collect(Collectors.partitioningBy(s -> s.charAt(0) == 'а' || s.charAt(0) == 'и' || s.charAt(0) == 'у' || s.charAt(0) == 'э' || s.charAt(0) == 'я' || s.charAt(0) == 'е' || s.charAt(0) == 'ы'|| s.charAt(0) == 'ю'|| s.charAt(0) == 'о'||
                s.charAt(0) == 'А' || s.charAt(0) == 'И' || s.charAt(0) == 'У' || s.charAt(0) == 'Э' || s.charAt(0) == 'Я' || s.charAt(0) == 'Е' || s.charAt(0) == 'Ы' || s.charAt(0) == 'Ю' || s.charAt(0) == 'О'));
        Map<Boolean, List<String>> orderedMap = new LinkedHashMap<>();
        orderedMap.put(true, list10.get(true));
        orderedMap.put(false, list10.get(false));

        orderedMap.forEach((key, value) -> System.out.println(key + " => " + value));



    }

}