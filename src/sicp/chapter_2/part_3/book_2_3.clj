(ns sicp.chapter-2.part-3.book-2-3)

(comment "2.3")
; Symbolic Data ------------------------------------------------------------------------------------

(comment "2.3.1")
; Quotation ----------------------------------------------------------------------------------------
; Exercises:
; * 2.53
; * 2.54
; * 2.55

(defn memq [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))

(comment "2.3.2")
; Example: Symbolic Differentiation ----------------------------------------------------------------
; Exercises:
; * 2.56
; * 2.57
; * 2.58

(defn =number? [exp num] (and (number? exp) (= exp num)))
(defn variable? [x] (symbol? x))
(defn same-variable? [v1 v2] (and (variable? v1) (variable? v2) (= v1 v2)))

(defn sum? [x] (and (sequential? x) (= (first x) '+)))
(defn addend [s] (second s))
(defn augend [s] (nth s 2))
(defn make-sum [a1 a2]
  (cond
    (= a1 0) a2
    (= a2 0) a1
    (and (number? a1) (number? a2)) (+ a1 a2)
    :else (list '+ a1 a2)))

(defn product? [x] (and (sequential? x) (= (first x) '*)))
(defn multiplier [p] (second p))
(defn multiplicand [p] (nth p 2))
(defn make-product [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn deriv [exp var]
  (cond
    (number? exp) 0
    (variable? exp) (if (same-variable? exp var) 1 0)
    (sum? exp) (make-sum (deriv (addend exp) var)
                         (deriv (augend exp) var))
    (product? exp) (make-sum
                     (make-product
                       (multiplier exp)
                       (deriv (multiplicand exp) var))
                     (make-product
                       (deriv (multiplier exp) var)
                       (multiplicand exp)))
    :else (throw (Exception. (str "unknown expression type: DERIV " exp)))))

(comment "2.3.3")
; Example: Representing Sets -----------------------------------------------------------------------
; Exercises:
; * 2.59
; * 2.60
; * 2.61
; * 2.62
; * 2.63
; * 2.64
; * 2.65
; * 2.66

(defn element-of-set? [x set]
  (cond
    (empty? set) false
    (= x (first set)) true
    :else (element-of-set? x (rest set))))

(defn adjoin-set [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) '()
    (element-of-set? (first set1) set2)
    (cons (first set1) (intersection-set (rest set1) set2))
    :else (intersection-set (rest set1) set2)))

; Sorted list for optimization
(defn element-of-set-sorted? [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :else (element-of-set-sorted? x (rest set))))

(defn intersection-set-sorted [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        :else (let [x1 (first set1) x2 (first set2)]
                (cond (= x1 x2) (cons x1 (intersection-set-sorted (rest set1) (rest set2)))
                      (< x1 x2) (intersection-set-sorted (rest set1) set2)
                      :else (intersection-set-sorted set1 (rest set2))))))

; List as tree
(defn entry [tree] (first tree))
(defn left-branch [tree] (second tree))
(defn right-branch [tree] (nth tree 2))
(defn make-tree [entry left right] (list entry left right))

(defn element-of-set-tree? [x set]
  (cond (empty? set) false
        (= x (entry set)) true
        (< x (entry set)) (element-of-set-tree? x (left-branch set))
        :else (element-of-set-tree? x (right-branch set))))

(defn adjoin-set-tree [x set]
  (cond (empty? set) (make-tree x '() '())
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set)
                                     (adjoin-set-tree x (left-branch set))
                                     (right-branch set))
        :else (make-tree (entry set)
                         (left-branch set)
                         (adjoin-set-tree x (right-branch set)))))
