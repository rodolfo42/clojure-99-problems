(ns l99)

(defn ^{:problem 1
        :level   :easy
        :doc     "Find the last box of a list."}
  my-last
  [coll]
  (last coll))

(defn ^{:problem 2
        :level   :easy
        :doc     "Find the last but one box of a list."}
  my-but-last
  [coll]
  (last (butlast coll)))

(defn ^{:problem 3
        :level   :easy
        :doc     "Find the nth element of a list."}
  element-at
  [coll n]
  (if (> n (count coll))
    nil
    (nth coll (dec n))))

(defn ^{:problem 4
        :level   :easy
        :doc     "Find the number of elements of a list."}
  count'
  [coll]
  (count coll))

(defn ^{:problem 5
        :level   :easy
        :doc     "Reverse a list"}
  reverse'
  [coll]
  (reverse coll))

(defn ^{:problem 6
        :level   :easy
        :doc     "Find out whether a list is a palindrome."}
  palindrome?
  [coll]
  (empty? (drop-while identity (map = coll (reverse coll)))))

(defn ^{:problem 7
        :level   :medium
        :doc     "Flatten a nested list structure."}
  my-flatten
  [coll]
  (flatten coll))

(defn ^{:problem 8
        :level   :medium
        :doc     "Eliminate consecutive duplicates of list elements."}
  compress
  [coll]
  (reduce (fn [r x]
            (if (= x (last r))
              r
              (concat r (list x))))
    '()
    coll))

(defn ^{:problem 9
        :level   :medium
        :doc     "Pack consecutive duplicates of list elements into sublists."}
  pack
  [coll]
  (reduce (fn [r x]
            (if (= x (first (last r)))
              (concat (butlast r) (list (concat (last r) (list x))))
              (concat r (list (list x)))))
    '()
    coll))

(defn ^{:problem 10
        :level   :easy
        :doc     "Run-length encoding of a list."}
  encode
  [coll]
  (reduce (fn [r x]
            (concat r (list (list (count x) (first x)))))
    '()
    (pack coll)))


(defn ^{:problem 11
        :level   :easy
        :doc     "Modified run-length encoding."}
  encode-modified
  [coll]
  (reduce (fn [r x]
            (concat r (list
                        (cond->> (first x)
                          (next x) (list (count x))))))
    '()
    (pack coll)))


(defn ^{:problem 12
        :level   :medium
        :doc     "Decode a run-length encoded list."}
  decode-modified
  [coll]
  (reduce (fn [r x]
            (if (seq? x)
              (concat r (apply repeat x))
              (concat r (list x))))
    '()
    coll))


(defn ^{:problem 13
        :level   :medium
        :doc     "Run-length encoding of a list (direct solution)."}
  encode-direct
  [coll]
  (reverse
    (reduce
      (fn [r x]
        (let [[cnt cur] (cond->> (first r)
                          (not (list? (first r))) (list 1))]
          (if (= x cur)
            (cons (list (inc cnt) cur) (next r))
            (cons x r))))
      '()
      coll)))


(defn ^{:problem 14
        :level   :easy
        :doc     "Duplicate the elements of a list."}
  dupli
  [coll]
  (mapcat #(list % %) coll))


(defn ^{:problem 15
        :level   :medium
        :doc     "Replicate the elements of a list a given number of times."}
  repli
  [coll n]
  (mapcat #(repeat n %) coll))


(defn ^{:problem 16
        :level   :medium
        :doc     "Drop every N'th element from a list."}
  drop-every
  [coll n]
  (keep-indexed
    (fn [i e]
      (when (> (mod (inc i) n) 0) e))
    coll))


(defn ^{:problem 17
        :level   :easy
        :doc     "Split a list into two parts; the length of the first part is given."}
  split'
  [coll n]
  (split-at n coll))


(defn ^{:problem 18
        :level   :medium
        :doc     "Extract a slice from a list."}
  slice
  [coll i k]
  (->> coll
    (drop (dec i))
    (take (- k (dec i)))))


(defn ^{:problem 19
        :level   :medium
        :doc     "Rotate a list N places to the left."}
  rotate
  [coll n]
  (apply concat
    (reverse
      (split' coll (if (neg-int? n)
                     (+ (count coll) n)
                     n)))))


(defn ^{:problem 20
        :level   :easy
        :doc     "Remove the K'th element from a list."}
  remove-at
  [coll n]
  (concat (take (dec n) coll) (drop n coll)))


(defn ^{:problem 21
        :level   :easy
        :doc     "Insert an element at a given position into a list."}
  insert-at
  [el coll n]
  (concat (take (dec n) coll) (cons el (drop (dec n) coll))))


(defn ^{:problem 22
        :level   :easy
        :doc     "Create a list containing all integers within a given range."}
  range'
  [i k]
  (range i (inc k)))

(defn ^{:problem 23
        :level   :medium
        :doc     "Extract a given number of randomly selected elements from a list."}
  rnd-select
  [coll n]
  (loop [ret '()
         sub coll
         i n]
    (if (or (empty? sub) (zero? i))
      ret
      (let [rnd (inc (rand-int (dec (count sub))))]
        (recur
          (conj ret (element-at sub rnd))
          (remove-at sub rnd)
          (dec i))))))


(defn ^{:problem 24
        :level   :easy
        :doc     "Lotto: Draw N different random numbers from the set 1..M"}
  lotto-select
  [n m]
  (rnd-select (range' 1 m) n))

(defn ^{:problem 25
        :level   :easy
        :doc     "Generate a random permutation of the elements of a list."}
  rnd-permu
  [coll]
  (rnd-select coll (count coll)))

