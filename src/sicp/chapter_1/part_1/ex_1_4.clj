(ns sicp.chapter-1.part_1.ex-1-4)

; Exercise 1.4
; Observe that our model of evaluation allows for combinations whose operators are compound expressions.
; Use this observation to describe the behavior of the following procedure:

(defn a-plus-abs-b
  [a b]
  ((if (> b 0) + -) a b))
