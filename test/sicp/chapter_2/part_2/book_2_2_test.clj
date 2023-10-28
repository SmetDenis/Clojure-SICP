(ns sicp.chapter-2.part-2.book-2-2-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.book-2-2 :refer [append length length-recursice list-ref]]))

(deftest list-ref-test
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
  (is (= 5 (length '(1 4 9 16 25))))
  (is (= 50 (length (range 0 100 2)))))

(deftest append-test
  (is (= '() (append nil '())))
  (is (= '() (append '() nil)))
  (is (= '() (append '() '())))
  (is (= '(1) (append '(1) '())))
  (is (= '(2) (append '() '(2))))
  (is (= '(1 2) (append '(1) '(2))))
  (is (= '(1 4 9 16 25) (append '(1 4 9 16 25) '())))
  (is (= '(1 4 9 16 25 3 2 1) (append '(1 4 9 16 25) '(3 2 1)))))
