(ns sicp.chapter-2.part-2.ex-2-41-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-2.ex-2-41 :refer [duplets find-triplets triplets]]))

(deftest duplets-test
  (is (= '((1 1)) (duplets 1)))
  (is (= '((1 1)
           (1 2)
           (2 1)
           (2 2)) (duplets 2)))
  (is (= '((1 1)
           (1 2)
           (1 3)
           (2 1)
           (2 2)
           (2 3)
           (3 1)
           (3 2)
           (3 3)) (duplets 3))))

(deftest triplets-test
  (is (= '((1 1 1)) (triplets 1)))
  (is (= '((1 1 1)
           (1 1 2)
           (1 2 1)
           (1 2 2)
           (2 1 1)
           (2 1 2)
           (2 2 1)
           (2 2 2)) (triplets 2)))
  (is (= '((1 1 1)
           (1 1 2)
           (1 1 3)
           (1 2 1)
           (1 2 2)
           (1 2 3)
           (1 3 1)
           (1 3 2)
           (1 3 3)
           (2 1 1)
           (2 1 2)
           (2 1 3)
           (2 2 1)
           (2 2 2)
           (2 2 3)
           (2 3 1)
           (2 3 2)
           (2 3 3)
           (3 1 1)
           (3 1 2)
           (3 1 3)
           (3 2 1)
           (3 2 2)
           (3 2 3)
           (3 3 1)
           (3 3 2)
           (3 3 3)) (triplets 3))))

(deftest find-triplets-test
  (is (= '() (find-triplets 3 3)))
  (is (= '() (find-triplets 3 4)))
  (is (= '() (find-triplets 3 5)))
  (is (= '((1 2 3)) (find-triplets 3 6)))
  (is (= '((1 3 4)) (find-triplets 4 8)))
  (is (= '((1 2 5) (1 3 4)) (find-triplets 5 8)))
  (is (= '((1 3 5) (2 3 4)) (find-triplets 5 9)))
  (is (= '((1 4 5) (2 3 5)) (find-triplets 5 10))))
