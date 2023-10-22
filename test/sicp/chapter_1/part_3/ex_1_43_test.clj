(ns sicp.chapter-1.part-3.ex-1-43-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.ex-1-43 :refer [repeated repeated-compose]]
            [sicp.misc :as m]))

(deftest repeated-test
  (is (= (m/square 5)
         ((repeated m/square 1) 5)))

  (is (= (m/square (m/square 5))
         ((repeated m/square 2) 5)))

  (is (= (m/square (m/square (m/square 5)))
         ((repeated m/square 3) 5)))

  (is (= (* 1 1)
         ((repeated m/square 2) 1)))

  (is (= (m/cube (m/cube 3))
         ((repeated m/cube 2) 3))))

(deftest repeated-compose-test
  (is (= (m/square 5)
         ((repeated-compose m/square 1) 5)))

  (is (= (m/square (m/square 5))
         ((repeated-compose m/square 2) 5)))

  (is (= (m/square (m/square (m/square 5)))
         ((repeated-compose m/square 3) 5)))

  (is (= (* 1 1)
         ((repeated-compose m/square 2) 1)))

  (is (= (m/cube (m/cube 3))
         ((repeated-compose m/cube 2) 3))))
