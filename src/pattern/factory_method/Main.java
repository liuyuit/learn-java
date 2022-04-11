package pattern.factory_method;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


/**
 * Learn Java from https://www.liaoxuefeng.com/
 *
 * @author liaoxuefeng
 */
public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        LocalDateFactory localDateFactory = LocalDateFactory.getFactory();
        LocalDate ld = localDateFactory.fromInt(20200202);
        System.out.println(ld);
        LocalDate ld2 = localDateFactory.fromInt(20200202);
        System.out.println(ld == ld2);
    }
}

interface LocalDateFactory {
    LocalDate fromInt(int yyyyMMdd);

    static LocalDateFactory getFactory() {
        return impl;
    }

    static LocalDateFactory impl = new LocalDateFactoryImpl();
}

class LocalDateFactoryImpl implements LocalDateFactory {

    private static Map<Integer, LocalDate> cache = new HashMap<>();

    public LocalDate fromInt(int yyyyMMdd) {
        if (yyyyMMdd >= 20200101 && yyyyMMdd <= 20301231) {
            LocalDate result = cache.get(yyyyMMdd);
            if (result == null) {
                result = create(yyyyMMdd);
                cache.put(yyyyMMdd, result);
            }
            return result;
        }
        return create(yyyyMMdd);
    }

    private static LocalDate create(int yyyyMMdd) {
        return LocalDate.of(yyyyMMdd / 10000, yyyyMMdd / 100 % 100, yyyyMMdd % 100);
    }
}
