(ns sicp.chapter-2.part-3.book-2-3)

(comment "2.3")
; Symbolic Data ------------------------------------------------------------------------------------
; Exercises:
; * 2.53
; * 2.54

(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))
