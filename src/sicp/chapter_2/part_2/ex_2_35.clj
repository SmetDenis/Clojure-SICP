(ns sicp.chapter-2.part-2.ex-2-35
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]
    [sicp.misc :as m]))

; Exercise 2.35
; Redefine count-leaves from 2.2.2 as an accumulation:
;
; (define (count-leaves t)
;   (accumulate ⟨??⟩ ⟨??⟩ (map ⟨??⟩ ⟨??⟩)))

(defn count-leaves
  [tree]
  (b22/accumulate + 0 (map (fn [sub-tree]
                             (if (m/pair? sub-tree)
                               (count-leaves sub-tree)
                               1))
                           tree)))
