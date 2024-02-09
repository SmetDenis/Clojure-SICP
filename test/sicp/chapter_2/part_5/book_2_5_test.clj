(ns sicp.chapter-2.part-5.book-2-5-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-5.book-2-5 :refer [add
                                            div
                                            install-rational-package
                                            install-scheme-number-package
                                            make-rational
                                            make-scheme-number
                                            mul
                                            sub]]))

(install-scheme-number-package)
(install-rational-package)

(deftest add-test
  (is (= (make-scheme-number 3) (add (make-scheme-number 1) (make-scheme-number 2))))
  (is (= (make-scheme-number 4) (add (make-scheme-number 2) (make-scheme-number 2))))
  (is (= (make-rational 4 1) (add (make-rational 2 1) (make-rational 2 1))))
  (is (= (make-rational 1 1) (add (make-rational 2 3) (make-rational 1 3)))))

(deftest sub-test
  (is (= (make-scheme-number 1) (sub (make-scheme-number 4) (make-scheme-number 3))))
  (is (= (make-scheme-number -6) (sub (make-scheme-number 4) (make-scheme-number 10))))
  (is (= (make-rational 0 1) (sub (make-rational 2 1) (make-rational 2 1))))
  (is (= (make-rational 1 3) (sub (make-rational 2 3) (make-rational 1 3)))))

(deftest mul-test
  (is (= (make-scheme-number 12) (mul (make-scheme-number 4) (make-scheme-number 3))))
  (is (= (make-scheme-number -40) (mul (make-scheme-number -4) (make-scheme-number 10))))
  (is (= (make-rational 4 1) (mul (make-rational 2 1) (make-rational 2 1))))
  (is (= (make-rational 2 9) (mul (make-rational 2 3) (make-rational 1 3)))))

(deftest div-test
  (is (= (make-scheme-number 20) (div (make-scheme-number 100) (make-scheme-number 5))))
  (is (= (make-scheme-number 1/2) (div (make-scheme-number 3) (make-scheme-number 6))))
  (is (= (make-rational 1 1) (div (make-rational 2 1) (make-rational 2 1))))
  (is (= (make-rational 2 1) (div (make-rational 2 3) (make-rational 1 3)))))
