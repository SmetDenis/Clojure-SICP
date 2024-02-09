(ns sicp.chapter-2.part-2.ex-2-45
  (:require
    [sicp.chapter-2.part-2.book-2-2 :as b22]))

; Exercise 2.45
;
; Right-split and up-split can be expressed as instances of a general splitting operation.
; Define a procedure split with the property that evaluating
;
; (define right-split (split beside below))
; (define up-split (split below beside))
;
; produces procedures right-split and up-split with the same behaviors as the ones already defined.

(defn split
  [primary secondary]
  (fn [painter n]
    (if (= n 0)
      painter
      (let [smaller ((split primary secondary) painter (dec n))
            primary-split (primary painter smaller)
            secondary-split (secondary smaller smaller)]
        (primary primary-split secondary-split)))))

(def right-split (split b22/beside b22/below))
(def up-split (split b22/below b22/beside))
