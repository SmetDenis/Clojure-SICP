(ns sicp.chapter-2.part-5.ex-2-77-test
  (:require
    [clojure.test :refer [deftest is]]
    [sicp.chapter-2.packages.install-complex :as complex]
    [sicp.chapter-2.packages.install-polar :as polar]
    [sicp.chapter-2.packages.install-rectangular :as rectangular]
    [sicp.chapter-2.packages.op-table :as ot]
    [sicp.chapter-2.part-4.book-2-4 :as b24]
    [sicp.chapter-2.part-5.ex-2-77 :refer [magnitude]]))

(rectangular/install-rectangular-package)
(polar/install-polar-package)
(complex/install-complex-package)

(ot/put :real-part '(:complex) b24/real-part)
(ot/put :imag-part '(:complex) b24/imag-part)
(ot/put :magnitude '(:complex) b24/magnitude)
(ot/put :angle '(:complex) b24/angle)

(deftest magnitude-test
  (is (= 5.0 (magnitude (complex/make-complex-from-real-imag 3 4)))))
