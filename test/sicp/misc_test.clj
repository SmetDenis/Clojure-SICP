(ns sicp.misc-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.misc :as m]))

(comment "Chapter #1")
; The Elements of Programming ----------------------------------------------------------------------

(deftest error-test
  (try
    (m/error "123")
    (catch Exception e
      (is (= (.getMessage e) "123")))))

(deftest square-test
  (is (= 4 (m/square 2)))
  (is (= 9 (m/square 3))))

(deftest cube-test
  (is (= 8 (m/cube 2)))
  (is (= 27 (m/cube 3)))
  (is (= 64 (m/cube 4)))
  (is (= 125 (m/cube 5))))

(deftest divides?-test
  (is (= true (m/divides? 2 4)))
  (is (= true (m/divides? 2 8)))
  (is (= false (m/divides? 2 9))))

(deftest find-divisor-test
  (is (= 2 (m/find-divisor 2 8)))
  (is (= 2 (m/find-divisor 2 16)))
  (is (= 1 (m/find-divisor 1 16)))
  (is (= 4 (m/find-divisor 4 16)))
  (is (= 4 (m/find-divisor 4 20))))

(deftest smallest-divisor-test
  (is (= 2 (m/smallest-divisor 6)))
  (is (= 7 (m/smallest-divisor 7)))
  (is (= 3 (m/smallest-divisor 21))))

(deftest prime?-test
  (is (= true (m/prime? 1)))
  (is (= true (m/prime? 2)))
  (is (= true (m/prime? 3)))
  (is (= true (m/prime? 7)))
  (is (= true (m/prime? 11)))
  (is (= true (m/prime? 23)))
  (is (= false (m/prime? 4)))
  (is (= false (m/prime? 6)))
  (is (= false (m/prime? 8))))

(deftest close-enough?-test
  (is (= false (m/close-enough? 1 2)))
  (is (= true (m/close-enough? 1 1)))
  (is (= true (m/close-enough? 1 1.00001)))
  (is (= true (m/close-enough? 1 1.0001)))
  (is (= true (m/close-enough? 1 1.001)))
  (is (= false (m/close-enough? 1 1.01)))
  (is (= false (m/close-enough? 1 2 1)))
  (is (= true (m/close-enough? 1 1 1)))
  (is (= true (m/close-enough? 1 1.00001 1)))
  (is (= true (m/close-enough? 1 1.0001 1)))
  (is (= true (m/close-enough? 1 1.001 1)))
  (is (= true (m/close-enough? 1 1.01 1)))
  (is (= false (m/close-enough? 1 10 1))))

(deftest average-test
  (is (= 11/2 (m/average 1 10)))
  (is (= 5.5 (m/average 1.0 10.0))))

(deftest positive?-test
  (is (= false (m/positive? 0)))
  (is (= true (m/positive? 1)))
  (is (= false (m/positive? -1))))

(deftest negative?-test
  (is (= false (m/negative? 0)))
  (is (= false (m/negative? 1)))
  (is (= true (m/negative? -1))))

(deftest gcd-test
  (is (= 8 (m/gcd 56 48)))
  (is (= 1 (m/gcd 101 103)))
  (is (= 12 (m/gcd 36 48)))
  (is (= 5 (m/gcd 5 0)))
  (is (= 5 (m/gcd 0 5)))
  (is (= 0 (m/gcd 0 0)))
  (is (= 21 (m/gcd 21 21)))
  (is (= 1 (m/gcd 17 19))))

(deftest round-to-dec-test
  (is (= 10.5 (m/round-to-dec 10.54 1)))
  (is (= 10.6 (m/round-to-dec 10.55 1)))
  (is (= 10.55 (m/round-to-dec 10.55 2)))
  (is (= 11.0 (m/round-to-dec 10.55 0))))

(comment "Chapter #2")
; Introduction to Data Abstraction -----------------------------------------------------------------

(deftest pair-test
  (is (= '(1 2) (m/pair 1 2)))
  (is (= '(1123 2123) (m/pair 1123 2123))))

(deftest pair?-test
  (is (= true (m/pair? (list 1 2))))
  (is (= true (m/pair? (m/pair 1 2))))
  (is (= false (m/pair? (list 1 2 3))))
  (is (= false (m/pair? false)))
  (is (= false (m/pair? true)))
  (is (= false (m/pair? '())))
  (is (= false (m/pair? '(1))))
  (is (= false (m/pair? [])))
  (is (= false (m/pair? [1])))
  (is (= false (m/pair? [1 2])))
  (is (= false (m/pair? [1 2 3]))))

(deftest leaf?-test
  (is (= false (m/leaf? '(1 2))))
  (is (= true (m/leaf? 1)))
  (is (= true (m/leaf? nil))))

(deftest pair-empty?-test
  (is (= true (m/pair-empty? (m/pair))))
  (is (= true (m/pair-empty? (m/pair nil nil))))
  (is (= true (m/pair-empty? '())))
  (is (= true (m/pair-empty? [])))
  (is (= true (m/pair-empty? nil)))
  (is (= false (m/pair-empty? '(1))))
  (is (= false (m/pair-empty? '(1 1))))
  (is (= false (m/pair-empty? '(1 1 1)))))

(deftest list-empty?-test
  (is (= true (m/list-empty? '())))
  (is (= true (m/list-empty? nil)))
  (is (= false (m/list-empty? 4))))                         ; Potential issues?

(deftest car-test
  (is (= 1 (m/car (m/pair 1 2))))
  (is (= 1123 (m/car (m/pair 1123 2))))
  (is (= 1123 (m/car 1123)))
  (is (= 1 (m/car (list 1 2 3)))))

(deftest cdr-test
  (is (= 2 (m/cdr (m/pair 1 2))))
  (is (= 2123 (m/cdr (m/pair 1 2123))))
  (is (= nil (m/cdr 1))))

(deftest cdr-for-list-test
  (is (= nil (m/cdr '())))
  (is (= nil (m/cdr '(1))))
  (is (= 2 (m/cdr '(1 2))))
  (is (= '(2 3 4) (m/cdr '(1 2 3 4)))))

(def i1 (m/make-interval 1 2))
(def i2 (m/make-interval 3 4))

(deftest make-interval-test
  (is (= (m/pair 1 2) (m/make-interval 1 2))))

(deftest lower-bound-test
  (is (= 1 (m/lower-bound i1)))
  (is (= 3 (m/lower-bound i2))))

(deftest upper-bound-test
  (is (= 2 (m/upper-bound i1)))
  (is (= 4 (m/upper-bound i2))))

(deftest mul-interval-test
  (is (= '(3 8) (m/mul-interval i1 i2)))
  (is (= '(3 8) (m/mul-interval i2 i1))))

(deftest div-interval-test
  (is (= '(0.25 0.6666666666666666) (m/div-interval i1 i2)))
  (is (= '(1.5 4.0) (m/div-interval i2 i1))))

(deftest add-interval-test
  (is (= '(4 6) (m/add-interval i1 i2)))
  (is (= '(4 6) (m/add-interval i2 i1))))

(deftest sub-interval-test
  (is (= '(-2 -2) (m/sub-interval i1 i2)))
  (is (= '(2 2) (m/sub-interval i2 i1))))

(deftest make-center-width-test
  (is (= '(0.5 1.5) (m/make-center-width 1 0.5))))

(deftest center-interval-test
  (is (= 1.5 (m/center-interval i1)))
  (is (= 3.5 (m/center-interval i2))))

(deftest width-interval-test
  (is (= 0.5 (m/width-interval i1)))
  (is (= 0.5 (m/width-interval i2))))

(deftest print-interval-test
  (is (= "[2.0, 1.0] / 1.5±0.5" (m/print-interval i1)))
  (is (= "[4.0, 3.0] / 3.5±0.5" (m/print-interval i2))))

(def tree (cons (m/pair 1 2) (m/pair 3 4)))                 ; ((1 2) 3 4)
(def tree-2 (list tree tree))                               ; (((1 2) 3 4) ((1 2) 3 4))

(deftest length-test
  (is (= 0 (m/length nil)))
  (is (= 0 (m/length '())))
  (is (= 1 (m/length '(123))))
  (is (= 5 (m/length '(1 4 9 16 25))))
  (is (= 3 (m/length tree)))
  (is (= 2 (m/length tree-2))))

(deftest append-test
  (is (= '() (m/append nil '())))
  (is (= '() (m/append '() nil)))
  (is (= '() (m/append '() '())))
  (is (= '(1) (m/append '(1) '())))
  (is (= '(2) (m/append '() '(2))))
  (is (= '(1 2) (m/append '(1) '(2))))
  (is (= '(1 4 9 16 25) (m/append '(1 4 9 16 25) '())))
  (is (= '(1 4 9 16 25 3 2 1) (m/append '(1 4 9 16 25) '(3 2 1)))))
