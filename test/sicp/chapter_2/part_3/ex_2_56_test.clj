(ns sicp.chapter-2.part-3.ex-2-56-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-3.ex-2-56 :refer [base
                                           deriv
                                           exponent
                                           exponentiation?
                                           make-exponentiation]]))

(deftest exponentiation?-test
  (is (= true (exponentiation? '(** 1 1))))
  (is (= false (exponentiation? '(+ 1 1)))))

(deftest base-test
  (is (= 1 (base '(** 1 2)))))

(deftest exponent-test
  (is (= 2 (exponent '(** 1 2)))))

(deftest make-exponentiation-test
  (is (= 1.0 (make-exponentiation 1 2)))
  (is (= 2.0 (make-exponentiation 2 1)))
  (is (= 1.0 (make-exponentiation 2 0)))
  (is (= 0.0 (make-exponentiation 0 2)))
  (is (= 8.0 (make-exponentiation 2 3)))

  (is (= '(** :a 2) (make-exponentiation :a 2)))
  (is (= '(** :a 1) (make-exponentiation :a 1)))
  (is (= 1.0 (make-exponentiation :a 0)))
  (is (= '(** 1 :b) (make-exponentiation 1 :b)))
  (is (= '(** 2 :b) (make-exponentiation 2 :b)))
  (is (= '(** 0 :b) (make-exponentiation 0 :b)))
  (is (= '(** :a :b) (make-exponentiation :a :b))))

(deftest deriv-test
  (is (= 0 (deriv '(** 2 2) 'x)))
  (is (= '(* 2 (** x 1)) (deriv '(** x 2) 'x)))
  (is (= '(* (* 5 (** (* x 3) 4)) 3)
         (deriv '(** (* x 3) 5) 'x))))
