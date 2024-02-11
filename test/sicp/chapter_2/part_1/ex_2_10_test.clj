(ns sicp.chapter-2.part-1.ex-2-10-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-1.ex-2-10 :refer [div-interval]]
    [sicp.misc :as m]))

(deftest div-interval-test
  (is (= [-1.5 -0.5]
         (div-interval (m/make-interval 10 15) (m/make-interval -10 -20))))
  (is (m/is-exception?
        (div-interval (m/make-interval 1 2) (m/make-interval -1 2))
        "Interval-2 is spanning zero")))
