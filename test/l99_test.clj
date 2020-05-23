(ns l99-test
  (:require [clojure.test :refer [deftest testing is]]
            [l99 :refer :all]))

(deftest ^{:problem 1} problem-1-test
  (testing "size 1+ list"
    (is (= (my-last '(a b c d)) 'd)))

  (testing "empty list"
    (is (= (my-last '()) nil))))

(deftest ^{:problem 2} problem-2-test
  (testing "size 2+ list"
    (is (= (my-but-last '(a b c d)) 'c)))

  (testing "size 2 list"
    (is (= (my-but-last '(a b)) 'a)))

  (testing "size 1 list"
    (is (= (my-but-last '(b)) nil)))

  (testing "empty list"
    (is (= (my-but-last '()) nil))))


(deftest ^{:problem 3} problem-3-test
  (testing "empty list"
    (is (= (element-at '() 3) nil)))

  (testing "n inside list size"
    (is (= (element-at '(a b c d e) 3) 'c)))

  (testing "n beyond list size"
    (is (= (element-at '(a b) 4) nil)))

  (testing "n exactly list size"
    (is (= (element-at '(a b) 2) 'b))))


(deftest ^{:problem 4} problem-4-test
  (testing "empty list"
    (is (= (count' '()) 0)))

  (testing "size 3 list"
    (is (= (count' '(a b c)) 3)))

  (testing "size 5 list"
    (is (= (count' '(a b c d e)) 5))))


(deftest ^{:problem 5} problem-5-test
  (testing "empty list"
    (is (= (reverse' '()) '())))

  (testing "size 1 list"
    (is (= (reverse' '(a)) '(a))))

  (testing "size 5 list"
    (is (= (reverse' '(a b c d e)) '(e d c b a)))))


(deftest ^{:problem 6} problem-6-test
  (testing "palindrome"
    (is (= (palindrome? '(a b c b a)) true)))

  (testing "not palindrome"
    (is (= (palindrome? "palindrome") false)))

  (testing "empty list"
    (is (= (palindrome? '()) true))))


(deftest ^{:problem 7} problem-7-test
  (testing "empty"
    (is (= (my-flatten '()) '())))

  (testing "list"
    (is (= (my-flatten '(a b c)) '(a b c))))

  (testing "nested"
    (is (= (my-flatten '(a (b (c d) e))) '(a b c d e)))))


(deftest ^{:problem 8} problem-8-test
  (testing "empty"
    (is (= (compress '()) '())))

  (testing "non-repeated vals"
    (is (= (compress '(a b c d e)) '(a b c d e))))

  (testing "repeated vals"
    (is (= (compress '(a a a a b c c a a d e e e e))
          '(a b c a d e)))))


(deftest ^{:problem 9} problem-9-test
  (testing "empty"
    (is (= (pack '()) '())))

  (testing "non-repeated vals"
    (is (= (pack '(a b c d e)) '((a) (b) (c) (d) (e)))))

  (testing "repeated vals"
    (is (= (pack '(a a a a b c c a a d e e e e))
          '((a a a a) (b) (c c) (a a) (d) (e e e e))))))

(deftest ^{:problem 10} problem-10-test
  (testing "empty"
    (is (= (encode '()) '())))

  (testing "non-repeated vals"
    (is (= (encode '(a b c d e)) '((1 a) (1 b) (1 c) (1 d) (1 e)))))

  (testing "repeated vals"
    (is (= (encode '(a a a a b c c a a d e e e e))
          '((4 a) (1 b) (2 c) (2 a) (1 d) (4 e))))))


(deftest ^{:problem 11} problem-11-test
  (testing "empty"
    (is (= (encode-modified '()) '())))

  (testing "non-repeated vals"
    (is (= (encode-modified '(a b c d e)) '(a b c d e))))

  (testing "repeated vals"
    (is (= (encode-modified '(a a a a b c c a a d e e e e))
          '((4 a) b (2 c) (2 a) d (4 e))))))

(deftest ^{:problem 12} problem-12-test
  (testing "empty"
    (is (= (decode-modified '()) '())))

  (testing "non-repeated vals"
    (is (= (decode-modified '(a b c d e)) '(a b c d e))))

  (testing "repeated vals"
    (is (= (decode-modified '((4 a) b (2 c) (2 a) d (4 e)))
          '(a a a a b c c a a d e e e e)))))


(deftest ^{:problem 13} problem-13-test
  (testing "empty"
    (is (= (encode-direct '()) '())))

  (testing "singleton"
    (is (= (encode-direct '(a)) '(a))))

  (testing "non-repeated vals"
    (is (= (encode-direct '(a b c d e)) '(a b c d e))))

  (testing "repeated vals"
    (is (= (encode-direct '(a a a a b c c a a d e e e e))
          '((4 a) b (2 c) (2 a) d (4 e))))))


(deftest ^{:problem 14} problem-14-test
  (testing "empty"
    (is (= (dupli '()) '())))

  (testing "list"
    (is (= (dupli '(a b c c d)) '(a a b b c c c c d d)))))


(deftest ^{:problem 15} problem-15-test
  (testing "empty"
    (is (= (repli '() 4) '())))

  (testing "list"
    (is (= (repli '(a b c) 3) '(a a a b b b c c c))))

  (testing "another list"
    (is (= (repli '(a b d b) 3) '(a a a b b b d d d b b b)))))


(deftest ^{:problem 16} problem-16-test
  (testing "empty"
    (is (= (drop-every '() 2) '())))

  (testing "list"
    (is (= (drop-every '(a b c) 2) '(a c))))

  (testing "another list"
    (is (= (drop-every '(a b c d e f g h i k) 3) '(a b d e g h k)))))


(deftest ^{:problem 17} problem-17-test
  (testing "list"
    (is (= (split' '(a b c) 2) '((a b) (c)))))

  (testing "another list"
    (is (= (split' '(a b c d e f g h i k) 3) '((a b c) (d e f g h i k))))))


(deftest ^{:problem 18} problem-18-test
  (testing "list"
    (is (= (slice '(a b c d e f g h i k) 3 7) '(c d e f g)))))


(deftest ^{:problem 19} problem-19-test
  (testing "rotate positive"
    (is (= (rotate '(a b c d e f g h) 3) '(d e f g h a b c))))

  (testing "rotate negative"
    (is (= (rotate '(a b c d e f g h) -2) '(g h a b c d e f))))

  (testing "rotate zero"
    (is (= (rotate '(a b c) 0) '(a b c))))

  (testing "rotate empty list"
    (is (= (rotate '() 3) '()))))


(deftest ^{:problem 20} remove-at-test
  (testing "empty list"
    (is (= (remove-at '() 2) '())))

  (testing "list"
    (is (= (remove-at '(a b c d) 2) '(a c d)))))

(deftest ^{:problem 21} insert-at-test
  (testing "empty list"
    (is (= (insert-at 'a '() 2) '(a))))

  (testing "list"
    (is (= (insert-at 'alfa '(a b c d) 2) '(a alfa b c d)))))


(deftest ^{:problem 22} range'-at-test
  (testing "zero"
    (is (= (range' 0 0) '(0))))

  (testing "i greater than k"
    (is (= (range' 2 1) '())))

  (testing "i equal to k"
    (is (= (range' 4 4) '(4))))

  (testing "i less than k"
    (is (= (range' 2 7) '(2 3 4 5 6 7)))))


(deftest ^{:problem 23} rnd-select-test
  (testing "n less than coll length"
    (is (= (count (rnd-select '(a b c d e f) 4)) 4)))

  (testing "n is coll length"
    (is (=
          (set (rnd-select '(a b c) 3))
          (set '(a b c)))))

  (testing "n is greater than length"
    (is (=
          (set (rnd-select '(a b c) 4))
          (set '(a b c))))))


(deftest ^{:problem 24} lotto-select-test
  (testing "returns numbers"
    (is (= (count (lotto-select 6 49)) 6)))

  (testing "is random"
    (is (not= (lotto-select 6 49) (lotto-select 6 49)))))


(deftest ^{:problem 25} rnd-permu-test
  (testing "yields permutation"
    (is (=
          (set (rnd-permu '(2 3 4 5 6)))
          (set (rnd-permu '(2 3 4 5 6))))))

  (testing "is random"
    (is (not= (rnd-permu '(2 3 4 5 6)) (rnd-permu '(2 3 4 5 6))))))
