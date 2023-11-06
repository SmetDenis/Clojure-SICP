(ns sicp.chapter-2.part-2.book-2-2-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.book-2-2 :refer [accumulate
                                                    append
                                                    count-leaves
                                                    enumerate-interval
                                                    enumerate-tree
                                                    even-fibs
                                                    even-fibs-v2
                                                    flatmap
                                                    length
                                                    length-recursice
                                                    length-tree
                                                    list-fib-squares
                                                    list-ref
                                                    make-pair-sum
                                                    my-map
                                                    permutations
                                                    prime-sum-pairs
                                                    prime-sum?
                                                    product-of-squares-of-odd-elements
                                                    scale-tree
                                                    scale-tree-v0
                                                    sum-odd-squares
                                                    sum-odd-squares-v2]]))

(deftest list-ref-test
  (is (= nil (list-ref '(1 4 9 16 25) -1)))
  (is (= 1 (list-ref '(1 4 9 16 25) 0)))
  (is (= 4 (list-ref '(1 4 9 16 25) 1)))
  (is (= 9 (list-ref '(1 4 9 16 25) 2)))
  (is (= 16 (list-ref '(1 4 9 16 25) 3)))
  (is (= 25 (list-ref '(1 4 9 16 25) 4)))
  (is (= nil (list-ref '(1 4 9 16 25) 5))))

(deftest length-recursice-test
  (is (= 0 (length-recursice nil)))
  (is (= 0 (length-recursice '())))
  (is (= 1 (length-recursice '(123))))
  (is (= 5 (length-recursice '(1 4 9 16 25))))
  (is (= 100 (length-recursice (range 0 100)))))

(deftest length-test
  (is (= 0 (length nil)))
  (is (= 0 (length '())))
  (is (= 1 (length '(123))))
  (is (= 5 (length '(1 4 9 16 25)))))

(deftest append-test
  (is (= '() (append nil '())))
  (is (= '() (append '() nil)))
  (is (= '() (append '() '())))
  (is (= '(1) (append '(1) '())))
  (is (= '(2) (append '() '(2))))
  (is (= '(1 2) (append '(1) '(2))))
  (is (= '(1 4 9 16 25) (append '(1 4 9 16 25) '())))
  (is (= '(1 4 9 16 25 3 2 1) (append '(1 4 9 16 25) '(3 2 1)))))

(deftest my-map-test
  ; Custom
  (is (= '(10 2.5 11.6 17) (my-map abs (list -10 2.5 -11.6 17))))
  (is (= '(1 4 9 16) (my-map #(* % %) (list 1 2 3 4))))
  ; Clojure built-in
  (is (= '(10 2.5 11.6 17) (map abs (list -10 2.5 -11.6 17))))
  (is (= '(1 4 9 16) (map #(* % %) (list 1 2 3 4)))))

(comment "2.2.2")
; Hierarchical Structures --------------------------------------------------------------------------

(def tree (cons (list 1 2) (list 3 4)))                     ; ((1 2) 3 4)
(def tree-2 (list tree tree))                               ; (((1 2) 3 4) ((1 2) 3 4))

(deftest count-leaves-test
  (is (= 4 (count-leaves tree)))
  (is (= 8 (count-leaves tree-2))))

(deftest length-tree-test
  (is (= 3 (length-tree tree)))
  (is (= 2 (length-tree tree-2))))

(deftest length-2-test
  (is (= 3 (length tree)))
  (is (= 2 (length tree-2))))

(deftest scale-tree-v0-test
  (is (= '(10 (20 (30 40) 50) (60 70)) (scale-tree-v0 '(1 (2 (3 4) 5) (6 7)) 10))))

(deftest scale-tree-test
  (is (= '(10 (20 (30 40) 50) (60 70)) (scale-tree '(1 (2 (3 4) 5) (6 7)) 10))))

(comment "2.2.3")
; Sequences as Conventional Interfaces -------------------------------------------------------------

(deftest sum-odd-squares-test
  (is (= 84 (sum-odd-squares '(1 (2 (3 4) 5) (6 7))))))

(deftest even-fibs-test
  (is (= '(0 2 8 34) (even-fibs 10))))

(deftest my-filter-test
  (is (= '(1 3 5) (filter odd? '(1 2 3 4 5)))))

(deftest accumulate-test
  (is (= 15 (accumulate + 0 '(1 2 3 4 5))))
  (is (= 120 (accumulate * 1 '(1 2 3 4 5))))
  (is (= '(1 2 3 4 5) (accumulate cons nil '(1 2 3 4 5)))))

(deftest enumerate-interval-test
  (is (= '(2 3 4 5 6 7) (enumerate-interval 2 7))))

(deftest enumerate-tree-test
  (is (= '(1 2 3 4 5) (enumerate-tree '(1 (2 (3 4)) 5)))))

(deftest sum-odd-squares-v2-test
  (is (= 84 (sum-odd-squares-v2 '(1 (2 (3 4) 5) (6 7))))))

(deftest even-fibs-v2-test
  (is (= '(0 2 8 34) (even-fibs-v2 10))))

(deftest list-fib-squares-test
  (is (= '(0 1 1 4 9 25 64 169 441 1156 3025) (list-fib-squares 10))))

(deftest product-of-squares-of-odd-elements-test
  (is (= 225 (product-of-squares-of-odd-elements '(1 2 3 4 5)))))

(deftest flatmap-test
  (is (= '(0 1 2 3 4 5) (flatmap (fn [i] (list (dec i))) '(1 2 3 4 5 6)))))

(deftest prime-sum?-test
  (is (= true (prime-sum? '(1 2))))
  (is (= true (prime-sum? '(1 4))))
  (is (= true (prime-sum? '(2 5))))
  (is (= false (prime-sum? '(2 6)))))

(deftest make-pair-sum-test
  (is (= '(1 2 3) (make-pair-sum '(1 2))))
  (is (= '(2 5 7) (make-pair-sum '(2 5)))))

(deftest prime-sum-pairs-test
  (is (= '((2 1 3)
           (3 2 5)
           (4 1 5)
           (4 3 7)
           (5 2 7)
           (6 1 7)
           (6 5 11)) (prime-sum-pairs 6))))

(deftest permutations-test
  (is (= '((1 2 3)
           (1 3 2)
           (2 1 3)
           (2 3 1)
           (3 1 2)
           (3 2 1)) (permutations '(1 2 3)))))
