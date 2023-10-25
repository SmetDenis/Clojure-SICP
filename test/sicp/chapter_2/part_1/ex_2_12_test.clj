(ns sicp.chapter-2.part-1.ex-2-12-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-12 :refer [make-center-percent percent]]
            [sicp.misc :as m]))

(deftest make-center-percent-test
  (is (= [95.0 105.0] (make-center-percent 100 5)))
  (is (= [110.7 135.3] (make-center-percent 123 10))))

(deftest percent-test
  (is (= 5.0 (percent (m/make-interval 95 105))))
  (is (= 3.0 (percent (m/make-interval 97 103)))))
