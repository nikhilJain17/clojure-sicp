(ns chapter1.core
  (:gen-class))

;; In the REPL, run (load-file "src/chapter1/core.clj")

; Exercise 1.3: Define a procedure that takes three numbers
; as arguments and returns the sum of the squares of the two
; larger numbers.
(defn exercise3 [a b c]
  (let [square (fn [x] (* x x))]
    (- (+ (square a) (square b) (square c)) (square (min a b c )))  
  )
)

; Square Root
(defn sqrt [x]
  ; Is our guess for sqrt good enough?
  (defn good-enough? [guess x]
    (defn abs [x] 
      (if (< x 0) (- x) x
      )
    )
    (defn square [x]
      (* x x)
    )
    (< (abs (- (square guess) x)) 0.001)
  )

  ; Improve our guess
  (defn improve [guess x]
    (defn average [x y] (/ (+ x y) 2))
    (average guess (/ x guess)) 
  )

  ; Iteratively compute sqrt
  (defn sqrt-iter [guess x]
    (if (good-enough? guess x)
      guess
      (sqrt-iter (improve guess x) x)
    )
  )

  (sqrt-iter 1.0 x)
)



(defn factorial [x]
  (defn factorial-iter [product counter max-count]
    (if (= counter max-count) 
      product 
      (factorial-iter (* product (+ 1 counter)) (+ 1 counter) max-count)
    )
  )
  (factorial-iter 1 1 x)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "hello world")
  (println (exercise3 10 3 -2))
  (println (sqrt 9))
  (println (factorial 6))
)

