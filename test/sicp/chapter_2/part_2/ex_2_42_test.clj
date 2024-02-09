(ns sicp.chapter-2.part-2.ex-2-42-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-42 :refer [adjoin-position
                                           attacks?
                                           make-pos
                                           pos-col
                                           pos-row
                                           queens
                                           safe?]]))

(deftest make-pos-test
  (is (= '(1 2) (make-pos 1 2))))

(deftest pos-row-test
  (is (= 1 (pos-row (make-pos 1 2)))))

(deftest pos-col-test
  (is (= 2 (pos-col (make-pos 1 2)))))

(deftest adjoin-position-test
  (is (= '((1 2)) (adjoin-position 1 2 nil)))
  (is (= '((3 4) (1 2)) (adjoin-position 1 2 '((3 4)))))
  (is (= '((3 4) (5 6) (1 2)) (adjoin-position 1 2 '((3 4) (5 6))))))

(deftest attacks?-test
  (is (= true (attacks? '(1 1) '(1 8))))                    ; X
  (is (= true (attacks? '(2 3) '(8 3))))                    ; Y
  (is (= true (attacks? '(3 3) '(5 5))))                    ; Diagonal
  (is (= true (attacks? '(3 5) '(6 8))))                    ; Diagonal
  (is (= true (attacks? '(1 8) '(5 4))))                    ; Diagonal
  (is (= true (attacks? '(7 2) '(4 5))))                    ; Diagonal
  (is (= true (attacks? '(2 7) '(5 4))))                    ; Diagonal

  (is (= false (attacks? '(1 1) '(2 3))))
  (is (= false (attacks? '(4 5) '(6 2))))
  (is (= false (attacks? '(7 1) '(8 3)))))

(deftest safe?-test
  (is (= true (safe? 3 '((5 1) (2 2) (4 3)))))
  (is (= true (safe? 4 '((5 1) (2 2) (4 3) (5 1)))))
  (is (= true (safe? 2 '((5 1) (1 2)))))
  (is (= false (safe? 2 '((1 1) (1 4)))))
  (is (= true (safe? 4 '((2 1) (4 2) (1 3) (3 4)))))
  (is (= false (safe? 5 '((2 1) (4 2) (1 3) (3 4) (1 1))))))

(deftest queens-test
  (is (= '(((1 1))) (queens 1)))
  (is (= '() (queens 2)))
  (is (= '() (queens 3)))
  (is (= '(((2 1) (4 2) (1 3) (3 4))
           ((3 1) (1 2) (4 3) (2 4))) (queens 4)))
  (is (= 10 (count (queens 5))))
  (is (= 04 (count (queens 6))))
  (is (= 40 (count (queens 7))))
  (is (= 92 (count (queens 8)))))
