(ns fourclojure-soln.easy-test
  (:require [clojure.test :refer :all]
            [fourclojure-soln.easy :refer :all]))

;; #19 
(deftest lastelm-test
  (testing "Last Element"
    (is (= (lastelm [1 2 3 4 5]) 5))
    (is (= (lastelm '(5 4 3)) 3))
    (is (= (lastelm ["b" "c" "d"] )"d"))
    ))

;; #20
(deftest penultimate-test
  (testing "Penultimate Element"
    (is (= (penultimate (list 1 2 3 4 5)) 4))
    (is (= (penultimate ["a" "b" "c"]) "b"))
    (is (= (penultimate [[1 2] [3 4]]) [1 2]))
    ))

;; #21
(deftest nth-elm-test
  (testing "Nth Element"
    (is (= (nth-elm '(4 5 6 7) 2) 6))
    (is (= (nth-elm [:a :b :c] 0) :a))
    (is (= (nth-elm [1 2 3 4] 1) 2))
    (is (= (nth-elm '([1 2] [3 4] [5 6]) 2) [5 6]))
    ))

;; #22
(deftest my-count-test
  (testing "Count a Sequence"
    (is (= (my-count '(1 2 3 3 1)) 5))
    (is (= (my-count "Hello World") 11))
    (is (= (my-count [[1 2] [3 4] [5 6]]) 3))
    (is (= (my-count '(13)) 1))
    (is (= (my-count '(:a :b :c)) 3))
    ))

;; #23
(deftest my-reverse-test
  (testing "Reverse a Sequence"
    (is (= (my-reverse [1 2 3 4 5]) [5 4 3 2 1]))
    (is (= (my-reverse (sorted-set 5 7 2 7)) '(7 5 2)))
    (is (= (my-reverse [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]]))
    ))

;; #24
(deftest sum-all-test
  (testing "Reverse a Sequence"
    (is (= (sum-all [1 2 3]) 6))
    (is (= (sum-all (list 0 -2 5 5)) 8))
    (is (= (sum-all #{4 2 1}) 7))
    (is (= (sum-all '(0 0 -1)) -1))
    (is (= (sum-all '(1 10 3)) 14))
    ))

;; #25
(deftest find-odd-test
  (testing "Find the odd numbers"
    (is (= (find-odd #{1 2 3 4 5}) '(1 3 5)))
    (is (= (find-odd [4 2 1 6]) '(1)))
    (is (= (find-odd [2 2 4 6]) '()))
    (is (= (find-odd [1 1 1 3]) '(1 1 1 3)))
    ))

;; #26 
(deftest fib-test
  (testing "Fibonacci Sequence"
    (is (= (fiblist 3) '(1 1 2)))
    (is (= (fiblist 6) '(1 1 2 3 5 8)))
    (is (= (fiblist 8) '(1 1 2 3 5 8 13 21)))

))

;; #27
(deftest palindrome-test
  (testing "Palindrome Detector"
    (is (false? (palindrome? '(1 2 3 4 5))))
    (is (true? (palindrome? "racecar")))
    (is (true? (palindrome? [:foo :bar :foo])))
    (is (true? (palindrome? '(1 1 3 3 1 1))))
    (is (false? (palindrome? '(:a :b :c))))
))

;; 29
(deftest getcaps-test
  (testing "Get the Caps"
    (is (= (getcaps "HeLlO, WoRlD!") "HLOWRD"))
    (is (empty? (getcaps "nothing")))
    (is (= (getcaps "$#A(*&987Zf") "AZ"))
))

;; 28
(deftest my-flatten-test
  (testing "Flatten a Sequence"
    (is (= (my-flatten '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6)))
    (is (= (my-flatten ["a" ["b"] "c"]) '("a" "b" "c")))
    (is (= (my-flatten '((((:a))))) '(:a)))
  )
)

;; #30 
(deftest compress-test
  (testing "Compress a Sequence"
    (is (= (apply str (compress "Leeeeeerrroyyy")) "Leroy"))
    (is (= (compress [1 1 2 3 3 3 2 2 3]) '(1 2 3 2 3)))
    (is (= (compress [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2])))
  )
)

;; #31
(deftest packseq-test
  (testing "Pack a Sequence"
    (is (= (packseq [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3))))
    (is (= (packseq [:a :a :b :b :c]) '((:a :a) (:b :b) (:c))))
    (is (= (packseq [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4]))))
    ))
    
;; #32
(deftest dupseq-test
  (testing "Duplicate a Sequence"
    (is (= (dupseq [1 2 3]) '(1 1 2 2 3 3)))
    (is (= (dupseq [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
    (is (= (dupseq [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
    ))

;; #33
(deftest repseq-test
  (testing "Replicate a Sequence"
    (is (= (repseq [1 2 3] 2) '(1 1 2 2 3 3)))
    (is (= (repseq [:a :b] 4) '(:a :a :a :a :b :b :b :b)))
    (is (= (repseq [4 5 6] 1) '(4 5 6)))
    (is (= (repseq [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4])))
    (is (= (repseq [44 33] 2) [44 44 33 33]))
  )
)

;; #34
(deftest my-range-test
  (testing "Implement Range"
    (is (= (my-range 1 4) '(1 2 3)))
    (is (= (my-range -2 2) '(-2 -1 0 1)))
    (is (= (my-range 5 8) '(5 6 7)))
  )
)

;; #38
(deftest my-max-test
  (testing "Maximum Value"
    (is (= (my-max 1 8 3 4) 8))
    (is (= (my-max 30 20) 30))
    (is (= (my-max 45 67 11) 67))
  )
)

;; #39
(deftest my-interleave-test
  (testing "Interleave Two Seqs"
    (is (= (my-interleave [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c)))
    (is (= (my-interleave [1 2] [3 4 5 6]) '(1 3 2 4)))
    (is (= (my-interleave [1 2 3 4] [5]) [1 5]))
    (is (= (my-interleave [30 20] [25 15]) [30 25 20 15]))
  )
)

;; #40
(deftest my-interpose-test
  (testing "Interpose a Seq"
    (is (= (my-interpose 0 [1 2 3]) [1 0 2 0 3]))
    (is (= (apply str (my-interpose ", " ["one" "two" "three"])) "one, two, three"))
    (is (= (my-interpose :z [:a :b :c :d]) [:a :z :b :z :c :z :d]))
  )
)

;; #41
(deftest dropnth-test
  (testing "Drop Every Nth Item"
    (is (= (dropnth [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
    (is (= (dropnth [:a :b :c :d :e :f] 2) [:a :c :e]))
    (is (= (dropnth [1 2 3 4 5 6] 4) [1 2 3 5 6]))
  )
)

;; #42
(deftest fact-test
  (testing "Factorial Fun"
    (is (= (fact 1) 1))
    (is (= (fact 3) 6))
    (is (= (fact 5) 120))
    (is (= (fact 8) 40320))
  )
)

;; #48
(deftest split-seq-test
  (testing "Split a sequence"
    (is (= (split-seq 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]]))    
    (is (= (split-seq 1 [:a :b :c :d]) [[:a] [:b :c :d]]))    
    (is (= (split-seq 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]]))    
  )
)

;; #66
(deftest gcd-test
  (testing "greatest common divisor"
    (is (= (gcd 2 4) 2))
    (is (= (gcd 2 4) 2))
    (is (= (gcd 5 7) 1))
    (is (= (gcd 1023 858) 33))
    )
  )

;; #83
(deftest half-truth-test
  (testing "Half Truths")
   (is (= false (half-truth false false)))
   (is (= true (half-truth true false)))
   (is (= false (half-truth true)))
   (is (= true (half-truth false true false)))
   (is (= false (half-truth true true true)))
   (is (= true (half-truth true true true false)))
  )