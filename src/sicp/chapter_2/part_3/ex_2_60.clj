(ns sicp.chapter-2.part-3.ex-2-60)

; Exercise 2.60
;
; We specified that a set would be represented as a list with no duplicates.
; Now suppose we allow duplicates. For instance, the set {1,2,3}
; could be represented as the list (2 3 2 1 3 2 2).
;
; Design procedures element-of-set?, adjoin-set, union-set, and intersection-set that
; operate on this representation.
;
; How does the efficiency of each compare with the corresponding procedure for
; the non-duplicate representation? Are there applications for which
; you would use this representation in preference to the non-duplicate one?)

; No change to element-of-set?
(defn element-of-set?
  [x set]
  (cond
    (empty? set) false
    (= x (first set)) true
    :else (element-of-set? x (rest set))))

; No checks for duplicates in adjoin-set. It has complexity O(n)
(defn adjoin-set
  [x set]
  (cons x set))

; No checks for duplicates in intersection-set. No visible reasons
(defn intersection-set
  [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) '()
    (element-of-set? (first set1) set2)
    (cons (first set1) (intersection-set (rest set1) set2))
    :else (intersection-set (rest set1) set2)))

; No checks for duplicates in union-set
; Complexity is O(n) instede of O(n^2)
(defn union-set
  [set1 set2]
  (concat set1 set2))
