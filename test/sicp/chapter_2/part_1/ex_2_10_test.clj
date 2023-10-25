(ns sicp.chapter-2.part-1.ex-2-10-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-1.ex-2-10 :refer [div-interval]]
            [sicp.misc :as m]))

(deftest div-interval-test
  (is (= [-1.5 -0.5]
         (div-interval (m/make-interval 10 15) (m/make-interval -10 -20)))))

(deftest exception-with-message-test
  (try
    (div-interval (m/make-interval 1 2) (m/make-interval -1 2))
    (is false "Exception not thrown")
    (catch Exception e
      (is (= (.getMessage e) "interval-2 is spanning zero")))))
