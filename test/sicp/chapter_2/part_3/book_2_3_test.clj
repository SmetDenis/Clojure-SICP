(ns sicp.chapter-2.part-3.book-2-3-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.book-2-3 :refer [adjoin-set
                                            adjoin-set-h
                                            deriv
                                            element-of-set-sorted?
                                            element-of-set-tree?
                                            element-of-set?
                                            entry
                                            huffman-tree
                                            huffman-tree-as-list
                                            intersection-set
                                            intersection-set-sorted
                                            leaf?
                                            left-branch
                                            left-branch-h
                                            lookup
                                            make-code-tree
                                            make-leaf
                                            make-leaf-set
                                            make-tree
                                            memq
                                            right-branch
                                            right-branch-h
                                            symbol-leaf
                                            symbols
                                            weight
                                            weight-leaf]]))

(comment "2.3 Symbolic data ----------------------------------------------------------------------")

(comment "2.3.1 Quotation ------------------------------------------------------------------------")

(deftest memq-test
  (is (= false (memq 'apple '(pear banana prune))))
  (is (= '(pear banana prune) (memq 'pear '(pear banana prune))))
  (is (= '(apple pear) (memq 'apple '(x (apple sauce) y apple pear)))))

(comment "2.3.2 Example: symbolic differentiation ------------------------------------------------")

(deftest deriv-test
  (is (= 1 (deriv '(+ x 3) 'x)))
  (is (= 'y (deriv '(* x y) 'x)))
  (is (= '(+ (* x y) (* y (+ x 3)))
         (deriv '(* (* x y) (+ x 3)) 'x))))

(comment "2.3.3 Example: representing sets -------------------------------------------------------")

(deftest element-of-set?-test
  (is (= true (element-of-set? 1 '(1 2 3))))
  (is (= true (element-of-set? 1 '[1 2 3])))
  (is (= true (element-of-set? :a '(:a :b))))
  (is (= true (element-of-set? :a '[:a :b])))
  (is (= true (element-of-set? :b '[:a :b :c :d])))
  (is (= true (element-of-set? :c '[:a :b :c :d])))
  (is (= false (element-of-set? 1 '(2 3))))
  (is (= false (element-of-set? 1 '())))
  (is (= false (element-of-set? nil '()))))

(deftest adjoin-set-test
  (is (= '(4) (adjoin-set 4 '())))
  (is (= '(4 1 2 3) (adjoin-set 4 '(1 2 3))))
  (is (= '(1 2 3) (adjoin-set 1 '(1 2 3)))))

(deftest intersection-set-test
  (is (= '() (intersection-set '(1 2) '(3 4))))
  (is (= '(3 4) (intersection-set '(3 4 5) '(3 4))))
  (is (= '(4) (intersection-set '(4) '(3 4))))
  (is (= '(15 16 17 18 19) (intersection-set (range 20) (range 15 25)))))

(deftest element-of-set-optimized?-test
  (is (= true (element-of-set-sorted? 1 '(1 2 3))))
  (is (= false (element-of-set-sorted? 1 '(2 3))))
  (is (= true (element-of-set-sorted? :a '(:a :b))))
  (is (= true (element-of-set-sorted? :a '[:a :b])))
  (is (= false (element-of-set-sorted? 1 '())))
  (is (= false (element-of-set-sorted? nil '())))
  (is (= true (element-of-set-sorted? 100 (range 10000000))))) ; faster than element-of-set?

(deftest intersection-set-sorted-test
  (is (= '() (intersection-set-sorted '(1 2) '(3 4))))
  (is (= '(3 4) (intersection-set-sorted '(3 4 5) '(3 4))))
  (is (= '(4) (intersection-set-sorted '(4) '(3 4))))
  (is (= '(15 16 17 18 19) (intersection-set-sorted (range 20) (range 15 25)))))

(deftest make-tree-test
  (is (= '(1 () ()) (make-tree 1 '() '())))
  (is (= '(1 (1 2 3) (4 5 6)) (make-tree 1 '(1 2 3) '(4 5 6)))))

(deftest right-branch-test
  (is (= '(3) (right-branch (make-tree 1 '(2) '(3)))))
  (is (= '() (right-branch '(2)))))

(deftest left-branch-test
  (is (= '(2) (left-branch (make-tree 1 '(2) '(3)))))
  (is (= '() (left-branch '(2)))))

(deftest entry-test
  (is (= 1 (entry (make-tree 1 '(2) '(3))))))

(deftest element-of-set-tree?-test
  (is (= true (element-of-set-tree? 2 (make-tree 2 '(1) '(3)))))
  (is (= true (element-of-set-tree? 2 (make-tree 2 '(1) '(3)))))
  (is (= true (element-of-set-tree? 3 (make-tree 2 '(1) '(3)))))
  (is (= false (element-of-set-tree? 0 (make-tree 2 '(1) '(3)))))
  (is (= false (element-of-set-tree? 4 (make-tree 2 '(1) '(3))))))

(deftest lookup-test
  (let [records [{:key 1 :value "A"}
                 {:key 2 :value "B"}
                 {:key 3 :value "C"}]]
    (is (= '{:key 1 :value "A"} (lookup 1 records)))
    (is (= '{:key 2 :value "B"} (lookup 2 records)))
    (is (= '{:key 3 :value "C"} (lookup 3 records)))
    (is (= false (lookup 4 records)))))

(comment "2.3.4 Example: Huffman Encoding Trees --------------------------------------------------")

(def sample-tree
  (make-code-tree
    (make-leaf :A 4)
    (make-code-tree
      (make-leaf :B 2)
      (make-code-tree
        (make-leaf :D 1)
        (make-leaf :C 1)))))

(deftest make-leaf-test
  (is (= '(:leaf :a 8) (make-leaf :a 8))))

(deftest leaf?-test
  (is (= true (leaf? (make-leaf :a 8))))
  (is (= false (leaf? :a)))
  (is (= false (leaf? '())))
  (is (= false (leaf? '(:node (:leaf :a 8) (:leaf :b 3))))))

(deftest symbol-leaf-test
  (is (= :a (symbol-leaf (make-leaf :a 8))))
  (is (= :b (symbol-leaf (make-leaf :b 4)))))

(deftest weight-leaf-test
  (is (= 8 (weight-leaf (make-leaf :a 8))))
  (is (= 4 (weight-leaf (make-leaf :b 4)))))

(deftest left-branch-h-test
  (is (= '(:leaf :a 8)
         (left-branch-h (make-tree (make-leaf :a 8) '() '())))))

(deftest right-branch-h-test
  (is (= '((:leaf :b 4))
         (right-branch-h (make-tree (make-leaf :a 8) (list (make-leaf :b 4)) '())))))

(deftest symbols-test
  (is (= '(:a) (symbols (make-leaf :a 8))))
  (is (= '(:A :B :D :C) (symbols sample-tree))))

(deftest weight-test
  (is (= 9 (weight (make-leaf :a 9))))
  (is (= 8 (weight sample-tree))))

(deftest adjoin-set-h-test
  (is (= '((:leaf :a 8))
         (adjoin-set-h (make-leaf :a 8) '())))
  (is (= '((:leaf :b 4) (:leaf :a 8))
         (adjoin-set-h (make-leaf :b 4) (list (make-leaf :a 8)))))
  (is (= '((:leaf :b 4) (:leaf :b 4) (:leaf :a 8))
         (adjoin-set-h (make-leaf :b 4) (list (make-leaf :b 4) (make-leaf :a 8))))))

(deftest make-leaf-set-test
  (is (= '([:leaf :D 1]
           [:leaf :C 1]
           [:leaf :B 2]
           [:leaf :A 4])
         (make-leaf-set '((:A 4) (:B 2) (:C 1) (:D 1))))))

(deftest huffman-examples-tests
  (is (= huffman-tree-as-list huffman-tree)))
