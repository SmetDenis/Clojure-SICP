(ns sicp.chapter-2.part-4.ex-2-73
  (:require
    [sicp.chapter-2.part-3.book-2-3 :as b23]))

; Exercise 2.73
;
; Described a program that performs symbolic differentiation:
;
; (define (deriv exp var)
;   (cond ((number? exp) 0)
;         ((variable? exp)
;          (if (same-variable? exp var) 1 0))
;         ((sum? exp)
;          (make-sum (deriv (addend exp) var)
;                    (deriv (augend exp) var)))
;         ((product? exp)
;          (make-sum
;            (make-product
;             (multiplier exp)
;             (deriv (multiplicand exp) var))
;            (make-product
;             (deriv (multiplier exp) var)
;             (multiplicand exp))))
;         ⟨more rules can be added here⟩
;         (else (error "unknown expression type:
;                       DERIV" exp))))
;
; We can regard this program as performing a dispatch on the type of the expression
; to be differentiated. In this situation the “type tag” of the datum is the algebraic operator
; symbol (such as +) and the operation being performed is deriv. We can transform this program
; into data-directed style by rewriting the basic derivative procedure as
;
; (define (deriv exp var)
;    (cond ((number? exp) 0)
;          ((variable? exp)
;            (if (same-variable? exp var)
;                1
;                0))
;          (else ((get 'deriv (operator exp))
;                 (operands exp)
;                 var))))
;
; (define (operator exp) (car exp))
; (define (operands exp) (cdr exp))
;
; 1. Explain what was done above. Why can’t we assimilate the predicates number? and variable?
; into the data-directed dispatch?
;
; 2. Write the procedures for derivatives of sums and products, and the auxiliary code required
; to install them in the table used by the program above.
;
; 3. Choose any additional differentiation rule that you like, such as the one for exponents
; (Exercise 2.56), and install it in this data-directed system.
;
; 4. In this simple algebraic manipulator the type of an expression is the algebraic operator
; that binds it together. Suppose, however, we indexed the procedures in the opposite way,
; so that the dispatch line in deriv looked like
;
; ((get (operator exp) 'deriv)
;   (operands exp) var)

(def derivations (atom {}))

(defn put-op
  [op method deriv-fn]
  (swap! derivations assoc-in [op method] deriv-fn))

(defn get-op
  [op method]
  (get-in @derivations [op method]))

(defn deriv
  [exp var]
  (cond
    (number? exp) 0
    (b23/variable? exp) (if (b23/same-variable? exp var) 1 0)
    (b23/sum? exp) (b23/make-sum (deriv (b23/addend exp) var)
                                 (deriv (b23/augend exp) var))
    (b23/product? exp) (b23/make-sum
                         (b23/make-product (b23/multiplier exp)
                                           (deriv (b23/multiplicand exp) var))
                         (b23/make-product (deriv (b23/multiplier exp) var)
                                           (b23/multiplicand exp)))
    ; ⟨more rules can be added here⟩
    :else (throw (Exception. (str "unknown expression type: DERIV " exp)))))

(defn operator
  [exp]
  (first exp))

(defn operands
  [exp]
  (rest exp))

(defn deriv-v2
  [exp var]
  (cond
    (number? exp) 0
    (b23/variable? exp) (if (b23/same-variable? exp var) 1 0)
    :else ((get-op :deriv (operator exp))
           (operands exp)
           var)))

; --------------------------------------------------------------------------------------------------
; The exercise just to check understanding of abstruction.
; Sorry, I'm lazy and took examples of code here and rewrite it to Clojure
; https://github.com/ivanjovanovic/sicp/blob/master/2.4/e-2.73.scm

(defn make-sum
  ([a b] (list '+ a b))
  ([a b c] (list '+ a b c)))

(defn make-product
  [m1 m2]
  (list '* m1 m2))

(defn install-sum-derivation
  []
  (letfn [(addend [operands] (first operands))
          (augend [operands] (second operands))
          (derive-sum
            [operands var]
            (make-sum (deriv (addend operands) var)
                      (deriv (augend operands) var)))]
    ; and methods for putting the thing in the table
    (put-op '+ :deriv derive-sum)))

(defn install-product-derivation
  []
  (letfn [(multiplier [operands] (first operands))
          (multiplicand [operands] (second operands))
          (derive-product
            [operands var]
            (make-sum
              (make-product (multiplier operands)
                            (deriv (multiplicand operands) var))
              (make-product (deriv (multiplier operands) var)
                            (multiplicand operands))
              var))]
    ; put that into table
    (put-op '* :deriv derive-product)))

(defn install-exponent-derivation
  []
  (letfn [(power [operands] (second operands))
          (base [operands] (first operands))
          (make-exponent [b p] (list '** b p))
          (derive-exponent
            [operands var]
            (make-product
              (make-product (power operands)
                            (make-exponent (base operands) (dec (power operands))))
              (deriv (base operands) var)))]
    (put-op '** :deriv derive-exponent)))
