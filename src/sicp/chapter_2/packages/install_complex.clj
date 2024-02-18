(ns sicp.chapter-2.packages.install-complex
  (:require
    [sicp.chapter-2.packages.op-table :as ot]
    [sicp.chapter-2.part-4.book-2-4 :as b24]))

(defn install-complex-package
  []
  ; Imported procedures from rectangular and polar packages
  (letfn [(make-from-real-imag [x y] ((ot/get :make-from-real-imag :rectangular) x y))
          (make-from-mag-ang [r a] ((ot/get :make-from-mag-ang :polar) r a))
          ; Internal procedures
          (add-complex
            [z1 z2]
            (make-from-real-imag (+ (b24/real-part z1) (b24/real-part z2))
                                 (+ (b24/imag-part z1) (b24/imag-part z2))))
          (sub-complex
            [z1 z2]
            (make-from-real-imag (- (b24/real-part z1) (b24/real-part z2))
                                 (- (b24/imag-part z1) (b24/imag-part z2))))
          (mul-complex
            [z1 z2]
            (make-from-mag-ang (* (b24/magnitude z1) (b24/magnitude z2))
                               (+ (b24/angle z1) (b24/angle z2))))
          (div-complex
            [z1 z2]
            (make-from-mag-ang (/ (b24/magnitude z1) (b24/magnitude z2))
                               (- (b24/angle z1) (b24/angle z2))))
          ; Interface to rest of the system
          (tag [z] (ot/attach-tag :complex z))]
    ; Putting functions in a map or registry
    (ot/put :add [:complex :complex] (fn [z1 z2] (tag (add-complex z1 z2))))
    (ot/put :sub [:complex :complex] (fn [z1 z2] (tag (sub-complex z1 z2))))
    (ot/put :mul [:complex :complex] (fn [z1 z2] (tag (mul-complex z1 z2))))
    (ot/put :div [:complex :complex] (fn [z1 z2] (tag (div-complex z1 z2))))
    (ot/put :make-from-real-imag :complex (fn [x y] (tag (make-from-real-imag x y))))
    (ot/put :make-from-mag-ang :complex (fn [r a] (tag (make-from-mag-ang r a))))
    :done))

(defn make-complex-from-real-imag
  [x y]
  ((ot/get :make-from-real-imag :complex) x y))

(defn make-complex-from-mag-ang
  [r a]
  ((ot/get :make-from-mag-ang :complex) r a))
