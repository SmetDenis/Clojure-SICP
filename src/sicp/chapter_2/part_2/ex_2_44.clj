(ns sicp.chapter-2.part-2.ex-2-44
  (:require [sicp.chapter-2.part-2.book-2-2 :as b22]))

; Exercise 2.44
;
; Define the procedure up-split used by corner-split. It is similar to right-split,
; except that it switches the roles of below and beside.


(defn up-split [painter n]                                  ; Just a potential solution...
  (if (= n 0)
    painter
    (let [down (up-split painter (dec n))
          up   (up-split painter (dec n))]
      (b22/below (b22/beside down down)
                 (b22/beside up up)))))
