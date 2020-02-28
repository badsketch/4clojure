(ns fourclojure-soln.easy)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; #19 Last Element
(defn lastelm 
  "returns the last element in a sequence"
  [[frst & rst :as elms]]
  (cond 
   	(= (count elms) 0) nil
  	(= (count elms) 1) frst
	  :else (lastelm rst)
))

;; #20 Penultimate Element
(defn penultimate 
  "returns second to last element from sequence"
  [elms]
  (if (= 2 (count elms)) (first elms) (penultimate (rest elms))))

;; #21 Nth Element
(defn nth-elm 
  "returns nth element from sequence"
  [elms, n]
  (if (= 0 n) (first elms) (nth-elm (rest elms) ( - n 1))))

;; #22 Count a Sequence
(defn my-count 
  "returns total number of elements in sequence"
  [elms]
  (if (empty? elms) 0 (+ 1 (my-count (rest elms)))))

;; #23 Reverse a Sequence
(defn my-reverse 
  "returns reverse of sequence"
  [elms]
  (reduce conj () elms))

;; #24 Sum It All Up
(defn sum-all 
  "returns sum of seq of numbers"
  [elms]
  (reduce + 0 elms))

;; #25 Find the odd numbers
(defn find-odd 
  "returns odd numbers in a sequence"
  [elms]
  (filter odd? elms))


;; #26 Fibonacci Sequence

;; Helper
(defn fib 
  "returns nth fibonacci number"
  [n]
  (cond 
    (<= n 2) 1
    :else (+ (fib (- n 1)) (fib (- n 2)))
  )
)
;; Fib Sequence
(defn fiblist 
  "returns first n fibonacci numbers"
  [n]
  (map fib (range 1 (inc n)))
)


;; #27 Palindrome Detector
(defn palindrome? 
  "returns true of given sequence is palindrome"
  [elms]
  (if (or (empty? elms) (= 1 (count elms))) true
    (and (= (first elms)(last elms)) 
      (palindrome? (subvec (vec elms) 1 (- (count elms ) 1))
    )) 
  )
)

;; #28 Flatten a Sequence
(defn my-flatten 
  "removes nested sequences to form one dimensional sequence"
  [[frst & rst :as elms]]
  (cond
    (empty? elms) nil
    (not (coll? frst)) (cons frst (my-flatten rst))
    :else (concat (my-flatten frst) (my-flatten rst))
  )
)

;; #29 Get the Caps
(defn getcaps 
  "returns new string containing only capital letters"
  [string]
  (apply str (filter #(Character/isUpperCase %) string))
  )

;; #30 Compress a Sequence
(defn compress 
  "removes consecutive duplicates from sequence"
  [elms]
  (cond 
    (or (empty? elms)(= 1 (count elms))) elms
    (= (first elms)(first (rest elms)))  (compress (rest elms))
    :else (concat (list (first elms)) (compress (rest elms)))
))

	

;; #31 Pack a Sequence 

;; Helper 
(defn numrep 
  "return number of consecutive duplicates from the start of a sequence"
  [[frst & others]]
  (cond
    (nil? frst) 0
    (empty? others) 1
    (= frst (first others)) (+ 1 (numrep others))
    :else 1
  ))

;; Pack a Sequence
(defn packseq 
  "return sequence with consecutive duplicates into sublists"
  [vec]
  (if (empty? vec) () 
  (concat (list (repeat (numrep vec) (first vec))) (packseq (subvec vec (numrep vec))))
  ))

;; alt solution: (partition-by identity?)


;; #32 Duplicate a Sequence
(defn dupseq 
  "returns sequence with each element duplicated"
  [elms]
  (apply concat (map #(list % %) elms))
  )

;; #33 Replicate a Sequence
(defn repseq 
  "returns sequence with each element repeated n times"
  [elms, n]
  (apply concat (map #(repeat n %) elms))
)

;; #34 Implement Range
(defn my-range 
  "creates list of all integers in given range"
  [start end]
  (if (> start (dec end)) () (cons start (my-range (inc start) end)))
)

;; #38 Maximum Value
(defn my-max 
  "takes variable number of parameters and returns maximum value"
  [& nums]
  (reduce #(if (< %1 %2) %2 %1) nums)
)

;; #39 Interleave Two Sequences
(defn my-interleave
  "takes two sequences and returns first item from each, second from each, etc."
  [seq1 seq2]
  (cond
    (or (empty? seq1) (empty? seq2)) []
    (or (= (count seq1) 1)(= (count seq2) 1)) [(first seq1) (first seq2)]
    :else (concat [(first seq1) (first seq2)] (my-interleave (rest seq1) (rest seq2)))
  )
)

;; alt solution: (mapcat list l1 l2)

;; #40 Interpose Two Sequences
(defn my-interpose
  "separates the items of a sequence by an arbitrary value"
  [val elms]
  (butlast (interleave elms (repeat (count elms) val)))
)

;; #41 Drop Every Nth Item
(defn dropnth
  "drops every nth item from a sequence"
  [elms n]
  (flatten (concat (map #(if (= (count %) n) (butlast %) %) (partition-all n elms))))
)

;; #42 Factorial Fun
(defn fact
  "calculates nth factorial"
  [n]
  (if (zero? n) 1 (* n (fact (dec n))))
)

;; #48 Split a sequence
(defn split-seq
  "splits a sequence into two parts"
  [idx lst]
  (list (take idx lst) (drop idx lst))
)

;; 66
(defn gcd
  "calculates greatest common divisor"
  [x y]
  (if (zero? y) x (gcd y (mod x y)))
  )

;; 83
(defn half-truth
  "takes variable number of booleans and returns true of some are true, but not all true, otherwise false"
  [& bools]
  (cond
    (every? true? bools) false
    (some true? bools) true
    :else false
    )
  )