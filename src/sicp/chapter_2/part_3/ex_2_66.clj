(ns sicp.chapter-2.part-3.ex-2-66
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.66
;
; Implement the lookup procedure for the case where the set of records is structured as
; a binary tree, ordered by the numerical values of the keys.

(defn lookup-tree
  [given-key set-of-records]
  (if (empty? set-of-records)
    false
    (let [parent (b23/entry set-of-records)]
      (cond
        (nil? parent) false
        (= given-key parent) parent
        :else (lookup-tree given-key
                           (if (< given-key parent)
                             (b23/left-branch set-of-records)
                             (b23/right-branch set-of-records)))))))
