package cc.ybin.churchencoding;

import cc.ybin.churchencoding.ChurchEncoding;
import cc.ybin.churchencoding.ChurchEncoding.F;
import cc.ybin.churchencoding.ChurchEncoding.Numb;

public class Test {

    public static <T> void test(F<T> f, T x) {
        Numb<T> zero = ChurchEncoding.zero();
        Numb<T> one = ChurchEncoding.add1(zero);
        Numb<T> two = ChurchEncoding.add1(one);
        Numb<T> three = ChurchEncoding.add(one, two);
        Numb<T> six = ChurchEncoding.mul(two, three);

        zero.debug(f, x);
        one.debug(f, x);
        two.debug(f, x);
        three.debug(f, x);
        six.debug(f, x);
    }

    public static void main(String[] args) {
        System.out.println("Church encoding");

        test((x) -> x + 1, 0);
        test((x) -> x + "A", "");
    }
}