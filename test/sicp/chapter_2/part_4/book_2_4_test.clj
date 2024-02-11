(ns sicp.chapter-2.part-4.book-2-4-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter-2.part-4.book-2-4 :as b24]))

(def angle-60 (/ Math/PI 3))
(def radius 2.0)
(def x 1.0000000000000002)
(def y 1.7320508075688772)

(comment "2.4 Multiple Representations for Abstract Data -----------------------------------------")

(comment "2.4.1 Representations for Complex Numbers ----------------------------------------------")

; Ben's way ----------------------------------------------------------------------------------------
(deftest Ben-add-complex-test
  (is (= (b24/Ben-make-from-real-imag 2.0 3.4641016)
         (b24/Ben-add-complex (b24/Ben-make-from-real-imag x y)
                              (b24/Ben-make-from-real-imag x y))))
  (is (= '(12.0 20.0) (b24/Ben-add-complex '(10 0) '(2 20)))))

(deftest Ben-sub-complex-test
  (is (= '(0.0 0.0) (b24/Ben-sub-complex [x y] [x y])))
  (is (= [1.0 1.0] (b24/Ben-sub-complex '(2 3) '(1 2)))))

(deftest Ben-mul-complex-test
  (is (= '(-13.999999999999998 22.0) (b24/Ben-mul-complex '(2 4) '(3 5))))
  (is (= '(11.0 8.0) (b24/Ben-mul-complex '(2 1) '(6 1)))))

(deftest Ben-div-complex-test
  (is (= '(2.0 0.0) (b24/Ben-div-complex '(2 2) '(1 1))))
  (is (= '(0.7647058823529411 0.0588235294117646) (b24/Ben-div-complex '(2 4) '(3 5)))))

; Alyssa's way -------------------------------------------------------------------------------------

(deftest Alyssa-make-from-real-imag-test
  (is (= [radius angle-60] (b24/Alyssa-make-from-real-imag x y))))

(deftest Alyssa-make-from-mag-ang-test
  (let [z  (b24/Ben-make-from-real-imag x y)
        bm (b24/Ben-real-part z)
        ba (b24/Ben-imag-part z)]
    (is (= [bm ba] (b24/Alyssa-make-from-mag-ang x y)))))

(deftest Alyssa-real-part-test
  (let [z  (b24/Ben-make-from-real-imag '(1 0))
        br (b24/Ben-real-part z)]
    (is (= br (b24/Alyssa-real-part '(1 0))))))

(deftest Alyssa-imag-part-test
  (let [z  (b24/Ben-make-from-real-imag '(0 0))
        bi (b24/Ben-imag-part z)]
    (is (= bi (b24/Alyssa-imag-part '(0 0))))))

(deftest Ben-make-from-real-imag-test
  (is (= '(1.0 2.0) (b24/Ben-make-from-real-imag '(1 2)))))

; Tagged data --------------------------------------------------------------------------------------

(deftest attach-tag-test
  (is (= '(:test x y) (b24/attach-tag :test '(x y))))
  (is (= '(:test) (b24/attach-tag :test '()))))

(deftest type-tag-test
  (is (= :test (b24/type-tag (b24/attach-tag :test '(x y))))))

(deftest contents-test
  (is (= '(x y) (b24/contents (b24/attach-tag :test '(x y))))))

(deftest rectangular?-test
  (is (= false (b24/rectangular? (b24/attach-tag :test '(x y)))))
  (is (= true (b24/rectangular? (b24/attach-tag :rectangular '(x y))))))

(deftest polar?-test
  (is (= false (b24/polar? (b24/attach-tag :test '(x y)))))
  (is (= true (b24/polar? (b24/attach-tag :polar '(x y))))))

; Rectangular
(deftest make-from-real-imag-rectangular-test
  (is (= [:rectangular x y] (b24/make-from-real-imag-rectangular x y)))
  (is (= [:rectangular x y] (b24/make-from-real-imag-v2 x y))))

(deftest make-from-mag-ang-rectangular-test
  (is (= [:rectangular x y] (b24/make-from-mag-ang-rectangular radius angle-60))))

(deftest make-from-real-imag-polar-test
  (is (= [:polar radius angle-60] (b24/make-from-real-imag-polar x y))))

(deftest make-from-mag-ang-polar-test
  (is (= [:polar radius angle-60] (b24/make-from-mag-ang-polar radius angle-60)))
  (is (= [:polar radius angle-60] (b24/make-from-mag-ang-v2 radius angle-60))))

; Compounding of Polar and Rectangular ways
(deftest real-part-test
  (is (= x (b24/real-part (b24/make-from-mag-ang-polar radius angle-60))))
  (is (= x (b24/real-part (b24/make-from-real-imag-polar x y))))
  (is (= x (b24/real-part (b24/make-from-real-imag-rectangular x y))))
  (is (= x (b24/real-part (b24/make-from-mag-ang-rectangular radius angle-60)))))

(deftest imag-part-test
  (is (= y (b24/imag-part (b24/make-from-mag-ang-polar radius angle-60))))
  (is (= y (b24/imag-part (b24/make-from-real-imag-polar x y))))
  (is (= y (b24/imag-part (b24/make-from-real-imag-rectangular x y))))
  (is (= y (b24/imag-part (b24/make-from-mag-ang-rectangular radius angle-60)))))

(deftest magnitude-test
  (is (= radius (b24/magnitude (b24/make-from-mag-ang-polar radius angle-60))))
  (is (= radius (b24/magnitude (b24/make-from-real-imag-polar x y))))
  (is (= radius (b24/magnitude (b24/make-from-real-imag-rectangular x y))))
  (is (= radius (b24/magnitude (b24/make-from-mag-ang-rectangular radius angle-60)))))

(deftest angle-test
  (is (= angle-60 (b24/angle (b24/make-from-mag-ang-polar radius angle-60))))
  (is (= angle-60 (b24/angle (b24/make-from-real-imag-polar x y))))
  (is (= angle-60 (b24/angle (b24/make-from-real-imag-rectangular x y))))
  (is (= angle-60 (b24/angle (b24/make-from-mag-ang-rectangular radius angle-60)))))

(deftest add-complex-test
  (is (= [:rectangular (* 2 x) (* 2 y)]
         (b24/add-complex
           (b24/make-from-mag-ang-polar radius angle-60)
           (b24/make-from-real-imag-rectangular x y)))))

(comment "2.4.3 Data-Directed Programming and Additivity -----------------------------------------")

(deftest make-from-real-imag-test
  (is (= x ((b24/make-from-real-imag x y) :real-part)))
  (is (= y ((b24/make-from-real-imag x y) :imag-part)))
  (is (= radius ((b24/make-from-real-imag x y) :magnitude)))
  (is (= angle-60 ((b24/make-from-real-imag x y) :angle))))
