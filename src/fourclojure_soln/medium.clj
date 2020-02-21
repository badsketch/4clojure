(ns fourclojure-soln.medium)


;; 43 Reverse Interleave

(defn rev-interleave [lst n] (apply map list (partition n lst)))

;; partition groups by values so ((1 2) (3 4) (5 6))
;; important step is that mapping over multiple lists applies the function to the first
;; then second and so on.. of each map and then returns a single list with result of each

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

;; 46 Flipping Out
(defn flip
  "higher order function that reverses parameters of input function"
  [f]
  (fn [& args] (apply f (reverse args)))
)

;; 50 Split By Type
(defn split-type
  "takes seq of different types and groups by type"
  [lst]
  (vals (group-by type lst))
  )
