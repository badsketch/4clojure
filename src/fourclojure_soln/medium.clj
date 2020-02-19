(ns fourclojure-soln.medium)


;; 44 Rotate Sequence

;; Helpers
(defn rotate-left
    "rotates a sequence left once"
    [seq]
    (concat (rest seq) (list (first seq)))  
)
  
(defn rotate-right
    "rotates a sequence right once"
    [seq]
    (concat (list (last seq)) (butlast seq) )
)

;; Rotate Sequence
(defn rotate
    "rotates a sequence in either direction"
    [dir seq]
    (cond
      (zero? dir) seq
      (neg? dir) (rotate (inc dir) (rotate-right seq))
      :else (rotate (dec dir) (rotate-left seq))
    )
  )
