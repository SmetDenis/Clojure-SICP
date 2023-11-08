(ns sicp.chapter-2.part-2.ex-2-47-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-2.ex-2-46 :as ex-2-46]
            [sicp.chapter-2.part-2.ex-2-47 :refer [edge1-frame
                                                   edge2-frame
                                                   edge2-frame-2
                                                   make-frame
                                                   make-frame-2
                                                   origin-frame]]))
(def vec-1 (ex-2-46/make-vect 0 0))
(def vec-2 (ex-2-46/make-vect 0.1 0.2))
(def vec-3 (ex-2-46/make-vect 0.5 0.75))
(def frame-1 (make-frame vec-1 vec-2 vec-3))
(def frame-2 (make-frame-2 vec-1 vec-2 vec-3))

(deftest make-frame-test
  (is (= '((0 0)
           (0.5 0.75)
           (0.5 0.75)) (make-frame vec-1 vec-3 vec-3))))

(deftest make-frame-2-test
  (is (= '((0 0)
           (0.5 0.75)
           0.5 0.75) (make-frame-2 vec-1 vec-3 vec-3))))

(deftest origin-frame-test
  (is (= vec-1 (origin-frame frame-1))))

(deftest edge1-frame-test
  (is (= vec-2 (edge1-frame frame-1))))

(deftest edge2-frame-test
  (is (= vec-3 (edge2-frame frame-1))))

(deftest edge2-frame-2-test
  (is (= vec-3 (edge2-frame-2 frame-2))))
