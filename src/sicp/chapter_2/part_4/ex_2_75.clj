(ns sicp.chapter-2.part-4.ex-2-75)

; Exercise 2.75
;
; Implement the constructor make-from-mag-ang in message-passing style.
; This procedure should be analogous to the make-from-real-imag procedure given above.

(defn make-from-mag-ang [r a]
  (fn [op]
    (cond
      (= op :real-part) (* r (Math/cos a))
      (= op :imag-part) (* r (Math/sin a))
      (= op :magnitude) r
      (= op :angle) a
      :else (throw (Exception. (str "Unknown op: MAKE-FROM-REAL-IMAG " op))))))
