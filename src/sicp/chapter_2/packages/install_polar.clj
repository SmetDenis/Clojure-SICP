(ns sicp.chapter-2.packages.install-polar
  (:require
    [sicp.chapter-2.packages.op-table :as ot]))

(defn install-polar-package
  []
  (letfn [(magnitude [z] (first z))
          (angle [z] (second z))
          (make-from-mag-ang [r a] (list r a))
          (real-part [z] (* (magnitude z) (Math/cos (angle z))))
          (imag-part [z] (* (magnitude z) (Math/sin (angle z))))
          (make-from-real-imag
            [x y]
            (list (Math/sqrt (+ (Math/pow x 2) (Math/pow y 2)))
                  (Math/atan2 y x)))
          (tag [x] (cons :polar x))]
    ; interface to the rest of the system
    (ot/put :real-part :polar real-part)
    (ot/put :imag-part :polar imag-part)
    (ot/put :magnitude :polar magnitude)
    (ot/put :angle :polar angle)
    (ot/put :make-from-real-imag :polar (fn [x y] (tag (make-from-real-imag x y))))
    (ot/put :make-from-mag-ang :polar (fn [r a] (tag (make-from-mag-ang r a))))
    :done))
