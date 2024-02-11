(ns sicp.chapter-2.part-5.book-2-5-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-5.book-2-5 :as b25]
    [sicp.misc :as m]))

(b25/install-scheme-number-package)
(b25/install-rational-package)
(b25/install-complex-package)

(deftest install-test
  (is (= :done (b25/install-scheme-number-package)))
  (is (= :done (b25/install-rational-package)))
  (is (= :done (b25/install-complex-package))))

(deftest add-test
  (is (= (b25/make-scheme-number 3) (b25/add (b25/make-scheme-number 1) (b25/make-scheme-number 2))))
  (is (= (b25/make-scheme-number 4) (b25/add (b25/make-scheme-number 2) (b25/make-scheme-number 2))))
  (is (= (b25/make-rational 4 1) (b25/add (b25/make-rational 2 1) (b25/make-rational 2 1))))
  (is (= (b25/make-rational 1 1) (b25/add (b25/make-rational 2 3) (b25/make-rational 1 3)))))

(deftest sub-test
  (is (= (b25/make-scheme-number 1) (b25/sub (b25/make-scheme-number 4) (b25/make-scheme-number 3))))
  (is (= (b25/make-scheme-number -6) (b25/sub (b25/make-scheme-number 4) (b25/make-scheme-number 10))))
  (is (= (b25/make-rational 0 1) (b25/sub (b25/make-rational 2 1) (b25/make-rational 2 1))))
  (is (= (b25/make-rational 1 3) (b25/sub (b25/make-rational 2 3) (b25/make-rational 1 3)))))

(deftest mul-test
  (is (= (b25/make-scheme-number 12) (b25/mul (b25/make-scheme-number 4) (b25/make-scheme-number 3))))
  (is (= (b25/make-scheme-number -40) (b25/mul (b25/make-scheme-number -4) (b25/make-scheme-number 10))))
  (is (= (b25/make-rational 4 1) (b25/mul (b25/make-rational 2 1) (b25/make-rational 2 1))))
  (is (= (b25/make-rational 2 9) (b25/mul (b25/make-rational 2 3) (b25/make-rational 1 3)))))

(deftest div-test
  (is (= (b25/make-scheme-number 20) (b25/div (b25/make-scheme-number 100) (b25/make-scheme-number 5))))
  (is (= (b25/make-scheme-number 1/2) (b25/div (b25/make-scheme-number 3) (b25/make-scheme-number 6))))
  (is (= (b25/make-rational 1 1) (b25/div (b25/make-rational 2 1) (b25/make-rational 2 1))))
  (is (= (b25/make-rational 2 1) (b25/div (b25/make-rational 2 3) (b25/make-rational 1 3)))))

(deftest apply-generic-test
  (is (= true (m/is-exception? ((b25/apply-generic :undefined 1 2)) "No method for: :undefined"))))

