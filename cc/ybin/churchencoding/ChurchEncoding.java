package cc.ybin.churchencoding;

public class ChurchEncoding {

    @FunctionalInterface
    public interface F<T> {
        public T apply(T x);
    }

    @FunctionalInterface
    public interface Numb<T> {
        public T apply(F<T> f, T x);

        default public void debug(F<T> f, T x) {
            System.out.println(apply(f, x));
        }
    }

    // encoding
    public static <T> Numb<T> zero() {
        /*
        return new Numb<T>() {
            public T apply(F<T> f, T x) {
                return x;
            }
        };
        */
        return (f, x) -> x;
    }

    public static <T> Numb<T> add1(Numb<T> n) {
        /*
        return new Numb<T>() {
            public T apply(F<T> f, T x) {
                return f.apply(n.apply(f, x));
            }
        };
        */
        return (f, x) -> f.apply(n.apply(f, x));
    }

    // si ze yun suan
    public static <T> Numb<T> add(Numb<T> m, Numb<T> n) {
        /*
        return new Numb<T>() {
            public T apply(F<T> f, T x) {
                return m.apply(f, n.apply(f, x));
            }
        };
        */
        return (f, x) -> m.apply(f, n.apply(f, x));
    }

    public static <T> Numb<T> mul(Numb<T> m, Numb<T> n) {
        /*
        return new Numb<T>() {
            public T apply(F<T> f, T x) {
                F<T> fn = new F<T>() {
                    public T apply(T x) {
                        return n.apply(f, x);
                    }
                };
                return m.apply(fn, x);
            }
        };
        */
        return (F<T> f, T x) -> m.apply(
                        (T xx) -> n.apply(f, xx), x);
    }
}