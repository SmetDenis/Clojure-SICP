(ns sicp.chapter-2.packages.install-rectangular
  (:require
    [sicp.chapter-2.packages.op-table :as ot]))

(defn install-rectangular-package
  []
  ; internal procedures
  (letfn [(real-part [z] (first z))
          (imag-part [z] (second z))
          (make-from-real-imag [x y] (list x y))
          (magnitude
            [z]
            (Math/sqrt (+ (Math/pow (real-part z) 2)
                          (Math/pow (imag-part z) 2))))
          (angle [z] (Math/atan2 (imag-part z) (real-part z)))
          (make-from-mag-ang [r a] (list (* r (Math/cos a)) (* r (Math/sin a))))
          (tag [x] (ot/attach-tag :rectangular x))]
    ; interface to the rest of the system
    (ot/put :real-part '(:rectangular) real-part)
    (ot/put :imag-part '(:rectangular) imag-part)
    (ot/put :magnitude '(:rectangular) magnitude)
    (ot/put :angle '(:rectangular) angle)
    (ot/put :make-from-real-imag :rectangular (fn [x y] (tag (make-from-real-imag x y))))
    (ot/put :make-from-mag-ang :rectangular (fn [r a] (tag (make-from-mag-ang r a))))
    :done))
