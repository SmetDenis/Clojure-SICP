(ns sicp.chapter-2.part-4.ex-2-73-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.part-4.ex-2-73 :as ex-2-73]
    [sicp.misc :as m]))

(ex-2-73/install-sum-derivation)
(ex-2-73/install-product-derivation)
(ex-2-73/install-exponent-derivation)

(deftest deriv-test
  (is (= 0 (ex-2-73/deriv 10 5)))
  (is (= 0 (ex-2-73/deriv 'x 5)))
  (is (= 0 (ex-2-73/deriv 'x 'y)))
  (is (= 0 (ex-2-73/deriv '+ 'y)))
  (is (= 0 (ex-2-73/deriv '(+ 2 2) 'x)))
  (is (= 0 (ex-2-73/deriv '(* 2 2) 'x)))
  (is (= true (m/is-exception? (ex-2-73/deriv '(** 2 2) 'x) "unknown expression type: DERIV (** 2 2)"))))

(deftest deriv-v2-test
  (is (= 0 (ex-2-73/deriv-v2 10 5)))
  (is (= 0 (ex-2-73/deriv-v2 'x 5)))
  (is (= 0 (ex-2-73/deriv-v2 'x 'y)))
  (is (= 0 (ex-2-73/deriv-v2 '+ 'y))))
