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