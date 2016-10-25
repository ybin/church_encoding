(defn pred [n]
  (fn [f]
    (fn [x]
      (((n (fn [g] (fn [h] (h (g f)))))
         (fn [u] x))
        (fn [u] u)))))

(defn sub [n] (fn [m] ((m pred) n)))

((sub 1) 2)
((fn [m] ((m pred) 1)) 2)
((2 pred) 1)

(defn g [u] x)
(defn h [u] u)

(((n  (fn [g] (fn [h] (h (g f)))))  g)  h)