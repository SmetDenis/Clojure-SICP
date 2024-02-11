(ns sicp.chapter-1.part-3.book-1-3-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-1.part-3.book-1-3 :as b13]
    [sicp.misc :as m]))

(comment "1.3.1 Procedures as Arguments ----------------------------------------------------------")

(deftest sum-integers-test
  (is (= 0 (b13/sum-integers 0 0)))
  (is (= 1 (b13/sum-integers 1 1)))
  (is (= 3 (b13/sum-integers 1 2)))
  (is (= 6 (b13/sum-integers 1 3)))
  (is (= 10 (b13/sum-integers 1 4)))
  (is (= 15 (b13/sum-integers 1 5))))

(deftest sum-cubes-test
  (is (= 0 (b13/sum-cubes 0 0)))
  (is (= 1 (b13/sum-cubes 1 1)))
  (is (= 9 (b13/sum-cubes 1 2)))
  (is (= 36 (b13/sum-cubes 1 3)))
  (is (= 100 (b13/sum-cubes 1 4)))
  (is (= 225 (b13/sum-cubes 1 5)))
  (is (= 441 (b13/sum-cubes 1 6)))
  (is (= 784 (b13/sum-cubes 1 7)))
  (is (= 1296 (b13/sum-cubes 1 8)))
  (is (= 2025 (b13/sum-cubes 1 9)))
  (is (= 3025 (b13/sum-cubes 1 10))))

(deftest pi-sum-test
  (is (= 0.3333333333333333 (b13/pi-sum 1 1)))
  (is (= 0.125 (b13/pi-sum 2 2)))
  (is (= 0.372005772005772 (b13/pi-sum 1 10)))
  (is (= 3.139592655589783 (* 8 (b13/pi-sum 1 1000)))))

(deftest sum-terms-test
  (is (= 3025 (b13/sum-terms m/cube 1 inc 10))))

(deftest sum-integers-2-test
  (is (= 15 (b13/sum-integers-2 1 5)))
  (is (= 55 (b13/sum-integers-2 1 10))))

(deftest sum-cubes-2-test
  (is (= 2025 (b13/sum-cubes-2 1 9)))
  (is (= 3025 (b13/sum-cubes-2 1 10))))

(deftest pi-sum-2-test
  (is (= 0.3333333333333333 (b13/pi-sum-2 1 1)))
  (is (= 0.125 (b13/pi-sum-2 2 2)))
  (is (= 0.372005772005772 (b13/pi-sum-2 1 10)))
  (is (= 3.139592655589783 (* 8 (b13/pi-sum-2 1 1000)))))

(deftest integral-test
  (is (= 0.24998750000000042 (b13/integral m/cube 0 1 0.01)))
  (is (= 0.249999875000001 (b13/integral m/cube 0 1 0.001))))

(deftest f-1-test
  (is (= 4 (b13/f-1 1 2)))
  (is (= 603 (b13/f-1 2 10)))
  (is (= 178 (b13/f-1 2 5))))

(deftest f-2-test
  (is (= 4 (b13/f-2 1 2)))
  (is (= 603 (b13/f-1 2 10)))
  (is (= 178 (b13/f-2 2 5))))

(comment "1.3.2 Constructing Procedures Using Lambda ---------------------------------------------")

(deftest pi-sum-lamda-test
  (is (= 0.3333333333333333 (b13/pi-sum-lamda 1 1)))
  (is (= 0.125 (b13/pi-sum-lamda 2 2)))
  (is (= 0.372005772005772 (b13/pi-sum-lamda 1 10)))
  (is (= 3.139592655589783 (* 8 (b13/pi-sum-lamda 1 1000)))))

(deftest integral-lamda-test
  (is (= 0.24998750000000042 (b13/integral-lamda m/cube 0 1 0.01)))
  (is (= 0.249999875000001 (b13/integral-lamda m/cube 0 1 0.001))))

(comment "1.3.3 Procedures as General Methods ----------------------------------------------------")

(deftest search-test
  (is (= 0 (b13/search m/cube -1 1)))
  (is (= 0 (b13/search m/cube -9 9)))
  (is (= 1/16384 (b13/search m/cube -1 9))))

(deftest half-interval-method-test
  (is (= 6.103515625E-5 (b13/half-interval-method m/cube -1.0 9.0)))
  (is (= 3.14111328125 (b13/half-interval-method #(Math/sin %) 2.0 4.0)))
  (is (= 1.89306640625 (b13/half-interval-method #(- (m/cube %) (* 2 %) 3) 1.0 2.0)))
  (is (= true (m/is-exception? (b13/half-interval-method m/cube 1 1) "Values are not of opposite sign 1 1"))))

(deftest fixed-point-test
  (is (= 0.7390822985224024 (b13/fixed-point #(Math/cos %) -1.0)))
  (is (= 1.2587315962971173 (b13/fixed-point #(+ (Math/sin %) (Math/cos %)) 1.0)))
  (is (= 1.2587315962971173 (b13/fixed-point #(+ (Math/sin %) (Math/cos %)) 1.0))))

(deftest sqrt-test
  (is (= 1.4142135623746899 (b13/sqrt 2)))
  (is (= 3.0 (b13/sqrt 9))))

(comment "1.3.4 Procedures as Returned Values ----------------------------------------------------")

(deftest average-damp-test
  (is (= 55 ((b13/average-damp m/square) 10))))

(deftest sqrt-lamda-test
  (is (= 3.0 (b13/sqrt-lamda 9)))
  (is (= 3.162277660168379 (b13/sqrt-lamda 10))))

(deftest cube-root-test
  (is (= 2.9999972321057697 (b13/cube-root 27)))
  (is (= 10.000002544054729 (b13/cube-root 1000))))

(deftest deriv-test
  (is (= 75.00014999664018 ((b13/deriv m/cube) 5))))

(deftest newton-transform-test
  (is (= 75.00014999664018 ((b13/deriv m/cube) 5))))

(deftest sqrt-newton-test
  (is (= 7.000000000000103 (b13/sqrt-newton 49)))
  (is (= 10.0 (b13/sqrt-newton 100)))
  (is (= 31.62277660168526 (b13/sqrt-newton 1000))))

(deftest sqrt-transform-test
  (is (= 7.000000000000002 (b13/sqrt-transform-average 49)))
  (is (= 10.0 (b13/sqrt-newton 100)))
  (is (= 31.622776601684336 (b13/sqrt-transform-average 1000))))

(deftest sqrt-newtons-transform-test
  (is (= 7.000000000000103 (b13/sqrt-newtons-transform 49)))
  (is (= 10.0 (b13/sqrt-newton 100)))
  (is (= 31.62277660168526 (b13/sqrt-newtons-transform 1000))))
