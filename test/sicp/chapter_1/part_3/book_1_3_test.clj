(ns sicp.chapter-1.part-3.book-1-3-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-1.part-3.book-1-3 :as book]
            [sicp.misc :as m]))

(comment "1.3.1")
; Procedures as Arguments --------------------------------------------------------------------------

(deftest sum-integers-test
  (is (= 0 (book/sum-integers 0 0)))
  (is (= 1 (book/sum-integers 1 1)))
  (is (= 3 (book/sum-integers 1 2)))
  (is (= 6 (book/sum-integers 1 3)))
  (is (= 10 (book/sum-integers 1 4)))
  (is (= 15 (book/sum-integers 1 5))))

(deftest sum-cubes-test
  (is (= 0 (book/sum-cubes 0 0)))
  (is (= 1 (book/sum-cubes 1 1)))
  (is (= 9 (book/sum-cubes 1 2)))
  (is (= 36 (book/sum-cubes 1 3)))
  (is (= 100 (book/sum-cubes 1 4)))
  (is (= 225 (book/sum-cubes 1 5)))
  (is (= 441 (book/sum-cubes 1 6)))
  (is (= 784 (book/sum-cubes 1 7)))
  (is (= 1296 (book/sum-cubes 1 8)))
  (is (= 2025 (book/sum-cubes 1 9)))
  (is (= 3025 (book/sum-cubes 1 10))))

(deftest pi-sum-test
  (is (= 0.3333333333333333 (book/pi-sum 1 1)))
  (is (= 0.125 (book/pi-sum 2 2)))
  (is (= 0.372005772005772 (book/pi-sum 1 10)))
  (is (= 3.139592655589783 (* 8 (book/pi-sum 1 1000)))))

(deftest sum-terms-test
  (is (= 3025 (book/sum-terms m/cube 1 inc 10))))

(deftest sum-integers-2-test
  (is (= 15 (book/sum-integers-2 1 5)))
  (is (= 55 (book/sum-integers-2 1 10))))

(deftest sum-cubes-2-test
  (is (= 2025 (book/sum-cubes-2 1 9)))
  (is (= 3025 (book/sum-cubes-2 1 10))))

(deftest pi-sum-2-test
  (is (= 0.3333333333333333 (book/pi-sum-2 1 1)))
  (is (= 0.125 (book/pi-sum-2 2 2)))
  (is (= 0.372005772005772 (book/pi-sum-2 1 10)))
  (is (= 3.139592655589783 (* 8 (book/pi-sum-2 1 1000)))))

(deftest integral-test
  (is (= 0.24998750000000042 (book/integral m/cube 0 1 0.01)))
  (is (= 0.249999875000001 (book/integral m/cube 0 1 0.001))))

(comment "1.3.2")
; Constructing Procedures Using Lambda -------------------------------------------------------------

(deftest pi-sum-lamda-test
  (is (= 0.3333333333333333 (book/pi-sum-lamda 1 1)))
  (is (= 0.125 (book/pi-sum-lamda 2 2)))
  (is (= 0.372005772005772 (book/pi-sum-lamda 1 10)))
  (is (= 3.139592655589783 (* 8 (book/pi-sum-lamda 1 1000)))))

(deftest integral-lamda-test
  (is (= 0.24998750000000042 (book/integral-lamda m/cube 0 1 0.01)))
  (is (= 0.249999875000001 (book/integral-lamda m/cube 0 1 0.001))))

(comment "1.3.3")
; Procedures as General Methods --------------------------------------------------------------------

(deftest search-test
  (is (= 0 (book/search m/cube -1 1)))
  (is (= 0 (book/search m/cube -9 9)))
  (is (= 1/16384 (book/search m/cube -1 9))))

(deftest half-interval-method-test
  (is (= 6.103515625E-5 (book/half-interval-method m/cube -1.0 9.0)))
  (is (= 3.14111328125 (book/half-interval-method #(Math/sin %) 2.0 4.0)))
  (is (= 1.89306640625 (book/half-interval-method #(- (m/cube %) (* 2 %) 3) 1.0 2.0))))

(deftest fixed-point-test
  (is (= 0.7390822985224024 (book/fixed-point #(Math/cos %) -1.0)))
  (is (= 1.2587315962971173 (book/fixed-point #(+ (Math/sin %) (Math/cos %)) 1.0)))
  (is (= 1.2587315962971173 (book/fixed-point #(+ (Math/sin %) (Math/cos %)) 1.0))))

(deftest sqrt-test
  (is (= 1.4142135623746899 (book/sqrt 2)))
  (is (= 3.0 (book/sqrt 9))))

(comment "1.3.4")
; Procedures as Returned Values --------------------------------------------------------------------

(deftest average-damp-test
  (is (= 55 ((book/average-damp m/square) 10))))

(deftest sqrt-lamda-test
  (is (= 3.0 (book/sqrt-lamda 9)))
  (is (= 3.162277660168379 (book/sqrt-lamda 10))))

(deftest cube-root-test
  (is (= 2.9999972321057697 (book/cube-root 27)))
  (is (= 10.000002544054729 (book/cube-root 1000))))

(deftest deriv-test
  (is (= 75.00014999664018 ((book/deriv m/cube) 5))))

(deftest newton-transform-test
  (is (= 75.00014999664018 ((book/deriv m/cube) 5))))

(deftest sqrt-newton-test
  (is (= 7.000000000000103 (book/sqrt-newton 49)))
  (is (= 10.0 (book/sqrt-newton 100)))
  (is (= 31.62277660168526 (book/sqrt-newton 1000))))
