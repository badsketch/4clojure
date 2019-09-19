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
  (filter odd? elms))