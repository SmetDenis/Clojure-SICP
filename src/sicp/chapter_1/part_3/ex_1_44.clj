(ns sicp.chapter-1.part-3.ex-1-44
  (:require [sicp.chapter-1.part-3.ex-1-43 :as ex-1-43]))

; Exercise 1.44
; The idea of smoothing a function is an important concept in signal processing.
; If f is a function and dx is some small number, then the smoothed version of f is the function
; whose value at a point x is the average of f(x−dx), f(x), and f(x+dx).
;
; Write a procedure smooth that takes as input a procedure that computes f and returns
; a procedure that computes the smoothed f.
;
; It is sometimes valuable to repeatedly smooth a function
; (that is, smooth the smoothed function, and so on) to obtain the n-fold smoothed function.
;
; Show how to generate the n-fold smoothed function of any given function
; using smooth and repeated from Exercise 1.43.

(defn smooth [func]
  (let [dx 0.001]
    (fn [x] (/ (+ (func (- x dx))
                  (func x)
                  (func (+ x dx)))
               3))))

(defn n-fold [func times]
  ((ex-1-43/repeated smooth times) func))
