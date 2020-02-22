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

;; #46
(deftest flip-test
  (testing "Flipped Out"
    (is (= 3 ((flip nth) 2 [1 2 3 4 5])))
    (is (= true ((flip >) 7 8)))
    (is (= 4 ((flip quot) 2 8)))
    (is (= [1 2 3] ((flip take) [1 2 3 4 5] 3)))
    )
  )

;; #50
(deftest split-type-test
  (testing "Split By Type"
    (is (= (set (split-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]}))
    (is (= (set (split-type [:a "foo"  "bar" :b])) #{[:a :b] ["foo" "bar"]}))
    (is (= (set (split-type [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]}))
    )
  )

;; #55
(deftest count-occ-test 
  (testing "Count Occurrence"
    (is (= (count-occ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1}))
    (is (= (count-occ [:b :a :b :a :b]) {:a 2, :b 3}))
    (is (= (count-occ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2}))
    )
  )

;; #56
(deftest my-distinct-test
  (testing "Find Distinct Items"
    (is (= (my-distinct [1 2 1 3 1 2 4]) [1 2 3 4]))
    (is (= (my-distinct [:a :a :b :b :c :c]) [:a :b :c]))
    (is (= (my-distinct '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3])))
    (is (= (my-distinct (range 50)) (range 50)))
    )
  )