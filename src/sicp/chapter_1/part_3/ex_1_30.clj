(ns sicp.chapter-1.part-3.ex-1-30)

; Exercise 1.30
; The sum procedure above generates a linear recursion.
; The procedure can be rewritten so that the sum is performed iteratively.
; Show how to do this by filling in the missing expressions in the following definition:

; Racket
; (define (sum term a next b)
;         (define (iter a result)
;                 (if ⟨??⟩
;                   ⟨??⟩
;                   (iter ⟨??⟩ ⟨??⟩)))
;         (iter ⟨??⟩ ⟨??⟩))

; Clojure
; (defn sum [term a next b]
;   (letfn [(iter [a result]
;             (if ⟨??⟩
;               ⟨??⟩
;               (iter ⟨??⟩ ⟨??⟩)))]
;     (iter ⟨??⟩ ⟨??⟩)))

(defn sum-2
  [term a next-fn b]
  (letfn [(iter [a result]
            (if (> a b)
              result
              (iter (next-fn a) (+ (term a) result))))]
    (iter a 0)))
