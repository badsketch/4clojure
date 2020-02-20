(ns fourclojure-soln.medium-test
    (:require [clojure.test :refer :all]
              [fourclojure-soln.medium :refer :all]))

;; #43
(deftest rev-interleave-test
  (testing "Reverse Interleave"
      (is (= (rev-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
      (is (= (rev-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
      (is (= (rev-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9))))
    )
  )

;; #44
(deftest rotate-test
    (testing "Rotate sequence"
      (is (= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2)))
      (is (= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3)))  
      (is (= (rotate 6 [1 2 3 4 5]) '(2 3 4 5 1)))
      (is (= (rotate 1 '(:a :b :c)) '(:b :c :a)))
      (is (= (rotate -4 '(:a :b :c)) '(:c :a :b)))
    )  
  )