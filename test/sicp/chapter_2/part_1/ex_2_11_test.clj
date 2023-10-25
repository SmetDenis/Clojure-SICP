(ns sicp.chapter-2.part-1.ex-2-11-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-11 :refer [center
                                                   interval-case
                                                   make-center-width
                                                   mul-interval
                                                   width]]
            [sicp.misc :as m]))

(def interval (m/make-interval 95 105))

(deftest make-center-width-test
  (is (= [97 103] (make-center-width 100 3))))

(deftest center-test
  (is (= 100.0 (center interval))))

(deftest width-test
  (is (= 5.0 (width interval))))

; Test solution
(deftest interval-case-test
  (is (= -1 (interval-case -1 -1)))
  (is (= 0 (interval-case -1 1)))
  (is (= 1 (interval-case 1 1)))
  (is (= 1 (interval-case 1 -1))))

(def i++ (m/make-interval 1 1))
(def i+- (m/make-interval 1 -1))
(def i-+ (m/make-interval -1 1))
(def i-- (m/make-interval -1 -1))

(deftest mul-interval-test
  (is (= [1 1] (mul-interval i++ i++)))
  (is (= [1 -1] (mul-interval i++ i+-)))
  (is (= [-1 -1] (mul-interval i++ i--)))
  (is (= [1 -1] (mul-interval i+- i--)))
  (is (= [1 1] (mul-interval i-- i--)))
  (is (= [-1 1] (mul-interval i-+ i-+)))
  (is (= [1 1] (mul-interval i+- i+-)))
  (is (= [1 -1] (mul-interval i+- i-+))))

(deftest mul-interval-old-test
  (is (= [1 1] (m/mul-interval i++ i++)))
  (is (= [-1 1] (m/mul-interval i++ i+-)))                  ; diff
  (is (= [-1 -1] (m/mul-interval i++ i--)))
  (is (= [-1 1] (m/mul-interval i+- i--)))                  ; diff
  (is (= [1 1] (m/mul-interval i-- i--)))
  (is (= [-1 1] (m/mul-interval i-+ i-+)))
  (is (= [-1 1] (m/mul-interval i+- i+-)))                  ; diff
  (is (= [-1 1] (m/mul-interval i+- i-+))))                 ; diff
