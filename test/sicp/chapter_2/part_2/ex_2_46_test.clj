(ns sicp.chapter-2.part-2.ex-2-46-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-46 :refer [add-vect
                                                   make-vect
                                                   scale-vect
                                                   sub-vect
                                                   xcor-vect
                                                   ycor-vect]]))
(def vec-1 (make-vect 1 2))
(def vec-2 (make-vect 3 4))

(deftest make-vect-test
  (is (= '(1 2) (make-vect 1 2))))

(deftest xcor-vect-test
  (is (= 1 (xcor-vect vec-1)))
  (is (= 3 (xcor-vect vec-2))))

(deftest ycor-vect-test
  (is (= 2 (ycor-vect vec-1)))
  (is (= 4 (ycor-vect vec-2))))

(deftest add-vect-test
  (is (= '(4 6) (add-vect vec-1 vec-2)))
  (is (= '(4 6) (add-vect vec-2 vec-1))))

(deftest sub-vect-test
  (is (= '(-2 -2) (sub-vect vec-1 vec-2)))
  (is (= '(2 2) (sub-vect vec-2 vec-1))))

(deftest scale-vect-test
  (is (= '(3 6) (scale-vect 3 vec-1)))
  (is (= '(15 20) (scale-vect 5 vec-2))))
