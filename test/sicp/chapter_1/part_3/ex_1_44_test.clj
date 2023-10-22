(ns sicp.chapter-1.part-3.ex-1-44-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-44 :refer [n-fold smooth]]
            [sicp.misc :as m]))

(deftest smooth-test
  (is (= 1.0000019999999998 ((smooth m/cube) 1)))
  (is (= 1000.0000200000001 ((smooth m/cube) 10))))

(deftest n-fold-test
  (is (= 1000.0002 ((n-fold m/cube 10) 10))))
