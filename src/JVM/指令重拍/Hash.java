package JVM.指令重拍;

        import java.util.Arrays;
        import java.util.List;
        import java.util.Map;
        import java.util.stream.Collectors;
        import java.util.stream.Stream;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 11:51 2018/7/24
 * @Modified By:
 */
public class Hash {
    public static void main(String[] args) {
        List<String> aList = Arrays.asList("1", "2", "3");
        List<String> bList = Arrays.asList("2", "3", "4");
        Map<Boolean, List<String>> compareMap = Stream.concat(aList.stream(), bList.stream()).filter(item -> !aList.contains(item) || !bList.contains(item)).collect(Collectors.groupingBy(aList::contains));
        System.out.println(compareMap.toString());

    }
}
