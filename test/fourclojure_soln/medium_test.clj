(ns fourclojure-soln.medium-test
    (:require [clojure.test :refer :all]
              [fourclojure-soln.medium :refer :all]))
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