(ns sicp.chapter-1.part-3.ex-1-37)

; Exercise 1.37
; 1. An infinite continued fraction is an expression of the form
; f = N1 / (D1 + N2 / (D2 + N3 / (D3 + ...)))

; As an example, one can show that the infinite continued fraction expansion with the Ni and the
; Di all equal to 1 produces 1/φ , where φ is the golden ratio (described in 1.2.2).
;
; One way to approximate an infinite continued fraction is to truncate the expansion after
; a given number of terms. Such a truncation—a so-called finite continued fraction k-term finite
; continued fraction—has the form
; N1 / (D1 + N2 / (... + Nk / Dk))

; Suppose that n and d are procedures of one argument (the term index i) that return the Ni and Di
; of the terms of the continued fraction. Define a procedure cont-frac such that evaluating
; (cont-frac n d k) computes the value of the k-term finite continued fraction.
;
; Check your procedure by approximating 1/φ using for successive values of k.
; (cont-frac (lambda (i) 1.0)
;           (lambda (i) 1.0)
;           k)
;
; How large must you make k in order to get an approximation that is accurate to 4 decimal places?

; 2. If your cont-frac procedure generates a recursive process, write one that generates an
; iterative process. If it generates an iterative process, write one that generates a recursive process.

; 1. Recursive process -------------------
(defn cont-frac
  [func-n func-d k]
  (letfn [(recursive [i]
            (let [n (func-n i)
                  d (func-d i)]
              (if (= i k)
                (/ n d)
                (/ n (+ d (recursive (inc i)))))))]
    (recursive 0)))

; 2. Iterative process -------------------
(defn cont-frac-iter
  [func-n func-d k]
  (letfn [(iterator [i result]
            (let [n (func-n i)
                  d (func-d i)]
              (if (= i 1)
                (/ n (+ d result))
                (iterator (dec i) (/ n (+ d result))))))]
    (iterator k 0)))
