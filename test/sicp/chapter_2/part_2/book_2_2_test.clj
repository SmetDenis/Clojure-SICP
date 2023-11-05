(ns sicp.chapter-2.part-2.book-2-2-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.book-2-2 :refer
             [append count-leaves length length-recursice length-tree list-ref my-map scale-tree scale-tree-v0]]))

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
