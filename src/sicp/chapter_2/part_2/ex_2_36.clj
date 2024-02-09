(ns sicp.chapter-2.part-2.ex-2-36
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.misc :as m]))

; Exercise 2.36
;
; The procedure accumulate-n is similar to accumulate except that it takes as its third argument
; a sequence of sequences, which are all assumed to have the same number of elements.
; It applies the designated accumulation procedure to combine all the first elements
; of the sequences, all the second elements of the sequences, and so on, and returns a sequence
; of the results.
;
; For instance, if s is a sequence containing four sequences, ((1 2 3) (4 5 6) (7 8 9) (10 11 12)),
; then the value of (accumulate-n + 0 s) should be the sequence (22 26 30).
; Fill in the missing expressions in the following definition of accumulate-n:
;
; (define (accumulate-n op init seqs)
;  (if (null? (car seqs))
;      nil
;      (cons (accumulate op init ⟨??⟩)
;            (accumulate-n op init ⟨??⟩))))
;

(defn accumulate-n
  [op init seqs]
  (if (nil? (m/car seqs))
    nil
    (cons (b22/accumulate op init (map m/car seqs))
          (accumulate-n op init (map m/cdr seqs)))))
