(ns sicp.chapter-2.part-5.book-2-5-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.packages.install-rational :as rational]
    [sicp.chapter-2.packages.install-scheme-number :as scheme]
    [sicp.chapter-2.packages.op-table :as ot]
    [sicp.chapter-2.part-5.book-2-5 :as b25]
    [sicp.misc :as m]))

(scheme/install-scheme-number-package)
(rational/install-rational-package)

(deftest add-test
  (is (= (scheme/make-scheme-number 3) (b25/add (scheme/make-scheme-number 1) (scheme/make-scheme-number 2))))
  (is (= (scheme/make-scheme-number 4) (b25/add (scheme/make-scheme-number 2) (scheme/make-scheme-number 2))))
  (is (= (rational/make-rational 4 1) (b25/add (rational/make-rational 2 1) (rational/make-rational 2 1))))
  (is (= (rational/make-rational 1 1) (b25/add (rational/make-rational 2 3) (rational/make-rational 1 3)))))

(deftest sub-test
  (is (= (scheme/make-scheme-number 1) (b25/sub (scheme/make-scheme-number 4) (scheme/make-scheme-number 3))))
  (is (= (scheme/make-scheme-number -6) (b25/sub (scheme/make-scheme-number 4) (scheme/make-scheme-number 10))))
  (is (= (rational/make-rational 0 1) (b25/sub (rational/make-rational 2 1) (rational/make-rational 2 1))))
  (is (= (rational/make-rational 1 3) (b25/sub (rational/make-rational 2 3) (rational/make-rational 1 3)))))

(deftest mul-test
  (is (= (scheme/make-scheme-number 12) (b25/mul (scheme/make-scheme-number 4) (scheme/make-scheme-number 3))))
  (is (= (scheme/make-scheme-number -40) (b25/mul (scheme/make-scheme-number -4) (scheme/make-scheme-number 10))))
  (is (= (rational/make-rational 4 1) (b25/mul (rational/make-rational 2 1) (rational/make-rational 2 1))))
  (is (= (rational/make-rational 2 9) (b25/mul (rational/make-rational 2 3) (rational/make-rational 1 3)))))

(deftest div-test
  (is (= (scheme/make-scheme-number 20) (b25/div (scheme/make-scheme-number 100) (scheme/make-scheme-number 5))))
  (is (= (scheme/make-scheme-number 1/2) (b25/div (scheme/make-scheme-number 3) (scheme/make-scheme-number 6))))
  (is (= (rational/make-rational 1 1) (b25/div (rational/make-rational 2 1) (rational/make-rational 2 1))))
  (is (= (rational/make-rational 2 1) (b25/div (rational/make-rational 2 3) (rational/make-rational 1 3)))))

(deftest apply-generic-test
  (is (= true (m/is-exception? ((ot/apply-generic :undefined 1 2)) "No method for: :undefined"))))
