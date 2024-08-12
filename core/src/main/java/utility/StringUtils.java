package utility;

public class StringUtils {
    public static String prepare(String value) {
        return (value != null && !value.isEmpty()) ? value : "";
    }
}
