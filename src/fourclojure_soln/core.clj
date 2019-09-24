(ns fourclojure-soln.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

;; #19 Last Element
(defn lastelm [[frst & rst :as elms]]
  "returns the last element in a sequence"
  (cond 
   	(= (count elms) 0) nil
  	(= (count elms) 1) frst
	  :else (lastelm rst)
))

;; #20 Penultimate Element
(defn penultimate [elms]
  "returns second to last element from sequence"
  (if (= 2 (count elms)) (first elms) (penultimate (rest elms))))

;; #21 Nth Element
(defn nth-elm [elms, n]
  "returns nth element from sequence"
  (if (= 0 n) (first elms) (nth-elm (rest elms) ( - n 1))))

;; #22 Count a Sequence
(defn my-count [elms]
  "returns total number of elements in sequence"
  (if (empty? elms) 0 (+ 1 (my-count (rest elms)))))

;; #23 Reverse a Sequence
(defn my-reverse [elms]
  "returns reverse of sequence"
  (reduce conj () elms))

;; #24 Sum It All Up
(defn sum-all [elms]
  "returns sum of seq of numbers"
  (reduce + 0 elms))

;; #25 Find the odd numbers
(defn find-odd [elms]
  "returns odd numbers in a sequence"
  (filter odd? elms))


;; #26 Fibonacci Sequence

;; Helper
(defn fib [n]
  "returns nth fibonacci number"
  (cond 
    (<= n 2) 1
    :else (+ (fib (- n 1)) (fib (- n 2)))
  )
)
;; Fib Sequence
(defn fiblist [n]
  "returns first n fibonacci numbers"
  (map fib (range 1 (inc n)))
)


;; #27 Palindrome Detector
(defn palindrome? [elms]
  "returns true of given sequence is palindrome"
  (if (or (empty? elms) (= 1 (count elms))) true
    (and (= (first elms)(last elms)) 
      (palindrome? (subvec (vec elms) 1 (- (count elms ) 1))
    )) 
  )
)

;; #28 Flatten a Sequence
(defn my-flatten [[frst & rst :as elms]]
  "removes nested sequences to form one dimensional sequence"
  (cond
    (empty? elms) nil
    (not (coll? frst)) (cons frst (my-flatten rst))
    :else (concat (my-flatten frst) (my-flatten rst))
  )
)

;; #29 Get the Caps
(defn getcaps [string]
  "returns new string containing only capital letters"
  (apply str (filter #(Character/isUpperCase %) string))
  )



;; #31 Pack a Sequence 

;; Helper 
(defn numrep [[frst & others]]
  "return number of consecutive duplicates from the start of a sequence"
  (cond
    (nil? frst) 0
    (empty? others) 1
    (= frst (first others)) (+ 1 (numrep others))
    :else 1
  ))

;; Pack a Sequence
(defn packseq [vec]
  "return sequence with consecutive duplicates into sublists"
  (if (empty? vec) () 
  (concat (list (repeat (numrep vec) (first vec))) (packseq (subvec vec (numrep vec))))
  ))

;; alt solution: (partition-by identity?)


;; #32 Duplicate a Sequence
(defn dupseq [elms]
  "returns sequence with each element duplicated"
  (apply concat (map #(list % %) elms))
  )