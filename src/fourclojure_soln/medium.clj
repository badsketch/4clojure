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

;; 54 Partition Sequence
(defn my-partition
  [n xs]
  (cond
    (< (count xs) n) '()
    (= (count xs) n) (list xs)
    :else (cons (take n xs) (my-partition n (drop n xs)))
    )
  )

;; 55 Count Occurrence
(defn count-occ
  "counts number of occurrences of each distinct item in sequence"
  [xs]
  (reduce (fn [m [k v]] (assoc m k (count v))) {} (group-by identity xs))
  )

;; 56 Distinct 
(defn my-distinct
  "removes duplicates and maintains order of original seq"
  [xs]
  (sort-by #(.indexOf xs %) (keys (group-by identity xs)))
  )

;; 58 Function Composition
(defn fcomp
  "composes functions right to left"
  [& fns]
  (fn [& args] (reduce #(%2 %1) (apply (first (reverse fns)) args) (rest (reverse fns))))
  )

;; 59 Juxtaposition
(defn juxtaposition
  [& fns]
  (fn [& args] (map #(apply %1 args) fns))
  )

;; 70
(defn word-sort
  [word-str]
  (sort #(compare (clojure.string/lower-case %) (clojure.string/lower-case %2)) (clojure.string/split word-str #"[,|!|?|.]* [,|!|?|.]*|[,|!|?|.]*$"))
  )

;;ahhhh use /w+ to split by words and try using stabby macro

;; 74 Helper
(defn is-perfect-square?
  [n]
  ((complement empty?) (filter #(= n (* % %)) (range (inc (/ n 2)))))
  )

;; 74
(defn perfect-squares
  [xs]
  (clojure.string/join "," (filter #(is-perfect-square? (Integer. %)) (clojure.string/split xs #",")))
  )
