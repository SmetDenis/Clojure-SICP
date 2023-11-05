(ns sicp.chapter-2.part-2.ex-2-29-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-29 :refer [branch-has-structure?
                                                   branch-moment
                                                   branch-structure
                                                   left-branch
                                                   make-branch
                                                   make-mobile
                                                   mobile-balanced?
                                                   right-branch
                                                   total-weight]]))

(def mobile-balanced (make-mobile (make-branch 5 2) (make-branch 1 10)))

(def nested-left-branch (make-branch 4 5))
(def nested-right-branch (make-branch nested-left-branch (make-branch 6 7)))
(def left (make-branch 1 2))
(def right (make-branch 3 nested-right-branch))
(def mobile-not-balanced (make-mobile left right))

(deftest branch-has-structure?-test
  (is (= false (branch-has-structure? left)))
  (is (= true (branch-has-structure? right))))

(deftest internal-state-test
  (is (= '((1 2) (3 ((4 5) (6 7)))) mobile-not-balanced))
  (is (= '((5 2) (1 10)) mobile-balanced))
  (is (= '((4 5) (6 7)) (branch-structure right))))

(deftest left-branch-test
  (is (= 1 (left-branch left)))
  (is (= left (left-branch mobile-not-balanced))))

(deftest right-branch-test
  (is (= 2 (right-branch left)))
  (is (= right (right-branch mobile-not-balanced))))

(deftest total-weight-test
  (is (= (+ 2 5 7) (total-weight mobile-not-balanced)))
  (is (= (+ 2 10) (total-weight mobile-balanced))))

(deftest branch-moment-test
  (is (= (* 5 2) (branch-moment (left-branch mobile-balanced))))
  (is (= (* 1 10) (branch-moment (right-branch mobile-balanced)))))

(deftest mobile-balanced?-test
  (is (= true (mobile-balanced? mobile-balanced)))
  (is (= false (mobile-balanced? mobile-not-balanced))))
