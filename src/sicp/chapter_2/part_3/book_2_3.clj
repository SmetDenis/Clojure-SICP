(ns sicp.chapter-2.part-3.book-2-3)

(comment "2.3 Symbolic Data ----------------------------------------------------------------------")

(comment "2.3.1 Quotation ------------------------------------------------------------------------")

; Exercises:
; * 2.53
; * 2.54
; * 2.55

(defn memq
  [item x]
  (cond (empty? x) false
        (= item (first x)) x
        :else (memq item (rest x))))

(comment "2.3.2 Example: Symbolic Differentiation ------------------------------------------------")

; Exercises:
; * 2.56
; * 2.57
; * 2.58

(defn =number?
  [exp num]
  (and (number? exp) (= exp num)))

(defn variable?
  [x]
  (symbol? x))

(defn same-variable?
  [v1 v2]
  (and (variable? v1) (variable? v2) (= v1 v2)))

(defn sum?
  [x]
  (and (sequential? x) (= (first x) '+)))

(defn addend
  [s]
  (second s))

(defn augend
  [s]
  (nth s 2))

(defn make-sum
  [a1 a2]
  (cond
    (= a1 0) a2
    (= a2 0) a1
    (and (number? a1) (number? a2)) (+ a1 a2)
    :else (list '+ a1 a2)))

(defn product?
  [x]
  (and (sequential? x) (= (first x) '*)))

(defn multiplier
  [p]
  (second p))

(defn multiplicand
  [p]
  (nth p 2))

(defn make-product
  [m1 m2]
  (cond (or (=number? m1 0) (=number? m2 0)) 0
        (=number? m1 1) m2
        (=number? m2 1) m1
        (and (number? m1) (number? m2)) (* m1 m2)
        :else (list '* m1 m2)))

(defn deriv
  [exp var]
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

(comment "2.3.3 Example: Representing Sets -------------------------------------------------------")

; Exercises:
; * 2.59
; * 2.60
; * 2.61
; * 2.62
; * 2.63
; * 2.64
; * 2.65
; * 2.66

(defn element-of-set?
  [x set]
  (cond
    (empty? set) false
    (= x (first set)) true
    :else (element-of-set? x (rest set))))

(defn adjoin-set
  [x set]
  (if (element-of-set? x set)
    set
    (cons x set)))

(defn intersection-set
  [set1 set2]
  (cond
    (or (empty? set1) (empty? set2)) '()
    (element-of-set? (first set1) set2)
    (cons (first set1) (intersection-set (rest set1) set2))
    :else (intersection-set (rest set1) set2)))

; Sorted list for optimization
(defn element-of-set-sorted?
  [x set]
  (cond (empty? set) false
        (= x (first set)) true
        (< x (first set)) false
        :else (element-of-set-sorted? x (rest set))))

(defn intersection-set-sorted
  [set1 set2]
  (cond (or (empty? set1) (empty? set2)) '()
        :else (let [x1 (first set1) x2 (first set2)]
                (cond (= x1 x2) (cons x1 (intersection-set-sorted (rest set1) (rest set2)))
                      (< x1 x2) (intersection-set-sorted (rest set1) set2)
                      :else (intersection-set-sorted set1 (rest set2))))))

; List as tree
(defn entry
  [tree]
  (first tree))

(defn left-branch
  [tree]
  (if (< 1 (count tree))
    (nth tree 1)
    '()))

(defn right-branch
  [tree]
  (if (< 2 (count tree))
    (nth tree 2)
    '()))

(defn make-tree
  [entry left right]
  (list entry left right))

(defn element-of-set-tree?
  [x set]
  (cond (empty? set) false
        (= x (entry set)) true
        (< x (entry set)) (element-of-set-tree? x (left-branch set))
        :else (element-of-set-tree? x (right-branch set))))

(defn adjoin-set-tree
  [x set]
  (cond (empty? set) (make-tree x '() '())
        (= x (entry set)) set
        (< x (entry set)) (make-tree (entry set)
                                     (adjoin-set-tree x (left-branch set))
                                     (right-branch set))
        :else (make-tree (entry set)
                         (left-branch set)
                         (adjoin-set-tree x (right-branch set)))))

(defn lookup
  [given-key set-of-records]
  (cond
    (empty? set-of-records) false
    (= given-key (:key (first set-of-records))) (first set-of-records)
    :else (lookup given-key (rest set-of-records))))

(comment "2.3.4 Example: Huffman Encoding Trees --------------------------------------------------")

; Exercises:
; * 2.67
; * 2.68
; * 2.69
; * 2.70
; * 2.71
; * 2.72

(defn make-leaf
  [symbol weight]
  [:leaf symbol weight])

(defn leaf?
  [object]
  (and (or (list? object) (vector? object))
       (= (first object) :leaf)))

(defn symbol-leaf
  [x]
  (second x))

(defn weight-leaf
  [x]
  (nth x 2))

(defn left-branch-h
  [tree]
  (first tree))

(defn right-branch-h
  [tree]
  (second tree))

(defn symbols
  [tree]
  (if (leaf? tree)
    (list (symbol-leaf tree))
    (nth tree 2)))

(defn weight
  [tree]
  (if (leaf? tree)
    (weight-leaf tree)
    (nth tree 3)))

(defn make-code-tree
  [left right]
  [left
   right
   (concat (symbols left) (symbols right))
   (+ (weight left) (weight right))])

(defn choose-branch
  [bit branch]
  (cond
    (= bit 0) (left-branch-h branch)
    (= bit 1) (right-branch-h branch)
    :else (throw (Exception. (str "bad bit: CHOOSE-BRANCH " bit)))))

(defn decode
  [bits tree]
  (letfn [(decode-1
            [bits current-branch]
            (if (empty? bits)
              '()
              (let [next-branch (choose-branch (first bits) current-branch)]
                (if (leaf? next-branch)
                  (cons (symbol-leaf next-branch)
                        (decode-1 (rest bits) tree))
                  (decode-1 (rest bits) next-branch)))))]
    (decode-1 bits tree)))

(defn adjoin-set-h
  [x set]
  (cond
    (empty? set) (list x)
    (< (weight x) (weight (first set))) (cons x set)
    :else (cons (first set)
                (adjoin-set-h x (rest set)))))

(defn make-leaf-set
  [pairs]
  (if (empty? pairs)
    '()
    (let [pair (first pairs)]
      (adjoin-set-h
        (make-leaf (first pair)                             ; symbol
                   (second pair))                           ; frequency
        (make-leaf-set (rest pairs))))))

; Samples
(def huffman-pairs '((:A 4) (:B 2) (:C 1) (:D 1)))

(def huffman-tree
  (make-code-tree
    (make-leaf :A 4)
    (make-code-tree
      (make-leaf :B 2)
      (make-code-tree
        (make-leaf :D 1)
        (make-leaf :C 1)))))

(def huffman-tree-as-list
  '[[:leaf :A 4]
    [[:leaf :B 2]
     [[:leaf :D 1]
      [:leaf :C 1]
      (:D :C) 2]
     (:B :D :C) 4]
    (:A :B :D :C) 8])

(def huffman-message-decoded
  '(0                                                      ; A
    1 1 0                                                  ; D
    0                                                      ; A
    1 0                                                    ; B
    1 0                                                    ; B
    1 1 1                                                  ; C
    0))                                                    ; A
(def huffman-message-encoded '(:A :D :A :B :B :C :A))

(def huffman-A '(0))
(def huffman-B '(1 0))
(def huffman-C '(1 1 1))
(def huffman-D '(1 1 0))
