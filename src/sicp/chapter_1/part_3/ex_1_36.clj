(ns sicp.chapter-1.part-3.ex-1-36
  (:require [sicp.misc :as m]))

; Exercise 1.36
; Modify fixed-point so that it prints the sequence of approximations it generates,
; using the newline and display primitives shown in Exercise 1.22.
; Then find a solution to x^x=1000 by finding a fixed point of x->log(1000)/log(x).
;
; (Use Scheme’s primitive log procedure, which computes natural logarithms.)
; Compare the number of steps this takes with and without average damping.
; (Note that you cannot start fixed-point with a guess of 1, as this would cause division by log(1)=0)

(defn fixed-point-print
  [f first-guess tolerance print?]
  (letfn [(try-fn [guess]
            (let [next (f guess)]
              (if
                (m/close-enough? guess next tolerance)
                next
                (do
                  (when print? (println next))
                  (recur next)))))]
    (try-fn first-guess)))
