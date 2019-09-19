(ns fourclojure-soln.core-test
  (:require [clojure.test :refer :all]
            [fourclojure-soln.core :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 1 1))))

;; #19 
(deftest lastelm-test
  (testing "Last Element"
    (is (= (lastelm [1 2 3 4 5]) 5))
    (is (= (lastelm '(5 4 3)) 3))
    (is (= (lastelm ["b" "c" "d"] )"d"))
    ))
